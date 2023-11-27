package proiect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GUI {
	
	private static String activeUser;
	private static String nume;
	
	public GUI() {
		
	}
	
private static boolean isValidUser_log_in(String username,String password) {
        
		Map<String,String> verificare = new HashMap<String,String>();
		verificare.put(username,password);
		
		for (Map.Entry<String, String> m : DataBase.afisare_log_in().entrySet())
		{ 
			if(m.getKey().equals(username) && m.getValue().equals(password))
					return true;
       } 
		
		return false;
    }
	
	private static boolean isValidUser_sign_in(String username) {
        
		ArrayList<String> utilizator = new ArrayList<String>();
		utilizator.add(username);
		
		return Collections.disjoint(DataBase.afisare_sign_in(), utilizator);
    }
	
    public static void main(String[] args) {
    	
    	System.out.println(DataBase.afisare_log_in());
    	
    	
    	
    	
    	
        // Create a JFrame
        JFrame firstframe = new JFrame("Multiple Buttons Example");
        JFrame menuFrame = new JFrame("Menu");
        JPanel menuPanel = new JPanel();

        // Set the default operation when the close button is clicked
        firstframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Dispose on close, not exit

        // buttons
        JButton button1 = new JButton("log in");
        JButton button2 = new JButton("sign in");
        JButton button3 = new JButton("agenda");
        JButton adaugaPersoana = new JButton("Adauga peroana");
        JButton stergePersoana = new JButton("Sterge persoana");
        JButton updatePersoana = new JButton("Update persoana");
        
        


        // Set preferred sizes for buttons
        button1.setPreferredSize(new Dimension(100, 30));
        button2.setPreferredSize(new Dimension(100, 30));
        button3.setPreferredSize(new Dimension(100, 30));
        
        //menu
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuFrame.getContentPane().add(menuPanel);
        menuPanel.add(button3);
        menuFrame.setSize(500, 400);
        menuFrame.setLocationRelativeTo(null);
        
        

        
        button1.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new JFrame for the sign-in form
                JFrame logInFrame = new JFrame("Log In Form");
                logInFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose on close, not exit

                JPanel logInPanel = new JPanel();
                JTextField usernameField = new JTextField(20);
                JPasswordField passwordField = new JPasswordField(20);
                JButton signInButton = new JButton("Log In");

                signInButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username = usernameField.getText();
                        char[] passwordChars = passwordField.getPassword();
                        String password = new String(passwordChars);

                        // Replace the following block with your actual sign-in logic
                        if (isValidUser_log_in(username,password)) {
                            JOptionPane.showMessageDialog(logInFrame, "Log In Successful!");
                            activeUser=username;
                            
                            firstframe.dispose();
                            logInFrame.dispose();
                            
                            
                            
                            menuFrame.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(logInFrame, "Invalid username or password. Try again.");
                        }

                        // Clear the password field for security
                        passwordField.setText("");
                    }
                });

                logInPanel.add(new JLabel("Username:"));
                logInPanel.add(usernameField);
                logInPanel.add(new JLabel("Password:"));
                logInPanel.add(passwordField);
                logInPanel.add(signInButton);

                logInFrame.getContentPane().add(logInPanel);
                logInFrame.setSize(300, 200);
                logInFrame.setLocationRelativeTo(null);
                logInFrame.setVisible(true);
            }
        });
        
        

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ArrayList<String> prop=DataBase.afisare_agenda(activeUser);
                // Create and show the second JFrame
                JFrame secondFrame = new JFrame("Agenda");
                secondFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // Create a JPanel for the second frame with BoxLayout (Y_AXIS)
                JPanel secondPanel = new JPanel();
                secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.Y_AXIS));
                secondFrame.getContentPane().add(secondPanel);

                
                
                JLabel label = new JLabel("<html>Persoane:<br></html>");
                secondPanel.add(label);
                // Add components to the second frame
                for(String s : prop)
                {
                	JLabel label1 = new JLabel("<html><a href=\"#\">"+s+"</a></html>");
                	
                	label1.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                        	nume=s;
                        	secondFrame.setVisible(false);
                            // Handle the click event here
                        	JFrame persoanaFrame = new JFrame(s);
                            persoanaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            JPanel persoanaPanel = new JPanel();
                            ArrayList<String> pers=DataBase.afisare_persoana(s,activeUser);
                            
                            persoanaPanel.add(new JLabel("<html>nume: "+pers.get(0)+"<br></html>"));
                            persoanaPanel.add(new JLabel("<html>telefon: "+pers.get(1)+"<br></html>"));
                            persoanaPanel.add(new JLabel("<html>email: "+pers.get(2)+"<br></html>"));
                            persoanaPanel.add(new JLabel("<html>nastere: "+pers.get(3)+"<br></html>"));
                            persoanaPanel.add(new JLabel("<html>instagram: "+pers.get(4)+"<br></html>"));
                            persoanaPanel.add(new JLabel("<html>facebook: "+pers.get(5)+"<br></html>"));
                            persoanaPanel.add(new JLabel("<html>discord: "+pers.get(6)+"<br></html>"));
                            persoanaPanel.add(new JLabel("<html>snapchat: "+pers.get(7)+"<br></html>"));
                            persoanaPanel.add(new JLabel("<html>twitter: "+pers.get(8)+"<br></html>"));
                            persoanaPanel.add(new JLabel("<html>tiktok: "+pers.get(9)+"<br></html>"));
                            persoanaPanel.add(new JLabel("<html>steam: "+pers.get(10)+"<br></html>"));
                            
                            
                            persoanaPanel.setLayout(new BoxLayout(persoanaPanel, BoxLayout.Y_AXIS));
                            persoanaFrame.getContentPane().add(persoanaPanel);
                            persoanaFrame.setSize(500, 400);
                            persoanaFrame.setLocationRelativeTo(null);
                            persoanaFrame.setVisible(true);
                            
                            JButton goBackButton1 = new JButton("Go Back");

                            
                            persoanaPanel.add(goBackButton1);
                            persoanaPanel.add(updatePersoana);

                            goBackButton1.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                	persoanaFrame.dispose();
                                	secondFrame.setVisible(true);
                                	secondFrame.setLocationRelativeTo(null);
                                }
                            });
                            
                            

                            
                            
                        }
                    });
                	
                	secondPanel.add(label1);
                }
                
                updatePersoana.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Create a new JFrame for the update form
                        JFrame updatePersoanaFrame = new JFrame("Actualizeaza persoana");
                        updatePersoanaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose on close, not exit

                        JPanel updatePersoanaPanel = new JPanel(new GridLayout(0, 2));

                        // Add text fields for each attribute you want to update
                        JTextField numeField = new JTextField(20);
                        JTextField telefonField = new JTextField(20);
                        JTextField emailField = new JTextField(20);
                        JTextField nastereField = new JTextField(20);
                        JTextField instagramField = new JTextField(20);
                        JTextField facebookField = new JTextField(20);
                        JTextField discordField = new JTextField(20);
                        JTextField snapchatField = new JTextField(20);
                        JTextField twitterField = new JTextField(20);
                        JTextField tiktokField = new JTextField(20);
                        JTextField steamField = new JTextField(20);

                        // Get the old data for the selected person (replace this with your actual data retrieval logic)
                        ArrayList<String> pers1=DataBase.afisare_persoana(nume,activeUser);

                        // Pre-fill the text fields with the old data
                        numeField.setText(pers1.get(0));
                        telefonField.setText(pers1.get(1));
                        emailField.setText(pers1.get(2));
                        nastereField.setText(pers1.get(3));
                        instagramField.setText(pers1.get(4));
                        facebookField.setText(pers1.get(5));
                        discordField.setText(pers1.get(6));
                        snapchatField.setText(pers1.get(7));
                        twitterField.setText(pers1.get(8));
                        tiktokField.setText(pers1.get(9));
                        steamField.setText(pers1.get(10));

                        JButton actualizare = new JButton("Actualizare");

                        actualizare.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String nume = numeField.getText();
                                String telefon = telefonField.getText();
                                String email = emailField.getText();
                                String nastere = nastereField.getText();
                                String instagram = instagramField.getText();
                                String facebook = facebookField.getText();
                                String discord = discordField.getText();
                                String snappchat = snapchatField.getText();
                                String twitter = twitterField.getText();
                                String tiktok = tiktokField.getText();
                                String steam = steamField.getText();

                                // Call a method to update user data in the database
                                DataBase.updatePerson(activeUser,pers1.get(0), nume, telefon, email, nastere, instagram, facebook, discord, snappchat, twitter, tiktok, steam);
                                updatePersoanaFrame.dispose();
                            }
                        });

                        // Add labels and text fields to the panel
                        updatePersoanaPanel.add(new JLabel("Nume: "));
                        updatePersoanaPanel.add(numeField);
                        updatePersoanaPanel.add(new JLabel("Telefon: "));
                        updatePersoanaPanel.add(telefonField);
                        updatePersoanaPanel.add(new JLabel("Email: "));
                        updatePersoanaPanel.add(emailField);
                        updatePersoanaPanel.add(new JLabel("Nastere (YYYY-MM-DD): "));
                        updatePersoanaPanel.add(nastereField);
                        updatePersoanaPanel.add(new JLabel("Instagram: "));
                        updatePersoanaPanel.add(instagramField);
                        updatePersoanaPanel.add(new JLabel("Facebook: "));
                        updatePersoanaPanel.add(facebookField);
                        updatePersoanaPanel.add(new JLabel("Discord: "));
                        updatePersoanaPanel.add(discordField);
                        updatePersoanaPanel.add(new JLabel("Snapchat: "));
                        updatePersoanaPanel.add(snapchatField);
                        updatePersoanaPanel.add(new JLabel("Twitter: "));
                        updatePersoanaPanel.add(twitterField);
                        updatePersoanaPanel.add(new JLabel("TikTok: "));
                        updatePersoanaPanel.add(tiktokField);
                        updatePersoanaPanel.add(new JLabel("Steam: "));
                        updatePersoanaPanel.add(steamField);

                        updatePersoanaPanel.add(actualizare);

                        updatePersoanaFrame.add(updatePersoanaPanel);
                        updatePersoanaFrame.setSize(700, 600);
                        updatePersoanaFrame.setLocationRelativeTo(null);
                        updatePersoanaFrame.setVisible(true);
                    }
                });
                JButton goBackButton2 = new JButton("Go Back");

                // Add the label and the "Go Back" button to the second panel
                
                secondPanel.add(goBackButton2);
                secondPanel.add(adaugaPersoana);
                secondPanel.add(stergePersoana);

                // Add an ActionListener to the "Go Back" button
                goBackButton2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Dispose of the second frame and show the main frame again
                        secondFrame.dispose();
                        menuFrame.setVisible(true);
                        menuFrame.setLocationRelativeTo(null);
                    }
                });

                // Set the size of the second frame
                secondFrame.setSize(500,400);

                // Center the second frame on the screen
                secondFrame.setLocationRelativeTo(null);

                // Make the second frame visible
                secondFrame.setVisible(true);

                // Hide the main frame when the second frame is opened
                menuFrame.setVisible(false);
            }
        });

        
        
        
        adaugaPersoana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new JFrame for the sign-in form
                JFrame adaugaPersoanaFrame = new JFrame("Adauga persoana");
                adaugaPersoanaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose on close, not exit

                JPanel adaugaPersoanaPanel = new JPanel(new GridLayout(0, 2));
                JTextField numeField = new JTextField(20);
                JTextField telefonField = new JTextField(20);
                JTextField emailField = new JTextField(20);
                JTextField nastereField = new JTextField(20);
                JTextField instagramField = new JTextField(20);
                JTextField facebookField = new JTextField(20);
                JTextField discordField = new JTextField(20);
                JTextField snapchatField = new JTextField(20);
                JTextField twitterField = new JTextField(20);
                JTextField tiktokField = new JTextField(20);
                JTextField steamField = new JTextField(20);
                
                JButton adaugare = new JButton("Adaugare");

               adaugare.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nume = numeField.getText();
                        String telefon = telefonField.getText();
                        String email = emailField.getText();
                        String nastere = nastereField.getText();
                        String instagram = instagramField.getText();
                        String facebook = facebookField.getText();
                        String discord = discordField.getText();
                        String snappchat = snapchatField.getText();
                        String twitter = twitterField.getText();
                        String tiktok = tiktokField.getText();
                        String steam = steamField.getText();
                        
                        DataBase.insertUserData(activeUser, nume, telefon, email, nastere, instagram, facebook, discord, snappchat, twitter, tiktok, steam);
                        adaugaPersoanaFrame.dispose();
                    }
                });

               adaugaPersoanaPanel.add(new JLabel("nume: "));
               adaugaPersoanaPanel.add(numeField);
               adaugaPersoanaPanel.add(new JLabel("telefon: "));
               adaugaPersoanaPanel.add(telefonField);
               adaugaPersoanaPanel.add(new JLabel("email: "));
               adaugaPersoanaPanel.add(emailField);
               adaugaPersoanaPanel.add(new JLabel("nastere(YYYY-MM-DD): "));
               adaugaPersoanaPanel.add(nastereField);
               adaugaPersoanaPanel.add(new JLabel("instagram: "));
               adaugaPersoanaPanel.add(instagramField);
               adaugaPersoanaPanel.add(new JLabel("facebook: "));
               adaugaPersoanaPanel.add(facebookField);
               adaugaPersoanaPanel.add(new JLabel("discord: "));
               adaugaPersoanaPanel.add(discordField);
               adaugaPersoanaPanel.add(new JLabel("snapchat: "));
               adaugaPersoanaPanel.add(snapchatField);
               adaugaPersoanaPanel.add(new JLabel("twitter: "));
               adaugaPersoanaPanel.add(twitterField);
               adaugaPersoanaPanel.add(new JLabel("tiktok: "));
               adaugaPersoanaPanel.add(tiktokField);
               adaugaPersoanaPanel.add(new JLabel("steam: "));
               adaugaPersoanaPanel.add(steamField);
               
               adaugaPersoanaPanel.add(adaugare);

               adaugaPersoanaFrame.getContentPane().add(adaugaPersoanaPanel);
               adaugaPersoanaFrame.setSize(700, 600);
               adaugaPersoanaFrame.setLocationRelativeTo(null);
               adaugaPersoanaFrame.setVisible(true);
            }
        });
        
        stergePersoana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame stergePersoanaFrame = new JFrame("Sterge persoana");
            	stergePersoanaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            	
            	JPanel stergePersoanaPanel = new JPanel();
            	JTextField numeField = new JTextField(20);
            	JButton deleteButton = new JButton("Sterge");
            	
            	deleteButton.addActionListener(new ActionListener() {
            	
            		public void actionPerformed(ActionEvent e) {
            			
            			String nume=numeField.getText();
            			DataBase.deleteRow(activeUser, nume);
            			stergePersoanaFrame.dispose();
            		}
            		
            	});
            	
            	stergePersoanaPanel.add(new JLabel("Nume de sters:"));
                stergePersoanaPanel.add(numeField);
                stergePersoanaPanel.add(deleteButton);
                
                
                stergePersoanaFrame.getContentPane().add(stergePersoanaPanel);
                stergePersoanaFrame.setSize(300, 200);
                stergePersoanaFrame.setLocationRelativeTo(null);
                stergePersoanaFrame.setVisible(true);
                
            }
        });
        
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new JFrame for the sign-in form
                JFrame signInFrame = new JFrame("Sign In Form");
                signInFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose on close, not exit

                JPanel signInPanel = new JPanel();
                JTextField usernameField = new JTextField(20);
                JPasswordField passwordField = new JPasswordField(20);
                JButton signInButton = new JButton("Sign In");

                signInButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username = usernameField.getText();
                        char[] passwordChars = passwordField.getPassword();
                        String password = new String(passwordChars);

                        // Replace the following block with your actual sign-in logic
                        if (isValidUser_sign_in(username)) {
                            JOptionPane.showMessageDialog(signInFrame, "Sign In Successful!");
                            DataBase.createUserTable(username);
                            DataBase.insert(username, password, "utilizatori");
                            // Close the sign-in frame
                            signInFrame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(signInFrame, "Username already taken");
                        }

                        // Clear the password field for security
                        passwordField.setText("");
                    }
                });

                signInPanel.add(new JLabel("Username:"));
                signInPanel.add(usernameField);
                signInPanel.add(new JLabel("Password:"));
                signInPanel.add(passwordField);
                signInPanel.add(signInButton);

                signInFrame.getContentPane().add(signInPanel);
                signInFrame.setSize(300, 200);
                signInFrame.setLocationRelativeTo(null);
                signInFrame.setVisible(true);
            }
        });

        

        
        
        JPanel panel1 = new JPanel();

        // Add components to the panel
        panel1.add(button1);
        panel1.add(button2);

        // Add the panel to the frame
        firstframe.add(panel1);

        // Set the size of the frame
        firstframe.setSize(200, 150);

        // Set the frame to be visible
        firstframe.setVisible(true);
        firstframe.setLocationRelativeTo(null);
    }

	public String getActiveUser() {
		return activeUser;
	}

}
