package com.example.peerai;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class PeeraiToolWindowFactory implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(
            @NotNull Project project,
            @NotNull ToolWindow toolWindow
    ){


        TutorService tutorService = new TutorService();

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Peerai tutor");
        JButton askButton = new JButton("ask");
        JTextField questionField = new JTextField(20);

        panel.add(label);
        panel.add(questionField);
        panel.add(askButton);

        Content content = ContentFactory.getInstance()
                .createContent(panel, "", false);

        toolWindow.getContentManager().addContent(content);

        askButton.addActionListener(event ->
        {

            String question = questionField.getText();
            String response = tutorService.answer(question);
            label.setText(response);

        });

    }
}
