package dev.surf.retrofitlesson.data.utils

import retrofit2.Response

abstract class BaseRemoteDataSource {
    suspend fun <T> safeApiCall(api: suspend () -> Response<T>): OperationResult<T> {
        return try {
            val response = api()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    OperationResult.Success(body)
                } ?: getErrorResult(
                    errorMessage = "Body is empty"
                )
            } else {
                getErrorResult(
                    errorMessage = "${response.code()} ${response.message()}"
                )
            }

        } catch (e: Exception) {
            getErrorResult(
                errorMessage = "Api call failed: ${e.message.toString()}"
            )
        }
    }

    private fun getErrorResult(errorMessage: String): OperationResult.Error =
        OperationResult.Error(errorMessage)
}
