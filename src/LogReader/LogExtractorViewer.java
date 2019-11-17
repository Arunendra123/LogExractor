package LogReader;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*; 
import javax.swing.*; 
public	class LogExtractorViewer extends JFrame implements ActionListener 
{ 
		static JTextField t,t1,t2; 
		static JFrame f; 
		static JButton b; 
		static JLabel l,l1,l2,l3,l4; 
		static JTextArea tArea;
		LogExtractorViewer() 
		{ 
		} 
		public static void viewer() 
		{ 
			f  = new JFrame("Log Extractor"); 
			l  = new JLabel(" ");
			l1 = new JLabel("Input File Path");
			l2 = new JLabel("Output File Path");
			l3 = new JLabel("Input Patter or Regex");
			l4 = new JLabel("");
			b  = new JButton("Extract");
			
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
	       
			JPanel p = new JPanel(new GridLayout(7, 2, 10, 2));
			p.setBorder(BorderFactory.createTitledBorder("Hello Arunendra: "));
			p.add(t);
			p.add(l1);
			p.add(t1);
			p.add(l2);
			p.add(t2);
			p.add(l3);
			p.add(b); 
			p.add(l4);
			p.add(l);
			//p.add(l4);
			f.add(p); 
			f.setSize(400, 200); 
	        f.show();
		} 
		public void actionPerformed(ActionEvent e) 
		{ 
			String s = e.getActionCommand(); 
			if (s.equals("Extract")) 
			{ 				
				if(t.getText().equals("")|t1.getText().equals("")|t2.getText().equals(""))
				{
					l.setText("Please Input");    
				}
				else
				{
					MyFileReader.myReader(t.getText(),t1.getText(),t2.getText());
					if(MyFileReader.flags==1)
					{
				         l.setText("Done!");
					}
					else
					{
						l.setText("Invalid Input!!!");
					}
						
				}
			} 
		} 
} 


