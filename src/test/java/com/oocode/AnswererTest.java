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

    public void addTwoNumbers() {
        var contents = new Answerer().answerFor("What is 30 plus 82?");

        assertThat(contents, equalTo("112"));
    }


}