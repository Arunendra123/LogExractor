package LogReader;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileView; 
public	class LogExtractorViewer extends JFrame implements ActionListener 
{ 
		static JTextField t,t1,t2; 
		static JFrame f; 
		static Button b,b1,b2; 
		static JLabel l,l1,l2,l3,l4; 
		static JTextArea tArea;
		LogExtractorViewer() 
		{ 
			
		} 
		public static void viewer() 
		{ 
			f  = new JFrame("Log Extractor"); 
			f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
			l  = new JLabel(" ");
			l1 = new JLabel("Input File Path");
			l2 = new JLabel("Output File Path");
			l3 = new JLabel("Input Pattern or Regex");
			l4 = new JLabel("");
			b  = new Button("Extract");
			b1 = new Button();
			b2 = new Button();
			
			
			LogExtractorViewer te = new LogExtractorViewer(); 
			b.addActionListener(te); 
			t  = new JTextField(30);
			t1 = new JTextField(30);
			t2 = new JTextField(30);
			
		    l.setFont(new Font("Serif", Font.ITALIC, 12));
		    l1.setFont(new Font("Serif", Font.BOLD, 14));
		    l2.setFont(new Font("Serif", Font.BOLD, 14));
		    l3.setFont(new Font("Serif", Font.BOLD, 14));
		    l4.setFont(new Font("Serif", Font.BOLD, 8));
	        
			JPanel p = new JPanel(new GridLayout(7, 2, 20, 4));
			p.setBorder(BorderFactory.createTitledBorder("Hello Arunendra: "));
			p.add(t);
			p.add(l1);
			//p.add(b1);
			p.add(t1);
			p.add(l2);
			//p.add(b2);
			p.add(t2);
			p.add(l3);
			p.add(b); 
			p.add(l4);
			p.add(l);
			//p.add(l4);
			f.add(p); 
			f.setSize(500, 300); 
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
		} 
} 


