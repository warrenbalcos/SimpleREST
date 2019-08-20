# Simple REST Server

A simple REST API server using Spring Boot


## Getting Started


### Building the project

building the binaries 

```
./gradlew build
```

building the docker image

```
./gradlew build docker
```

### Running the docker image

```
docker run -p 8080:8080 -t com.wfdb/simplerest
```

### Running Tests

```
./gradlew test
```

Test results can be found here

build/reports/tests/test/index.html

### API Specs


```http
GET /echo?data=hello
```

| Parameter | Type | Description |
| :--- | :--- | :--- |
| `data` | `string` | **Required**. The Data to be echoed |


#### Response

format:

```javascript
{
  "count" : long,
  "content" : string
}
```

The `count` attribute contains the current number of calls to the echo endpoint

The `content` attribute contains the data being echoed back



### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

