package proiect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GUI {
	
	private static String activeUser;
	private static String nume;
	private static String grup;
	static Color Buton_color;
	static Color BackGround_color;
	static Color Text_color;
	
	
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
	
private static boolean isValidGroup(String nume) {
        
		ArrayList<String> group = new ArrayList<String>();
		group.add(nume);
		
		return Collections.disjoint(DataBase.afisare_agenda(activeUser+"_groups"), group);
    }
	
    public static void main(String[] args) {
    	
    	int sw;

    	
    	if(checkTime())
    	{
    		sw=1;
    	}
    	else
    		sw=0;
    	
    
    	if(sw == 1)
    	{
    		Text_color=Color.black;
    		Buton_color=new Color(109, 82, 60);
    		BackGround_color=new Color(255, 219, 179);
    	}
    	else
    	{
    		Text_color=Color.white;
    		Buton_color=new Color(0, 9, 36);
    		BackGround_color = new Color(61, 80, 133);
    	}
    	
    	System.out.println(sw);
    	
    	try {
    	    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    	
    	Font customFont = new Font("Times New Roman", Font.PLAIN, 16);
    	
        JFrame firstframe = new JFrame("Log in/Sign in");
        JFrame menuFrame = new JFrame("Menu");
        JPanel menuPanel = new JPanel();

        firstframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // buttons
        JButton button1 = new JButton("log in");
        button1.setBackground(Buton_color);
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Arial", Font.BOLD, 16));
        
        JButton button2 = new JButton("sign in");
        button2.setBackground(Buton_color);
        button2.setForeground(Color.WHITE);
        button2.setFont(new Font("Arial", Font.BOLD, 16));
        
        JButton button3 = new JButton("agenda");
        button3.setBackground(Buton_color);
        button3.setForeground(Color.WHITE);
        button3.setFont(new Font("Arial", Font.BOLD, 16));
        
        JButton adaugaPersoana = new JButton("Adauga peroana");
        adaugaPersoana.setBackground(Buton_color);
        adaugaPersoana.setForeground(Color.WHITE);
        adaugaPersoana.setFont(new Font("Arial", Font.BOLD, 16));
        
        JButton stergePersoana = new JButton("Sterge persoana");
        stergePersoana.setBackground(Buton_color);
        stergePersoana.setForeground(Color.WHITE);
        stergePersoana.setFont(new Font("Arial", Font.BOLD, 16));
        
        JButton updatePersoana = new JButton("Update persoana");
        updatePersoana.setBackground(Buton_color);
        updatePersoana.setForeground(Color.WHITE);
        updatePersoana.setFont(new Font("Arial", Font.BOLD, 16));
        
        JButton addFavorite = new JButton("add Favorite");
        addFavorite.setBackground(Buton_color);
        addFavorite.setForeground(Color.WHITE);
        addFavorite.setFont(new Font("Arial", Font.BOLD, 16));
        
        JButton removeFavorite = new JButton("remove Favorite");
        removeFavorite.setBackground(Buton_color);
        removeFavorite.setForeground(Color.WHITE);
        removeFavorite.setFont(new Font("Arial", Font.BOLD, 16));
        
        JButton Groups = new JButton("Grupuri");
        Groups.setBackground(Buton_color);
        Groups.setForeground(Color.WHITE);
        Groups.setFont(new Font("Arial", Font.BOLD, 16));
        
        JButton addGroup = new JButton("Adauga");
        addGroup.setBackground(Buton_color);
        addGroup.setForeground(Color.WHITE);
        addGroup.setFont(new Font("Arial", Font.BOLD, 16));
        
        JButton addToGroup = new JButton("Adauga persoana");
        addToGroup.setBackground(Buton_color);
        addToGroup.setForeground(Color.WHITE);
        addToGroup.setFont(new Font("Arial", Font.BOLD, 16));
        
        JButton removeFromGroup = new JButton("Sterge persoana");
        removeFromGroup.setBackground(Buton_color);
        removeFromGroup.setForeground(Color.WHITE);
        removeFromGroup.setFont(new Font("Arial", Font.BOLD, 16));
        
        JButton deleteGroup = new JButton("Sterge grup");
        deleteGroup.setBackground(Buton_color);
        deleteGroup.setForeground(Color.WHITE);
        deleteGroup.setFont(new Font("Arial", Font.BOLD, 16));
        
        JButton reminder = new JButton("Zile de nastere");
        reminder.setBackground(Buton_color);
        reminder.setForeground(Color.WHITE);
        reminder.setFont(new Font("Arial", Font.BOLD, 16));
        
        


       
        button1.setPreferredSize(new Dimension(100, 30));
        button2.setPreferredSize(new Dimension(100, 30));
        button3.setPreferredSize(new Dimension(100, 30));
        
     
        menuPanel.setLayout(null);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuFrame.getContentPane().add(menuPanel);
        menuPanel.add(button3);
        menuPanel.add(Groups);
        menuPanel.setBackground(BackGround_color);
        
        JButton Favorites = new JButton("Favorites");
        menuPanel.add(Favorites);
        
        Favorites.setBackground(Buton_color);
        Favorites.setForeground(Color.WHITE);
        Favorites.setFont(new Font("Arial", Font.BOLD, 16));

        
                
                Favorites.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				ArrayList<String> prop=DataBase.afisare_agenda(activeUser+"_favorites");
        				JFrame favoriteFrame = new JFrame("Favorites");
        				favoriteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        				
        				JPanel mainPanel = new JPanel(new BorderLayout());
        				
        				JPanel labelPanel = new JPanel(new GridLayout(0, 1));
                        JPanel favoritePanel = new JPanel(new FlowLayout());
                        favoritePanel.setBackground(BackGround_color);
                        labelPanel.setBackground(BackGround_color);
                        
                        JLabel label = new JLabel("<html>Persoane:<br></html>");
                        label.setFont(customFont);
                        label.setForeground(Text_color);
                        labelPanel.add(label);
        				
        				for(String s : prop) {
        					label label1 = new label(s,"",Buton_color);
        					
                        	label1.addMouseListener(new java.awt.event.MouseAdapter() {
                                public void mouseClicked(java.awt.event.MouseEvent evt) {
                                	nume=s;
                                	favoriteFrame.setVisible(false);
                                    
                                	JFrame persoaneFrame = new JFrame(s);
                                    persoaneFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    JPanel persoanePanel = new JPanel();
                                    persoanePanel.setBackground(BackGround_color);
                                    ArrayList<String> pers=DataBase.afisare_persoana(s,activeUser);
                                    
                                    JLabel label1 = new JLabel("<html>nume: " + pers.get(0) + "<br></html>");
                                    label1.setForeground(Text_color);
                                    label1.setFont(customFont);
                                    persoanePanel.add(label1);
                                    
                                    JLabel label2 = new JLabel("<html>telefon: "+pers.get(1)+"<br></html>");
                                    label2.setForeground(Text_color);
                                    label2.setFont(customFont);
                                    persoanePanel.add(label2);
                                    
                                    JLabel label3 = new JLabel("<html>email: "+pers.get(2)+"<br></html>");
                                    label3.setForeground(Text_color);
                                    label3.setFont(customFont);
                                    persoanePanel.add(label3);
                                    
                                    JLabel label4 = new JLabel("<html>nastere: "+pers.get(3)+"<br></html>");
                                    label4.setForeground(Text_color);
                                    label4.setFont(customFont);
                                    persoanePanel.add(label4);
                                    
                                    JLabel label5 = new JLabel("<html>instagram: "+pers.get(4)+"<br></html>");
                                    label5.setForeground(Text_color);
                                    label5.setFont(customFont);
                                    persoanePanel.add(label5);
                                    
                                    JLabel label6 = new JLabel("<html>facebook: "+pers.get(5)+"<br></html>");
                                    label6.setForeground(Text_color);
                                    label6.setFont(customFont);
                                    persoanePanel.add(label6);
                                    
                                    JLabel label7 = new JLabel("<html>discord: "+pers.get(6)+"<br></html>");
                                    label7.setForeground(Text_color);
                                    label7.setFont(customFont);
                                    persoanePanel.add(label7);
                                    
                                    JLabel label8 = new JLabel("<html>snapchat: "+pers.get(7)+"<br></html>");
                                    label8.setForeground(Text_color);
                                    label8.setFont(customFont);
                                    persoanePanel.add(label8);
                                    
                                    JLabel label9 = new JLabel("<html>twitter: "+pers.get(8)+"<br></html>");
                                    label9.setForeground(Text_color);
                                    label9.setFont(customFont);
                                    persoanePanel.add(label9);
                                    
                                    JLabel label10 = new JLabel("<html>tiktok: "+pers.get(9)+"<br></html>");
                                    label10.setForeground(Text_color);
                                    label10.setFont(customFont);
                                    persoanePanel.add(label10);
                                    
                                    JLabel label11 = new JLabel("<html>steam: "+pers.get(10)+"<br></html>");
                                    label11.setForeground(Text_color);
                                    label11.setFont(customFont);
                                    persoanePanel.add(label11);
                                    
                                    
                                    persoanePanel.setLayout(new BoxLayout(persoanePanel, BoxLayout.Y_AXIS));
                                    persoaneFrame.getContentPane().add(persoanePanel);
                                    persoaneFrame.setSize(500, 400);
                                    persoaneFrame.setLocationRelativeTo(null);
                                    persoaneFrame.setVisible(true);
                                    
                                    JButton goBackButton1 = new JButton("Go Back");
                                    goBackButton1.setBackground(Buton_color);
                                    goBackButton1.setForeground(Color.WHITE);
                                    goBackButton1.setFont(new Font("Arial", Font.BOLD, 16));
        
                                    
                                    persoanePanel.add(goBackButton1);
                                    persoanePanel.add(updatePersoana);
                                    persoanePanel.add(removeFavorite);
        
                                    goBackButton1.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                        	persoaneFrame.dispose();
                                        	favoriteFrame.setVisible(true);
                                        	favoriteFrame.setLocationRelativeTo(null);
                                        }
                                    });
                                    
                                    
                                }
                            });
                        	labelPanel.add(label1);
        				}
        				
        				JButton goBackButton2 = new JButton("Go Back");
                        goBackButton2.setBackground(Buton_color);
                        goBackButton2.setForeground(Color.WHITE);
                        goBackButton2.setFont(new Font("Arial", Font.BOLD, 16));
        
                        
                        
                        favoritePanel.add(goBackButton2);
        
                        
                        goBackButton2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                               
                                favoriteFrame.dispose();
                                menuFrame.setVisible(true);
                                menuFrame.setLocationRelativeTo(null);
                            }
                        });
        				
                        mainPanel.add(labelPanel,BorderLayout.NORTH);
                        mainPanel.add(favoritePanel, BorderLayout.CENTER);
                        
                        favoriteFrame.getContentPane().add(mainPanel);
                        
        				
                        favoriteFrame.setSize(800,700);
        
                        
                        favoriteFrame.setLocationRelativeTo(null);
        
                      
                        favoriteFrame.setVisible(true);
        
                        
                        menuFrame.setVisible(false);
        			}
                	
                });
        menuPanel.add(reminder);
        menuFrame.setSize(600, 500);
        menuFrame.setLocationRelativeTo(null);
        
        

        
        button1.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
               
                JFrame logInFrame = new JFrame("Log In Form");
                logInFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel logInPanel = new JPanel();
                logInPanel.setBackground(BackGround_color);
                JTextField usernameField = new JTextField(20);
                JPasswordField passwordField = new JPasswordField(20);
                JButton signInButton = new JButton("Log In");
                signInButton.setBackground(Buton_color);
                signInButton.setForeground(Color.WHITE);
                signInButton.setFont(new Font("Arial", Font.BOLD, 16));

                signInButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username = usernameField.getText();
                        char[] passwordChars = passwordField.getPassword();
                        String password = new String(passwordChars);

                        
                        if (isValidUser_log_in(username,password)) {
                            JOptionPane.showMessageDialog(logInFrame, "Log In Successful!");
                            activeUser=username;
                            
                            firstframe.dispose();
                            logInFrame.dispose();
                            
                            
                            ArrayList<String> data = DataBase.get_nastere(activeUser);
                            int y=0;

            				ArrayList<String> n = new ArrayList<String>();
            				System.out.println(data);
            				String currentMonth = YearMonth.now().format(DateTimeFormatter.ofPattern("MM"));
            				String currentDay = LocalDate.now().format(DateTimeFormatter.ofPattern("dd"));
            				for(String d : data) {
            					if(d.equals(currentMonth)) {
            						n =DataBase.get_nume(activeUser,d);
            						break;
            					}
            				}
            				
            				for(String s : n) {
            					if(Integer.parseInt(DataBase.get_zi(activeUser,s)) >= Integer.parseInt(currentDay)) 
            					{
            						if(Integer.parseInt(DataBase.get_zi(activeUser,s)) == Integer.parseInt(currentDay))
            						{
            							showTemporaryNotification(menuFrame,"<html>Astazi este ziua de nastere a lui "+s+"<br></html>",4000,y);
            							y+=80;
            							continue;
            						}
            					
            						showTemporaryNotification(menuFrame,"<html>"+s+" va avea ziua de nastere in ziua "+DataBase.get_zi(activeUser,s)+" a lunii curente<br></html>",4000,y);
            						y+=80;
            					}
            				}
                            
                            
                            
                            menuFrame.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(logInFrame, "Invalid username or password. Try again.");
                        }

                        
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
                
                JFrame secondFrame = new JFrame("Agenda");
                secondFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel mainPanel = new JPanel(new BorderLayout());
                
               
                
                JPanel labelPanel = new JPanel(new GridLayout(0, 1));
                JPanel secondPanel = new JPanel(new FlowLayout());
                secondPanel.setBackground(BackGround_color);
                labelPanel.setBackground(BackGround_color);

                
                
                JLabel label = new JLabel("Persoane");
                label.setFont(customFont);
                label.setForeground(Text_color);
                labelPanel.add(label);
                
                for(String s : prop)
                {
                	
                	label label1 = new label(s,"",Buton_color);
                	
                	label1.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                        	nume=s;
                        	secondFrame.setVisible(false);
                            
                        	JFrame persoanaFrame = new JFrame(s);
                            persoanaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            JPanel persoanaPanel = new JPanel();
                            persoanaPanel.setBackground(BackGround_color);
                            
                            ArrayList<String> pers=DataBase.afisare_persoana(s,activeUser);
                            
                            JLabel label1 = new JLabel("<html>nume: " + pers.get(0) + "<br></html>");
                            label1.setForeground(Text_color);
                            label1.setFont(customFont);
                            persoanaPanel.add(label1);
                            
                            JLabel label2 = new JLabel("<html>telefon: "+pers.get(1)+"<br></html>");
                            label2.setForeground(Text_color);
                            label2.setFont(customFont);
                            persoanaPanel.add(label2);
                            
                            JLabel label3 = new JLabel("<html>email: "+pers.get(2)+"<br></html>");
                            label3.setForeground(Text_color);
                            label3.setFont(customFont);
                            persoanaPanel.add(label3);
                            
                            JLabel label4 = new JLabel("<html>nastere: "+pers.get(3)+"<br></html>");
                            label4.setForeground(Text_color);
                            label4.setFont(customFont);
                            persoanaPanel.add(label4);
                            
                            JLabel label5 = new JLabel("<html>instagram: "+pers.get(4)+"<br></html>");
                            label5.setForeground(Text_color);
                            label5.setFont(customFont);
                            persoanaPanel.add(label5);
                            
                            JLabel label6 = new JLabel("<html>facebook: "+pers.get(5)+"<br></html>");
                            label6.setForeground(Text_color);
                            label6.setFont(customFont);
                            persoanaPanel.add(label6);
                            
                            JLabel label7 = new JLabel("<html>discord: "+pers.get(6)+"<br></html>");
                            label7.setForeground(Text_color);
                            label7.setFont(customFont);
                            persoanaPanel.add(label7);
                            
                            JLabel label8 = new JLabel("<html>snapchat: "+pers.get(7)+"<br></html>");
                            label8.setForeground(Text_color);
                            label8.setFont(customFont);
                            persoanaPanel.add(label8);
                            
                            JLabel label9 = new JLabel("<html>twitter: "+pers.get(8)+"<br></html>");
                            label9.setForeground(Text_color);
                            label9.setFont(customFont);
                            persoanaPanel.add(label9);
                            
                            JLabel label10 = new JLabel("<html>tiktok: "+pers.get(9)+"<br></html>");
                            label10.setForeground(Text_color);
                            label10.setFont(customFont);
                            persoanaPanel.add(label10);
                            
                            JLabel label11 = new JLabel("<html>steam: "+pers.get(10)+"<br></html>");
                            label11.setForeground(Text_color);
                            label11.setFont(customFont);
                            persoanaPanel.add(label11);
                            
                            
                            persoanaPanel.setLayout(new BoxLayout(persoanaPanel, BoxLayout.Y_AXIS));
                            persoanaFrame.getContentPane().add(persoanaPanel);
                            persoanaFrame.setSize(500, 400);
                            persoanaFrame.setLocationRelativeTo(null);
                            persoanaFrame.setVisible(true);
                            
                            JButton goBackButton1 = new JButton("Go Back");
                            goBackButton1.setBackground(Buton_color); 
                            goBackButton1.setForeground(Color.WHITE);
                            goBackButton1.setFont(new Font("Arial", Font.BOLD, 16));

                            
                            persoanaPanel.add(goBackButton1);
                            persoanaPanel.add(updatePersoana);
                            persoanaPanel.add(addFavorite);

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
                	
                	labelPanel.add(label1);
                	
                }
                

                
                JButton goBackButton2 = new JButton("Go Back");
                goBackButton2.setBackground(Buton_color);
                goBackButton2.setForeground(Color.WHITE);
                goBackButton2.setFont(new Font("Arial", Font.BOLD, 16));

                
                
                secondPanel.add(goBackButton2);
                secondPanel.add(adaugaPersoana);
                secondPanel.add(stergePersoana);

                
                goBackButton2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                   
                        secondFrame.dispose();
                        menuFrame.setVisible(true);
                        menuFrame.setLocationRelativeTo(null);
                    }
                });
                mainPanel.add(labelPanel,BorderLayout.NORTH);
                mainPanel.add(secondPanel, BorderLayout.CENTER);
                
                secondFrame.getContentPane().add(mainPanel);
              
                secondFrame.setSize(800,700);

                
                secondFrame.setLocationRelativeTo(null);

               
                secondFrame.setVisible(true);

                
                menuFrame.setVisible(false);
            }
        });

        
        addFavorite.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String tabela;
				tabela = activeUser + "_favorites";
				DataBase.insertfavorite(tabela,nume);
			}
        	
        });
        
        adaugaPersoana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JFrame adaugaPersoanaFrame = new JFrame("Adauga persoana");
                adaugaPersoanaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose on close, not exit

                JPanel adaugaPersoanaPanel = new JPanel(new GridLayout(0, 2));
                adaugaPersoanaPanel.setBackground(BackGround_color);
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
                adaugare.setBackground(Buton_color);
                adaugare.setForeground(Color.WHITE);
                adaugare.setFont(new Font("Arial", Font.BOLD, 16));

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
        
        updatePersoana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JFrame updatePersoanaFrame = new JFrame("Actualizeaza persoana");
                updatePersoanaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel updatePersoanaPanel = new JPanel(new GridLayout(0, 2));
                updatePersoanaPanel.setBackground(BackGround_color);

             
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

                
                ArrayList<String> pers1=DataBase.afisare_persoana(nume,activeUser);

            
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
                actualizare.setBackground(Buton_color);
                actualizare.setForeground(Color.WHITE);
                actualizare.setFont(new Font("Arial", Font.BOLD, 16));

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

                        
                        DataBase.updatePerson(activeUser,pers1.get(0), nume, telefon, email, nastere, instagram, facebook, discord, snappchat, twitter, tiktok, steam);
                        updatePersoanaFrame.dispose();
                    }
                });

              
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

                updatePersoanaFrame.getContentPane().add(updatePersoanaPanel);
                updatePersoanaFrame.setSize(700, 600);
                updatePersoanaFrame.setLocationRelativeTo(null);
                updatePersoanaFrame.setVisible(true);
            }
        });
        
        stergePersoana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame stergePersoanaFrame = new JFrame("Sterge persoana");
            	stergePersoanaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            	
            	JPanel stergePersoanaPanel = new JPanel();
            	stergePersoanaPanel.setBackground(BackGround_color);
            	JTextField numeField = new JTextField(20);
            	JButton deleteButton = new JButton("Sterge");
            	deleteButton.setBackground(Buton_color);
            	deleteButton.setForeground(Color.WHITE);
            	deleteButton.setFont(new Font("Arial", Font.BOLD, 16));
            	
            	deleteButton.addActionListener(new ActionListener() {
            	
            		public void actionPerformed(ActionEvent e) {
            			
            			String nume=numeField.getText();
            			DataBase.deleteRow(activeUser, nume);
            			DataBase.deleteRow(activeUser+"_favorites", nume);
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
              
                JFrame signInFrame = new JFrame("Sign In Form");
                signInFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel signInPanel = new JPanel();
                signInPanel.setBackground(BackGround_color);
                JTextField usernameField = new JTextField(20);
                JPasswordField passwordField = new JPasswordField(20);
                JButton signInButton = new JButton("Sign In");
                signInButton.setBackground(Buton_color);
                signInButton.setForeground(Color.WHITE);
                signInButton.setFont(new Font("Arial", Font.BOLD, 16));

                signInButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username = usernameField.getText();
                        char[] passwordChars = passwordField.getPassword();
                        String password = new String(passwordChars);

                        
                        if (isValidUser_sign_in(username)) {
                            JOptionPane.showMessageDialog(signInFrame, "Sign In Successful!");
                            DataBase.createUserTable(username);
                            DataBase.createFavoriteTable(username+"_favorites");
                            DataBase.createGroupTable(username+"_groups");
                            DataBase.insert(username, password, "utilizatori");
                           
                            signInFrame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(signInFrame, "Username already taken");
                        }

                       
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

        removeFavorite.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				DataBase.deleteRow(activeUser+"_favorites", nume);
			}
        	
        	
        });
        
        removeFromGroup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				DataBase.deleteRow(activeUser+"_"+grup, nume);
			}
        	
        	
        });
        
        Groups.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> prop=DataBase.afisare_agenda(activeUser+"_groups");
				JFrame groupFrame = new JFrame("Grupuri");
				groupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				JPanel mainPanel = new JPanel(new BorderLayout());
				
				JPanel labelPanel = new JPanel(new GridLayout(0, 1));
                JPanel groupPanel = new JPanel(new FlowLayout());
                groupPanel.setBackground(BackGround_color);
                labelPanel.setBackground(BackGround_color);
				
                
                JLabel label = new JLabel("<html>Grupuri:<br></html>");
                label.setFont(customFont);
                label.setForeground(Text_color);
                labelPanel.add(label);
                for(String s : prop)
                {
                	label label1 = new label(s,"",Buton_color);
                	label1.addMouseListener(new java.awt.event.MouseAdapter() {
                		public void mouseClicked(java.awt.event.MouseEvent evt) {
                			grup=s;
                			System.out.println(grup);
                			ArrayList<String> prop2=DataBase.afisare_agenda(activeUser+"_"+grup);
                			groupFrame.setVisible(false);
                			JFrame persoane_grupFrame = new JFrame(s);
                			persoane_grupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                			
            				JPanel mainPanel2 = new JPanel(new BorderLayout());
            				
            				JPanel labelPanel2 = new JPanel(new GridLayout(0, 1));
                            JPanel persoane_grupPanel = new JPanel(new FlowLayout());
                            persoane_grupPanel.setBackground(BackGround_color);
                            labelPanel2.setBackground(BackGround_color);
                			
                            
                            JLabel label2 = new JLabel("<html>Persoane:<br></html>");
                            label2.setForeground(Text_color);
                            label2.setFont(customFont);
                            labelPanel2.add(label2);
                            for(String s2 : prop2) {
                            	label label3 = new label(s2,"",Buton_color);
                            	label3.addMouseListener(new java.awt.event.MouseAdapter() {
                                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                                    nume=s2;
                                    persoane_grupFrame.setVisible(false);
                                    
                                    JFrame persoanaFrame = new JFrame(s);
                                    persoanaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    JPanel persoanaPanel = new JPanel();
                                    persoanaPanel.setBackground(BackGround_color);
                                    ArrayList<String> pers=DataBase.afisare_persoana(nume,activeUser);
                                    
                                    JLabel label1 = new JLabel("<html>nume: " + pers.get(0) + "<br></html>");
                                    label1.setForeground(Text_color);
                                    label1.setFont(customFont);
                                    persoanaPanel.add(label1);
                                    
                                    JLabel label2 = new JLabel("<html>telefon: "+pers.get(1)+"<br></html>");
                                    label2.setForeground(Text_color);
                                    label2.setFont(customFont);
                                    persoanaPanel.add(label2);
                                    
                                    JLabel label3 = new JLabel("<html>email: "+pers.get(2)+"<br></html>");
                                    label3.setForeground(Text_color);
                                    label3.setFont(customFont);
                                    persoanaPanel.add(label3);
                                    
                                    JLabel label4 = new JLabel("<html>nastere: "+pers.get(3)+"<br></html>");
                                    label4.setForeground(Text_color);
                                    label4.setFont(customFont);
                                    persoanaPanel.add(label4);
                                    
                                    JLabel label5 = new JLabel("<html>instagram: "+pers.get(4)+"<br></html>");
                                    label5.setForeground(Text_color);
                                    label5.setFont(customFont);
                                    persoanaPanel.add(label5);
                                    
                                    JLabel label6 = new JLabel("<html>facebook: "+pers.get(5)+"<br></html>");
                                    label6.setForeground(Text_color);
                                    label6.setFont(customFont);
                                    persoanaPanel.add(label6);
                                    
                                    JLabel label7 = new JLabel("<html>discord: "+pers.get(6)+"<br></html>");
                                    label7.setForeground(Text_color);
                                    label7.setFont(customFont);
                                    persoanaPanel.add(label7);
                                    
                                    JLabel label8 = new JLabel("<html>snapchat: "+pers.get(7)+"<br></html>");
                                    label8.setForeground(Text_color);
                                    label8.setFont(customFont);
                                    persoanaPanel.add(label8);
                                    
                                    JLabel label9 = new JLabel("<html>twitter: "+pers.get(8)+"<br></html>");
                                    label9.setForeground(Text_color);
                                    label9.setFont(customFont);
                                    persoanaPanel.add(label9);
                                    
                                    JLabel label10 = new JLabel("<html>tiktok: "+pers.get(9)+"<br></html>");
                                    label10.setForeground(Text_color);
                                    label10.setFont(customFont);
                                    persoanaPanel.add(label10);
                                    
                                    JLabel label11 = new JLabel("<html>steam: "+pers.get(10)+"<br></html>");
                                    label11.setForeground(Text_color);
                                    label11.setFont(customFont);
                                    persoanaPanel.add(label11);
                                    
                                    
                                    persoanaPanel.setLayout(new BoxLayout(persoanaPanel, BoxLayout.Y_AXIS));
                                    persoanaFrame.getContentPane().add(persoanaPanel);
                                    persoanaFrame.setSize(500, 400);
                                    persoanaFrame.setLocationRelativeTo(null);
                                    persoanaFrame.setVisible(true);
                                    
                                    JButton goBackButton1 = new JButton("Go Back");
                                    goBackButton1.setBackground(Buton_color);
                                    goBackButton1.setForeground(Color.WHITE);
                                    goBackButton1.setFont(new Font("Arial", Font.BOLD, 16));

                                    
                                    persoanaPanel.add(goBackButton1);
                                    persoanaPanel.add(updatePersoana);
                                    persoanaPanel.add(removeFromGroup);

                                    goBackButton1.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                        	persoanaFrame.dispose();
                                        	persoane_grupFrame.setVisible(true);
                                        	persoane_grupFrame.setLocationRelativeTo(null);
                                        }
                                    });
                                    
                                    }
                            	});
                            	labelPanel2.add(label3);
                            }
                            JButton goBackButton2 = new JButton("Go Back");
                            goBackButton2.setBackground(Buton_color);
                            goBackButton2.setForeground(Color.WHITE);
                            goBackButton2.setFont(new Font("Arial", Font.BOLD, 16));

                            
                            persoane_grupPanel.add(goBackButton2);
                            persoane_grupPanel.add(addToGroup);
                            persoane_grupPanel.add(deleteGroup);
                            
                            goBackButton2.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                	persoane_grupFrame.dispose();
                                	groupFrame.setVisible(true);
                                	groupFrame.setLocationRelativeTo(null);
                                }
                            });
                            
                            mainPanel2.add(labelPanel2,BorderLayout.NORTH);
                            mainPanel2.add(persoane_grupPanel, BorderLayout.CENTER);
                            
                            persoane_grupFrame.getContentPane().add(mainPanel2);
                            
                        
                            persoane_grupFrame.setSize(800,700);

                        
                            persoane_grupFrame.setLocationRelativeTo(null);

                          
                            persoane_grupFrame.setVisible(true);
                		}
                	});
                    
                	labelPanel.add(label1);
                	
                }
                JButton goBackButton3 = new JButton("Go Back");
                goBackButton3.setBackground(Buton_color);
                goBackButton3.setForeground(Color.WHITE);
                goBackButton3.setFont(new Font("Arial", Font.BOLD, 16));

                
                groupPanel.add(goBackButton3);
                groupPanel.add(addGroup);
                
                goBackButton3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	groupFrame.dispose();
                    	menuFrame.setVisible(true);
                    	menuFrame.setLocationRelativeTo(null);
                    }
                });

                mainPanel.add(labelPanel,BorderLayout.NORTH);
                mainPanel.add(groupPanel, BorderLayout.CENTER);
                
                groupFrame.getContentPane().add(mainPanel);
                
            
                groupFrame.setSize(800,700);

               
                groupFrame.setLocationRelativeTo(null);

               
                groupFrame.setVisible(true);

                
                menuFrame.setVisible(false);
                
			}
        	
        	
        });
        
        addToGroup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> prop=DataBase.afisare_agenda(activeUser);
				
				JFrame addFrame = new JFrame("Favorites");
				addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				JPanel addPanel = new JPanel();
				addPanel.setBackground(BackGround_color);
				addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.Y_AXIS));
				addFrame.getContentPane().add(addPanel);
                
                JLabel label = new JLabel("<html>Selectati persoana de adaugat:<br></html>");
                label.setForeground(Text_color);
                label.setFont(customFont);
                addPanel.add(label);
				
                for(String s : prop) {
                	
                	label label1 = new label(s,"",Buton_color);
                	label1.addMouseListener(new java.awt.event.MouseAdapter() {
                		public void mouseClicked(java.awt.event.MouseEvent evt) {
                		nume=s;
                		DataBase.insertgroup(activeUser+"_"+grup, nume);
                		addFrame.dispose();
                		}
                	});
                	addPanel.add(label1);
                }
                
                addFrame.setSize(500,400);

                
                addFrame.setLocationRelativeTo(null);

                
                addFrame.setVisible(true);
			}
         });
        
        deleteGroup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DataBase.deleteTable(activeUser+"_"+grup);
				DataBase.deleteRow(activeUser+"_groups", grup);
			}
        	
        	
        	
        });
        
        reminder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame reminderFrame = new JFrame("Zile de nastere");
				reminderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
				
				JPanel reminderPanel = new JPanel();
				reminderPanel.setBackground(BackGround_color);
				reminderPanel.setLayout(new BoxLayout(reminderPanel, BoxLayout.Y_AXIS));
				reminderFrame.getContentPane().add(reminderPanel);
				
				JLabel label1 = new JLabel("<html>Zile de nastere:<br></html>");
				label1.setForeground(Text_color);
				label1.setFont(customFont);
				label1.setFont(customFont);
				reminderPanel.add(label1);
				
				ArrayList<String> data = DataBase.get_nastere(activeUser);

				ArrayList<String> n = new ArrayList<String>();
				System.out.println(data);
				String currentMonth = YearMonth.now().format(DateTimeFormatter.ofPattern("MM"));
				String currentDay = LocalDate.now().format(DateTimeFormatter.ofPattern("dd"));
				for(String d : data) {
					if(d.equals(currentMonth)) {
						n =DataBase.get_nume(activeUser,d);
						break;
					}
				}
				
				for(String s : n) {
					if(Integer.parseInt(DataBase.get_zi(activeUser,s)) >= Integer.parseInt(currentDay)) 
					{
						if(Integer.parseInt(DataBase.get_zi(activeUser,s)) == Integer.parseInt(currentDay))
						{
							JLabel label2 = new JLabel("<html>Astazi este ziua de nastere a lui "+s+"<br></html>");
							label2.setForeground(Text_color);
							label2.setFont(customFont);
							reminderPanel.add(label2);
							continue;
						}
						
					JLabel label2 = new JLabel("<html>"+s+" va avea ziua de nastere in ziua "+DataBase.get_zi(activeUser,s)+" a lunii curente<br></html>");
					label2.setFont(customFont);
					label2.setForeground(Text_color);
					reminderPanel.add(label2);
					}
				}
				
				JButton goBackButton2 = new JButton("Go Back");
                goBackButton2.setBackground(Buton_color);
                goBackButton2.setForeground(Color.WHITE);
                goBackButton2.setFont(new Font("Arial", Font.BOLD, 16));

                
                
				reminderPanel.add(goBackButton2);

                
                goBackButton2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                     
                    	reminderFrame.dispose();
                        menuFrame.setVisible(true);
                        menuFrame.setLocationRelativeTo(null);
                    }
                });
				
				System.out.println(n);
				
				reminderFrame.setSize(500,400);

                
				reminderFrame.setLocationRelativeTo(null);

              
				reminderFrame.setVisible(true);

               
                menuFrame.setVisible(false);
			}
        	
        	
        	
        });
        
        addGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                JFrame addGroupFrame = new JFrame("Adauga grup");
                addGroupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel addGroupPanel = new JPanel();
                addGroupPanel.setBackground(BackGround_color);
                JTextField groupField = new JTextField(20);
                JButton addButton = new JButton("Adauga");
                addButton.setBackground(Buton_color);
                addButton.setForeground(Color.WHITE);
                addButton.setFont(new Font("Arial", Font.BOLD, 16));

                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String group = groupField.getText();
                       
                        if (isValidGroup(group)) {
                            JOptionPane.showMessageDialog(addGroupFrame, "Grup adaugat!");
                            DataBase.createGroupTable(activeUser+"_"+group);
                            DataBase.insert_grup(group,activeUser+"_groups");
                            
                            addGroupFrame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(addGroupFrame, "Grupul exista deja");
                        }
                    }
                });

                addGroupPanel.add(new JLabel("Nume grup:"));
                addGroupPanel.add(groupField);

                addGroupPanel.add(addButton);

                addGroupFrame.getContentPane().add(addGroupPanel);
                addGroupFrame.setSize(300, 200);
                addGroupFrame.setLocationRelativeTo(null);
                addGroupFrame.setVisible(true);
            }
        });
        
        JPanel panel1 = new JPanel();
        panel1.setBackground(BackGround_color);

        
        panel1.add(button1);
        panel1.add(button2);

       
        firstframe.getContentPane().add(panel1);

        
        firstframe.setSize(200, 150);

        
        firstframe.setVisible(true);
        firstframe.setLocationRelativeTo(null);
    }

    private static void showTemporaryNotification(JFrame parent, String message, int duration, int y) {
        JDialog notificationDialog = new JDialog(parent, false);
        notificationDialog.setUndecorated(true);
        notificationDialog.setSize(160, 75);
        notificationDialog.setLocation(parent.getX() + parent.getWidth() - notificationDialog.getWidth()-20,
                parent.getY() + parent.getHeight() - notificationDialog.getHeight() - y - 20);

        
        
        JLabel label = new JLabel(message, SwingConstants.CENTER);
        Font customFont = new Font("Times New Roman", Font.PLAIN, 16);
        label.setFont(customFont);
        label.setForeground(Color.WHITE);
        label.setBackground(new Color(109, 82, 60));
        label.setOpaque(true);

        notificationDialog.add(label);

        Timer timer = new Timer(duration, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notificationDialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();

        notificationDialog.setVisible(true);
    }
    
    private static boolean checkTime() {
       
        LocalTime currentTime = LocalTime.now();

        
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(18, 0); 

      
        return currentTime.isAfter(startTime) && currentTime.isBefore(endTime);
    }
    
	public String getActiveUser() {
		return activeUser;
	}

}
