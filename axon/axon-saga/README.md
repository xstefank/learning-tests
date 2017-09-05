
## Example Axon framework saga implementation

### Build

`mvn clean package`

### Start application

`mvn exec:java -Dstart-class=org.learn.axonframework.axonsaga.AxonSagaApplication`

### Post orders

`curl -H "Content-Type:application/json" -d '{"productName":"testProduct","description":"testing order"}' localhost:8080`



