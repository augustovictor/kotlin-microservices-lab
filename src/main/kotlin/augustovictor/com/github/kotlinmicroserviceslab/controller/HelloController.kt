package augustovictor.com.github.kotlinmicroserviceslab.controller

import org.springframework.context.MessageSource
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/")
class HelloController(
    private val messageSource: MessageSource
) {

    @GetMapping("")
    fun sayHello(): String {
        return "Hello"
    }

    @GetMapping("/i18n")
    fun getInternationalizedString(@RequestHeader(name = "Accept-Language", required = false) locale: Locale): String {
        return messageSource.getMessage("good.morning.message", null, locale)
    }

    @GetMapping("/{name}")
    fun sayHelloToName(@PathVariable name: String): String {
        return "Hello, ${name}"
    }

}