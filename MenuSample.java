import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MenuSample extends JFrame{
		JLabel jlbHeading;
		JTextArea jtaText;
		JCheckBox jcbBold, jcbItalic;
		JPanel jplCheck;
		
		JMenuBar jmbMenu; //menu bar
		JMenu jmFile;  //file menu
		JMenuItem jmiExit; //MenuItem
	
		MenuSample(String title){
			super(title);
			buildGUI(); //construct GUI
			setSize(300, 300);
			setLocationRelativeTo(null);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		}
	
		private void buildGUI(){
			jlbHeading = new JLabel("Simple Text Demonstration ",JLabel.CENTER);
			jlbHeading.setFont(new Font("Seris", Font.PLAIN, 16));
		
			jtaText = new JTextArea(10, 40);
			jtaText.setLineWrap(true);
		
		
			jcbBold = new JCheckBox("Bold");
			jcbItalic = new JCheckBox("Italic");
		
			jplCheck = new JPanel();
			jplCheck.add(jcbBold);
			jplCheck.add(jcbItalic);
			
			jmbMenu = new JMenuBar();
		
			jmFile = new JMenu("File");
		
			jmiExit = new JMenuItem("Exit");		
			jmiExit.setMnemonic('E');
		
			jmiExit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.exit(0);
				}
			});
		
		jcbBold.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				if(jcbBold.isSelected())
					jtaText.setFont(new Font("Seris",Font.BOLD, 14));
				else
					jtaText.setFont(new Font("Seris", Font.BOLD, 12));			
			}
		});
		
		jmbMenu.add(jmFile);
		jmFile.add(jmiExit);
		setJMenuBar(jmbMenu);
		
		add(jlbHeading, BorderLayout.NORTH);
		add(new JScrollPane(jtaText), BorderLayout.CENTER);
		add(jplCheck,BorderLayout.SOUTH);
	}
	public static void main(String args[]){
		new MenuSample("Sample Menu");
	}
 }
