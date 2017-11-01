package org.learn.mdb;


import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.logging.Logger;

@MessageDriven(name = "HelloMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/HELLOMDBQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
})
public class HelloMDB implements MessageListener {

    private static final Logger log = Logger.getLogger(HelloMDB.class.getSimpleName());

    public void onMessage(Message message) {

        TextMessage textMessage = null;

        try {
            if (message instanceof TextMessage) {
                textMessage = (TextMessage) message;
                log.info("Received message from queue - " + textMessage.getText());
            } else {
                log.warning("Message of wrong type - " + message.getClass().getName());
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

    }
}
