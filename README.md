# Car Catalog
Simple project based on a microservice's architecture. That's
shows list of car's with their name, description and rating for
user's. Main api is on port 8084. For a database is An embedded server of MongoDB. 
## Services and description
* `car-catalog-main` - main folder that consume information from rest of services
with car information's and create CatalogItem to user with all details
* `car-details` - provide details of specific car like power of car
* `car-rating` - provide rating of specific car
* `car-service` - provide car's to service
* `service-registration` - instance of eureka server to connect rest of services