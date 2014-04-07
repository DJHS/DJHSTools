package djhstools.api.utilities;

import djhstools.api.input.LineInput;

public class LineSplitter {
	
	//Still in works... got bored in comp sci
	
	LineInput lineInput;
	
	public LineSplitter(){
		this(new LineInput());
	}
	
	public LineSplitter(LineInput lineInput){
		this.lineInput = lineInput;
	}
	
	public String[] splitInput(String arr){
		return arr.split(", ");
	}
	
	
}
