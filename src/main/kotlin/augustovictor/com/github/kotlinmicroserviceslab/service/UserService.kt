package augustovictor.com.github.kotlinmicroserviceslab.service

import augustovictor.com.github.kotlinmicroserviceslab.model.User
import augustovictor.com.github.kotlinmicroserviceslab.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: UserRepository
) {
    fun findAll(): List<User> = userRepository.findAll()

    fun create(user: User): User {
        return userRepository.save(user)
    }
}