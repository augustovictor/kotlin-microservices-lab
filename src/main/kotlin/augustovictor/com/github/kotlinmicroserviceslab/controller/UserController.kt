package augustovictor.com.github.kotlinmicroserviceslab.controller

import augustovictor.com.github.kotlinmicroserviceslab.model.User
import augustovictor.com.github.kotlinmicroserviceslab.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/users")
class UserController(
        private val userService: UserService
) {
    @GetMapping("/all")
    fun findAll(): List<User> = userService.findAll()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody user: User): ResponseEntity<User> {
        val createdUser = userService.create(user)
        val location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.id).toUri()

        return ResponseEntity.created(location).build()

    }
}