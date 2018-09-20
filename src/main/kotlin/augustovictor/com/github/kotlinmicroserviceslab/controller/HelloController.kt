package augustovictor.com.github.kotlinmicroserviceslab.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class HelloController {

    @GetMapping("")
    fun sayHello(): String {
        return "Hello"
    }

    @GetMapping("/{name}")
    fun sayHelloToName(@PathVariable name: String): String {
        return "Hello, ${name}"
    }

}