# Sample Spring i18ns bits and pieces

Super small example demonstrating a few Spring out of the box things - mostly for i18n / property bits.

Not quite prod-ready code - i.e a bit rough round the edges, but just to demonstrate the concepts.

## Configuration Properties Binding

https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config-java-bean-binding

Useful for binding directly to a fragment of yaml - esp in cases where there's some simple static values or 
bits that are easy to read describe in a nested block / keyed by some values.

 
## Message Source

https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-internationalization

Just to demonstrate programmatic usage of MessageSource for translating message keys with optional args.

Often templates are used in conjunction which wouldn't require explicit usage, but sometimes (i.e when creating 
APIs in backend-for-frontend type service it can be handy to use in such a manner).

You would'nt normally hand craft / edit the resource bundle files - perhaps a tool like Crowdin would generate these 
in CI using a translator service as an input.


## Locale

https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/web.html#mvc-localeresolver

Spring has various strategies to determine locale of the current request. The most commonly used and one of the default registered 
is to parse the Accept Language header on an inbound http request. This will automatically get bound to a parameter of a controller
method if specified.


## Run it

Run the app locally, and head to:

```
localhost:8080/fun
```

Set the `Accept-Language` to your favourite language for _even_ more fun.
