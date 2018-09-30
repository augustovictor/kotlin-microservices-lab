package augustovictor.com.github.kotlinmicroserviceslab.representer

import augustovictor.com.github.kotlinmicroserviceslab.model.Post

class PostDto(
    val title: String,
    val description: String
) {
    constructor(post: Post): this(post.title, post.description)
}