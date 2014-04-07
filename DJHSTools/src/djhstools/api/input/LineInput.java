package djhstools.api.input;

import java.io.InputStream;
import java.util.Scanner;

public class LineInput {
	
	private Scanner scan;
	
	public LineInput(){
		this(System.in);
	}
	public LineInput(InputStream stream){
		this.scan = new Scanner(stream);
	}
	
	public final String[] getInputLines(int amtLines){
		String[] lines = new String[amtLines];
		for(int i=0; i<amtLines; i++)
			lines[i] = scan.nextLine();
		return lines;
	}
}
