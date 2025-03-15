package dev.surf.retrofitlesson.domain.usecase.post

import dev.surf.retrofitlesson.data.utils.OperationResult
import dev.surf.retrofitlesson.domain.models.PostModel
import dev.surf.retrofitlesson.domain.repository.PostRepository
import javax.inject.Inject

/** Создать новый пост. */
class CreatePostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(
        userId: Long?,
        title: String,
        body: String,
    ): OperationResult<PostModel> =
        postRepository.createPost(userId, title, body)
}