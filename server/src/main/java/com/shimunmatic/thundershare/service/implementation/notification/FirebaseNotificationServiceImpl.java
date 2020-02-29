package com.shimunmatic.thundershare.service.implementation.notification;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.shimunmatic.thundershare.model.Message;
import com.shimunmatic.thundershare.service.definition.config.ConfigurationConstants;
import com.shimunmatic.thundershare.service.definition.config.ConfigurationService;
import com.shimunmatic.thundershare.service.definition.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
public class FirebaseNotificationServiceImpl implements NotificationService {
    private ConfigurationService configurationService;

    @Autowired
    public FirebaseNotificationServiceImpl(@Qualifier("db") ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @PostConstruct
    private void init() throws IOException {
        String firebaseAdminJson = configurationService.getConfigurationValue(ConfigurationConstants.CONFIG_FIREBASE_ADMIN_JSON);
        assert firebaseAdminJson != null;
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(new ByteArrayInputStream(firebaseAdminJson.getBytes())))
                .setDatabaseUrl("https://thunder-share.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
    }

    @Override
    public void sendNotification(Message message, String channel) {

    }
}
