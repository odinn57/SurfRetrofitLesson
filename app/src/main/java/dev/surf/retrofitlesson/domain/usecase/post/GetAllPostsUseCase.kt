package dev.surf.retrofitlesson.domain.usecase.post

import dev.surf.retrofitlesson.data.utils.OperationResult
import dev.surf.retrofitlesson.domain.models.PostModel
import dev.surf.retrofitlesson.domain.repository.PostRepository
import javax.inject.Inject

/** Получить все посты. */
class GetAllPostsUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(): OperationResult<List<PostModel>> =
        postRepository.getAllPosts()
}