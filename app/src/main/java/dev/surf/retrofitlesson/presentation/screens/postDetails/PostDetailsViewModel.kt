package dev.surf.retrofitlesson.presentation.screens.postDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dev.surf.retrofitlesson.domain.models.PostModel
import dev.surf.retrofitlesson.presentation.navigation.Route
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PostDetailsViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val _uiState: MutableStateFlow<PostDetailsScreenState>
    val uiState: StateFlow<PostDetailsScreenState>

    init {
        val postId = savedStateHandle.get<Int>(Route.PostDetails.POST_ID) ?: -1
        _uiState = MutableStateFlow(
            PostDetailsScreenState(
                postId = postId
            )
        )
        uiState = _uiState.asStateFlow()
        reload()
    }

    fun reload() {
        getPost(_uiState.value.postId)
    }

    fun updatePost(postModel: PostModel) {
        // TODO("Отправить запрос на изменение поста посте")
    }

    private fun getPost(id: Int) {
        // TODO("Отправить запрос на получение информации о посте")
        onError("Not implement yet!")
    }

    private fun onError(message: String) {
        _uiState.update { state ->
            state.copy(
                isLoading = false,
                postDetails = null,
                errorMessage = message
            )
        }
    }
}

