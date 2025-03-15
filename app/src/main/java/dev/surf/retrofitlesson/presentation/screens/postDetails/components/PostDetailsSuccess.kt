package dev.surf.retrofitlesson.presentation.screens.postDetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.surf.retrofitlesson.domain.models.PostModel
import dev.surf.retrofitlesson.presentation.ui.theme.SurfRetrofitLessonTheme

@Composable
fun PostDetailsSuccess(
    postDetails: PostModel?,
    modifier: Modifier = Modifier
) {
    postDetails.let { post ->
        Column(
            modifier = modifier
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                text = post?.title.orEmpty(),
                textAlign = TextAlign.Start,
                fontSize = 18.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Medium
            )
            Text(
                modifier = Modifier
                    .fillMaxSize(),
                text = post?.body.orEmpty(),
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewPostDetailsSuccess() {
    SurfRetrofitLessonTheme {
        PostDetailsSuccess(
            postDetails = PostModel(
                userId = 1,
                id = 1,
                title = "Title",
                body = LoremIpsum().values.first()
            )
        )
    }
}