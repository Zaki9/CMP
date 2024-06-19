package data.model

interface Error
typealias RootError = Error
enum class NetworkError : Error {
    TIME_OUT,
    NOT_AUTHENTICATED,
    PAYLOAD_ERROR
}