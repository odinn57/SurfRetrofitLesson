package dev.surf.retrofitlesson.domain.usecase.post

import dev.surf.retrofitlesson.data.utils.OperationResult
import dev.surf.retrofitlesson.domain.repository.PostRepository
import javax.inject.Inject

/** Удалить пост по идентификатору. */
class DeletePostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(id: Int): OperationResult<Any> =
        postRepository.deletePost(id)
}