package org.learn.axonframework.axonlt;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.learn.axonframework.axonlt.coreapi.CreateAccountCommand;
import org.learn.axonframework.axonlt.coreapi.RequestMoneyTransferCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class TransferController {

    @Autowired
    private CommandGateway commandGateway;

    @RequestMapping("/")
    @ResponseBody
    public String sendMessage() {

        commandGateway.send(new CreateAccountCommand("1234", 500), LoggingCallback.INSTANCE);
        commandGateway.send(new CreateAccountCommand("4321", 500), LoggingCallback.INSTANCE);
        commandGateway.send(new RequestMoneyTransferCommand("tf1", "1234", "4321", 100), LoggingCallback.INSTANCE);

        return "OK";
    }

    @RequestMapping("/transfer/{sourceAccount}/{destinationAccount}/{amount}")
    @ResponseBody
    public String transfer(@PathVariable String sourceAccount, @PathVariable String destinationAccount, @PathVariable int amount) {
        commandGateway.send(new RequestMoneyTransferCommand(UUID.randomUUID().toString(),
                sourceAccount, destinationAccount, amount), LoggingCallback.INSTANCE);
        return "OK";
    }


}
