package com.railway;


//importing java swing and database connection libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



/*
 * created by JS VIGNESH KANNA
 * 17/08/2019 3:30 pm
 * Railway-Database connection software GUI application
 */

public class DemoGui {
	public static void main(String[] args) {
		DemoGui software = new DemoGui();
		software.go();

	}
	
	//public variables for GUI components
	JFrame frame;
	//component variables for entering passenger name
	JLabel name_label;
	JTextField name_field;  
	//components variables for entering the train name of passenger
	JLabel train_label;
	JTextField train_field;
	//checkbox variables for selecting the sex of passenger
	JCheckBox male;
	JCheckBox female;
	//components variable for selecting the age of passenger
	JLabel age_label;
	
	JList age_list;
	//components variables for enteing the source place
	JLabel source_label;
	JTextField source_field;
	//components variables for entering the destination place
	JLabel destination_label;
	JTextField destination_field;
	//components variable for butto
	JButton button1;
	
	//MYSQL validation components
	String url = "jdbc:mysql://localhost:3306/vkrailway";   //format for URL is "jdbc:mysql:database-name"    jdbc:mysql://127.0.0.1:3306/?user=root
	String username = "root";
	String password = "rishitaran";
	
	
	//MYSQL validation components
		//String url = "jdbc:mysql://localhost:3306/vkrailway";   //format for URL is "jdbc:mysql:database-name"    jdbc:mysql://127.0.0.1:3306/?user=root
		//String username = "root";
		//String password = "rishitaran";
	
	
	//go method to initiate the software process from main method when it starts
	
	public void go() {
		frame = new JFrame(); //creating main frame which holds all the components in it
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //making the frame to close on clicking 'X' button on taskbar
		frame.setBackground(Color.DARK_GRAY); //making the background of the frame of orange color
		
		//label and testfield for prompting the user to enter the name
		name_label = new JLabel("Enter your Name "); 
		name_field = new JTextField(15);
		
		//label and textfield to enter the train name
		train_label = new JLabel("Enter the train name");
		train_field = new JTextField(10);
		
		//checkbox for selecting the sex of passenger
		male = new JCheckBox("Select for male");
		female = new JCheckBox("Select for female");
		
		//dropdown box for selecting the age of passenger
		age_label = new JLabel("Select your Age");
		String[] list = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
		age_list = new JList(list); 
		age_list.setVisibleRowCount(5);
		age_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scroller = new JScrollPane(age_list);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); //making vertical scrollbar only and not horizontal one
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//components for entering the source place
		source_label = new JLabel("Enter the source place");
		source_field = new JTextField(10);
		
		//components for entering the destination place
		destination_label = new JLabel("Enter the Destination place");
		destination_field = new JTextField(10);
		
		//name_field.addActionListener(new nameFieldListener());
		button1 = new JButton("Book and Upgrade DataBase");
		button1.addActionListener(new ButtonListener());
		
		
		//putting EACH component in the HORIZONTAL layout
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		panel1.add(name_label);
		panel1.add(name_field);
		

		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		panel1.add(train_label);
		panel1.add(train_field);
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));
		panel4.add(male);
		panel4.add(female);
		
		JPanel panel5 = new JPanel();
		panel5.setLayout(new BoxLayout(panel5, BoxLayout.X_AXIS));
		panel5.add(age_label);
		panel5.add(scroller);
		
		JPanel panel6 = new JPanel();
		panel6.setLayout(new BoxLayout(panel6, BoxLayout.X_AXIS));
		panel6.add(source_label);
		panel6.add(source_field);
		
		JPanel panel7 = new JPanel();
		panel7.setLayout(new BoxLayout(panel7, BoxLayout.X_AXIS));
		panel7.add(destination_label);
		panel7.add(destination_field);
		
		JPanel panel8 = new JPanel();
		panel8.setLayout(new BoxLayout(panel8, BoxLayout.X_AXIS));
		panel8.add(button1);
		
		//PANEL-9 for holding ALL ABOVE panels in VERTICAL layout
		JPanel panel9 = new JPanel();
		panel9.setLayout(new BoxLayout(panel9, BoxLayout.Y_AXIS));
		panel9.add(panel1);
		
		panel9.add(panel3);
		panel9.add(panel4);
		panel9.add(panel5);
		panel9.add(panel6);
		panel9.add(panel7);
		panel9.add(panel8);
		
		frame.getContentPane().add(BorderLayout.CENTER, panel9);
		
		frame.setSize(800,800);
		frame.setVisible(true);
		
	}
	public class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			//generating random number for unique-id in database
			//Random rand = new Random();
			int uid = 140;
		   
			//getting the USER entered name and train name from their respectice text-fields
			String name = name_field.getText();
		   String train = train_field.getText();
		   String sex = "";
		   //getting the USER clicked SEX checkbox
		   if(male.isSelected()) {
			   sex = "Male";
		   }
		   else if(female.isSelected()) {
			   sex = "Female";
		   }
		   
		   //getting the USER selected age
		   String age = (String) age_list.getSelectedValue();
		   
			//getting the USER entered SOURCE and DESTINATION places
		   String source = source_field.getText();
		   String destination = destination_field.getText();
		   
		   //sending the above EXTARCTED information to the RAILWAY DATABASE
		   try {
			 
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
			
			//query to update the table with above instances
			String query = " insert into passengerdetail (uid, name, train, sex, age, source, destination)"
					+ " values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement prestmt = con.prepareStatement(query);
			prestmt.setInt(1, uid);
			prestmt.setString(2, name);
			prestmt.setString(3, train);
			prestmt.setString(4, sex);
			prestmt.setString(5, age);
			prestmt.setString(6, source);
			prestmt.setString(7, destination);
			
			
			
			
			prestmt.execute();
			con.close();
			
		   
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		}
	}

	

}
