package dev.surf.retrofitlesson.presentation.screens.postDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.surf.retrofitlesson.presentation.screens.components.DefaultErrorScreen
import dev.surf.retrofitlesson.presentation.screens.components.DefaultLoadingScreen
import dev.surf.retrofitlesson.presentation.screens.postDetails.components.PostDetailsSuccess

@Composable
fun PostDetailsScreen(
    onNavigateUp: () -> Unit,
    modifier: Modifier,
    postDetailsViewModel: PostDetailsViewModel = hiltViewModel()
) {
    val state by postDetailsViewModel.uiState.collectAsStateWithLifecycle()

    val errorMessage = state.errorMessage
    val id = state.postId
    val contentModifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp)
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                modifier = Modifier.padding(8.dp),
                onClick = onNavigateUp
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Вернуться назад",
                )
            }
            Text(
                modifier = Modifier
                    .weight(1f),
                text = "Пост с id = $id",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
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
                    onRetryClick = postDetailsViewModel::reload
                )
            }

            else -> {
                PostDetailsSuccess(
                    modifier = contentModifier,
                    postDetails = state.postDetails,
                    onEditPostClick = postDetailsViewModel::updatePost
                )
            }
        }
    }
}