package org.example;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final List<String> COMPLIMENTS = List.of(
            "ты всегда хорошо одеваешься!",
            "твоя улыбка делает этот день светлее!",
            "ты вдохновляешь окружающих!",
            "с тобой всегда приятно общаться!",
            "у тебя отличное чувство юмора!"
    );

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите токен:");
        String botToken = in.nextLine();

        TelegramBot bot = new TelegramBot(botToken);
        Random random = new Random();

        System.out.println("[LOG] Бот запущен...");

        bot.setUpdatesListener(updates -> {
            for (Update update : updates) {
                try {
                    if (update.message() != null &&
                            update.message().text() != null &&
                            "/compliment".equals(update.message().text())) {

                        String firstName = update.message().from().firstName();
                        long chatId = update.message().chat().id();

                        String randomCompliment = COMPLIMENTS.get(random.nextInt(COMPLIMENTS.size()));
                        String responseText = firstName + ", " + randomCompliment;

                        bot.execute(new SendMessage(chatId, responseText));
                        System.out.println("[LOG] Отправлен комплимент пользователю: " + firstName);
                    }
                } catch (Exception e) {
                    System.out.println("[LOG] Ошибка при обработке сообщения: " + e.getMessage());
                }
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });

        System.out.println("[LOG] Бот готов к работе. Нажмите Enter для остановки...");
        in.nextLine();
        System.out.println("[LOG] Бот остановлен");
    }
}