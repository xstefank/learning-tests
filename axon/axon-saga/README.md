
## Example Axon framework saga implementation

### Build

`mvn clean package`

### Start application

`mvn exec:java -Dstart-class=org.learn.axonframework.axonsaga.AxonSagaApplication`

### Post orders

`curl -H "Content-Type:application/json" -d '{"productName":"testProduct","description":"testing order"}' localhost:8080`

### Saga compensation example

create an order with product name __compensateSaga__

`curl -H "Content-Type:application/json" -d '{"productName":"compensateSaga","description":"testing order"}' localhost:8080`


