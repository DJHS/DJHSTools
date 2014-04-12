/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package djhstools.api.input;

import djhstools.api.util.ScannerWrapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DDW
 */
public abstract class AbstractParse {
    public Scanner newScanner(){
        return new Scanner(this.newInputStream());
    }
    
    public ScannerWrapper newScannerWrapper(){
        return new ScannerWrapper(newScanner());
    }
    
    public LineInput newLineInput(){
        return new LineInput(this.newInputStream());
    }
    
    public abstract InputStream newInputStream();
    
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
