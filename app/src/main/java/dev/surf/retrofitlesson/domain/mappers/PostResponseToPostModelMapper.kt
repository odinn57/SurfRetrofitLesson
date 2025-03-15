package dev.surf.retrofitlesson.domain.mappers

import dev.surf.retrofitlesson.data.post.remote.models.PostResponse
import dev.surf.retrofitlesson.domain.models.PostModel
import javax.inject.Inject

/** Маппит [PostResponse] в [PostModel]. */
class PostResponseToPostModelMapper @Inject constructor() : (PostResponse) -> PostModel {
    override operator fun invoke(from: PostResponse): PostModel =
        PostModel(
            userId = from.userId ?: -1,
            id = from.id,
            title = from.title ?: "",
            body = from.body ?: ""
        )
}