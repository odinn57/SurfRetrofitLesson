package dev.surf.retrofitlesson.presentation.screens.main

import dev.surf.retrofitlesson.domain.models.PostModel

data class MainScreenState(
    val postList: List<PostModel> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
)