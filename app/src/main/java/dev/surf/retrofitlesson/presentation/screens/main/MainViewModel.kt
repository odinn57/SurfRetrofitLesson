package dev.surf.retrofitlesson.presentation.screens.main

import androidx.lifecycle.ViewModel
import dev.surf.retrofitlesson.domain.models.PostModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainScreenState())
    val uiState = _uiState.asStateFlow()

    init {
        reload()
    }

    fun reload() {
        getAllPosts()
    }

    fun createNew() {
        // TODO("Отправить запрос на создание поста")
    }

    fun onDeletePost(id: Int) {
        // TODO("Отправить запрос на удаление поста")
    }

    fun onEditPost(post: PostModel) {
        // TODO("Отправить запрос на редактирование поста")
    }

    private fun getAllPosts() {
        // TODO("Отправить запрос на получение списка постов")
        onError("Not implement yet!")
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