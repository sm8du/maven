package Moscalu.Loops;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter a number: ");
        int x = scan.nextInt();
        for (int i=1; i <= x; i++){
        	System.out.println(i);
        }

        	
    }
}
