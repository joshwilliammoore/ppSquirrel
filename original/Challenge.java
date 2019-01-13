import java.util.Stack;	 	       	  	 	        	      	   	
public class Challenge	 	       	  	 	        	      	   	
{	 	       	  	 	        	      	   	
  public static String convert(int original,int base)	 	       	  	 	        	      	   	
  {	 	       	  	 	        	      	   	
    String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";	 	       	  	 	        	      	   	
    int divident = original;	 	       	  	 	        	      	   	
    int divisor = base;	 	       	  	 	        	      	   	
    int quotient = 0;	 	       	  	 	        	      	   	
    int remainder = 0;	 	       	  	 	        	      	   	
    Stack<String> temp = new Stack<String>();	 	       	  	 	        	      	   	
    String result ="";	 	       	  	 	        	      	   	
    while(divident>0)	 	       	  	 	        	      	   	
    {	 	       	  	 	        	      	   	
      //divident/divisor = quotient;	 	       	  	 	        	      	   	
      quotient = divident/divisor;	 	       	  	 	        	      	   	
	 	       	  	 	        	      	   	
      //base-(divident%divisor) = remainder;	 	       	  	 	        	      	   	
	 	       	  	 	        	      	   	
      remainder=(divident%divisor);	 	       	  	 	        	      	   	
	 	       	  	 	        	      	   	
      divident=quotient;	 	       	  	 	        	      	   	
      temp.push(Character.toString(digits.charAt(remainder)));	 	       	  	 	        	      	   	
    }	 	       	  	 	        	      	   	
	 	       	  	 	        	      	   	
     while(temp.size()>0)	 	       	  	 	        	      	   	
     {	 	       	  	 	        	      	   	
       result+=temp.pop();	 	       	  	 	        	      	   	
     }	 	       	  	 	        	      	   	
    return result;	 	       	  	 	        	      	   	
  }	 	       	  	 	        	      	   	
}