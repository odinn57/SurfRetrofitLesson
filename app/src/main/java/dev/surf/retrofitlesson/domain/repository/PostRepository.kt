package dev.surf.retrofitlesson.domain.repository

import dev.surf.retrofitlesson.data.post.remote.PostRemoteDataSource
import dev.surf.retrofitlesson.data.post.remote.models.PostBody
import dev.surf.retrofitlesson.data.utils.OperationResult
import dev.surf.retrofitlesson.domain.mappers.PostResponseToPostModelMapper
import dev.surf.retrofitlesson.domain.models.PostModel
import dev.surf.retrofitlesson.domain.utils.flatMapIfSuccess
import dev.surf.retrofitlesson.domain.utils.toSuccessResult
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val remoteDataSource: PostRemoteDataSource,
    private val postResponseToPostModelMapper: PostResponseToPostModelMapper,
) {
    /** Получить список всех постов. */
    suspend fun getAllPosts(): OperationResult<List<PostModel>> =
        remoteDataSource.getAllPosts().flatMapIfSuccess { postResponseList ->
            postResponseList.map { postResponse ->
                postResponseToPostModelMapper(postResponse)
            }.toSuccessResult()
        }

    /** Получить пост с идентификатором [id]. */
    suspend fun getPostById(id: Int): OperationResult<PostModel> =
        remoteDataSource.getPostById(id).flatMapIfSuccess { postResponse ->
            postResponseToPostModelMapper(postResponse).toSuccessResult()
        }

    /** Создать новый пост. */
    suspend fun createPost(userId: Long?, title: String, body: String): OperationResult<PostModel> {
        val requestBody = PostBody(
            userId = userId,
            title = title,
            body = body
        )
        return remoteDataSource.createPost(requestBody).flatMapIfSuccess { postResponse ->
            postResponseToPostModelMapper(postResponse).toSuccessResult()
        }
    }


    /** Обновить пост с идентификатором [id]. */
    suspend fun updatePost(
        id: Int,
        userId: Long?,
        title: String,
        body: String
    ): OperationResult<PostModel> {
        val requestBody = PostBody(
            userId = userId,
            title = title,
            body = body
        )
        return remoteDataSource.updatePost(id, requestBody).flatMapIfSuccess { postResponse ->
            postResponseToPostModelMapper(postResponse).toSuccessResult()
        }
    }


    /** Удалить пост с идентификатором [id]. */
    suspend fun deletePost(id: Int): OperationResult<Any> =
        remoteDataSource.deletePost(id)
}