package com.example.telegrambot.bot;

import java.io.IOException;
import java.util.function.Supplier;

import org.json.simple.parser.ParseException;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.CommandRegistry;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.example.telegrambot.bot.command.*;

public class Bot extends TelegramLongPollingCommandBot {

    private static final String BOT_NAME = "HelpToPlanStudyBot";
    private static final String BOT_TOKEN = "6015366458:AAHOfVyAH1zFCRIkmIgEBLh2artNvpntfTw";
    public CommandRegistry commandRegistry;

    public Bot(DefaultBotOptions botOptions) {
        super(botOptions, true);
        commandRegistry = new CommandRegistry(true, ?);
        // new StartCommand().register(this);
        // new MarkCommand().register(this);

        // new HelpCommand().register(this);

        register(new MarkCommand());

    }

    // @Override
    public final boolean register(CustomCommand botCommand) {
        return commandRegistry.register(botCommand);
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    public String getBotName() {
        return BOT_NAME;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());

            String ReceivedText = update.getMessage().getText();

            if (ReceivedText.equals("/mark")) {
                try {
                    ReceivedText = new MarkCommand().getmark("65913");
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }

            }

            message.setText(ReceivedText + " T_T");
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}