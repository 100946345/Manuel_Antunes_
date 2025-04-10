/*   Name: Manuel Antunes
     Date: 2025-04-10
     Description: This program is a simple copy of Notepad, allowing the user
     to save and open files, clear the window, or exit the application.

*/

import javax.swing.*;
//basic windows tools
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class UserInterface4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Editor");
        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JTextArea with a scroll pane
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton saveButton = new JButton("Save");
        JButton openButton = new JButton("Open");
        JButton exitButton = new JButton("Exit");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(saveButton);
        buttonPanel.add(openButton);
        buttonPanel.add(exitButton);


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showSaveDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    try (FileWriter writer = new FileWriter(fileChooser.getSelectedFile())) {
                        writer.write(textArea.getText());
                        JOptionPane.showMessageDialog(frame, "File saved successfully!");
                        System.out.println("File saved at: " + fileChooser.getSelectedFile().getAbsolutePath()); // Debugging
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error saving file.", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            }
        });

    }
}
