package com.example.telegrambot.bot;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.example.telegrambot.command.*;

public class Bot extends TelegramLongPollingBot {

    private static final String BOT_NAME = "HelpToPlanStudyBot";
    private static final String BOT_TOKEN = "6015366458:AAHOfVyAH1zFCRIkmIgEBLh2artNvpntfTw";

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    public Bot(DefaultBotOptions botOptions) {
        super(botOptions, BOT_NAME);

        System.out.println(new MarkCommand());

    }

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());

            String UserText = update.getMessage().getText(); // сохраняем полученный от пользователя текст в отдельную
                                                             // переменную

            // изменяем как хотим UserText
            UserText += " :))";

            message.setText(UserText); // сохраняем в переменную для отправки

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

}