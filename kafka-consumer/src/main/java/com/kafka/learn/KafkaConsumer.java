package com.kafka.learn;

import com.kafka.learn.entity.WikimediaEntity;
import com.kafka.learn.repo.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private WikimediaRepository wikimediaRepository;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(String eventMessage) {
        LOGGER.info("Event message received: {}", eventMessage);
        WikimediaEntity entity = new WikimediaEntity();
        entity.setData(eventMessage);
        WikimediaEntity entity1 = wikimediaRepository.save(entity);
        System.out.println(entity1.getData());
    }
}
