package proiect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBase {

	private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String user = "postgres";
    private static String password = "Original50!";
	
    public DataBase(String url, String user, String password) {
    	
    }
        // Database connection parameters
    
	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
	
	public static ArrayList<String> afisare_persoana(String persoana,String tabela)
    {
    	ArrayList<String> prop = new ArrayList<String>();
        // JDBC variables for opening, closing, and managing a connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the PostgreSQL server successfully.");
            String sql = "SELECT * FROM " + tabela + " WHERE nume IN ('" + persoana + "')";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Execute the query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Process the result set
                    while (resultSet.next()) {
                        // Retrieve data from each row
                        String columnName1 = resultSet.getString("nume");
                        String columnName2 = resultSet.getString("telefon");
                        String columnName3 = resultSet.getString("email");
                        String columnName4 = resultSet.getString("nastere");
                        String columnName5 = resultSet.getString("instagram");
                        String columnName6 = resultSet.getString("facebook");
                        String columnName7 = resultSet.getString("discord");
                        String columnName8 = resultSet.getString("snapchat");
                        String columnName9 = resultSet.getString("twitter");
                        String columnName10 = resultSet.getString("tiktok");
                        String columnName11 = resultSet.getString("steam");
                        
                        // Print or process the data as needed
                         prop.add(columnName1);
                         prop.add(columnName2);
                         prop.add(columnName3);
                         prop.add(columnName4);
                         prop.add(columnName5);
                         prop.add(columnName6);
                         prop.add(columnName7);
                         prop.add(columnName8);
                         prop.add(columnName9);
                         prop.add(columnName10);
                         prop.add(columnName11);
                         
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return prop;
    }
	
	public static ArrayList<String> afisare_agenda(String tabela)
    {
    	ArrayList<String> prop = new ArrayList<String>();
        // JDBC variables for opening, closing, and managing a connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the PostgreSQL server successfully.");
            String sql = "Select * from "+tabela+" order by nume";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Execute the query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Process the result set
                    while (resultSet.next()) {
                        // Retrieve data from each row
                        String columnName1 = resultSet.getString("nume");
                        
                        // Print or process the data as needed
                         prop.add(columnName1);
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return prop;
    }

	public static ArrayList<String> get_nastere(String tabela)
    {
    	ArrayList<String> prop = new ArrayList<String>();
        // JDBC variables for opening, closing, and managing a connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the PostgreSQL server successfully.");
            String sql = "Select substring(nastere from 6 for 2) as nastere from "+tabela+" where nastere not in('-')";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Execute the query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Process the result set
                    while (resultSet.next()) {
                        // Retrieve data from each row
                        String columnName1 = resultSet.getString("nastere");
                        
                        // Print or process the data as needed
                         prop.add(columnName1);
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return prop;
    }
	
	public static ArrayList<String> get_nume(String tabela,String data)
    {
    	ArrayList<String> prop = new ArrayList<String>();
        // JDBC variables for opening, closing, and managing a connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the PostgreSQL server successfully.");
            String sql = "Select nume from "+tabela+" where substring(nastere from 6 for 2) = '"+data+"' ";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Execute the query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Process the result set
                    while (resultSet.next()) {
                        // Retrieve data from each row
                        String columnName1 = resultSet.getString("nume");
                        
                        // Print or process the data as needed
                         prop.add(columnName1);
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return prop;
    }
	
	public static String get_zi(String tabela,String nume)
    {
    	String prop = new String();
        // JDBC variables for opening, closing, and managing a connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the PostgreSQL server successfully.");
            String sql = "Select substring(nastere from 9 for 2) as nastere from "+tabela+" where nume = '"+nume+"'";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Execute the query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Process the result set
                    while (resultSet.next()) {
                        // Retrieve data from each row
                        String columnName1 = resultSet.getString("nastere");
                        
                        // Print or process the data as needed
                         prop=columnName1;
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return prop;
    }
	
    public static ArrayList<String> afisare_sign_in()
    {
    	ArrayList<String> prop = new ArrayList<String>();
        // JDBC variables for opening, closing, and managing a connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the PostgreSQL server successfully.");
            String sql = "Select * from utilizatori";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Execute the query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Process the result set
                    while (resultSet.next()) {
                        // Retrieve data from each row
                        String columnName1 = resultSet.getString("username");
                        
                        // Print or process the data as needed
                         prop.add(columnName1);
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return prop;
    }

    public static Map<String,String> afisare_log_in()
    {
    	Map<String,String> prop = new HashMap<String,String>();
        // JDBC variables for opening, closing, and managing a connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the PostgreSQL server successfully.");
            String sql = "Select * from utilizatori";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Execute the query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Process the result set
                    while (resultSet.next()) {
                        // Retrieve data from each row
                        String columnName1 = resultSet.getString("username");
                        String columnName2 = resultSet.getString("password");
                        
                        // Print or process the data as needed
                         prop.put(columnName1,columnName2);
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return prop;
    }
    
    public static void insert(String username, String pword,String tabela)
    {
    	try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // SQL query to insert data into the column
            String sql1 = "INSERT INTO "+tabela+"(username,password) VALUES (?, ?)";

            // Create a PreparedStatement with the SQL query
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql1)) {
                // Set the parameter values
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, pword);

                // Execute the update
                int rowsAffected = preparedStatement.executeUpdate();

                // Check the number of rows affected
                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully.");
                } else {
                    System.out.println("No rows affected. Data insertion failed.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Data insertion failure.");
            e.printStackTrace();
        }
    	
    	
    }
    
    public static void insert_grup(String grup,String tabela)
    {
    	try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // SQL query to insert data into the column
            String sql1 = "INSERT INTO "+tabela+"(nume) VALUES (?)";

            // Create a PreparedStatement with the SQL query
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql1)) {
                // Set the parameter values
                preparedStatement.setString(1, grup);
                // Execute the update
                int rowsAffected = preparedStatement.executeUpdate();

                // Check the number of rows affected
                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully.");
                } else {
                    System.out.println("No rows affected. Data insertion failed.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Data insertion failure.");
            e.printStackTrace();
        }
    	
    	
    }
    
    public static void delete(String username,String tabela)
    {
    	try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // SQL query to delete a row from the table
            String sql = "DELETE FROM " + tabela + " WHERE username = ?";

            // Create a PreparedStatement with the SQL query
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Set the parameter value
                preparedStatement.setString(1, username);

                // Execute the update
                int rowsAffected = preparedStatement.executeUpdate();

                // Check the number of rows affected
                if (rowsAffected > 0) {
                    System.out.println("Row deleted successfully.");
                } else {
                    System.out.println("No rows affected. Row deletion failed.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Row deletion failure.");
            e.printStackTrace();
        }
    }

    public static void createUserTable(String username) {
        String tableName =username; // Assuming you want a table per user

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
        	String createTableSQL = "CREATE TABLE IF NOT EXISTS public." + tableName + " ("
        	        + "Nume character varying COLLATE pg_catalog.\"default\" NOT NULL,"
        	        + "Telefon character varying COLLATE pg_catalog.\"default\" NOT NULL,"
        	        + "Email character varying COLLATE pg_catalog.\"default\" NOT NULL,"
        	        + "Nastere character varying COLLATE pg_catalog.\"default\" NOT NULL,"
        	        + "Instagram character varying COLLATE pg_catalog.\"default\" NOT NULL,"
        	        + "Facebook character varying COLLATE pg_catalog.\"default\" NOT NULL,"
        	        + "Discord character varying COLLATE pg_catalog.\"default\" NOT NULL,"
        	        + "Snapchat character varying COLLATE pg_catalog.\"default\" NOT NULL,"
        	        + "Twitter character varying COLLATE pg_catalog.\"default\" NOT NULL,"
        	        + "TikTok character varying COLLATE pg_catalog.\"default\" NOT NULL," // Corrected column name
        	        + "Steam character varying COLLATE pg_catalog.\"default\" NOT NULL,"
        	        + "CONSTRAINT " + tableName + "_pkey PRIMARY KEY (Nume)"
        	        + ")";
            try (PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) {
                preparedStatement.executeUpdate();
                System.out.println("Table for user " + username + " created successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }
    
    public static void deleteTable(String tableName) {
        String sql = "DROP TABLE IF EXISTS " + tableName;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.executeUpdate();
            System.out.println("Table deleted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void createFavoriteTable(String username) {
        String tableName =username; // Assuming you want a table per user

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
        	String createTableSQL = "CREATE TABLE IF NOT EXISTS public." + tableName + " ("
        	        + "Nume character varying COLLATE pg_catalog.\"default\" NOT NULL"
        	        + ")";
            try (PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) {
                preparedStatement.executeUpdate();
                System.out.println("Table for user " + username + " created successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }
    
    public static void createGroupTable(String grup) {
        String tableName =grup; // Assuming you want a table per user

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
        	String createTableSQL = "CREATE TABLE IF NOT EXISTS public." + tableName + " ("
        	        + "Nume character varying COLLATE pg_catalog.\"default\" NOT NULL"
        	        + ")";
            try (PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) {
                preparedStatement.executeUpdate();
                System.out.println("Table " + grup + " created successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }
    
    public static void updatePerson(String tabela,String oldName, String newName, String newPhoneNumber, String newEmail,
    			String newBirthdate, String newInstagram, String newFacebook,
    			String newDiscord, String newSnapchat, String newTwitter,
    			String newTikTok, String newSteam) {
    		// SQL query to update person data
    		String updateQuery = "UPDATE public." + tabela + " SET "
    				+ "nume = ?, telefon = ?, email = ?, nastere = ?, instagram = ?, facebook = ?, discord = ?,"
    				+ " snapchat = ?, twitter = ?, tikTok = ?, steam = ? WHERE nume = ?";

    		try (
    				// Establish a connection to the database
    				Connection connection = DriverManager.getConnection(url, user, password);

    				// Create a prepared statement
    				PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)
    				) {
    			// Set parameters for the update query
    			preparedStatement.setString(1, newName);
    			preparedStatement.setString(2, newPhoneNumber);
    			preparedStatement.setString(3, newEmail);
    			preparedStatement.setString(4, newBirthdate);
    			preparedStatement.setString(5, newInstagram);
    			preparedStatement.setString(6, newFacebook);
    			preparedStatement.setString(7, newDiscord);
    			preparedStatement.setString(8, newSnapchat);
    			preparedStatement.setString(9, newTwitter);
    			preparedStatement.setString(10, newTikTok);
    			preparedStatement.setString(11, newSteam);
    			preparedStatement.setString(12, oldName);

    			// Execute the update query
    			int rowsAffected = preparedStatement.executeUpdate();
    			System.out.println(rowsAffected + " row(s) updated successfully.");
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    
    public static void deleteRow(String tableName,String condition) {
        // SQL query to delete a row
        String deleteQuery = "DELETE FROM " + tableName + " WHERE nume = ?";

        try (
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, user, password);
            
            // Create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)
        ) {
            // Set the parameter for the condition value
            preparedStatement.setString(1, condition);

            // Execute the delete query
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    	public static void insertUserData(String tableName, String nume, String telefon, String email, 
    			String nastere, String instagram, String facebook, String discord, 
    		String snapchat, String twitter, String tikTok, String steam) {
    			String insertDataSQL = "INSERT INTO public." + tableName + " (nume, telefon, email, nastere, instagram, facebook, discord, snapchat, twitter, tiktok, steam) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    				try (Connection connection = DriverManager.getConnection(url, user, password);
    							PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {

    						preparedStatement.setString(1, nume);
    						preparedStatement.setString(2, telefon);
    						preparedStatement.setString(3, email);
    						preparedStatement.setString(4, nastere);
    						preparedStatement.setString(5, instagram);
    						preparedStatement.setString(6, facebook);
    						preparedStatement.setString(7, discord);
    						preparedStatement.setString(8, snapchat);
    						preparedStatement.setString(9, twitter);
    						preparedStatement.setString(10, tikTok);
    						preparedStatement.setString(11, steam);

    						int rowsAffected = preparedStatement.executeUpdate();

    						if (rowsAffected > 0) {
    							System.out.println("Data inserted into table " + tableName + " successfully.");
    						} else {
    							System.out.println("No rows affected. Data insertion failed.");
    						}
    				} catch (SQLException e) {
    					System.out.println("Data insertion failure.");
    					e.printStackTrace();
    				}
    	}
    	
    	public static void insertfavorite(String tableName,String nume) {
    			String insertDataSQL = "INSERT INTO public." + tableName + " (nume) VALUES (?)";

    				try (Connection connection = DriverManager.getConnection(url, user, password);
    							PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {

    						preparedStatement.setString(1, nume);

    						int rowsAffected = preparedStatement.executeUpdate();

    						if (rowsAffected > 0) {
    							System.out.println("Data inserted into table " + tableName + " successfully.");
    						} else {
    							System.out.println("No rows affected. Data insertion failed.");
    						}
    				} catch (SQLException e) {
    					System.out.println("Data insertion failure.");
    					e.printStackTrace();
    				}
    	}
    	
    	public static void insertgroup(String tableName,String nume) {
			String insertDataSQL = "INSERT INTO public." + tableName + " (nume) VALUES (?)";

				try (Connection connection = DriverManager.getConnection(url, user, password);
							PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {

						preparedStatement.setString(1, nume);

						int rowsAffected = preparedStatement.executeUpdate();

						if (rowsAffected > 0) {
							System.out.println("Data inserted into table " + tableName + " successfully.");
						} else {
							System.out.println("No rows affected. Data insertion failed.");
						}
				} catch (SQLException e) {
					System.out.println("Data insertion failure.");
					e.printStackTrace();
				}
	}
    	
    
	public void setText(String string) {
		// TODO Auto-generated method stub
		
	}
    
    
    }


    


