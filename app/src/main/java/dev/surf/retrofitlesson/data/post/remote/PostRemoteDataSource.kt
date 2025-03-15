package dev.surf.retrofitlesson.data.post.remote

import dev.surf.retrofitlesson.data.post.remote.models.PostBody
import dev.surf.retrofitlesson.data.post.remote.models.PostResponse
import dev.surf.retrofitlesson.data.utils.BaseRemoteDataSource
import dev.surf.retrofitlesson.data.utils.OperationResult
import javax.inject.Inject

class PostRemoteDataSource @Inject constructor(
    private val postApi: PostApi
) : BaseRemoteDataSource() {

    suspend fun getAllPosts(): OperationResult<List<PostResponse>> =
        safeApiCall { postApi.getAllPosts() }


    suspend fun getPostById(id: Int): OperationResult<PostResponse> =
        safeApiCall { postApi.getPostById(id) }

    suspend fun createPost(body: PostBody): OperationResult<PostResponse> =
        safeApiCall { postApi.createPost(body) }

    suspend fun updatePost(
        id: Int,
        body: PostBody,
    ): OperationResult<PostResponse> =
        safeApiCall { postApi.updatePost(id, body) }

    suspend fun deletePost(id: Int): OperationResult<Any> =
        safeApiCall { postApi.deletePost(id) }
}