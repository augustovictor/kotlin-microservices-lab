package augustovictor.com.github.kotlinmicroserviceslab.exception

import org.springframework.http.HttpStatus

class UserNotFoundException(message: String): KMSLabException(message) {
    override val statusCode = HttpStatus.NOT_FOUND
}