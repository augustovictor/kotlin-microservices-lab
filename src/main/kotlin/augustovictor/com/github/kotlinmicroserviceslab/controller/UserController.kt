package augustovictor.com.github.kotlinmicroserviceslab.controller

import augustovictor.com.github.kotlinmicroserviceslab.exception.UserNotFoundException
import augustovictor.com.github.kotlinmicroserviceslab.model.Post
import augustovictor.com.github.kotlinmicroserviceslab.model.User
import augustovictor.com.github.kotlinmicroserviceslab.service.UserService
import org.springframework.hateoas.Resource
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/users", produces = ["application/app-v1+json"])
class UserController(
        private val userService: UserService
) {
    @GetMapping("/all-users")
    fun findAll(): List<User> = userService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Resource<User> {
        val user = userService.findById(id)
        if (!user.isPresent) throw UserNotFoundException("User with id ${id} was not found")
        val resource = Resource<User>(user.get())
        val linkTo = linkTo(methodOn(this::class.java).findAll())
        resource.add(linkTo.withRel("all users"))

        return resource
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

    @GetMapping("/{id}/posts")
    fun allPosts(@PathVariable id: Int): List<Post> {
        val user = userService.findById(id)

        if(!user.isPresent) throw UserNotFoundException("User with id $id not found!")

        return user.get().posts

    }
}