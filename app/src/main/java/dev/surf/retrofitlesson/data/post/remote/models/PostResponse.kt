package dev.surf.retrofitlesson.data.post.remote.models

import com.google.gson.annotations.SerializedName

/** Модель полученного из ответа с сервера поста. */
data class PostResponse(
    @SerializedName("userId")
    val userId: Long? = null,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("body")
    val body: String? = null,
)
