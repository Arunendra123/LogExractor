package LogReader;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileView; 
public	class LogExtractorViewer extends JFrame implements ActionListener 
{ 
		static JTextField t,t1,t2; 
		static Frame f; 
		static JButton b,b1,b2; 
		static JLabel l,l1,l2,l3,l4; 
		static JTextArea tArea;
		LogExtractorViewer() 
		{ 
			
		} 
		public static void viewer() 
		{ 
			f  = new Frame("Log Extractor"); 
			f.addWindowListener(new WindowAdapter() {
		         public void windowClosing(WindowEvent windowEvent){
		            System.exit(0);
		         }        
		      }); 
			//f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			f.setLocation((dim.width/2-f.getSize().width/2)-250, (dim.height/2-f.getSize().height/2)-100);
			
			//f.setLocationRelativeTo(null);
			//l  = new Label(" ");
			//l1 = new Label("Input  File Path");
			//l2 = new Label("Output File Path");
			l3 = new JLabel("  Input Pattern or Regex");
			//l4 = new Label("");
			b  = new JButton("Extract");
			b.setPreferredSize(new Dimension(90,20));
			b1 = new JButton("Input File Path");
			b2 = new JButton("Output File Path");
			b1.setPreferredSize(new Dimension(125, 20));
			b2.setPreferredSize(new Dimension(125, 20));
			
			LogExtractorViewer te = new LogExtractorViewer(); 
			b.addActionListener(te);
			b1.addActionListener(te);
			b2.addActionListener(te);
			t  = new JTextField(28);
			t1 = new JTextField(28);
			t2 = new JTextField(28);
			
		    //l.setFont(new Font("Serif", Font.ITALIC, 12));
		    //l1.setFont(new Font("Serif", Font.BOLD, 10));
		    //l2.setFont(new Font("Serif", Font.BOLD, 10));
		    l3.setFont(new Font("Serif", Font.BOLD, 12));
			//JPanel p = new JPanel(new GridLayout(7, 2, 20, 4));
			JPanel p = new JPanel();
			p.setBorder(BorderFactory.createTitledBorder("Hello Arcsight V1.0: "));
			p.add(t);
			p.add(b1);
			//p.add(l1);
			p.add(t1);
			p.add(b2);
			//p.add(l2);
			p.add(t2);
			p.add(l3);
			p.add(b); 
			//p.add(l);
			//p.add(l4);
			f.add(p); 
			f.setSize(500, 250); 
	        f.show();
		} 
		public void actionPerformed(ActionEvent e) 
		{ 
			
			String s = e.getActionCommand(); 
			if (s.equals("Extract")) 
			{ 				
				
				if(t.getText().equals("")|t1.getText().equals("")|t2.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(this,"Please Input",
							   "Warning",JOptionPane.WARNING_MESSAGE);    
				}
				else
				{
					MyFileReader.myReader(t.getText(),t1.getText(),t2.getText());
					if(MyFileReader.flags==1)
					{
						 JOptionPane.showMessageDialog(this,"Done!!!!!!","Successful",JOptionPane.PLAIN_MESSAGE);
					}
					else
					{
						 JOptionPane.showMessageDialog(this,"Invalid Input!!!","Error",JOptionPane.ERROR_MESSAGE);
		
					}
						
				}
			} 
			else if(s.equals("Output File Path"))
			{
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = jfc.showOpenDialog(null);
				//int returnValue = jfc.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) 
				{
					File selectedFile = jfc.getSelectedFile();
					t1.setText( selectedFile.getAbsolutePath());
				}
			}
			else
			{
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = jfc.showOpenDialog(null);
				//int returnValue = jfc.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) 
				{
					File selectedFile = jfc.getSelectedFile();
					t.setText( selectedFile.getAbsolutePath());
				}
			}
		} 
} 


