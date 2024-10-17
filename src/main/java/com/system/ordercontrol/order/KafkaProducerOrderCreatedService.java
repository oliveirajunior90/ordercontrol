package com.system.ordercontrol.order;

import com.system.ordercontrol.protobuf.OrderProto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerOrderCreatedService {

    private final String topicName;

    private final KafkaTemplate<String, Byte[]> kafkaTemplate;

    public KafkaProducerOrderCreatedService(
            @Value("${order-created-topic-name}") String topicName, KafkaTemplate<String, Byte[]> kafkaTemplate
    ) {
        this.topicName = topicName;
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendOrderCreated(OrderProto.Order order) {
        byte[] byteArray = order.toByteArray();
        Byte[] byteObjectArray = new Byte[byteArray.length];
        kafkaTemplate.send(topicName, order.toByteArray());
    }

}
