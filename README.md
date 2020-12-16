# Product Comparison Task

This project allows us to use three different data sources to import the various products.
The data sources are as follows:
    REST API (implemented)
    Pull
    Batch
The steps to add a new data source are as follows:
    Create a new interface for new data sources
    Classes that will use this data source must implement this interface.
    Privileges for vendors that use a new data source should be added to the database.
    Create a service like PullImportService and implement the logic.

I used MongoDB as the database as this is a proof-of-concept task and I felt like I could achive the most velocity with this.
If I developed this project for production, 
I would choose to store the product catalog in something like Solr or Elastic Search for their text search capabilities.

 
To test this project, execute the commands below

    `curl -X POST \
    -H "Content-Type: application/json" \
    -d '
    {
    "vendor" : "amazon",                                                    
    "apiKey" : "12345678",
    "privilege":"rest-api"
    }' \
    http://localhost:8080/vendor/create`


    `curl -X POST \
    -H "Content-Type: application/json" \
    -d '
    {
    "vendor" : "amazon",                                                    
    "privilege":"pull",
    "serviceName":"amazonVendorService"
    }' \
    http://localhost:8080/vendor/create`


    `curl -X POST \
    -H "Content-Type: application/json" \
    -d '
    {
    "vendor" : "ebay",                                                    
    "apiKey" : "87654321",
    "privilege":"rest-api"
    }' \
    http://localhost:8080/vendor/create`


    `curl -X POST \
    -H "api-key: 12345678" \
    -H "Content-Type: application/json" \
    -d '[
    {
    "category" : "phone",
    "price" : 1000,
    "name" : "iphone8","id":"2"
    },
    {
    "category" : "kitchen",
    "price" : 56,
    "name" : "Cooker","id":"1"
    }
    ]' \
    http://localhost:8080/admin/api/product`

    `curl -X POST \
    -H "api-key: 87654321" \
    -H "Content-Type: application/json" \
    -d '[
    {
    "category" : "phone",
    "price" : 1020,
    "name" : "iphone7","id":"2"
    },
    {
    "category" : "kitchen",
    "price" : 98,
    "name" : "Cooker-2","id":"1"
    }
    ]' \
    http://localhost:8080/admin/api/product`

    `curl -G --data-urlencode category='phone' --data-urlencode name='iphone' http://localhost:8080/product/search`

Technologies and libraries are basically like below:

1. `MongoDb` for database
2. `Mongo client` for connecting database
3. `Apache commons library` for some util classes
4. `Google guava library` for some util classes
5. `Spring Web` for rest api
6. `Junit 4` for tests
7. `Lombok` for data and logging support to getters and setters
8. `Docker` for running app in container


How to run locally with docker compose : 
1. `./start-app.sh` --> running tests, building application jar, and start docker-compose
2. `./stop-app.sh` --> stop docker container
