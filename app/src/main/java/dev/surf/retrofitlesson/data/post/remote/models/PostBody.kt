package dev.surf.retrofitlesson.data.post.remote.models

import com.google.gson.annotations.SerializedName

/** Модель для отправки данных поста на сервер. */
data class PostBody(
    @SerializedName("userId")
    val userId: Long? = null,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String,
)