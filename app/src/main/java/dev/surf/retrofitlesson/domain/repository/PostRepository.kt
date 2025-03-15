package dev.surf.retrofitlesson.domain.repository

import dev.surf.retrofitlesson.data.post.remote.PostRemoteDataSource
import dev.surf.retrofitlesson.data.post.remote.models.PostBody
import dev.surf.retrofitlesson.data.post.remote.models.PostResponse
import dev.surf.retrofitlesson.data.utils.OperationResult
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val remoteDataSource: PostRemoteDataSource
) {
    /** Получить список всех постов. */
    suspend fun getAllPosts(): OperationResult<List<PostResponse>> =
        remoteDataSource.getAllPosts()

    /** Получить пост с идентификатором [id]. */
    suspend fun getPostById(id: Int): OperationResult<PostResponse> =
        remoteDataSource.getPostById(id)

    /** Создать новый пост. */
    suspend fun createPost(body: PostBody): OperationResult<PostResponse> =
        remoteDataSource.createPost(body)

    /** Обновить пост с идентификатором [id]. */
    suspend fun updatePost(
        id: Int,
        body: PostBody,
    ): OperationResult<PostResponse> =
        remoteDataSource.updatePost(id, body)

    /** Удалить пост с идентификатором [id]. */
    suspend fun deletePost(id: Int): OperationResult<Any> =
        remoteDataSource.deletePost(id)
}