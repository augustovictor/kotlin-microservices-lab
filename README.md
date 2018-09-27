# kotlin-microservices-lab

## Annotations

### Core Spring Framework anontations
- `@Bean` - Works as a bean ID. It creates and returns the actual bean within `@Configuration` classes;
- `@Configuration` - Used on classes that define `beans`. Its analog to XML config files; 
- `@ComponentScan` -  Allow spring to know which packages to look for components;

### SpringBoot annotations
- `@EnableAutoConfiguration` -  Tells spring to start adding beans based on classpath settings, other beans, and property settings;
- `@SpringBootApplication` - Does a component scan through its subpackages;
    - Includes the following annotations: `@Configuration`, `@EnableAutoConfiguration`, `@ComponentScan`;
        

## Content negotiation


## Internationalization
To do this we have to add 2 instances to the execution env:
- `LocaleResolver`
- `ResourceBundleMessageSource`

All messages should go within a file named as `messages.properties`, `messages_pt.properties` 

ps: The client should specify in the header the attribute `Accept-Language` and a value. Eg.: pt, en.

## Api documentation

Add two dependencies:
- `springfox.swagger2` -> `http://localhost:9000/v2/api-docs`
- `springfox.swagger-ui` -> `http://localhost:9000/swagger-ui.html`

