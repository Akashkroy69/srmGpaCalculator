import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

   public class BinaryNumber {
	    static int count=0;
	    static int max=0;

	    void maxconsecutiveone(int n)
	    {
	        int r,q;


	        if(n==1 || n==0)
	        {
	           
	           if(n==1)
	           {
	        	   r=n%2;
	        	   count++;//count=0;
	        	   //System.out.println(".."+ count);
	        	   if(count>max) 
	        		   {
	        		    max=count;
	        		    //count=0;
	        		    //System.out.println(".."+ max);
	        		   }
	           }
	           else
	           {
	        	   r=0;
		           count=0;
		           
	           }
	           //System.out.println("lak");
	        }
	        
	        else
	        {
	            r=n%2;
	            if(r==1)
	            {
	                count++;
	               if(count>max) max=count;
	            }
	            else 
	            {
	                count=0;
	                
	            }
	            if(n==0) {q=0;}
	            else {q=n/2;}		
	            maxconsecutiveone(q);

	        }
	        

	    }



	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	    	BinaryNumber bin=new BinaryNumber();
	        
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	        System.out.println("hi");
	        while(true)
	        {
	        	int n = scanner.nextInt();
	        	bin.maxconsecutiveone(n);
	            System.out.println(max);
	            max=0;
	            count=0;
	        }
	        //scanner.close();
	    }
	}
   
   
///ALLISON CODE FOR THE QUESTION:
/*import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        
        char[] binary = Integer.toBinaryString(n).toCharArray();
        int tmpCount = 0;
        int maxCount = 0;
        for(int i = 0; i < binary.length; i++){
            tmpCount = (binary[i] == '0') ? 0 : tmpCount + 1; 
            if(tmpCount > maxCount){
                maxCount = tmpCount;
            }
        }
        System.out.println(maxCount);
    }
}*/


