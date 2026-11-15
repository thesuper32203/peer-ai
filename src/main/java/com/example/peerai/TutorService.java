package com.example.peerai;

public class TutorService {

    public String answer(String question){

        if (question.isBlank())
        {
            return " ";
        }

        return "You asked: " + question;

    }


}
