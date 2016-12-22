import javax.swing.*;
import java.awt.*;

class SimpleForm3 extends JFrame{
	JButton jbtButton[] = new JButton[6]; //5 Button here
	
	public SimpleForm3(){
		super("Layout Management");
		setSize(400,400);
		//setLayout(new GridLayout(3,2));
		
		//create 5 buttons
		for(int i= 0; i < jbtButton.length; i++){
			jbtButton[i] = new JButton(""+i);
		}
		
		/*ImageIcon coffee = new ImageIcon("coffee.gif");
		jbtButton[0].setBounds(50,10,50,50);
		jbtButton[0].setImageIcon(coffee);
		jbtButton[0].setToolTips("Buy Coffee");
		jbtButton[0].setMnemonic("C");
		add(jbtButton[0]);*/
		
		//arrange the buttons
		add(jbtButton[0],BorderLayout.NORTH);
		add(jbtButton[1],BorderLayout.EAST);
		add(jbtButton[2],BorderLayout.WEST);
		add(jbtButton[3],BorderLayout.SOUTH);
		add(jbtButton[4],BorderLayout.CENTER);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]){
		new SimpleForm3();
	}
}