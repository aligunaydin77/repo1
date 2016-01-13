package test;

import java.util.Locale;

public class MathOperations 
{
    static int number2=getValue();
    static int number1=10;
    static int getValue()
    {
        return number1;
    }
    static int doSum(){ return number1+number2;}
    static int doMinus(){ return number1-number2;}
    public static void main(String[] args) 
    {
//    		Locale locale1 = new Locale(Locale.ENGLISH, Locale.US);
//    		Locale locale2 = new Locale();
//    		Locale locale3 = new Locale(Locale.ENGLISH);
    		Locale locale4 = new Locale("English","US");
    		Locale locale5 = new Locale("ENGLISH");
    		System.out.println(locale5.getDisplayCountry());
    }
}
