# kotlin-microservices-lab

## Annotations

### Core Spring Framework annotations
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

## HATEOAS (Hypermedia As The Engine Of Application State)
Describes what can be done with resources;

## Api documentation

Add two dependencies:
- `springfox.swagger2` -> `http://localhost:9000/v2/api-docs`
- `springfox.swagger-ui` -> `http://localhost:9000/swagger-ui.html`

## Monitoring
- SpringBoot Actuator: Provides maintenance endpoints for checking application health;
- SpringBoot Hal (Hypertext Application Language) Browser: Lets us see actuator in the browser;
    - To open `hal browser` navigate to `http://localhost:9000/browser/index.html`
    
## Properties filtering
We can do this statically at the `Bean` level with the annotation `@JsonIgnore`;
Or dinamically with a `FilterProvider` and `MappingJacksonValue`

## Resources versioning
- URI: `@GetMapping("/v1/users")`. Client: `http://localhost:9000/v1/users`
- Request Parameter versioning: `@GetMapping("/users", param = "version=1")`. Client: `http://localhost:9000/v1/users?version=1` 
- Header: `@GetMapping("/users", headers="X-API-VERSION=1")`. Client Header: key(`X-API-VERSION`), value(`1`)
- Produces (Accept Header Versioning/MimeType Versioning): `@GetMapping("/users", produces="application/vnd.company.app-v1+json")`. Client Header: key(`Accept`), value(`application/vnd.company.app-v1+json`)

What to consider when choosing:
- URI Polution;
- Missuse of HTTP Headers;
- Caching;
- Can we execute the request from a browser?
- How easy is it to generate docs?

## Security
Just add to your main application the annotation `@EnableWebSecurity`.

This will add the following properties:
```
security.basic.authorize-mode
security.basic.enabled
security.basic.path
security.basic.realm
security.enable-csrf
security.headers.cache
security.headers.content-security-policy
security.headers.content-security-policy-mode
security.headers.content-type
security.headers.frame
security.headers.hsts
security.headers.xss
security.ignored
security.require-ssl
security.sessions
```

## Richardson Maturity Model
- Level 1: Expose soap web services in a rest style: `http://server/getPosts` (Actions)
- Level 2: Expose resources with proper URI: `http://server/posts` (Resorces)
- Level 3: Implementation of `HATEOAS`. Data + next possible actions;

## Microservices concerns
- Bounded Contexts
- Configuration management
- Dynamic scale UP and scale DOWN
    - Naming server (Eureka)
    - Ribbon (Client side load balancer)
    - Feign (Easier REST APIS)
- Monitoring
    - Zipkin Distributed Tracing
    - Netflix Zuul API Gateway