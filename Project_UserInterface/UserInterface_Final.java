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


    public static void main(String[] args) {
        // runs Swing Event Dispatch Thread
        SwingUtilities.invokeLater(UserInterfaceFinal::new);
    }
}
