package augustovictor.com.github.kotlinmicroserviceslab.controller

import augustovictor.com.github.kotlinmicroserviceslab.model.User
import augustovictor.com.github.kotlinmicroserviceslab.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
        private val userService: UserService
) {
    @GetMapping("/all")
    fun findAll(): List<User> = userService.findAll()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody user: User): User {
        return userService.create(user)
    }
}