package org.example;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class UserContext {
    //public final long chatId;
    public final String firstName;
    public final LocalDateTime now;
    public final String messageText;
    public final Set<String> tags = new HashSet<>(); // Сюда фильтры пишут метки (morning, weekend, sad...)

    public UserContext(String firstName, String messageText) {
        //this.chatId = chatId;
        this.firstName = firstName;
        this.messageText = messageText.toLowerCase();
        this.now = LocalDateTime.now();
    }
}

