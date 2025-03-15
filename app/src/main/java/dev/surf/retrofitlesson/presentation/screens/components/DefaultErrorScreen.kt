package dev.surf.retrofitlesson.presentation.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.surf.retrofitlesson.presentation.ui.theme.SurfRetrofitLessonTheme

@Composable
fun DefaultErrorScreen(
    message: String,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .size(64.dp),
            imageVector = Icons.Default.Warning,
            contentDescription = "Error state",
            tint = Color.Yellow
        )

        Text(
            modifier = Modifier.padding(horizontal = 24.dp),
            textAlign = TextAlign.Center,
            text = message,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )
        TextButton(
            modifier = Modifier.padding(horizontal = 24.dp),
            onClick = onRetryClick,
            colors = ButtonColors(
                contentColor = Color.White,
                containerColor = Color.DarkGray,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.LightGray
            ),
            shape = ShapeDefaults.Small
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "Повторить",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainErrorState() {
    SurfRetrofitLessonTheme {
        DefaultErrorScreen(
            message = "Test",
            onRetryClick = {}
        )
    }
}