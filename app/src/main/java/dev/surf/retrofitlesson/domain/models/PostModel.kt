package dev.surf.retrofitlesson.domain.models

/**
 * Модель поста.
 *
 * @property userId идентификатор пользователя создавшего пост
 * @property id идентификатор поста
 * @property title заголовок поста
 * @property body текст поста
 */
data class PostModel(
    val userId: Long,
    val id: Int,
    val title: String,
    val body: String,
)