package dev.surf.retrofitlesson.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.surf.retrofitlesson.presentation.screens.main.MainScreen
import dev.surf.retrofitlesson.presentation.screens.postDetails.PostDetailsScreen

@Composable
fun AppNavigationGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Route.MainScreen().route,
        modifier = modifier.fillMaxSize()
    ) {
        composable(
            route = Route.MainScreen().route
        ) {
            MainScreen(
                modifier = modifier,
                onPostClick = { postId ->
                    navController.navigate(
                        Route.PostDetails().getRouteWithArgs(postId)
                    ) {
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            inclusive = false
                        }
                    }
                }
            )
        }
        composable(
            route = Route.PostDetails().routeWithArgs,
            arguments = listOf(navArgument(name = Route.PostDetails.POST_ID) {
                type = NavType.IntType
            })
        ) {
            PostDetailsScreen(
                modifier = modifier,
                onNavigateUp = { navController.navigateUp() },
            )
        }
    }
}