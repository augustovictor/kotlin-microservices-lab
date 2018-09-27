# kotlin-microservices-lab

## Content negotiation
T

## Internationalization
To do this we have to add 2 instances to the execution env:
- `LocaleResolver`
- `ResourceBundleMessageSource`

All messages should go within a file named as `messages.properties`, `messages_pt.properties` 

ps: The client should specify in the header the attribute `Accept-Language` and a value. Eg.: pt, en.

## Api documentation

Add two dependencies:
- `springfox.swagger2`
- `springfox.swagger-ui`

