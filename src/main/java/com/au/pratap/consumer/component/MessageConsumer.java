package com.au.pratap.consumer.component;

import com.au.pratap.model.SystemMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Pratap
 */
@Component
public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    @JmsListener(destination = "ems-queue")
    public void messageListener(SystemMessage systemMessage) {

        LOGGER.info("Message received! {}", systemMessage.getMessageText());

        final RestTemplate restTemplate = new RestTemplate();

        final StringBuilder stringBuilder =  new StringBuilder("http://localhost:8080/account/");
        stringBuilder.append(systemMessage.getBsb()).append("/").append(systemMessage.getAccountNumber());

        Integer tAccountId = restTemplate.getForObject(stringBuilder.toString(), Integer.class);
        LOGGER.info("Account Id Fetched! {}", tAccountId);

        //Submit Kafka
    }
}
