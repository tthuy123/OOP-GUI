package com.example.gui;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MessageController {
    @FXML
    private VBox chatPane;
    @FXML
    private TextField messageField;
    @FXML
    private Button sendButton;
    @FXML
    private Label chatBubble;

    public void initialize() {
        sendButton.setOnAction(event -> sendMessage());
        messageField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                sendMessage();
            }
        });
    }
    @FXML
    public void sendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            addMessage(message);
            messageField.clear();
            showSentMessage(message);
        }
    }

    //   @FXML
    // public void handleSendButtonClick(MouseEvent event) {
//        sendMessage();
    //}

    private void addMessage(String message) {
        HBox container = new HBox();
        container.setAlignment(Pos.TOP_RIGHT);
        container.getStyleClass().add("left-aligned");
        Label chatBubble = new Label(message);
        chatBubble.getStyleClass().add("user-bubble");
        container.getChildren().add(chatBubble);
        chatPane.getChildren().add(container);
    }

    private void showSentMessage(String message) {
        if (chatBubble != null) {
            chatBubble.setText(message);
        }
    }
}