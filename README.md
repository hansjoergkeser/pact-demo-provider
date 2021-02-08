# Pact Demo Provider

<a href="https://github.com/hansjoergkeser/pact-demo-consumer/actions?query=workflow%3A%22Java+CI+with+Maven">
<img alt="GitHub Actions status" 
src="https://github.com/actions/cache/workflows/Tests/badge.svg?branch=main&event=push">
</a>

This is the sample web app from: <br>
https://dzone.com/articles/java-8-springboot-angularjs-bootstrap-springdata-j

and slightly modified for the purpose to demonstrate <br>
Consumer Driven Contract Testing `CDCT` with [Pact](https://pact.io/)

## Used frameworks & plugins

- [Spring Boot](https://spring.io/guides/gs/spring-boot/)
- [Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- springdoc-openapi with [Swagger UI](https://swagger.io/tools/swagger-ui/)
- [Lombok](https://projectlombok.org/) to create DTOs
  <br>(for usage in IntelliJ Idea, install [Lombok Plugin](https://projectlombok.org/setup/intellij))

## Start service

after first checkout/cloning the project, execute in terminal:

```yaml
mvn clean install -U
mvn spring-boot:run
```

> Note: Service runs on localhost:9090 (see or configure `server.port` in application.properties)

### pact-demo-consumer

Find the according consumer service here: <br>
https://github.com/hansjoergkeser/pact-demo-consumer