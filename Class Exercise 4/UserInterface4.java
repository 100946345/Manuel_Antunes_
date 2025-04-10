/*   Name: Manuel Antunes
     Date: 2025-04-10
     Description: This program is a simple copy of Notepad, allowing the user
     to save and open files, clear the window, or exit the application.

*/

import javax.swing.*;
//basic windows tools
import java.awt.*;

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

    }
}
