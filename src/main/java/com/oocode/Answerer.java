package com.oocode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Answerer {
    public String answerFor(String question) {
        List<String> questionList = Arrays.asList(question.split(" "));
        if (Objects.equals(questionList.get(0), "What") && Objects.equals(questionList.get(1), "is")) {
            return String.valueOf(Integer.parseInt(questionList.get(2)) + Integer.parseInt(questionList.get(4)));
        } else {
            switch (question) {
                case "What is your name?":
                    return "TobiTill";

            }
        }
        return "57";
    }
}
