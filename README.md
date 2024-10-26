# Blog API

A RESTful API built with Spring Boot that provides CRUD operations for a personal blogging platform.

## Features

- Create new blog posts
- Retrieve single and multiple blog posts
- Update existing blog posts
- Delete blog posts
- Search functionality across title, content, and category
- SQL database integration
- Input validation and error handling

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL Database
- Gradle

## API Endpoints

### Create Blog Post
```http
POST /posts

Request Body:
{
    "title": "My First Blog Post",
    "content": "This is the content of my first blog post.",
    "category": "Technology",
    "tags": ["Tech", "Programming"]
}

Response: 201 Created
{
    "id": 1,
    "title": "My First Blog Post",
    "content": "This is the content of my first blog post.",
    "category": "Technology",
    "tags": ["Tech", "Programming"],
    "createdAt": "2024-10-26T12:00:00Z",
    "updatedAt": "2024-10-26T12:00:00Z"
}
```

### Get All Posts
```http
GET /posts

Response: 200 OK
[
    {
        "id": 1,
        "title": "My First Blog Post",
        "content": "This is the content of my first blog post.",
        "category": "Technology",
        "tags": ["Tech", "Programming"],
        "createdAt": "2024-10-26T12:00:00Z",
        "updatedAt": "2024-10-26T12:00:00Z"
    }
]
```

### Get Single Post
```http
GET /posts/{id}

Response: 200 OK
{
    "id": 1,
    "title": "My First Blog Post",
    "content": "This is the content of my first blog post.",
    "category": "Technology",
    "tags": ["Tech", "Programming"],
    "createdAt": "2024-10-26T12:00:00Z",
    "updatedAt": "2024-10-26T12:00:00Z"
}
```

### Update Post
```http
PUT /posts/{id}

Request Body:
{
    "title": "Updated Blog Post",
    "content": "Updated content of my blog post.",
    "category": "Technology",
    "tags": ["Tech", "Programming"]
}

Response: 200 OK
{
    "id": 1,
    "title": "Updated Blog Post",
    "content": "Updated content of my blog post.",
    "category": "Technology",
    "tags": ["Tech", "Programming"],
    "createdAt": "2024-10-26T12:00:00Z",
    "updatedAt": "2024-10-26T12:30:00Z"
}
```

### Delete Post
```http
DELETE /posts/{id}

Response: 204 No Content
```

### Search Posts
```http
GET /posts?term={searchTerm}

Response: 200 OK
[
    {
        "id": 1,
        "title": "My Tech Blog Post",
        "content": "Content matching search term...",
        "category": "Technology",
        "tags": ["Tech", "Programming"],
        "createdAt": "2024-10-26T12:00:00Z",
        "updatedAt": "2024-10-26T12:00:00Z"
    }
]
```

## Getting Started

### Prerequisites

- Java 17 or higher
- MySQL 8.0 or higher
- Gradle 7.0 or higher

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/blog-api.git
```

2. Navigate to the project directory:
```bash
cd blog-api
```

3. Configure database connection in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blog_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

4. Build the project:
```bash
./gradlew build
```

5. Run the application:
```bash
./gradlew bootRun
```

The API will be available at `http://localhost:8080`
### Requriements
Requirements are taken from https://roadmap.sh/projects/blogging-platform-api
