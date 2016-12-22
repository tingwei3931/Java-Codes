import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LoginForm extends JFrame{
	//swing components
	JLabel jlbUser, jlbPassword;
	JTextField jtfUser, jtfPassword;
	JButton jbtOK, jbtCancel;
	//inner class
	private class buttonAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//alternatives: if(e.getActionCommand.Equals("OK"))
			if(e.getSource()==jbtOK){
				//JOptionPane.showMessageDialog(null, "Under Construction");
				if(jtfUser.getText().equals("") && jtfPassword.getText().equals("tapir")){
					JOptionPane.showMessageDialog(null, "William black black hahaha");
				}
				else{
					JOptionPane.showMessageDialog(null, "Illegal access");	
				}
			}
			else{
				//JOptionPane.showMessageDialog(null, "Under Construction");
				//if cancel button was clicked, clear the both text field
				jtfPassword.setText("");
				jtfUser.setText("");			
			}
		}
			
	}
	LoginForm(String title){
		super(title); //set window title(invoke parent constructor aka jFrame)
		setSize(500, 150);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);//Form will display at the center of screen
		buildGUI();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
    }
    
    //instantiate and build all the GUI components
    private void buildGUI(){
		jlbUser = new JLabel("Username:", JLabel.RIGHT);
		jlbPassword = new JLabel("Password: ", JLabel.RIGHT);	
			
		jtfUser = new JTextField(20);//20 spaces
		jtfPassword = new JPasswordField(20);
		
		jbtOK = new JButton("Ok");
		jbtCancel = new JButton("Cancel");
		//Register action event for both button
		jbtOK.addActionListener(new buttonAction());
		jbtCancel.addActionListener(new buttonAction());
			
		//Add the components inside the frame
		add(jlbUser);
		add(jtfUser);
		add(jlbPassword);
		add(jtfPassword);
		add(jbtOK);
		add(jbtCancel);
	}
	
	public static void main(String args[]){
		new LoginForm("Login");

	}
	
}
//end LoginForm