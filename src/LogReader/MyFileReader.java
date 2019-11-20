package LogReader;


import java.io.*;

public class MyFileReader 
{
	static int flags=1;
	public static void myReader(String input,String output,String pattern) 
	{	   
		    FileReader reader;
		    FileWriter writer;
		    pattern=LogExtractorViewer.t2.getText();
			try {
				writer=new FileWriter(output); 
				reader=new FileReader(input);
				BufferedReader readme =new BufferedReader(reader);
				BufferedWriter writeme =new BufferedWriter(writer);
				String line = readme.readLine();
				while (line != null)
				{
					if(PatternProcessor.checkLine(pattern, line))
					{
						writeme.write(line);
						writeme.newLine();
					}
					line = readme.readLine();
				}
				flags=1;
				readme.close();
				writeme.close();
				reader.close();
				writer.close();
				
			}
			catch (IOException e) 
			{
				flags=0;		
			}
		
			
	}

}
