package augustovictor.com.github.kotlinmicroserviceslab.repository

import augustovictor.com.github.kotlinmicroserviceslab.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Int>