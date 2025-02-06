#!/bin/sh

# Script that make sure release build is correctly published in the appropriate channels.
#
# The following steps are executed:
#
# 1. Check that version in version.txt matches git tag which indicate a release.
# 2. Check that the changelog has a correct set date.
# 3. Build Javadoc/KDoc
# 4. Upload all artifacts to Maven Central without releasing them.
# 5. Verify that all artifacts have been uploaded, then release all of them at once.
# 6. Upload native debug symobols and update latest version number on S3.
# 7. Upload Javadoc/KDoc to MongoDB Realm S3 bucket.
# 8. Notify #realm-releases and #realm-java-team-ci about the new release.
set -e

######################################
# Input Validation
######################################

######################################
# Define Release steps
######################################

HERE=$(dirname `realpath "$0"`)
REALM_KOTLIN_PATH="$HERE/.."
RELEASE_VERSION="3.2.1"
MAVEN_CENTRAL_USER="$1"
MAVEN_CENTRAL_KEY="$2"
GRADLE_PORTAL_KEY="$3"
GRADLE_PORTAL_SECRET="${4}"
GRADLE_BUILD_PARAMS="${5}"

abort_release() {
  # Reporting failures to #realm-java-team-ci is done from Jenkins
  exit 1
}

create_javadoc() {
  echo "Creating JavaDoc/KDoc..."
  cd $REALM_KOTLIN_PATH/packages
  ./gradlew dokkaHtmlMultiModule --info --stacktrace --no-daemon
  ../tools/fix-h1s.sh build/dokka/htmlMultiModule
  cd $HERE
}

publish_artifacts() {
  echo "Releasing on MavenCentral"
  cd $REALM_KOTLIN_PATH/packages
  eval "./gradlew publishToSonatype closeAndReleaseSonatypeStagingRepository $GRADLE_BUILD_PARAMS -PossrhUsername=$MAVEN_CENTRAL_USER -PossrhPassword=$MAVEN_CENTRAL_KEY"
  echo "Releasing on Gradle Plugin Portal"
  eval "./gradlew :gradle-plugin:publishPlugin $GRADLE_BUILD_PARAMS -PgeneratePluginArtifactMarker=true -Pgradle.publish.key=$GRADLE_PORTAL_KEY -Pgradle.publish.secret=$GRADLE_PORTAL_SECRET"
  cd $HERE
}




######################################
# Run Release steps
######################################\

if [ "$1" != "verify" ]; then
  create_javadoc
  publish_artifacts
fi
