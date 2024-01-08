package proiect;

import javax.swing.*;
import java.awt.*;

public class label extends JButton {
    private JLabel label;

    public label(String buttonText, String labeltext,Color culoare) {
        super(buttonText);
        label = new JLabel(labeltext);
        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
        
        
        super.setPreferredSize(new Dimension(150, 50));
        super.setBackground(culoare);
        super.setForeground(Color.WHITE);
        super.setFont(new Font("Arial", Font.BOLD, 16));
        
    }

    // Example of setting text for the label
    public void setLabelText(String text) {
        label.setText(text);
    }

    
}
