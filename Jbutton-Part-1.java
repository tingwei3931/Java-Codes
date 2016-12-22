import java.awt.FlowLayout;
import java.awt.event.ActionListener;// wait user act something like enter textbox
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JButton;
class Jbutton extends JFrame{
private JButton reg;
private JButton custom;
public Jbutton (){
	super("Button");
	setLayout(new FlowLayout());
	
	reg=new JButton("Enter Quantity");
	add(reg);
	
	Icon b=new ImageIcon(getClass().getResource("b.png"));
	Icon x=new ImageIcon(getClass().getResource("a.png"));
	
	custom=new JButton("Custom",b);
	custom.setRolloverIcon(x);
	add(custom);
	
	HandlerClass handle=new HandlerClass();
	reg.addActionListener(handle);
	custom.addActionListener(handle);
		
}

private class HandlerClass implements ActionListener{
	public void actionPerformed(ActionEvent event){
		if(event.getSource()==reg){
	    String num=JOptionPane.showInputDialog(null,String.format("%s",event.getActionCommand()));
		System.out.println(""+num);
		}
		else{
		JOptionPane.showMessageDialog(null,String.format("B2",event.getActionCommand()));
		}
	}
}


	
}
