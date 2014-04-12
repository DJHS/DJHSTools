package djhstools.api.input;

import java.io.InputStream;
import java.util.Scanner;

/**
 * The entire functionality of this class is provided by convenience methods
 * in FileParse, or by calls to an instantiated ScannerWrapper.
 * If no other functionality was meant for this class, it can be removed.
 * If other functionality was meant for this class, please remove this comment
 * and the Deprecated annotation (and hopefully implement that functionality :)
 */
@Deprecated
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
