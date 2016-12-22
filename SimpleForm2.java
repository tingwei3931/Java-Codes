import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SimpleForm2 extends JFrame implements ActionListener{
	JLabel jlbText;
	JButton jbtSurprise, jbtBye;
	
	public SimpleForm2(){
		super("Hello World");
		setSize(350,100);
		
		//set the layout
		setLayout(new FlowLayout());
		
		//initiate all window components
		jlbText = new JLabel("Welcome to Swing");
		jbtSurprise = new JButton("Surprise");
		jbtBye = new JButton("See you");
		
		jbtSurprise.addActionListener(this); //step
		
		
		add(jlbText); //add label to the form
		add(jbtSurprise); //add button to the form
		add(jbtBye);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//DISPOSE_ON_CLOSE, HIDE_ON_CLOSE
	}
	//step5
	public void actionPerformed(ActionEvent e){
		JOptionPane.showMessageDialog(null,"no surprise");	
	}
	
	public static void main(String args[]){
		new SimpleForm2();
	}
}