# spring-boot-model-mapper-ex
run the project first. Automatic create database[need to valid db credentials] and user,book,post,comment.
post response
http://localhost:8989/book/2
```

{
  "id": 2,
  "title": "Man of Supreme",
  "description": "Man of supreme",
  "author": {
    "id": 2,
    "username": "user"
  },
  "isPublished": true,
  "posts": [
    {
      "id": 2,
      "title": "Great Book",
      "content": "if you read the book you can learn!!",
      "comments": [
        {
          "id": 2,
          "comment": "Great Book Again Same User",
          "user": {
            "id": 1,
            "username": "author"
          }
        },
        {
          "id": 3,
          "comment": "Great Book Again Same User",
          "user": {
            "id": 1,
            "username": "author"
          }
        }
      ]
    }
  ]
}
```
