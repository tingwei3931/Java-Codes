import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CalculatorLab extends JFrame implements ActionListener{
	private JLabel jlbNo1, jlbNo2, jlbAnswer;
	private JTextField jtfNo1, jtfNo2, jtfAnswer;
	private JButton jbtPlus, jbtMinus, jbtMul, jbtDiv;
	
	//constructor
	CalculatorLab(String title){
		super(title);
		setSize(250,300);
		setLayout(null);
		
		buildGUI();
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void buildGUI(){
		
		//declare
		jlbNo1 = new JLabel("Number 1: ", JLabel.LEFT);
		jlbNo2 = new JLabel("Number 2: ", JLabel.LEFT);
		
		jtfNo1 = new JTextField(20);
		jtfNo2 = new JTextField(20);
		
		jbtPlus = new JButton("+");
		jbtMinus = new JButton("-");
		jbtMul = new JButton("*");
		jbtDiv = new JButton("/");
		
		jlbAnswer = new JLabel("Answer");
		jtfAnswer = new JTextField(20);
		jtfAnswer.setEditable(false);
			
		//set	
		jtfNo1.setBounds(120,10,100,20);
		jtfNo2.setBounds(120,40,100,20);
		
		jlbNo1.setBounds(10,10,100,20);
		jlbNo2.setBounds(10,40,100,20);
		
		jbtPlus.setBounds(20,90,50,50);
		jbtMinus.setBounds(70,90,50,50);
		jbtMul.setBounds(120,90,50,50);
		jbtDiv.setBounds(170,90,50,50);
		
		jlbAnswer.setBounds(10,180,100,20);
		jtfAnswer.setBounds(120,180,100,20);
		
		//register event
		jbtPlus.addActionListener(this);
		jbtMinus.addActionListener(this);
		jbtMul.addActionListener(this);
		jbtDiv.addActionListener(this);
		
		//add
		add(jlbNo1);
		add(jlbNo2);
		
		add(jtfNo1);
		add(jtfNo2);
		
		add(jbtPlus);
		add(jbtMinus);
		add(jbtMul);
		add(jbtDiv);
		
		add(jlbAnswer);
		add(jtfAnswer);
		
		
	}
	
	//handler for ActionListener
	//plus
	public void actionPerformed(ActionEvent e){
		double no1,no2,answer;
		
		if(e.getSource() == jbtPlus){
			no1 = Double.parseDouble(jtfNo1.getText());
			no2 = Double.parseDouble(jtfNo2.getText());
			
			answer = no1+no2;
			
			jtfAnswer.setText(answer+"");
		}

		else if(e.getSource() == jbtMinus){
			no1 = Double.parseDouble(jtfNo1.getText());
			no2 = Double.parseDouble(jtfNo2.getText());
			
			answer = no1-no2;
			
			jtfAnswer.setText(answer+"");
		}

		
		else if(e.getSource() == jbtMul){
			no1 = Double.parseDouble(jtfNo1.getText());
			no2 = Double.parseDouble(jtfNo2.getText());
			
			answer = no1*no2;
			
			jtfAnswer.setText(answer+"");
		}

	
		else if(e.getSource() == jbtDiv){
			no1 = Double.parseDouble(jtfNo1.getText());
			no2 = Double.parseDouble(jtfNo2.getText());
			
			answer = no1/no2;
			
			jtfAnswer.setText(answer+"");
		}
	}
	
	public static void main(String args []){
		new CalculatorLab("Calculator");
	}
	
}//end class