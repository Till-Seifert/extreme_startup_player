package com.oocode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Answerer {
    public String answerFor(String question) {
        question = question.replace("?", "");
        List<String> questionList = Arrays.asList(question.split(" "));
        if (Objects.equals(questionList.get(0), "What") && Objects.equals(questionList.get(1), "is")) {
            if (Objects.equals(questionList.get(3), "plus")) {
                return String.valueOf(Integer.parseInt(questionList.get(2)) + Integer.parseInt(questionList.get(4)));
            } else if (Objects.equals(questionList.get(3), "multiplied")) {
                return String.valueOf(Integer.parseInt(questionList.get(2)) * Integer.parseInt(questionList.get(5)));
            }
        } else if (question.contains("Which of the following numbers is the largest:")) {
            List<String> questionList2 = Arrays.asList(question.split(":"));
            String t = questionList2.get(1).replace(" ", "");
            List<String> questionList3 = Arrays.asList(t.split(","));
            var max1 = Math.max(Integer.parseInt(questionList3.get(0)), Integer.parseInt(questionList3.get(1)));
            return String.valueOf(Math.max(max1, Integer.parseInt(questionList3.get(2))));
        } else if (question.contains("Which of the following numbers is both a square and a cube:")) {
            List<String> questionList2 = Arrays.asList(question.split(":"));
            String t = questionList2.get(1).replace(" ", "");
            List<String> questionList3 = Arrays.asList(t.split(","));
            return questionList3.stream()
                    .map(Integer::parseInt)
                    .filter(num -> isCubed(num) && isSqua(num))
                    .map(String::valueOf)
                    .findFirst().get();
        }
        return "TobiTill";
    }

    private boolean isSqua(Integer num) {
        var sq = Math.sqrt(num);
        return Math.floor(sq) == sq;
    }

    private boolean isCubed(Integer num) {
        var sq = Math.cbrt(num);
        return Math.floor(sq) == sq;
    }
}
