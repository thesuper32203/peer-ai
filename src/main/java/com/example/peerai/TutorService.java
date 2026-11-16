package com.example.peerai;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;


public class TutorService {

    public String answer(String question, String code){

        if (question.isBlank())
        {
            return "Please enter question";
        }


        return "You asked: " + question + " Theres " + code.length() + " Characters";

    }


}
