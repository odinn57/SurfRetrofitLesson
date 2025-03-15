package dev.surf.retrofitlesson.presentation.screens.postDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.surf.retrofitlesson.domain.models.PostModel
import dev.surf.retrofitlesson.domain.usecase.post.GetPostByIdUseCase
import dev.surf.retrofitlesson.domain.usecase.post.UpdatePostUseCase
import dev.surf.retrofitlesson.presentation.navigation.Route
import dev.surf.retrofitlesson.presentation.screens.utils.handle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    private val getPostByIdUseCase: GetPostByIdUseCase,
    private val updatePostUseCase: UpdatePostUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
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
        viewModelScope.launch {
            updatePostUseCase(
                id = postModel.id,
                userId = postModel.userId,
                title = "New Post Title",
                body = "New Post Body"
            )
        }
    }

    private fun getPost(id: Int) {
        _uiState.update { state ->
            state.copy(
                isLoading = true
            )
        }
        if (id != -1) {
            viewModelScope.launch {
                getPostByIdUseCase(id).handle(
                    onSuccess = { postDetails ->
                        _uiState.update { state ->
                            state.copy(
                                isLoading = false,
                                postDetails = postDetails,
                                errorMessage = null
                            )
                        }
                    },
                    onError = ::onError,
                )

            }
        } else {
            onError("Post id = $id is not correct!")
        }
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

