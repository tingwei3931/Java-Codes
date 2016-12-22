import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class SimpleTextEditor extends JFrame {
	JTextArea jtaEditor;
	JButton jbtSave, jbtCancel;
	JPanel jplAction;
	JCheckBox jcbWrap;
	
	JMenuBar jmbMenu;
	JMenu jmFile, jmAbout;
	JMenuItem jmiSave, jmiExit;
	
	JFileChooser jfile = new JFileChooser(new File("."));
	
	SimpleTextEditor(String title){
		super(title);
		
		//call function
		buildGUI();
		
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
			private void save(){
				if (jfile.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
				JOptionPane.showMessageDialog(null, "Not done yet");
				}
				
		private void buildGUI(){
				jtaEditor = new JTextArea();
				jbtSave = new JButton("Save");
				jbtCancel = new JButton("Cancel");
				jcbWrap = new JCheckBox("LineWrap");
				
				jbtSave.setMnemonic('S');
				jbtCancel.setMnemonic('C');
				
				jplAction = new JPanel();
				jplAction.add(jbtSave);
				jplAction.add(jbtCancel);
				jplAction.add(jcbWrap);
				
				jplAction.setBorder(BorderFactory.createTitledBorder("~=+Action+=~"));
					
				jmbMenu = new JMenuBar();
				jmFile = new JMenu("File");
				jmAbout = new JMenu("About");
				jmiSave = new JMenuItem("Save");
				jmiExit = new JMenuItem("Exit");
				
				jmiExit.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e){
						System.exit(0);
					}
				});
				
				jbtSave.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							/*JFileChooser jfile = new JFileChooser(new File("."));
						
							if (jfile.showSaveDialog(this)== JFileChooser.APPROVE_OPTION)
							{
								JOptionPane.showMessageDialog(null, "Not done yet");
							}*/
							save();
						}
					});
					
				jcbWrap.addItemListener(new ItemListener(){
					public void itemStateChanged(ItemEvent e){
						if (jcbWrap.isSelected())
							jtaEditor.setLineWrap(true);
						else
							jtaEditor.setLineWrap(false);
					}
				});
					
				//add menu to menu bar
				jmbMenu.add(jmFile);
				jmbMenu.add(jmAbout);
				
				//add menu item into menu
				jmFile.add(jmiSave);
				jmFile.addSeparator();
				jmFile.add(jmiExit);
				
				//add menu bar to frame
				setJMenuBar(jmbMenu);
				
				add(new JScrollPane(jtaEditor),BorderLayout.CENTER);
				add(jplAction,BorderLayout.SOUTH);
			}
		public static void main(String args []){
			new SimpleTextEditor("Simple Text Editor V 1.0");
		}
	}