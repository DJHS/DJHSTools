package djhstools.api.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class FileArgParse {
    File file;
    
    public FileArgParse(String filePath)throws FileNotFoundException{
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
}
