package djhstools.api.util;

import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * A wrapper around a PrintStream (e.g. System.out) to provide extra 
 * functionality.
 */
public class PrintStreamWrapper {
    PrintStream ps;
    private PrintStreamWrapper(PrintStream stream){
        ps = stream;
    }
    
    /*
    static PrintStreamWrapper defaultInstance;
    public static PrintStreamWrapper getInstance(){
        if(!(defaultInstance instanceof PrintStreamWrapper)){
            defaultInstance = new PrintStreamWrapper(System.out);
        }
        return defaultInstance;
    }
    */ 
    //Implement as a final public field instead
    public final static PrintStreamWrapper out = new PrintStreamWrapper(System.out);
    
    static Map<PrintStream, PrintStreamWrapper> instanceMap = 
            new HashMap<PrintStream, PrintStreamWrapper>();
    public static PrintStreamWrapper getInstance(PrintStream stream){
        if(instanceMap.containsKey(stream)){
            return instanceMap.get(stream);
        }else{
            PrintStreamWrapper instance = new PrintStreamWrapper(stream);
            instanceMap.put(stream, instance);
            return instance;
        }
    }
    
    public PrintStream ps(){
        return ps;
    }
    
    /* Convenince Methods (for those not inculded, make call to ps() first)*/
    public void println(){
        ps.println();
    }
    public void print(int i){
        ps.print(i);
    }
    public void print(long l){
        ps.print(l);
    }
    public void print(Object obj){
        ps.print(obj);
    }
    
    static final String NEWLINE_DELIMETER = "\n";
    private final void printDelimeter(String delimeter){
        if(delimeter.equals(NEWLINE_DELIMETER)){
                println();
        }else{
                print(delimeter);
        }
    }

    public final void printArray(Object[] oa){
        printArray(oa, "");
    }
    public final void printArrayLines(Object[] oa){
        printArray(oa, NEWLINE_DELIMETER);
    }
    public final void printArray(Object[] oa, String delimeter){
        for(Object o : oa){
            print(o); printDelimeter(delimeter);
        }
    }

    public final void printArray(int[] ia){
        printArray(ia, "");
    }
    public final void printArrayLines(int[] ia){
        printArray(ia, NEWLINE_DELIMETER);
    }
    public final void printArray(int[] ia, String delimeter){
        for(int i : ia){
            print(i); printDelimeter(delimeter);
        }
    }

    public final void printCollection(Collection c){
        printCollection(c, "");
    }
    public final void printCollectionLines(Collection c){
        printCollection(c, NEWLINE_DELIMETER);
    }
    public final void printCollection(Collection c, String delimeter){
        for(Object o : c){
            print(o); printDelimeter(delimeter);
        }
    }


    public final void print2dArrayLines(Object[][] o2a){
        print2dArrayLines(o2a, "");
    }
    public final void print2dArrayLines(Object[][] o2a, String horDelimeter){
        print2dArray(o2a, horDelimeter, NEWLINE_DELIMETER);
    }
    public final void print2dArray(Object[][] o2a, String horDelimeter, String verDelimeter){
        for(Object[] oa : o2a){
            printArray(oa, horDelimeter);
            printDelimeter(verDelimeter);
        }
    }

    public final void print2dArrayLines(int[][] i2a){
        print2dArrayLines(i2a, "");
    }
    public final void print2dArrayLines(int[][] i2a, String horDelimeter){
        print2dArray(i2a, horDelimeter, NEWLINE_DELIMETER);
    }
    public final void print2dArray(int[][] i2a, String horDelimeter, String verDelimeter){
        for(int[] ia : i2a){
            printArray(ia, horDelimeter);
            printDelimeter(verDelimeter);
        }
    }
    
}
