/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passcode.authentication;

/**
 *
 * Programmer: Joshua Cogburn
 * Date 9-05-2015
 * 
 * Future Modifications:
 * -Design the program to be a fully functional ATM Program
 * -Implement the functionality to allow the user to enter their account number (before Authentication)
 * -Implement a Re-entry Loop
 * -Implement a lock-out state if the user enters the wrong Pass-Code 3 times in a sequence (the account will also be flagged)
 * -Implement an Option to change the Pass-Code
 * -Implement an Option to Make Deposits/Withdraws/Check Balance
 * -Create a Bank program that has many accounts
 * -A bank program could be used in a game to allow the user to manage finances 
 */
import java.util.Scanner;
import java.util.Random;

public class PasscodeAuthentication {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
	
		//Password array
		int[] passcodeAry = {7,7,7,4,5};
	
		//Random array
		int[] randomNumAry = new int[10];
	
		//Entry array
		int[] userEntryAry = new int[passcodeAry.length];
	
		//Generate random array
		for (int i =0; i < 10; i++){
			Random randomGenerator = new Random();
			randomNumAry[i] = randomGenerator.nextInt(10);
		}
	
		//First Output
		System.out.println("The Sets of Numbers shown below are Associative Array's.");
		System.out.println("The Second Row of Numbers are a set of Random Numbers.");
                System.out.println("Each Number on the Second Row corresponds to the number directly above itself.");
                System.out.println("Enter the numbers from the second row which correspond to the numbers in your Pass-Code.");
                System.out.println("The purpose of this Authentication Method is to protect your account.");
                System.out.println();
                System.out.println("--------------------");
                System.out.println("0 1 2 3 4 5 6 7 8 9 ");

                
		for (int i = 0; i < 10; i++){
			System.out.print(randomNumAry[i]+ " ");
		}
		System.out.println();
                System.out.println("--------------------");
                System.out.println("Enter the Nubers that correspond to your Pass-Code:");
		//Input
		Scanner keyboard = new Scanner(System.in);
	
		//Get entered numbers as integer
		int num = keyboard.nextInt();
	
		//Put integers into array
		for (int i = 5; i > 0; i--){
			userEntryAry[i-1] = num % 10;
			num /= 10;
			}
		if (isValid(passcodeAry, userEntryAry, randomNumAry)){
			System.out.println("Valid");
		}
		else{
			System.out.println("Invalid");
		}
		keyboard.close();
	}
	
	public static boolean isValid(int[] passcode, int[] userEntry, int[] randomNums){
		int temp = 0;
		boolean Valid = true;
		while(Valid && (temp < passcode.length)){
			int x = passcode[temp];
			if( userEntry[temp] != randomNums[x]){
				Valid = false;
			}
			temp++;
		}
		return Valid;
	}
}
