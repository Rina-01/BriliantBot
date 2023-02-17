package com.example.telegrambot.bot;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "HelpToPlanStudyBot";
    }

    @Override
    public String getBotToken() {
        return "6015366458:AAHOfVyAH1zFCRIkmIgEBLh2artNvpntfTw";
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
            switch (UserText) {
                case "/mark":
                    try {
                        UserText = this.getmark("65913");
                    } catch (IOException | ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                default:
                    UserText += " :))";
            }

            message.setText(UserText); // сохраняем в переменную для отправки

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private String getmark(String stud) throws IOException, ParseException {
        URL url = new URL("http://127.0.0.1:5000/api/avg?stud=" + stud);
        Scanner scanner = new Scanner((InputStream) url.getContent());
        String result = "";
        while (scanner.hasNext()) {
            result += scanner.nextLine();
        }
        JSONParser parser = new JSONParser();
        JSONObject JSobj = (JSONObject) parser.parse(result);

        return (String) JSobj.get("avg_points");
    }
}