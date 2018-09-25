package augustovictor.com.github.kotlinmicroserviceslab.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(KMSLabException::class)
    fun handlerKMSLabException(ex: KMSLabException): ResponseEntity<String> {
        return ResponseEntity.status(ex.statusCode).body(ex.message)
    }

}