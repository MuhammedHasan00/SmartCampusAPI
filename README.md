#SmartCampusAPI Report

#Part 1 (Setup & Discovery)

1. A JAX-RS Resource class by default is request-scoped, which means that the runtime creates a new instance for every incoming request. This aligns with the stateless architecture of RESTful services, where each request is independent and has all the information needed to be processed within it.
As each request gets a new instance, resource classes do not share instance-level state across the requests, but this does not mean that the application is automatically thread-safe. In this coursework, shared data is stored in in-memory collections such as HashMap and ArrayList, which can be found inside the mock database. These data structures are shared across all requests, meaning that multiple threads may access or modify them at the same time.
This fact introduces potential race conditions where concurrent requests could overwrite or, even worse, corrupt shared data. For example, in this coursework, one request could delete a room whilst another adds a sensor to it. Developers like ourselves must carefully manage shared data structures to prevent this, because whilst the lifecycle design helps to isolate request logic, we can still have errors.
This reinforces the principle of separation of concerns where resource classes handle HTTP interaction and data management is handled separately, for example, a DAO layer. In the real world and production systems, this problem would be easily solved by using thread-safe collections or databases. However, in this coursework, we assume controlled usage of shared memory whilst keeping resource classes stateless.

2. The provison of Hypermedia is considered a hallmark of advanced RESTful design because the server does't only return raw data but also returns navigational information about what the client can do next. Rather than the client having to hard-code every possible endpoint from the external documentation, the API cna simply include links to realted resources and collections in its response.
This is a huge benefit for client developers as it makes API's easier to explore and easier to evolve. An example from my coursework would be clients being able to start at the root endpoint '/api/v1', inspect the available links presented to them and then naviagate to the room and sensor resources without the need for static documenation. This is because the API itself becomes discoverable.
Maintainability is also a massive advantage as if the server changes the internal organisation of endpoints, hypermedia allows us to give the server more control over how clients navigate the API. Clients would follow links provided by the server as opposed to having fixed URL structures. This improves decoupling between the client and server.

#Part 2 (Room Management)

1. Returning only ID's rather than returning the full room objects has the advantage of smaller response payloads. This reduces network bandwidth usage and if there are many rooms there will be a much faster response. This is also very useful to the client as there will not be uneccesary data presented. Details will only be presented when requests are specifically made.
The main disadvantage is that the client will have to make additional requests to the API to get the full room information. This will increase client-side processing and create more network traffic. For example, if a client was to recieve a list of room IDs and wanted the room name, capacities, temperature etc then they would need to make new request for each one.
Returning only ID's is not as heavy for the bandwidth whilst returning the full objects may be easier for clients in some circumstances.

2. The DELETE operation is idempotent in my implementation as sending the same delete request multiple times shoudl nto prduces multiple different distructiuve effects. The first request for deletion should delete the room, and any follow up deletion requests for the same room will recieve the error that the room does not exist.
In my implementation the room is only deleted if it meets two conditions: it exists and no sensors are assigned to it. If these conditions are met, the deletion is successful and then another deletion request for the same room is made then a room not foound message will appear.

#Part 3 (Sensors & Filtering)

1. As we have used @Consumes (MediaType.APPLICATION_JSON), the JAX-RS runtime expects the request to be sent in JSON format, so if a client were to send something like 'text/plain' or 'application/xml', the runtime will reject the request before it is even executed. Due to the content type mismatch, the runtime cannot safely deserialise the body into Java.
This is essential because the @Consumes annotation acts like a contract between the client and the API and lets the client know what format is accepted and protects the server from unsupported formats.

2. The query parameter approach is considered superior for filtering and searching collections, as they represent optional constraints applied to all collection resources rather than identifying a completely different resource. For example, '/api/v1/sensors?type=CO2' refers to the sensor resource but with a filter applied.
If the filter were placed directly in the path, like '/api/v1/sensors/type/CO2', the URL would look more like a separate sub-resource than a filter. This is less expressive when multiple filters are needed. Query parameters make it much easier to combine multiple filters, for example, '?type=CO2&status=ACTIVE'.

#Part 4 (Sub - Resources)

The sub-resource locator pattern improves API structure by delegating nested resource handling to a separate class rather than forcing every nested endpoint into one large controller. In this coursework, the 'SensorResource' is responsible for the main sensors at '/sensors', whilst 'SensorReadingResource' is responsible for '/sensors/{sensorId}/readings'. This clearly separates responsibilities.
As nested resources have their own logic, validation and rules, this level of separation can help manage the complexity. If all the paths were placed into one class, it would be very hard to read, maintain and debug.
Adding extra reading operations to 'SensorReadingResource' rather than cluttering the sensor class would improve maintainability. The code would be easier to find, it would be easier to test logic in isolation and easier to extend the API in the future.

#Part 5 (Error Handling and Logging)

1. HTTP 422 is often considered more semantically accurate than a standard 404 when the issue is missing a reference inside a valid JSON payload, as with a 422, the request itself is well informed, and the target endpoint does exist, but the data inside the request is what cannot be processed correctly. For example, if the client were to post a new sensor with a room ID that doesn't exist, the JSON syntax may be valid, and the sensors endpoint is real, but the request is still invalid.
A HTTP 404 error usually implies that the requested URL resource could not be found. In this specific case, this is not the issue as the direct path is not missing, but the payload references a resource that doesn't exist. This is why 422 communicates the error better, especially to client developers, as it is more precise with the issue.

2. From a cybersecurity standpoint, exposing internal Java stack traces to external API consumers is very dangerous, as stack traces reveal private implementation details. They could expose a lot of data, including class names, package names, framework components, method names, the execution path that led to the error and more.
With this information, an attacker could easily use this information to learn how the application is structured internally, making reconnaissance easier and allowing for more targeted attacks. They may learn which frameworks are in use, identify library versions and discover where validation and exception handling are weak.
For these reasons it’s much safer to return a generic 500 response to the client while logging the technical details only on the server side.

3. JAX-RS filters are better for cross-cutting concerns such as logging, as it applies to many endpoints rather than having to manually insert Logger.info() statements into every method, making the code repetitive and harder to maintain. By using a 'ContainerRequestFilter' and 'ContainerResponseFilter', we can centralise the logging logic, and all the incoming requests and outgoing responses can be logged in one place without duplicate code.
This would improve maintainability as changes to the logging behaviour would only need to be made once, rather than individually changing every Logger.info() statement.
