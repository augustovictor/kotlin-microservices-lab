package augustovictor.com.github.kotlinmicroserviceslab.repository

import augustovictor.com.github.kotlinmicroserviceslab.model.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<Post, Int>