package augustovictor.com.github.kotlinmicroserviceslab.exception

import org.springframework.http.HttpStatus

abstract class KMSLabException(message: String): Exception(message) {
    abstract val statusCode: HttpStatus
}