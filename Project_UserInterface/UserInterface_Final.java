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


public class UserInterface_Final {
    //window frame
    private final JFrame frame;
    //all the components (textfield)
    private final JTextField txtPatient;
    private final JTextField txtOwner;
    private final JTextField txtEmail;
    //set the buttons
    private final JRadioButton rbAntunes;
    private final JRadioButton rbBalboa;
    //errors message
    private final JLabel lblMessage;


    public UserInterfaceFinal() {
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
        //add the component into the frame
        frame.add(txtEmail, layout);










        public static void main(String[] args) {
        // runs Swing Event Dispatch Thread
        SwingUtilities.invokeLater(UserInterfaceFinal::new);
    }
}
