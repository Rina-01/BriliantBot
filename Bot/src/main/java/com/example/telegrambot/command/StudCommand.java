// package com.example.telegrambot.command;

// import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
// import org.telegram.telegrambots.meta.api.objects.Chat;
// import org.telegram.telegrambots.meta.api.objects.User;
// import org.telegram.telegrambots.meta.bots.AbsSender;

// import com.example.telegrambot.bot.Bot;

// public class StudCommand extends CustomCommands {
// private String Stud;

// public StudCommand() {
// super("stud", "set student number");
// }

// @Override
// public void execute(AbsSender absSender, User user, Chat chat, String[]
// arguments) {
// StringBuilder sb = new StringBuilder();

// SendMessage message = new SendMessage();
// message.setChatId(chat.getId().toString());

// String displayedStud = getStud(arguments);

// if (displayedStud == null) {
// message.setText("Your student number cannot be empty!");
// execute(absSender, message, user);
// return;
// }

// StringBuilder sb = new StringBuilder();

// if (mAnonymouses.setUserDisplayedName(user, displayedStud)) {

// if (mAnonymouses.getDisplayedName(user) == null) {
// sb.append("Your displayed name: '").append(displayedStud)
// .append("'. Now you can see your mark!");
// } else {
// sb.append("Your new displayed name: '").append(displayedStud).append("'.");
// }
// } else {
// sb.append("Name ").append(displayedStud).append(" is already in use! Choose
// another name!");
// }

// message.setText(sb.toString());
// execute(absSender, message, user);
// }

// private String getStud(String[] strings) {
// if (strings == null || strings.length == 0) {
// return null;
// }

// String name = String.join(" ", strings);
// return name.replaceAll(" ", "").isEmpty() ? null : name;
// }
// }
