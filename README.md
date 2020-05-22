This repo shows how to customize JSON serialization in Spring MVC.  To make this work ensure that the `@RequestBody` is in the Controller.

## Test

Launch the app:

```
mvn clean install spring-boot:run
```

Then use curl or your favorite tool to test it out.

```
curl -X POST \
  http://localhost:8080/syncToContact \
  -H 'content-type: application/json' \
  -d '{
    "lname":"Contact574",
    "fname":"User",
    "emailList":[
      {
        "email":"sample_contact_xyz5711e@example.net",
        "deleted":false,
        "id":0
      }
    ],
    "contactSource":"PieSync",
    "tags":[]
  }'
```

```
curl -X PATCH \
  http://localhost:8080/syncToContact \
  -H 'content-type: application/json' \
  -d '{
    "lname":"Contact574",
    "fname":"User",
    "emailList":[
      {
        "email":"sample_contact_xyz5711e@example.net",
        "deleted":false,
        "id":0
      }
    ],
    "contactSource":"PieSync",
    "tags":[]
  }'
```

## Alternative Approach: Using @JsonSerialize and @JsonDeserialize
A short cut sets the serializer and deserializer by adding the following annotations to the BasketItem class:

```java
@JsonDeserialize(using = SyncContactDeserializer.class)
@JsonSerialize(using = SyncContactSerializer.class)
public class SyncContact {
...
```

This approach removes the need for the `Jackson` module and thus is shorter and very straightforward. However, I tend to think it should only be used for simple applications. In systems composed of multiple modules, one would not want to spread the Jackson dependencies.