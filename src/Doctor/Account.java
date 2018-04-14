package Doctor;





import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

public class Account extends JFrame implements ActionListener { 

	JPanel top = new JPanel();
	JPanel bottom = new JPanel();
	JPanel left = new JPanel();
	JPanel right = new JPanel();
	JTextField password= null;
	
	
	JTextField name = null;
	JTextField phone = null;
	JTextField appdate = null;
	JTextField apptime = null;
	JTextArea commentTextArea = null;
	JTextField medicine = null;
	JTextField billamount = null;
	JTextField date = null;
	JLabel label1 = null;
	
	JTable table =null;
	
	JButton login=null;
	
	 JTextField status=null;
	
	JButton Add=null;
	public  Account(){
		
	
		
	     setSize(500,500);
	     setVisible(true);
	     
	 	 this.setLayout(new BorderLayout());
	 	 
			try {
				
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			}catch(Exception e ){}
			
			
			  Connection conn = null;
	    	Statement stmt = null;
	    	ResultSet rs = null;
    	    Object[][] data = new Object[100][8];
    	    try {
        	    conn =
        	       DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=");

        	    // Do something with the Connection
        	    stmt = conn.createStatement();



	    	
	    	    
	    	    if (stmt.execute("SELECT * FROM `mypatient`")) {
	    	        rs = stmt.getResultSet();
	    	    }

	    	    // loop over results
	    	    

	    	    
	    	    int rowCounter = 0;
	    	    
	    	    while(rs.next()){
	    	    
	    	    	String id = rs.getString("id");
	    	    	
	    	    	data[rowCounter][0] = id;
	 
	    	        String name = rs.getString("name");
	    	    	data[rowCounter][1] = name;
	    	    	
	    	    	 String pho = rs.getString("phone");
		    	    	data[rowCounter][2] = pho;
	    	    	String messa = rs.getString("date");    	    
	    	    	data[rowCounter][3] = messa;
	    	    	
	    	    
	    	    	
	    	    	String appdat = rs.getString("appdate");
	    	    	data[rowCounter][4] =appdat;
	    	    	String apptim = rs.getString("apptime");
	    	    	data[rowCounter][5] = apptim;
	    	    	
	    	    	String medicine = rs.getString("medicine");
	    	    	data[rowCounter][6] = medicine;
	    	    	
	    	    	
	    	         rowCounter++;    
	    	        
	        	    
	    	        
	    	    } 
	    	
	    	} catch (SQLException ex) {
	    	    // handle any errors
	    	    System.out.println("SQLException: " + ex.getMessage());
	    	    System.out.println("SQLState: " + ex.getSQLState());
	    	    System.out.println("VendorError: " + ex.getErrorCode());
	    	}
	    	
	    	
	    	String[] columnNames = {"Id",
	                "Patient Name",
	                "Phone",
	               
	                "'Date",
	                "App Date",
	                "App Time",
	                "Medicine"
	    	
	    	};
	    	
	    	table = new JTable(data, columnNames);
	    	
	    	JScrollPane js=new JScrollPane(table);
	    	
	    	
	         left.add(js);
	         
	    
	         this.add(top, BorderLayout.NORTH);
	         
	         this.add(bottom, BorderLayout.SOUTH);
	         
	         this.add(left, BorderLayout.WEST);
	         this.add(right, BorderLayout.EAST);
	         
	         right.setLayout(new GridLayout(9,0));
	         
	     validate();
	     repaint();
	     
	     
	     JLabel label1=new JLabel("NAME");
			right.add(label1);
	     
	     
	 	 name = new JTextField(20);
		right.add(name);
		
		
		JLabel label2=new JLabel("PHONE");
		right.add(label2);
		 phone = new JTextField(20);
			right.add(phone);
			JLabel label5=new JLabel(" DATE");
			right.add(label5);
			date = new JTextField(20);
				right.add(date);
			
			JLabel label3=new JLabel("APP DATE");
			right.add(label3);
			 appdate = new JTextField(20);
				right.add(appdate);
				
				JLabel label4=new JLabel("APP TIME");
				right.add(label4);
				
				 apptime = new JTextField(20);
					right.add(apptime);
					
					
					JLabel label6=new JLabel("Medicine ");
					right.add(label6);
					 medicine = new JTextField(20);
						right.add(medicine);	 
						
						
						
						JLabel label0=new JLabel("Add Bill Amount ");
						right.add(label0);
						 billamount = new JTextField(20);
							right.add(billamount);
						
						
							JLabel labelii=new JLabel("Bill Status ");
							right.add(labelii);
							 status = new JTextField(20);
								right.add(status);	
							
							
							
						
						Add = new JButton("Add");
						Add.addActionListener(this);
					      Add.setActionCommand("add");
						Add.setSize(30, 50);
						// we are adding on a label to the button here
						// so later we will know which button has been clicked.
						
						right.add(Add);	
							
							
		
		
		
		 
		
	
		
		login = new JButton("Show!");
		login.addActionListener(this);
	      login.setActionCommand("Login");
		login.setSize(30, 50);
		// we are adding on a label to the button here
		// so later we will know which button has been clicked.
		
		top.add(login);
		
		
		JButton logout = new JButton("log out!");
		logout.addActionListener(this);
	      logout.setActionCommand("logout");
		logout.setSize(30, 50);
		// we are adding on a label to the button here
		// so later we will know which button has been clicked.
		
		bottom.add(logout);
	     
	     
	     
	}
	


	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Login")){
		
		
		TableModel model=table.getModel();
		
		int indexes=table.getSelectedRow();
		
		name.setText(model.getValueAt(indexes,1).toString());
		phone.setText(model.getValueAt(indexes,2).toString());
		date.setText(model.getValueAt(indexes,3).toString());
		appdate.setText(model.getValueAt(indexes,4).toString());
		apptime.setText(model.getValueAt(indexes,5).toString());
		medicine.setText(model.getValueAt(indexes,6).toString());
		 }
		
		
		
		if(e.getActionCommand().equals("logout")){
			
			
			System.exit(0);
			 }
		
		
		
		 
			if(e.getActionCommand().equals("add")){
			 
				
					
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
					
					  Connection conn = null;
			    	Statement stmt = null;
			    	ResultSet rs = null;
		    	    Object[][] data = new Object[100][7];
		    	    try {
		        	    conn =
		        	       DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=");

		        	    // Do something with the Connection
		        	    stmt = conn.createStatement();

	
					
				
					
					
					
				
				
				
				
				
				

		  	    String medicin = medicine.getText();
		  	    
		  	    System.out.println(medicin);
		  	  String nam = name.getText();
		  	  
		  	String n = status.getText();
		  	 System.out.println(nam);
		  	    
		  	    if (stmt.execute("UPDATE `mypatient` SET `medicine`='"+medicin+"',`status`='"+n+"' where `name`='"+nam+"'")) {
		  	    	System.out.println("Added");
		  	    	
		  	    }

		  	    // loop over results
		  	  	    	   
		  	} catch (SQLException ex) {
		  	    // handle any errors
		  	    System.out.println("SQLException: " + ex.getMessage());
		  	    System.out.println("SQLState: " + ex.getSQLState());
		  	    System.out.println("VendorError: " + ex.getErrorCode());
		  	}

			 
			 
			 
		    	    
			 
		    	    JOptionPane.showMessageDialog(null,"Added bill");
			 
		    	   
			 
		 }
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
}

















