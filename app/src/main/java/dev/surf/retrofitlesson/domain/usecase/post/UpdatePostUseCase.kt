package dev.surf.retrofitlesson.domain.usecase.post

import dev.surf.retrofitlesson.data.utils.OperationResult
import dev.surf.retrofitlesson.domain.models.PostModel
import dev.surf.retrofitlesson.domain.repository.PostRepository
import javax.inject.Inject

/** Обновить существующий пост. */
class UpdatePostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(
        id: Int,
        userId: Long?,
        title: String,
        body: String
    ): OperationResult<PostModel> =
        postRepository.updatePost(
            id = id,
            userId = userId,
            title = title,
            body = body,
        )
}