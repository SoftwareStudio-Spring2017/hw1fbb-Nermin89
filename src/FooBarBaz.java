import java.util.Scanner;
import java.util.regex.*;
import  java.util.regex.Matcher;
import java.io.*;

public class FooBarBaz {

	static int number;
	static String theRegex = "[0-9]";
	static int flag = 0; // a flag to print out the suitable message to the user 
	static FileWriter fwriter;
	static BufferedWriter bwriter;
	static Boolean flagstop = false;
	static File FileName;
	static int flagFirstRun = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserInput();	
	}
	
	public static void UserInput()
	{
		if (flag==0)
		{
			System.out.println("Enter a Number To Count Up To, Make sure it is from 1 to 110");	
		}
		else 
		{ 
			System.out.println('\n'+"Two Options:" +'\n'+ "1.Enter a Number To Count Up To, Make sure it is from 1 to 110"+'\n'+"2. Type the word \"Stop\" to stop counting and print the result"); 
		}
		
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		
		if ( word.equalsIgnoreCase("stop")) // no matter how the user write it with upper or lower or even a mix of both
		{
			flagstop =true;
			System.out.println("Stopped");
		}
		else 
		{
			flag++; 
			Pattern ptr = Pattern.compile(theRegex);
			Matcher regexmatcher = ptr.matcher(word);
			// Created the Regex to make sure that the input is only Integer.	
			if (regexmatcher.find())
			{
				number = Integer.valueOf(word); // converting the string input to Integer
				
				if (number <= 110 && number > 0) // handling edge case of Zero or less.
				{ 
					PrintFooBarGame();
					UserInput();
				}	
				else 
				{
					InvalidInput();
					// Prompt the user the enter a number again
					UserInput();
				}
			} 
			else
				InvalidInput();
			}
		}
	
	private static void InvalidInput()
	{
		System.out.println("Invalid Input, Please Enter Only Integers, And Only between 1 & 110");
	}
	
	public static void PrintFooBarGame()
	{
		 FileName = new File ("foobarbaz.txt");
		 
	try {
			
			if (flagFirstRun==0)
			{
				if (FileName.exists())
				{
					FileName.delete();
					fwriter = new FileWriter(FileName,false);
					bwriter = new BufferedWriter(fwriter);	
				}
				
				flagFirstRun++;
			}
			else
			{								
				fwriter = new FileWriter(FileName,true);
				bwriter = new BufferedWriter(fwriter);	
			}	
			
			for (int i=1; i <= number; i++)
			{
				boolean myFlag = false;
				
				if (i%3==0)
				{
					bwriter.write("Foo");
					myFlag = true;
				}		
				if (i%5==0)
				{
					bwriter.write("Bar");
					myFlag = true;
				}
				if (i%7==0)
				{
					bwriter.write("Baz");
					myFlag = true;
				} 
				
				if(myFlag)
				{
					bwriter.newLine();
				}
				else 
				{
					bwriter.write(String.valueOf(i)); // because the BufferedWriter print strings only
					bwriter.newLine();
				}
			}
			
			if (bwriter!=null)
			{
				bwriter.close();
			}
			
			if (fwriter!=null)
			{
				fwriter.close();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
