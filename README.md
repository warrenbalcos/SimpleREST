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

### Echo API

```http
GET /echo?data=hello
```

| Parameter | Type | Description |
| :--- | :--- | :--- |
| `data` | `string` | **Required**. The Data to be echoed |


response:

```javascript
{
  "count" : long,
  "content" : string
}
```

The `count` attribute contains the current number of calls to the echo endpoint

The `content` attribute contains the data being echoed back

### Math APIs

```http
GET /add?first=<number>&second=<number>

GET /subtract?first=<number>&second=<number>

GET /multiply?first=<number>&second=<number>

GET /divide?first=<number>&second=<number>
```

| Parameter | Type | Description |
| :--- | :--- | :--- |
| `first` | `float` | **Required**. the first number |
| `second` | `float` | **Required**. the second number |


response:

```javascript
{
	id: 1,
	first: 1.0,
	second: 2.0,
	result: 3.0
}
```

The `id` attribute contains a unique operation id

The `first` attribute contains the first number for the math operation

The `second` attribute contains the second number for the math operation

The `result` attribute contains the result of the math operation


### Translation APIs


#### Get the list of available translations

```http
GET /translations
```

response

```javascript
[
	{
		name: "English - US",
		language: "en",
		region: "us"
	},
	{
		name: "Hindi",
		language: "hi",
		region: "hi"
	},
	{
		name: "Chinese - China",
		language: "zh",
		region: "cn"
	}
]
```

The `name` attribute contains the name of the locale details

The `language` attribute contains the language code

The `region` attribute contains the region code  


#### Get the specific translation for a given language and region


```http
GET /translation?language=<string>&region=<string>
```

Response:

```javascript
{
	name: "English - US",
	language: "en",
	region: "us",
	entries: {
		hello_world_label: "Hello world!"
	}
}
```

The `name` attribute contains the name of the locale details

The `language` attribute contains the language code

The `region` attribute contains the region code  

The `entries` attribute contains the map of all the key value translations for the given translation  

```
*note: if the region is unavailable, the API will return a translation with an available language requested with a different region
```

### Author

* **Warren Balcos** - *Initial work* - [warrenbalcos](https://github.com/warrenbalcos)

### License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details


