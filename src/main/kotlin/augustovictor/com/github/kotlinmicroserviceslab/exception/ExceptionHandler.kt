package augustovictor.com.github.kotlinmicroserviceslab.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(KMSLabException::class)
    fun handlerKMSLabException(ex: KMSLabException): ResponseEntity<String> {
        return ResponseEntity.status(ex.statusCode).body(ex.message)
    }

}