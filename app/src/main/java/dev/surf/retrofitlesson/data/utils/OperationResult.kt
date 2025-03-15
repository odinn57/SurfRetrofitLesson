package dev.surf.retrofitlesson.data.utils

/** Обертка для состояния загрузки. */
sealed interface OperationResult<out T> {
    class Success<T>(val data: T) : OperationResult<T>
    class Error(val message: String) : OperationResult<Nothing>
    data object Loading : OperationResult<Nothing> // Don't use
}