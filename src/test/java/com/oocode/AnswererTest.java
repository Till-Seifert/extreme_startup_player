package com.oocode;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnswererTest {
    @Test
    public void canAnswerMyName() {
        var contents = new Answerer().answerFor("What is your name?");

        assertThat(contents, equalTo("TobiTill"));
    }

    @Test
    public void addTwoNumbers() {
        var contents = new Answerer().answerFor("What is 30 plus 82?");

        assertThat(contents, equalTo("112"));
    }

    @Test
    public void multiplyTwoNumbers(){
        var contents = new Answerer().answerFor("What is 3 multiplied by 4?");

        assertThat(contents, equalTo("12"));
    }


    @Test
    public void whichIsHighestNumber(){
        var contents = new Answerer().answerFor("Which of the following numbers is the largest: 52, 17, 57?");

        assertThat(contents, equalTo("57"));
    }

}