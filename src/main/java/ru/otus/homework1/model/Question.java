package ru.otus.homework1.model;

public class Question {
    private String question;
    private String expectedAnswer;
    private String userAnswer;
    private Boolean isCorrect;

    public Question(String question, String expectedAnswer){
        this.question = question;
        this.expectedAnswer = expectedAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getExpectedAnswer() {
        return expectedAnswer;
    }

    public void setExpectedAnswer(String expectedAnswer) {
        this.expectedAnswer = expectedAnswer;
    }


    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "question : " + question +
                ". expectedAnswer:  " + expectedAnswer +
                ". userAnswer :" + userAnswer +
                ". User answer is correct? : " + isCorrect;
    }

}
