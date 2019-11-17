package LogReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PatternProcessor
{
	public static boolean checkLine(String pattern, String line)
	{
		Pattern p=Pattern.compile(pattern);
		Matcher m = p.matcher(line);
		if(m.find()) 
		{
			return true;
		}
		return false;
	}
}
