package dev.surf.retrofitlesson.data.post.remote

object PostUrls {
    const val POSTS = "/posts"
    const val GET_POST_BY_ID = "$POSTS/{id}"
    const val UPDATE_POST = "$POSTS/{id}"
    const val DELETE_POST = "$POSTS/{id}"
}