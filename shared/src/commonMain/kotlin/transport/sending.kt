package transport

expect fun getTimeNow(): String

expect val localHost: String

typealias WsSession = Any
