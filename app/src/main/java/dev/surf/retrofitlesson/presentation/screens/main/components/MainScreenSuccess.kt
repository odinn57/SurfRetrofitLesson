package dev.surf.retrofitlesson.presentation.screens.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.surf.retrofitlesson.domain.models.PostModel

@Composable
fun MainScreenSuccess(
    posts: List<PostModel>,
    onPostClick: (postId: Int) -> Unit,
    onDeleteClick: (postId: Int) -> Unit,
    onEditClick: (post: PostModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LazyColumn {
            items(posts) { item ->
                PostItem(
                    post = item,
                    onPostClick = onPostClick,
                    onDeleteClick = onDeleteClick,
                    onEditClick = onEditClick
                )
                Spacer(modifier = Modifier.size(12.dp))
            }
        }
    }
}