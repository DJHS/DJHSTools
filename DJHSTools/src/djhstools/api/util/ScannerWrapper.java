package djhstools.api.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class ScannerWrapper {

    Scanner scan;
    public ScannerWrapper(Scanner scanner) {
        scan = scanner;
    }
    
    public Scanner scanner(){
        return this.scan;
    }
    
    public String[] nextLinesArray(int numLines){
        return (String[]) nextLinesCollection(numLines).toArray();
    }
    public Collection<String> nextLinesCollection(int numLines){
        /* 
         * ArrayDeque is most efficient Collection implementation in default
         * java libraries.
         */
        Collection<String> result = new ArrayDeque<String>();
        populateCollectionWithLines(result, numLines);
        return result;
    }
    public List<String> nextLinesList(int numLines){
        /* 
         * ArrayList is most efficient List implementation in default java 
         * libraries
         */
        List<String> result = new ArrayList<String>();
        populateCollectionWithLines(result, numLines);
        return result;
    }
    private void populateCollectionWithLines(Collection collection, int numLines){
        for(int i=0; i<numLines && scan.hasNextLine(); i++){
            collection.add(scan.nextLine());
        }
    }
    
    /**
     * @return a Scanner ready to scan the next line of the wrapped scanner of
     * this wrapper if such as line exists, otherwise returns a scanner ready to
     * scan null
     */
    public Scanner nextLineScanner(){
        return new Scanner(scan.nextLine());
    }
    public Scanner nextLineScanner(String delimeter){
        Scanner lineScanner = new Scanner(scan.nextLine());
        lineScanner.useDelimiter(delimeter);
        return lineScanner;
    }
    
    /**
     * Convenience method to reduce a call to scanner() 
     * (for use with dem while loops) :)
     * Accomplishes exact same thing as scanner().hasNextLine();
     */
    public boolean hasNextLine(){
        return scan.hasNextLine();
    }
    
}
