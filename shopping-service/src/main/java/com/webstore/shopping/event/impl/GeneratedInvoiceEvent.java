package com.webstore.shopping.event.impl;

import com.webstore.shopping.config.MQConfig;
import com.webstore.shopping.model.message.InvoiceMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeneratedInvoiceEvent {

    private final RabbitTemplate template;

    @Autowired
    public GeneratedInvoiceEvent(RabbitTemplate template) {
        this.template = template;
    }

    public void sendMessage(InvoiceMessage message) {
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);
    }
}
