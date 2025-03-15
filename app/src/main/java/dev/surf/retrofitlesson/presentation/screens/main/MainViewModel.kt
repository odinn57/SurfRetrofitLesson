package dev.surf.retrofitlesson.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.surf.retrofitlesson.domain.models.PostModel
import dev.surf.retrofitlesson.domain.usecase.post.CreatePostUseCase
import dev.surf.retrofitlesson.domain.usecase.post.DeletePostUseCase
import dev.surf.retrofitlesson.domain.usecase.post.GetAllPostsUseCase
import dev.surf.retrofitlesson.domain.usecase.post.UpdatePostUseCase
import dev.surf.retrofitlesson.presentation.screens.utils.handle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllPostsUseCase: GetAllPostsUseCase,
    private val createPostUseCase: CreatePostUseCase,
    private val deletePostUseCase: DeletePostUseCase,
    private val updatePostUseCase: UpdatePostUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainScreenState())
    val uiState = _uiState.asStateFlow()

    init {
        reload()
    }

    fun reload() {
        getAllPosts()
    }

    fun createNew() {
        viewModelScope.launch {
            createPostUseCase(
                userId = 101,
                title = "New Title",
                body = "New Body"
            )
        }
    }

    fun onDeletePost(id: Int) {
        viewModelScope.launch {
            deletePostUseCase(id)
        }
    }

    fun onEditPost(post: PostModel) {
        viewModelScope.launch {
            updatePostUseCase(
                id = post.id,
                userId = post.userId,
                title = "Updated Title",
                body = "Updated Body",
            )
        }
    }

    private fun getAllPosts() {
        _uiState.update { state ->
            state.copy(
                isLoading = true
            )
        }
        viewModelScope.launch {
            getAllPostsUseCase().handle(
                onSuccess = { postList ->
                    _uiState.update { state ->
                        state.copy(
                            isLoading = false,
                            postList = postList,
                            errorMessage = null
                        )
                    }
                },
                onError = ::onError
            )
        }
    }

    private fun onError(message: String) {
        _uiState.update { state ->
            state.copy(
                isLoading = false,
                postList = emptyList(),
                errorMessage = message
            )
        }
    }
}