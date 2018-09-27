package augustovictor.com.github.kotlinmicroserviceslab.controller

import augustovictor.com.github.kotlinmicroserviceslab.exception.UserNotFoundException
import augustovictor.com.github.kotlinmicroserviceslab.model.User
import augustovictor.com.github.kotlinmicroserviceslab.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController(
        private val userService: UserService
) {
    @GetMapping("/all-users")
    fun findAll(): List<User> = userService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Optional<User> {
        val user = userService.findById(id)
        if (!user.isPresent) throw UserNotFoundException("User with id ${id} was not found")

        return user
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody user: User): ResponseEntity<User> {
        val createdUser = userService.create(user)
        val location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.id).toUri()

        return ResponseEntity.created(location).build()
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Int) {
        try {
            userService.deleteById(id)
        } catch (ex: Exception) {
            throw UserNotFoundException("User with id ${id} was not found")
        }
    }
}