package com.shimunmatic.thundershare.service.definition.notification;

import com.shimunmatic.thundershare.model.Message;

public interface NotificationService {
    void sendNotification(Message message, String channel);
}
