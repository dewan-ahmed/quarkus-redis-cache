# Quarkus Redis Project

This project uses [Quarkus](https://quarkus.io) (the Supersonic Subatomic Java Framework) and [Redis](https://redis.io/) (a distributed, in-memory key–value database) as a cache to store some GitHub metrics.

This project is a work-in-progress.

## Running the application in dev mode

You can run your application in dev mode:
```shell script
./mvnw quarkus:dev
```

To view the number of stars of an open-source GitHub project, navigate to **http://localhost:8080/stars?user=[user OR org name]&repo=[repository name]**.



## Related Guides

- Cache ([guide](https://quarkus.io/guides/cache)): Enable application data caching in CDI beans
- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more
