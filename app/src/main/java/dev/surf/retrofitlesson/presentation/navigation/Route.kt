package dev.surf.retrofitlesson.presentation.navigation

sealed class Route {
    data class MainScreen(val route: String = "main") : Route()
    data class PostDetails(
        val route: String = "post_details",
        val routeWithArgs: String = "$route/{$POST_ID}"
    ) : Route() {
        fun getRouteWithArgs(postId: Int): String = "$route/$postId"

        companion object {
            const val POST_ID = "postId"
        }
    }
}