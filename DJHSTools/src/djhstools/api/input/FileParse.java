package djhstools.api.input;

import djhstools.api.util.ScannerWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class FileParse {
    File file;
    
    public FileParse(String filePath)throws FileNotFoundException{
        file = new File(filePath);
        if(!file.exists()){
            throw new FileNotFoundException(filePath + " does not exist.");
        }
        if(!file.isFile()){
            throw new IllegalArgumentException(filePath + " is not a file (maybe a directory?)");
        }
    }
    
    public Scanner newScanner(){
        return new Scanner(this.newInputStream());
    }
    
    public ScannerWrapper newScannerWrapper(){
        return new ScannerWrapper(newScanner());
    }
    
    public LineInput newLineInput(){
        return new LineInput(this.newInputStream());
    }
    
    public InputStream newInputStream(){
        try{
            return new FileInputStream(file);
        }catch(FileNotFoundException e){
            //Will never happen, would be thrown in constructor
            return null;
        }
    }
    
    public String[] getLinesArray(){	
        return newScannerWrapper().nextLinesArray(Integer.MAX_VALUE);
    }
    
    public Collection<String> getLinesCollection(){
        return newScannerWrapper().nextLinesCollection(Integer.MAX_VALUE);
    }
    
    public List<String> getLinesList(){
        return newScannerWrapper().nextLinesList(Integer.MAX_VALUE);
    }
}
