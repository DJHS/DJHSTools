package djhstools.api.utilities;

import java.io.PrintStream;
import java.util.Collection;

public class SystemOut {
        static final String NEWLINE_DELIMETER = "\n";
        PrintStream out;
        
        public SystemOut(){
            this(System.out);
        }
	public SystemOut(PrintStream printStream){
            this.out = printStream;
	}
	
	public final void p(Object o){
		out.print(o);
	}
        public final void p(int i){
                out.print(i);
        }
        public final void p(long i){
                out.print(i);
        }
	
        public final void pl(){
                out.println();
        }
        public final void pnl(int numberOfLines){
            for(int i=0; i<numberOfLines; i++){
                pl();
            }
        }
	public final void pl(Object o){
		p(o); pl();
	}
        public final void pl(int i){
                p(i); pl();
        }
        public final void pl(long i){
                p(i); pl();
        }
        
        final void printDelimeter(String delimeter){
            if(delimeter.equals(NEWLINE_DELIMETER)){
                    pl();
            }else{
                    p(delimeter);
            }
        }
        
        public final void p(Object[] oa){
            p(oa, "");
        }
        public final void pl(Object[] oa){
            p(oa, NEWLINE_DELIMETER);
        }
        public final void p(Object[] oa, String delimeter){
            for(Object o : oa){
                p(o); printDelimeter(delimeter);
            }
        }
        
        public final void p(int[] ia){
            p(ia, "");
        }
        public final void pl(int[] ia){
            p(ia, NEWLINE_DELIMETER);
        }
        public final void p(int[] ia, String delimeter){
            for(int i : ia){
                p(i); printDelimeter(delimeter);
            }
        }
        
        public final void p(Collection c){
            p(c, "");
        }
        public final void pl(Collection c){
            p(c, NEWLINE_DELIMETER);
        }
        public final void p(Collection c, String delimeter){
            for(Object o : c){
                p(o); printDelimeter(delimeter);
            }
        }

        
        public final void pl(Object[][] o2a){
            pl(o2a, "");
        }
        public final void pl(Object[][] o2a, String horDelimeter){
            for(Object[] oa : o2a){
                p(oa, horDelimeter);
                pl();
            }
        }
        
        public final void pl(int[][] i2a){
            pl(i2a, "");
        }
        public final void pl(int[][] i2a, String horDelimeter){
            for(int[] ia : i2a){
                p(ia, horDelimeter);
                pl();
            }
        }
        
        
}
