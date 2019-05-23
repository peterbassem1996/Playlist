import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args)throws IOException{
		PrintWriter output = new PrintWriter("output.txt");
		File inputFile = new File("playlist.dat");
		Scanner input = new Scanner(inputFile);
		Scanner counter = new Scanner(inputFile);
		Scanner userInput = new Scanner(System.in);
		PlayList myPlayList = new PlayList(countingSongs(counter));
		myPlayList.readFromFile(input);
		mainMenu(userInput, myPlayList, output);
	}

	public static int countingSongs(Scanner counter){
		int count = 0;
		while(counter.hasNext()){
			count++;
			counter.nextLine();
		}
		return (count/4);
	}

	public static void mainMenu(Scanner userInput, PlayList myPlayList, PrintWriter output){
		Scanner userInput2 = new Scanner(System.in);
		int selection = 0;
		System.out.print("1.Search by Title\n2.Search by Song ID\n3.Report  By Tiitle\n4.Report By Playing Time\n5.Exit\n\n");
		do{
			System.out.print("Make a selection using your num pad:\n");
			selection = userInput.nextInt();
			System.out.println();
			if (selection < 1 || selection > 5){
				System.out.println("invalid selection!\n");
			}
		}while(selection < 1 || selection > 5);
		switch(selection){
			case 1:
			searchByTitle(userInput2, myPlayList);
			mainMenu(userInput2, myPlayList, output);
			break;
			case 2:
			searchById(userInput2, myPlayList);
			mainMenu(userInput2, myPlayList, output);
			break;
			case 3:
			reportByTitle(userInput2, myPlayList, output);
			mainMenu(userInput2, myPlayList, output);
			break;
			case 4:
			reportByTime(userInput2, myPlayList, output);
			mainMenu(userInput2, myPlayList, output);
			break;
			case 5:
			System.exit(1);
			break;
		}
	}
	public static void searchByTitle(Scanner userInput, PlayList myPlayList){
		String input = "";
		do{
			System.out.print("Enter the title of the song you are looking for: ");
			input = userInput.nextLine();
			if(input.equals("")){
				System.out.println("Please don't leave it blank");
			}
			System.out.println();
		} while (input.equals(""));
		myPlayList.searchByName(input);
		System.out.println();
	}
	public static void searchById(Scanner userInput, PlayList myPlayList){
		int input = 0;
		do{
			System.out.print("Enter the ID of the song you are looking for: ");
			input = userInput.nextInt();
			if(input < 11111 || input > 99999){
				System.out.println("Please enter a value from 11111 to 99999");
			}
			System.out.println();
		}while(input < 11111 || input > 99999);
		myPlayList.searchById(input);
		System.out.println();
	}
	public static void reportByTitle(Scanner userInput, PlayList myPlayList, PrintWriter output){
		int selection = 0;
		do{
			System.out.print("Screen only press 1, file only press 2, both press 3: ");
			selection = userInput.nextInt();
		}while (selection < 1 || selection > 3);
		myPlayList.reportByTitle(selection, output);
		System.out.println();
	}
	public static void reportByTime(Scanner userInput, PlayList myPlayList, PrintWriter output){
		int selection = 0;
		do{
			System.out.print("Screen only press 1, file only press 2, both press 3: ");
			selection = userInput.nextInt();
		}while (selection < 1 || selection > 3);
		myPlayList.reportByTime(selection, output);
		System.out.println();
	}
}