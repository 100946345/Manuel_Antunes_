/*   Name: Manuel Antunes
Date: 2025-04-17
Description: This Veterinary Clinic program allows customers to enter their
information and securely store it in the company's database for easy access
and record management.

 */
//user interface elements
import javax.swing.*;
//layout and design
import java.awt.*;

//action taken for buttons
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//write in the textfield
import java.io.FileWriter;
import java.io.IOException; //Errors

import java.util.Date;
//checks the emails format
import java.util.regex.Pattern;


class Patient {
    private final String name;
    private final String owner;
    private final String email;
    private final String veterinarian;
}


public class VeterinaryClinicUI {
    //window frame
    private final JFrame frame;
    //all the components (textfield)
    private final JTextField txtPatient;
    private final JTextField txtOwner;
    private final JTextField txtEmail;
    //set the buttons
    private final JRadioButton rbAntunes;
    private final JRadioButton rbBalboa;
    private final JRadioButton rbTaboada
    //errors message
    private final JLabel lblMessage;


    public VeterinaryClinicUI() {
        frame = new JFrame("Veterinary clinic [Patient registration]");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        //variable that let me edit the layout
        frame.setLayout(new GridBagLayout());
        //creates the object for the layout position
        GridBagConstraints layout = new GridBagConstraints();
        //space 10px
        layout.insets = new Insets(10, 10, 10, 10);
        layout.fill = GridBagConstraints.HORIZONTAL;

        // Font Sizes
        Font labelFont = new Font("Arial", Font.BOLD, 20);
        Font inputFont = new Font("Arial", Font.PLAIN, 18);
        Dimension inputSize = new Dimension(350, 40);


        // Patient Name
        layout.gridx = 0; layout.gridy = 0;
        JLabel lblPatient = new JLabel("Patient Name:");
        lblPatient.setFont(labelFont);
        //add the component into the frame
        frame.add(lblPatient, layout);
        layout.gridy = 1;
        txtPatient = new JTextField();
        txtPatient.setPreferredSize(inputSize);
        txtPatient.setFont(inputFont);
        txtPatient.setToolTipText("Enter the name of the patient");
        //add the component into the frame
        frame.add(txtPatient, layout);


        // Owner Name
        layout.gridx = 0; layout.gridy = 2;
        JLabel lblOwner = new JLabel("Owner Name:");
        lblOwner.setFont(labelFont);
        //add the component into the frame
        frame.add(lblOwner, layout);
        layout.gridy = 3;
        txtOwner = new JTextField();
        txtOwner.setPreferredSize(inputSize);
        txtOwner.setFont(inputFont);
        txtOwner.setToolTipText("Enter the name of the pet owner");
        //add the component into the frame
        frame.add(txtOwner, layout);


        // Email Address
        layout.gridx = 0; layout.gridy = 4;
        JLabel lblEmail = new JLabel("Email Address:");
        lblEmail.setFont(labelFont);
        //add the component into the frame
        frame.add(lblEmail, layout);
        layout.gridy = 5;
        txtEmail = new JTextField();
        txtEmail.setPreferredSize(inputSize);
        txtEmail.setFont(inputFont);
        txtEmail.setToolTipText("Enter a valid email address");
        //add the component into the frame
        frame.add(txtEmail, layout);


        // Veterinarian
        layout.gridx = 0; layout.gridy = 6;
        JLabel lblVet = new JLabel("Choose the Veterinarian:");
        lblVet.setFont(labelFont);
        //add the component into the frame
        frame.add(lblVet, layout);
        layout.gridy = 7;
        rbAntunes = new JRadioButton("Dr. Antunes", true);
        rbBalboa = new JRadioButton("Dr. Balboa");
        rbTaboada = new JRadioButton("Dr. Taboada");

        //group of vet options selected
        ButtonGroup vetGroup = new ButtonGroup();
        vetGroup.add(rbAntunes);
        vetGroup.add(rbBalboa);
        vetGroup.add(rbTaboada);

        //layout buttons
        JPanel vetPanel = new JPanel(new GridLayout(1, 3));
        rbAntunes.setFont(inputFont);
        rbBalboa.setFont(inputFont);
        rbTaboada.setFont(inputFont);
        // add radio buttons into the vetPanel format
        vetPanel.add(rbAntunes);
        vetPanel.add(rbBalboa);
        vetPanel.add(rbTaboada);
        //add the components as part of the frame
        frame.add(vetPanel, layout);



        // Message Label
        layout.gridy = 8;
        //new label
        lblMessage = new JLabel(" ");
        lblMessage.setFont(labelFont);
        //add the component into the frame
        frame.add(lblMessage, layout);


        // News buttons
        layout.gridy = 9;
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        JButton btnRegister = new JButton("Register");
        JButton btnClear = new JButton("Clear");
        JButton btnExit = new JButton("Exit");


        btnRegister.setFont(inputFont);
        btnClear.setFont(inputFont);
        btnExit.setFont(inputFont);

        //add them into the buttonPanel
        buttonPanel.add(btnRegister);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnExit);
        //add the components into the frame
        frame.add(buttonPanel, layout);

        // Event Listeners (clicked)
        btnRegister.addActionListener(new UserInterface_Final.RegisterTaken());
        btnClear.addActionListener(_-> clearFrame());
        btnExit.addActionListener(_-> System.exit(0));//no errors

        //prompt the frame
        frame.setVisible(true);
    }

    private void clearFrame() {
        txtPatient.setText("");
        txtOwner.setText("");
        txtEmail.setText("");
        rbAntunes.setSelected(true);
        lblMessage.setText(" ");
    }


    //button click event
    private class RegisterTaken implements ActionListener {
        //replace a method
        @Override
        public void actionPerformed(ActionEvent e) {
            //steal the txtPatient into patient
            String patient = txtPatient.getText().trim();
            String owner = txtOwner.getText().trim();
            String email = txtEmail.getText().trim();
            //ternary operator
            String vet = rbAntunes.isSelected() ? "Dr. Antunes" :
                    rbBalboa.isSelected() ? "Dr. Balboa" : "Dr. Taboada";

            // Error Messages
            //StringBuilder object
            StringBuilder errorMessage = new StringBuilder();
            if (patient.isEmpty())
                errorMessage.append("Patient name cannot be empty.<br>");
            if (owner.isEmpty())
                errorMessage.append("Owner name cannot be empty.<br>");
            if (!isValidEmail(email))
                errorMessage.append("Invalid email address.<br>");

            //return those errors to the user
            if (!errorMessage.isEmpty()) {
                lblMessage.setText("<html>" + errorMessage + "</html>");
                return;
            }


            Date date = new Date();
            //open file browser window
            JFileChooser fileChooser = new JFileChooser();
            //title
            fileChooser.setDialogTitle("Save Patient Record");

            //Open the "save as" window
            if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                //let the user write the file's name
                try (FileWriter writer = new FileWriter(fileChooser.getSelectedFile())) {
                    writer.write("**Patient Registration Document**\n");
                    writer.write("Patient: " + patient + "\n");
                    writer.write("Owner: " + owner + "\n");
                    writer.write("Email: " + email + "\n");
                    writer.write("Veterinarian: " + vet + "\n");
                    writer.write("Date: " + date + "\n");
                    lblMessage.setText("File saved successfully!");
                } catch (IOException ex) {
                    lblMessage.setText("Error: Unable to save file.");
                }
            }
        }

        //Email Validation
        private boolean isValidEmail(String email) {
            String regexPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
            return Pattern.compile(regexPattern).matcher(email).matches();
        }
    }

        public static void main(String[] args) {
        // runs Swing Event Dispatch Thread
        SwingUtilities.invokeLater(UserInterface_Final::new);
    }
}
