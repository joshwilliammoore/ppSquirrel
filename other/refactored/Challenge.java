public class Challenge	 	       	  	 	        	      	   	
{	 	       	  	 	        	      	   	
  public static String convert(int original,int base)	 	       	  	 	        	      	   	
  {	 	       	  	 	        	      	   	
    String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";	 	       	  	 	        	      	   	
    String[] digits_array = digits.split("");	 	       	  	 	        	      	   	
	 	       	  	 	        	      	   	
    int divident = original;	 	       	  	 	        	      	   	
    int divisor = base;	 	       	  	 	        	      	   	
    int quotient = 0;	 	       	  	 	        	      	   	
    int remainder = 0;	 	       	  	 	        	      	   	
	 	       	  	 	        	      	   	
    String result ="";	 	       	  	 	        	      	   	
    while(divident>0)	 	       	  	 	        	      	   	
    {	 	       	  	 	        	      	   	
      //divident/divisor = quotient;	 	       	  	 	        	      	   	
      quotient = divident/divisor;	 	       	  	 	        	      	   	
	 	       	  	 	        	      	   	
      //base-(divident%divisor) = remainder;	 	       	  	 	        	      	   	
	 	       	  	 	        	      	   	
      remainder=(divident%divisor);	 	       	  	 	        	      	   	
	 	       	  	 	        	      	   	
      divident=quotient;	 	       	  	 	        	      	   	
      result=digits_array[remainder+1]+result;	 	       	  	 	        	      	   	
    }	 	       	  	 	        	      	   	
	 	       	  	 	        	      	   	
	 	       	  	 	        	      	   	
    return result;	 	       	  	 	        	      	   	
  }	 	       	  	 	        	      	   	
}