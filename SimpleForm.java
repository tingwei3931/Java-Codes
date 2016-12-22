import javax.swing.*;

class SimpleForm{
	public static void main(String args[]){
		JLabel jlbText = new JLabel("Hello");
		JFrame window = new JFrame("Hello World");
		window.setSize(300,300);
		//adding the label to the frame
		window.add(jlbText);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
}