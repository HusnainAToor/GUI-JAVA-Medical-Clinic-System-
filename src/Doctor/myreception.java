package Doctor;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;




public class myreception extends JFrame implements ActionListener { 
	
	JTextField username = null;
	JTextField phone = null;
	JTextField appdate = null;
	JTextField apptime = null;
	JTextArea commentTextArea = null;
	public myreception(){
		
		
		
		setSize(300,300);
		setVisible(true);
		this.setLayout(new GridLayout(6,0));
		
		
		JLabel label1=new JLabel("NAME");
		this.add(label1);
		username = new JTextField(50);
		this.add(username);
		JLabel label2=new JLabel("Phone");
		this.add(label2);
		phone = new JTextField(50);
		this.add(phone);
		JLabel label3=new JLabel("Message");
		this.add(label3);
	 commentTextArea = new JTextArea(10,30);
		
		this.add(commentTextArea);
		
		
		
		JLabel label4=new JLabel("Appointment date");
		this.add(label4);
		appdate = new JTextField(50);
		this.add(appdate);
		JLabel label5=new JLabel("Appointment Time");
		this.add(label5);
		apptime = new JTextField(50);
		this.add(apptime);
		
	
		
		JButton login = new JButton("Submit");
		login.addActionListener(this);
		// we are adding on a label to the button here
		// so later we will know which button has been clicked.
		login.setActionCommand("login");
		this.add(login);
		
		JButton logout = new JButton("log out!");
		logout.addActionListener(this);
	      logout.setActionCommand("logout");
		logout.setSize(30, 50);
		// we are adding on a label to the button here
		// so later we will know which button has been clicked.
		
		this.add(logout);
		
		
		validate();
		repaint();

		
		
	
	}
	
	
	

	
	
	
	
	
	
public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().equals("add")){
	
	
savepatient();
	}


if(e.getActionCommand().equals("logout")){
	
	
	System.exit(0);
	 }
	

}




private void savepatient() {
	// TODO Auto-generated method stub
	try {
		
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		}catch(Exception e ){}
		
		
		  Connection conn = null;
  	Statement stmt = null;
  	ResultSet rs = null;
  	try {
  	    conn =
  	       DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?user=root&date=");

  	    // Do something with the Connection
  	  stmt = conn.createStatement();

  	    // or alternatively, if you don't know ahead of time that
  	    // the query will be a SELECT...

  	    String  usernam= username.getText();
  	    String phon = phone.getText();
  	  String coment= commentTextArea.getText();
  	String  apdate= appdate.getText();
	    String aptime = apptime.getText();
	 
  	Date date = new Date();
  	SimpleDateFormat d1=new SimpleDateFormat("dd/mm/yyyy");
	String s=d1.format(date);
  	 
  	    
	 if (stmt.execute("INSERT INTO `mypatient` (`id`, `name`, `phone`, `message`, `date`, `appdate`, `apptime`, `medicine`, `bill`, `status`) VALUES (NULL, '"+usernam+"', '"+phon+"', '"+coment+"', '"+s+"', '"+apdate+"', '"+aptime+"', '', '', '');")) {
	    	System.out.println("Added");
	    	
	    }


  	    // loop over results
  	  	    	   
  	} catch (SQLException ex) {
  	    // handle any errors
  	    System.out.println("SQLException: " + ex.getMessage());
  	    System.out.println("SQLState: " + ex.getSQLState());
  	    System.out.println("VendorError: " + ex.getErrorCode());
  	}

    JOptionPane.showMessageDialog(null,"Appointment Made");
	
	
}



}

