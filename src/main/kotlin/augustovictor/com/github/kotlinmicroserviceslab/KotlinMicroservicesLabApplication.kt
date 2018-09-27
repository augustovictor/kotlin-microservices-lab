package augustovictor.com.github.kotlinmicroserviceslab

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import java.util.*

@SpringBootApplication
class KotlinMicroservicesLabApplication

@Bean
fun localeResolver(): LocaleResolver {
    val localResolver = SessionLocaleResolver()
    localResolver.setDefaultLocale(Locale.US)
    return localResolver
}

@Bean
fun bundleMessageSource(): ResourceBundleMessageSource {
    val messageSource = ResourceBundleMessageSource()
    messageSource.setBasename("messages")
    return messageSource
}

fun main(args: Array<String>) {
    runApplication<KotlinMicroservicesLabApplication>(*args)
}
