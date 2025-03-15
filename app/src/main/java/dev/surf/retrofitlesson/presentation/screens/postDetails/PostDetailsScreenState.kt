package dev.surf.retrofitlesson.presentation.screens.postDetails

import dev.surf.retrofitlesson.domain.models.PostModel

data class PostDetailsScreenState(
    val postId: Int,
    val postDetails: PostModel? = null,
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
)
