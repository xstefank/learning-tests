
# Axon Saga example quickstart

This project is an example of the saga distributed user transaction processing using the [Axon framework](http://www.axonframework.org/) 

## Axon

Axon is a framework for developing reactive applications based on the CQRS principles. It is easy to start with as it went through major simplification of the APIs in the version 3. 

## CQRS

The Command Query Responsibility Segregation is a pattern based on the decomposition of the message processing into two domains - commands (e.g. CRUD operations) and queries (asking the application for information). The idea is that the commands in the application do not interact or effect the queries handled by events. By this principles it is possible to issue a command from the user and forget about it, the application would handle the processing and issue a new event about the command result. The query is then issued directly to the persistent store without issueing a command which should be faster. In this regard, this approach is suitable for applications with more requests for the data then the requests changing the data. What I see as a problem at least in the start of the application development the actual domain of the application needs to duplicated in the command and the query part. On the other hand, the domain can be shared in the separate jar file. The domain for commands and queries is expected to differ as the development of the application proceed (for instance - FileOrderCommand and OrderFiledEvent in this application).

## Basic implementation

### Commands

Commands are processed by methods annotated by `@CommandHandler` annotation. This method (or a constructor) is taking the desired command object as an argument and is invoked when the command is issued. Commands are by default distributed by the command bus which is separated from the event bus by invoking `CommandGateway#send` method (command gateway is injected by the container).

### Events 

Similar to commands, events have their handlers defined by the `@EventHandler` or `@EventSourcingHandler` and their own event bus. The handler again takes the desired event as an argument. Events are created with the static method __apply__ from the Axon framework.

### Aggregates

Aggreagates are groups of entities that together act as a single unit with regards to the data changes. If something changes the aggregate is always in the persistent state. It makes the decisions based on the incoming command and based on what happened in the past on what will happen when the command comes. The aggregate must be annotated with a `@Aggregate` annotation and it must have one mandatory field annotated with `@AggregateIdentifier`.

### Event sourcing 

TODO

## Saga

Axon has a basic support for sagas controlled by the events. The saga can be started with the annotation `@StartSaga` and ended with the static method __end__ or method annotated with `@EndSaga`. The handling of events is slightly different from normal event processing - instead of single instance of the event handler normally created it creates multiple instances of the sagas as there may be several sagas running in parallel. Each saga event handler takes in the annotation `@SageEventHandler` an __associationProperty__ which identifies the field of the issued event that identifies the saga this event is associated with (you can see the example in `OrderManagementSaga` class). Association properties can be also associated with the saga with the static methods __associateWith__ and __removeAssociationWith__.

### Saga compensation

As far as I was I able to look into Axon, it does not come with build in support for saga compenstations. I have implemented it in this project yet with another events and saga event handlers. Again the example is in the `OrderManagementSaga` class. 



