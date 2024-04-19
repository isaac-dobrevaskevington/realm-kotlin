/*
 * Copyright 2022 Realm Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.realm.kotlin.internal.interop.sync

import io.realm.kotlin.internal.interop.CodeDescription

/**
 * Wrapper for C-API `realm_sync_errno_connection`.
 * See https://github.com/realm/realm-core/blob/master/src/realm/error_codes.h#L209
 */
expect enum class SyncConnectionErrorCode : CodeDescription {
    RLM_SYNC_ERR_CONNECTION_CONNECTION_CLOSED,
    RLM_SYNC_ERR_CONNECTION_OTHER_ERROR,
    RLM_SYNC_ERR_CONNECTION_UNKNOWN_MESSAGE,
    RLM_SYNC_ERR_CONNECTION_BAD_SYNTAX,
    RLM_SYNC_ERR_CONNECTION_LIMITS_EXCEEDED,
    RLM_SYNC_ERR_CONNECTION_WRONG_PROTOCOL_VERSION,
    RLM_SYNC_ERR_CONNECTION_BAD_SESSION_IDENT,
    RLM_SYNC_ERR_CONNECTION_REUSE_OF_SESSION_IDENT,
    RLM_SYNC_ERR_CONNECTION_BOUND_IN_OTHER_SESSION,
    RLM_SYNC_ERR_CONNECTION_BAD_MESSAGE_ORDER,
    RLM_SYNC_ERR_CONNECTION_BAD_DECOMPRESSION,
    RLM_SYNC_ERR_CONNECTION_BAD_CHANGESET_HEADER_SYNTAX,
    RLM_SYNC_ERR_CONNECTION_BAD_CHANGESET_SIZE,
    RLM_SYNC_ERR_CONNECTION_SWITCH_TO_FLX_SYNC,
    RLM_SYNC_ERR_CONNECTION_SWITCH_TO_PBS;

    override val nativeValue: Int
    override val description: String?

    companion object {
        internal fun of(nativeValue: Int): SyncConnectionErrorCode?
    }
}

/**
 * Wrapper for C-API `realm_sync_errno_session`.
 * See https://github.com/realm/realm-core/blob/master/src/realm/error_codes.h#L228
 */
expect enum class SyncSessionErrorCode : CodeDescription {
    RLM_SYNC_ERR_SESSION_SESSION_CLOSED,
    RLM_SYNC_ERR_SESSION_OTHER_SESSION_ERROR,
    RLM_SYNC_ERR_SESSION_TOKEN_EXPIRED,
    RLM_SYNC_ERR_SESSION_BAD_AUTHENTICATION,
    RLM_SYNC_ERR_SESSION_ILLEGAL_REALM_PATH,
    RLM_SYNC_ERR_SESSION_NO_SUCH_REALM,
    RLM_SYNC_ERR_SESSION_PERMISSION_DENIED,
    RLM_SYNC_ERR_SESSION_BAD_SERVER_FILE_IDENT,
    RLM_SYNC_ERR_SESSION_BAD_CLIENT_FILE_IDENT,
    RLM_SYNC_ERR_SESSION_BAD_SERVER_VERSION,
    RLM_SYNC_ERR_SESSION_BAD_CLIENT_VERSION,
    RLM_SYNC_ERR_SESSION_DIVERGING_HISTORIES,
    RLM_SYNC_ERR_SESSION_BAD_CHANGESET,
    RLM_SYNC_ERR_SESSION_PARTIAL_SYNC_DISABLED,
    RLM_SYNC_ERR_SESSION_UNSUPPORTED_SESSION_FEATURE,
    RLM_SYNC_ERR_SESSION_BAD_ORIGIN_FILE_IDENT,
    RLM_SYNC_ERR_SESSION_BAD_CLIENT_FILE,
    RLM_SYNC_ERR_SESSION_SERVER_FILE_DELETED,
    RLM_SYNC_ERR_SESSION_CLIENT_FILE_BLACKLISTED,
    RLM_SYNC_ERR_SESSION_USER_BLACKLISTED,
    RLM_SYNC_ERR_SESSION_TRANSACT_BEFORE_UPLOAD,
    RLM_SYNC_ERR_SESSION_CLIENT_FILE_EXPIRED,
    RLM_SYNC_ERR_SESSION_USER_MISMATCH,
    RLM_SYNC_ERR_SESSION_TOO_MANY_SESSIONS,
    RLM_SYNC_ERR_SESSION_INVALID_SCHEMA_CHANGE,
    RLM_SYNC_ERR_SESSION_BAD_QUERY,
    RLM_SYNC_ERR_SESSION_OBJECT_ALREADY_EXISTS,
    RLM_SYNC_ERR_SESSION_SERVER_PERMISSIONS_CHANGED,
    RLM_SYNC_ERR_SESSION_INITIAL_SYNC_NOT_COMPLETED,
    RLM_SYNC_ERR_SESSION_WRITE_NOT_ALLOWED,
    RLM_SYNC_ERR_SESSION_COMPENSATING_WRITE,
    RLM_SYNC_ERR_SESSION_MIGRATE_TO_FLX,
    RLM_SYNC_ERR_SESSION_BAD_PROGRESS,
    RLM_SYNC_ERR_SESSION_REVERT_TO_PBS,
    RLM_SYNC_ERR_SESSION_BAD_SCHEMA_VERSION,
    RLM_SYNC_ERR_SESSION_SCHEMA_VERSION_CHANGED;

    override val nativeValue: Int
    override val description: String?

    companion object {
        internal fun of(nativeValue: Int): SyncSessionErrorCode?
    }
}

/**
 * Wrapper for C-API `realm_web_socket_errno`.
 * See https://github.com/realm/realm-core/blob/master/src/realm/error_codes.h#L266
 */
expect enum class WebsocketErrorCode : CodeDescription {
    RLM_ERR_WEBSOCKET_OK,
    RLM_ERR_WEBSOCKET_GOINGAWAY,
    RLM_ERR_WEBSOCKET_PROTOCOLERROR,
    RLM_ERR_WEBSOCKET_UNSUPPORTEDDATA,
    RLM_ERR_WEBSOCKET_RESERVED,
    RLM_ERR_WEBSOCKET_NOSTATUSRECEIVED,
    RLM_ERR_WEBSOCKET_ABNORMALCLOSURE,
    RLM_ERR_WEBSOCKET_INVALIDPAYLOADDATA,
    RLM_ERR_WEBSOCKET_POLICYVIOLATION,
    RLM_ERR_WEBSOCKET_MESSAGETOOBIG,
    RLM_ERR_WEBSOCKET_INAVALIDEXTENSION,
    RLM_ERR_WEBSOCKET_INTERNALSERVERERROR,
    RLM_ERR_WEBSOCKET_TLSHANDSHAKEFAILED,
    RLM_ERR_WEBSOCKET_UNAUTHORIZED,
    RLM_ERR_WEBSOCKET_FORBIDDEN,
    RLM_ERR_WEBSOCKET_MOVEDPERMANENTLY,
    RLM_ERR_WEBSOCKET_CLIENT_TOO_OLD,
    RLM_ERR_WEBSOCKET_CLIENT_TOO_NEW,
    RLM_ERR_WEBSOCKET_PROTOCOL_MISMATCH,
    RLM_ERR_WEBSOCKET_RESOLVE_FAILED,
    RLM_ERR_WEBSOCKET_CONNECTION_FAILED,
    RLM_ERR_WEBSOCKET_READ_ERROR,
    RLM_ERR_WEBSOCKET_WRITE_ERROR,
    RLM_ERR_WEBSOCKET_RETRY_ERROR,
    RLM_ERR_WEBSOCKET_FATAL_ERROR;

    override val nativeValue: Int
    override val description: String?

    companion object {
        fun of(nativeValue: Int): WebsocketErrorCode?
    }
}

/**
 * Wrapper for C-API `realm_sync_socket_callback_result`
 * See https://github.com/realm/realm-core/blob/master/src/realm/error_codes.h#L298
 */
expect enum class WebsocketCallbackResult : CodeDescription {
    RLM_ERR_SYNC_SOCKET_SUCCESS,
    RLM_ERR_SYNC_SOCKET_OPERATION_ABORTED,
    RLM_ERR_SYNC_SOCKET_RUNTIME,
    RLM_ERR_SYNC_SOCKET_OUT_OF_MEMORY,
    RLM_ERR_SYNC_SOCKET_ADDRESS_SPACE_EXHAUSTED,
    RLM_ERR_SYNC_SOCKET_CONNECTION_CLOSED,
    RLM_ERR_SYNC_SOCKET_NOT_SUPPORTED,
    RLM_ERR_SYNC_SOCKET_INVALID_ARGUMENT;

    override val nativeValue: Int
    override val description: String?

    companion object {
        fun of(nativeValue: Int): WebsocketCallbackResult?
    }
}
