package com.github.evgenylizogubov.jshomework13;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    
    @FXML
    TextArea questionArea;
    
    @FXML
    RadioButton answer1, answer2, answer3, answer4;
    
    @FXML
    ToggleGroup answers;
    
    private final String[] questions = {
            "Какой из этапов не относится к жизненному циклу сервлета?",
            "Как получить путь к каталогу src/test/resources в JUnit?",
            "Каким образом можно исключить поле Entity из маппинга?"
    };
    
    private final String[][] variants = {
            {"Обработка запроса service()", "Формирование ответа response()", "Инициализация init()", "Уничтожение destroy()"},
            {"Папка есть, но не используется тестами", "Вызвать Test.getResourcesPath()", "У тестов нет папки с ресурсами", "С помощью ClassLoader"},
            {"@Ignore", "@Transient", "@Immutable", "@Embedded"}
    };
    
    private final String[] correctVariants = {
            "Формирование ответа response()",
            "С помощью ClassLoader",
            "@Transient"
    };
    
    private int currentQuestion = 0;
    private int correctAnswerCount = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        questionArea.setText(questions[0]);
        answer1.setText(variants[0][0]);
        answer2.setText(variants[0][1]);
        answer3.setText(variants[0][2]);
        answer4.setText(variants[0][3]);
    }
    
    public void tryToAnswer() {
        if (answers.getSelectedToggle() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Выберите один из вариантов.");
            alert.showAndWait();
            return;
        }
        
        if (((RadioButton) answers.getSelectedToggle()).getText().equals(correctVariants[currentQuestion])) {
            correctAnswerCount++;
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Правильно!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Не правильно!");
            alert.showAndWait();
        }
        
        if (currentQuestion == 2) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "По результатам тестирования вы набрали " + correctAnswerCount + " баллов. Хотите попробовать ещё раз?");
            alert.showAndWait();
            if (alert.getResult().getText().equals("OK")) {
                currentQuestion = 0;
            } else {
                questionArea.getScene().getWindow().hide();
            }
        } else {
            currentQuestion++;
        }
        
        questionArea.setText(questions[currentQuestion]);
        answer1.setText(variants[currentQuestion][0]);
        answer2.setText(variants[currentQuestion][1]);
        answer3.setText(variants[currentQuestion][2]);
        answer4.setText(variants[currentQuestion][3]);
    }
}