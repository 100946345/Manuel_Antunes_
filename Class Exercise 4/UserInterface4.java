import javax.swing.*;
//basic windows tools
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class userInterface {
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
        JButton clearButton = new JButton("Clear");


        // Panel to hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(saveButton);
        buttonPanel.add(openButton);
        buttonPanel.add(clearButton);
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


        // Open button functionality
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                        textArea.setText("");
                        String line;
                        while ((line = reader.readLine()) != null) {
                            textArea.append(line + "\n");
                        }
                        JOptionPane.showMessageDialog(frame, "File loaded successfully!");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error encounter.", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Exit Button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Terminates the program
            }
        });


        //Clear Button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(""); // Clears all text
            }
        });





        frame.setLayout(new BorderLayout());
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}