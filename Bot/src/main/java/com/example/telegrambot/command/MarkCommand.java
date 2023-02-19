package com.example.telegrambot.command;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class MarkCommand extends CustomCommands {
    public MarkCommand() {
        super("mark", "get average mar");
    }

    // private String getmark(String stud) throws IOException, ParseException {
    // URL url = new URL("http://127.0.0.1:5000/api/avg?stud=" + stud);
    // Scanner scanner = new Scanner((InputStream) url.getContent());
    // String result = "";
    // while (scanner.hasNext()) {
    // result += scanner.nextLine();
    // }
    // JSONParser parser = new JSONParser();
    // JSONObject JSobj = (JSONObject) parser.parse(result);

    // return (String) JSobj.get("avg_points");
    // }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage message = new SendMessage();
        message.setChatId(chat.getId().toString());

        // System.out.println("execute");
        String text = "no avg_points";

        // try {
        // // System.out.println(user.getId().toString());
        // text = this.getmark("65913");
        // } catch (IOException | ParseException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        message.setText(text);
        execute(absSender, message, user);

    }
}
