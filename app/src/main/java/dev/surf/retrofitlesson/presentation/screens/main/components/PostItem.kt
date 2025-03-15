package dev.surf.retrofitlesson.presentation.screens.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.surf.retrofitlesson.domain.models.PostModel
import dev.surf.retrofitlesson.presentation.ui.theme.SurfRetrofitLessonTheme

@Composable
fun PostItem(
    post: PostModel,
    onPostClick: (postId: Int) -> Unit,
    onDeleteClick: (postId: Int) -> Unit,
    onEditClick: (post: PostModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    val title = post.title
    val body = post.body

    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = {
            onPostClick(post.id)
        }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = post.id.toString(), fontSize = 24.sp)
            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .weight(1f)
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = body, fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            IconButton(
                onClick = { onDeleteClick(post.id) }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Удалить",
                    tint = Color.Red
                )
            }
            IconButton(
                onClick = { onEditClick(post) }
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Редактировать"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPostItem() {
    SurfRetrofitLessonTheme {
        PostItem(
            post = PostModel(
                userId = 1,
                id = 1,
                title = "Заголовок",
                body = "Текст поста"
            ),
            onPostClick = {},
            onEditClick = {},
            onDeleteClick = {}
        )
    }
}