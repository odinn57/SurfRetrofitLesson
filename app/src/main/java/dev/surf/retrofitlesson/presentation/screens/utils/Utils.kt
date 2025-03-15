package dev.surf.retrofitlesson.presentation.screens.utils

import dev.surf.retrofitlesson.data.utils.OperationResult

/**
 * Выполняет действие в зависимости от полученного [OperationResult].
 *
 * @param onSuccess действие при успешном получении данных
 * @param onError действие при получении ошибки
 * @param onLoading действие при загрузке
 * */
suspend fun <T> OperationResult<T>.handle(
    onSuccess: (data: T) -> Unit,
    onError: (message: String) -> Unit = {},
    onLoading: () -> Unit = {},
) {
    when (this) {
        is OperationResult.Error -> {
            onError(message)
        }

        OperationResult.Loading -> {
            onLoading()
        }

        is OperationResult.Success -> {
            onSuccess(data)
        }
    }
}