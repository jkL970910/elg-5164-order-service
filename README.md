# elg5164-order-microservice
This is a microservice for managing orders in a SOA microservice architecture e-commerce platform. The microservice provides APIs for performing CRUD operations on orders.
## API Endpoints
Current Base URL: 34.148.161.115 

Get all orders: 
```
[Get] <Base URL>/orders
```
Get order by ID:
```
[Get] <Base URL>/orders/<id>
```
Create a order:
```
[Post] <Base URL>/orders
```
```
request body
{
    "productName": "testname",
    "postUserId": "1",
    "purchaseUserId": "2"
}
```
Creates a new order. The request body should be a JSON object containing the following fields:

- `productName` (string, required): The name of the product in the order.
- `postUserId` (number, required): The ID of the user who created the order.
- `purchaseUserId` (number, required): The ID of the user who purchased the order.

Delete order by ID:
```
[Delete] <Base URL>/orders/<id>
```
Delete all orders:
```
[Delete] <Base URL>/orders
```
## Getting Started

To get a local copy up and running follow these simple steps:

1. Clone the repository.
2. Build the project with Maven: `mvn clean install`.
3. Run the application: `java -jar target/elg5164-product-microservice-1.0.0.jar`.
4. Test the API endpoints using a tool like [Postman](https://www.postman.com/) or `curl`.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
