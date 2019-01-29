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
	 	       	  	 	        	      	   	
  public static String convert(double original,int base, int precision)	 	       	  	 	        	      	   	
  {	 	       	  	 	        	      	   	
    String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";	 	       	  	 	        	      	   	
    int divident = (int)original;	 	       	  	 	        	      	   	
    double fraction = original-divident;	 	       	  	 	        	      	   	
    int divisor = base;	 	       	  	 	        	      	   	
    int quotient = 0;	 	       	  	 	        	      	   	
    int remainder = 0;	 	       	  	 	        	      	   	
    int precision_counter = 0;	 	       	  	 	        	      	   	
    String result ="";	 	       	  	 	        	      	   	
    while(divident>0)	 	       	  	 	        	      	   	
    {	 	       	  	 	        	      	   	
      //divident/divisor = quotient;	 	       	  	 	        	      	   	
      quotient = divident/divisor;	 	       	  	 	        	      	   	
	 	       	  	 	        	      	   	
      //base-(divident%divisor) = remainder;	 	       	  	 	        	      	   	
	 	       	  	 	        	      	   	
      remainder=(divident%divisor);	 	       	  	 	        	      	   	
	 	       	  	 	        	      	   	
      divident=quotient;	 	       	  	 	        	      	   	
      result=(Character.toString(digits.charAt(remainder)))+result;	 	       	  	 	        	      	   	
    }	 	       	  	 	        	      	   	
    //converting the fraction part to base n	 	       	  	 	        	      	   	
    int whole_part=0;	 	       	  	 	        	      	   	
    double fractionPart=0.0;	 	       	  	 	        	      	   	
	 	       	  	 	        	      	   	
    int roundDown = 0;	 	       	  	 	        	      	   	
    //Ensuring that the "fraction conversion" part is only executed if the number passed as a double has fraction part.	 	       	  	 	        	      	   	
    if(fraction>0){	 	       	  	 	        	      	   	
         //the condition in the head of the while loop ensures that the user gets the desired precision floating point number.	 	       	  	 	        	      	   	
	 	       	  	 	        	      	   	
        result+=".";	 	       	  	 	        	      	   	
        while(precision_counter<precision)	 	       	  	 	        	      	   	
        {	 	       	  	 	        	      	   	
            fractionPart = fraction * base;	 	       	  	 	        	      	   	
            //getting the next digit in the fraction part	 	       	  	 	        	      	   	
            roundDown = (int) fractionPart;	 	       	  	 	        	      	   	
            //no reversed order when it comes to converting the fraction part, therefore it can be added to results straight away.	 	       	  	 	        	      	   	
            result+=Character.toString(digits.charAt(roundDown));	 	       	  	 	        	      	   	
            //getting the new fraction part for the next iteration.	 	       	  	 	        	      	   	
            fraction = fractionPart -roundDown;	 	       	  	 	        	      	   	
            //precision counter is incremented.	 	       	  	 	        	      	   	
            precision_counter++;	 	       	  	 	        	      	   	
        }	 	       	  	 	        	      	   	
    }	 	       	  	 	        	      	   	
	 	       	  	 	        	      	   	
    return result;	 	       	  	 	        	      	   	
  }	 	       	  	 	        	      	   	
}