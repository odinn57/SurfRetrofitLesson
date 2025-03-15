package dev.surf.retrofitlesson.data.post.remote

import dev.surf.retrofitlesson.data.post.remote.PostUrls.DELETE_POST
import dev.surf.retrofitlesson.data.post.remote.PostUrls.GET_POST_BY_ID
import dev.surf.retrofitlesson.data.post.remote.PostUrls.POSTS
import dev.surf.retrofitlesson.data.post.remote.PostUrls.UPDATE_POST
import dev.surf.retrofitlesson.data.post.remote.models.PostBody
import dev.surf.retrofitlesson.data.post.remote.models.PostResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PostApi {

    /** Получить список всех постов. */
    @GET(POSTS)
    suspend fun getAllPosts(): Response<List<PostResponse>>

    /** Получить пост с идентификатором [id]. */
    @GET(GET_POST_BY_ID)
    suspend fun getPostById(@Path("id") id: Int): Response<PostResponse>

    /** Создать новый пост. */
    @POST(POSTS)
    suspend fun createPost(@Body body: PostBody): Response<PostResponse>

    /** Обновить пост с идентификатором [id]. */
    @PUT(UPDATE_POST)
    suspend fun updatePost(
        @Path("id") id: Int,
        @Body body: PostBody,
    ): Response<PostResponse>

    /** Удалить пост с идентификатором [id]. */
    @DELETE(DELETE_POST)
    suspend fun deletePost(@Path("id") id: Int): Response<Any>
}