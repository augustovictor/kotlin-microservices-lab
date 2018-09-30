package augustovictor.com.github.kotlinmicroserviceslab.representer

import augustovictor.com.github.kotlinmicroserviceslab.model.User

data class UserDto(
        val firstName: String,
        val lastName: String
) {
    private var id: Int = 0
    var password: String = ""
    var posts: List<PostDto> = listOf()

    constructor(user: User): this(user.firstName, user.lastName) {
        id = user.id
        password = user.password
        posts = user.posts.map { PostDto(it) }
    }
}