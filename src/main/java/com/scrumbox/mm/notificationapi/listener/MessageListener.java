package com.scrumbox.mm.notificationapi.listener;

import com.scrumbox.mm.notificationapi.commons.QueueConstants;
import com.scrumbox.mm.notificationapi.commons.QueueEvents;
import com.scrumbox.mm.notificationapi.commons.QueueMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    private static final Logger log = LoggerFactory.getLogger(MessageListener.class);


    @RabbitListener(queues = QueueConstants.QUEUE_SPECIFIC_NAME)
    public void processNotification(QueueMessage queueMessage) {

        //Check and log the event
        if(queueMessage.getEventName().equals(QueueEvents.USER_CREATED)) {
            Integer userId = (Integer) queueMessage.getData();
            log.info("Got message with user id: {}", userId);
        }
    }
}
