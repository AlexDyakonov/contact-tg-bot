package ru.home.bot;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.home.bot.config.BotConfig;


@Component
public class BotRealization extends TelegramLongPollingBot {
    @Autowired
    final BotConfig configuration;

    public BotRealization(BotConfig configuration) {
        this.configuration = configuration;
    }

    @Override
    public String getBotToken(){
        return configuration.getToken();
    }

    //главный метод бота, определяет, что делать ему когда человек пишет (типо UI)
    @Override
    public void onUpdateReceived(@NotNull Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            String message = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            String userName = update.getMessage().getChat().getUserName();
            switch (message){
                case "/start" -> startBot(chatId, userName);
                default -> sendMessage(chatId, "Не понял.");
            }
        }
    }

    private void startBot(long chatId, String userName){
        String answer = "Привет бебрик " + userName;
        sendMessage(chatId, answer);
    }

    private void sendMessage(long chatId, String message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return configuration.getName();
    }
}
