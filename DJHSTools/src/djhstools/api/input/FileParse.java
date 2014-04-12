package djhstools.api.input;

import djhstools.api.util.ScannerWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class FileParse extends AbstractParse{
    File file;
    
    public FileParse(String filePath) throws FileNotFoundException{
        file = new File(filePath);
        if(!file.exists()){
            throw new FileNotFoundException(filePath + " does not exist.");
        }
        if(!file.isFile()){
            throw new IllegalArgumentException(filePath + " is not a file (maybe a directory?)");
        }
    }
  
    @Override
    public InputStream newInputStream(){
        try{
            return new FileInputStream(file);
        }catch(FileNotFoundException e){
            //Will never happen, would be thrown in constructor
            return null;
        }
    }
}

