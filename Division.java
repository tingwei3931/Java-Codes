import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Division extends JFrame implements ActionListener{
	JLabel jlbNo1, jlbNo2;
	JTextField jtfNo1, jtfNo2;
	JButton jbtDivide;
	JPanel jplGroup;
	
	Division(String title){
		super(title);
		buildGUI();
		setSize(200, 100);
		setLocationRelativeTo(null);//center screen
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//if got multiple form, use dispose on close
	}
	
	private void buildGUI(){
		
		jlbNo1 = new JLabel("Number 1:", JLabel.LEFT);
		jlbNo2 = new JLabel("Number 2:", JLabel.LEFT);
		
		jtfNo1 = new JTextField(20);
		jtfNo2 = new JTextField(20);
		
		jbtDivide = new JButton("Divide");
		
		jbtDivide.addActionListener(this);//register the click event
		
		
		
		jplGroup = new JPanel();
		jplGroup.setLayout(new GridLayout(2,2,5,5));
		
		//add the labels and textfields to panel
		jplGroup.add(jlbNo1);
		jplGroup.add(jtfNo1);
		jplGroup.add(jlbNo2);
		jplGroup.add(jtfNo2);
		
		add(jplGroup, BorderLayout.CENTER);
		add(jbtDivide, BorderLayout.SOUTH);
		
	}
	public void actionPerformed(ActionEvent e){
		//if(e.getSource() == jbtDivide)
		//retrieve number one and number 2 
		int no1 = 0, no2 = 0;
		int result = 0;
		try{
			no1 = Integer.parseInt(jtfNo1.getText());
			no2 = Integer.parseInt(jtfNo2.getText());
			
			//System.out.println(no1);
		    //System.out.println(no2);
		    result = no1/no2 ;
		    JOptionPane.showMessageDialog(null, "Result: " + result);
		}
		catch(NumberFormatException hwalim){
			JOptionPane.showMessageDialog(null, "Number must be in numerical field.");
		}
		//Only division by zero with integers will raise an ArithmeticException. Division by zero
		// with double or float will result in Infinity.
		catch(ArithmeticException william){
			JOptionPane.showMessageDialog(null, "Unable to divide by 0");
		}
		catch(Exception tapir){
			JOptionPane.showMessageDialog(null, "Error: " + tapir.getMessage());
		}
	}
	public static void main(String args[]){
		new Division("Division"); 
	}
	 
}