package com.oocode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Answerer {
    public String answerFor(String question) {
        question = question.replace("?", "");
        List<String> questionList = Arrays.asList(question.split(" "));
        if (Objects.equals(questionList.get(0), "What") && Objects.equals(questionList.get(1), "is")) {
            if (Objects.equals(questionList.get(3), "name")){
                return "TobiTill";
            } else if (Objects.equals(questionList.get(3), "plus")) {
                return String.valueOf(Integer.parseInt(questionList.get(2)) + Integer.parseInt(questionList.get(4)));
            } else if (Objects.equals(questionList.get(3), "multiplied")) {
                return String.valueOf(Integer.parseInt(questionList.get(2)) * Integer.parseInt(questionList.get(5)));
            } else if (Objects.equals(questionList.get(3), "minus")) {
                return String.valueOf(Integer.parseInt(questionList.get(2)) - Integer.parseInt(questionList.get(4)));
            } else if (Objects.equals(questionList.get(5), "power")) {
                return String.valueOf(Math.pow(Double.parseDouble(questionList.get(2)), Integer.parseInt(questionList.get(7))));
            }
        } else if (question.contains(":")) {
            String shortQ = question.split(":")[1];
            shortQ = shortQ.replace(" ", "");
            List<String> strList = Arrays.asList(shortQ.split(","));
            if (question.contains("Which of the following numbers is the largest:")) {
                return strList.stream().map(Integer::parseInt).max(Comparator.naturalOrder()).map(String::valueOf).get();
            }
        }
        if (question.contains("Which of the following numbers is the largest:")) {
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
            else if (question.contains("Which of the following numbers are primes:")) {
                List<String> questionList2 = Arrays.asList(question.split(":"));
                String t = questionList2.get(1).replace(" ", "");
                List<String> questionList3 = Arrays.asList(t.split(","));
                return questionList3.stream()
                        .map(Integer::parseInt)
                        .filter(num -> isPrime(num))
                        .map(String::valueOf)
                        .findFirst().get();
            }
        return "TobiTill";
    }

    private boolean isPrime(Integer num) {
        if (num % 2 == 0){
            return false;
        } else {
            for (double i=3; i<num; i=i+2){
                if (num/i == Math.floor(num/i)){
                    return false;
                }
            }
            return true;
        }
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
