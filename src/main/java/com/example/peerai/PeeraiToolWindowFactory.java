package com.example.peerai;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import javax.swing.JScrollPane;


public class PeeraiToolWindowFactory implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(
            @NotNull Project project,
            @NotNull ToolWindow toolWindow
    ){

        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel();
        JTextArea responseArea = new JTextArea();

        responseArea.setEditable(false);
        responseArea.setLineWrap(true);
        responseArea.setWrapStyleWord(true);

        JBScrollPane scrollPan = new JBScrollPane(responseArea);

        JButton askButton = new JButton("ask");
        JTextField questionField = new JTextField(20);

        inputPanel.add(questionField);
        inputPanel.add(askButton);

        panel.add(scrollPan, BorderLayout.CENTER);
        panel.add(inputPanel, BorderLayout.SOUTH);

        Content content = ContentFactory.getInstance()
                .createContent(panel, "", false);
        toolWindow.getContentManager().addContent(content);

        TutorService tutorService = new TutorService();

        askButton.addActionListener(event ->
        {

            Editor editor = FileEditorManager.getInstance(project)
                    .getSelectedTextEditor();

            if (editor == null){
                responseArea.setText("Open a file first");
                return;
            }
            String question = questionField.getText();
            String code = editor.getDocument().getText();
            String response = tutorService.answer(question, code);

              responseArea.setText(response);

        });

    }
}
