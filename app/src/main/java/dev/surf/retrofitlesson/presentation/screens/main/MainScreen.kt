package dev.surf.retrofitlesson.presentation.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.surf.retrofitlesson.presentation.screens.components.DefaultErrorScreen
import dev.surf.retrofitlesson.presentation.screens.components.DefaultLoadingScreen
import dev.surf.retrofitlesson.presentation.screens.main.components.MainScreenSuccess

@Composable
fun MainScreen(
    modifier: Modifier,
    onPostClick: (postId: Int) -> Unit,
    mainViewModel: MainViewModel = viewModel()
) {
    val state by mainViewModel.uiState.collectAsStateWithLifecycle()

    val errorMessage = state.errorMessage

    val contentModifier = Modifier.fillMaxSize()

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "Лента постов",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )
            IconButton(
                onClick = mainViewModel::createNew
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Создать"
                )
            }
        }

        when {
            state.isLoading -> {
                DefaultLoadingScreen(
                    modifier = contentModifier
                )
            }

            errorMessage != null -> {
                DefaultErrorScreen(
                    modifier = contentModifier,
                    message = errorMessage,
                    onRetryClick = mainViewModel::reload
                )
            }

            else -> {
                MainScreenSuccess(
                    modifier = contentModifier,
                    posts = state.postList,
                    onPostClick = onPostClick,
                    onDeleteClick = mainViewModel::onDeletePost,
                    onEditClick = mainViewModel::onEditPost
                )
            }

        }
    }
}
