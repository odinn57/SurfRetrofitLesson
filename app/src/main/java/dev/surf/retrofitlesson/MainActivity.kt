package dev.surf.retrofitlesson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dev.surf.retrofitlesson.presentation.navigation.AppNavigationGraph
import dev.surf.retrofitlesson.presentation.ui.theme.SurfRetrofitLessonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { App() }
    }

    @Composable
    fun App() {
        val navController = rememberNavController()
        SurfRetrofitLessonTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                AppNavigationGraph(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }

    }
}