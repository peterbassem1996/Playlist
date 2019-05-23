import java.io.*;
import java.util.*;
public class PlayList{
	private Song[] playList;

	public PlayList(int numOfSongs){
		playList = new Song[numOfSongs];
	}

	public void readFromFile(Scanner input){
		for (int i = 0; i < playList.length; i++){
			playList[i] = new Song();
			playList[i].songId(input.nextInt());
			input.nextLine();
			playList[i].artist(input.nextLine());
			playList[i].songTitle(input.nextLine());
			playList[i].yearPublished(input.nextInt());
			playList[i].playTime(input.nextInt());
		}
	}

	private void printting(){
		System.out.printf("%-30s%-25s%-8s%-5s%-5s%-5s\n", "Song Title", "Artist", "Year", "Mins", "Secs", "ID");
		for (int i = 0; i < playList.length; i++){
			System.out.printf("%-30s%-25s%-8d%-5d%-5d%-5d\n", playList[i].songTitle(), playList[i].artist(), playList[i].yearPublished(), playList[i].mins(), playList[i].secs(), playList[i].songId());
		}
	}

	private void printtingToFile(PrintWriter output){
		output.printf("%-30s%-25s%-8s%-5s%-5s%-5s\n", "Song Title", "Artist", "Year", "Mins", "Secs", "ID");
		for (int i = 0; i < playList.length; i++){
			output.printf("%-30s%-25s%-8d%-5d%-5d%-5d\n", playList[i].songTitle(), playList[i].artist(), playList[i].yearPublished(), playList[i].mins(), playList[i].secs(), playList[i].songId());
		}
		output.close();
	}

	private void printByIndex(int i){
		System.out.printf("%-30s%-25s%-8s%-5s%-5s%-5s\n", "Song Title", "Artist", "Year", "Mins", "Secs", "ID");
		System.out.printf("%-30s%-25s%-8d%-5d%-5d%-5d\n", playList[i].songTitle(), playList[i].artist(), playList[i].yearPublished(), playList[i].mins(), playList[i].secs(), playList[i].songId());
	}

	private void printByIndexToFile(int i, PrintWriter output){
		output.printf("%-30s%-25s%-8s%-5s%-5s%-5s\n", "Song Title", "Artist", "Year", "Mins", "Secs", "ID");
		output.printf("%-30s%-25s%-8d%-5d%-5d%-5d\n", playList[i].songTitle(), playList[i].artist(), playList[i].yearPublished(), playList[i].mins(), playList[i].secs(), playList[i].songId());
		output.close();
	}

	public void searchByName(String search){
		boolean found = false;
		for (int i = 0; i < playList.length; i++){
			if(search.toUpperCase().equals(playList[i].songTitle().toUpperCase())){
				printByIndex(i);
				found = true;
			}
		}
		if(!found){
			System.out.println("Nothing found");
		}
	}

	public void searchById(int id){
		boolean found = false;
		for (int i = 0; i < playList.length; i++){
			if(id == playList[i].songId()){
				printByIndex(i);
				found = true;
			}
		}
		if(!found){
			System.out.println("Nothing found");
		}
	}

	public void reportByTitle(int a, PrintWriter output){
		Song temp = new Song();
		for (int i = 0; i < playList.length - 1; i++){
			for (int j = (i+1); j < playList.length; j++){
				if (playList[i].songTitle().compareTo(playList[j].songTitle()) > 0){
					temp = playList[i];
					playList[i] = playList[j];
					playList[j] = temp;
				}
			}
		}
		switch (a){
			case 1:
			printting();
			break;
			case 2:
			printtingToFile(output);
			break;
			case 3:
			printting();
			printtingToFile(output);
			break;
		}
	}

	public void reportByTime(int a, PrintWriter output){
		Song temp = new Song();
		for (int i = 0; i < playList.length - 1; i++){
			for (int j = (i+1); j < playList.length; j++){
				if (playList[i].playTime() > playList[j].playTime()){
					temp = playList[i];
					playList[i] = playList[j];
					playList[j] = temp;
				}
			}
		}
		switch (a){
			case 1:
			printting();
			break;
			case 2:
			printtingToFile(output);
			break;
			case 3:
			printting();
			printtingToFile(output);
			break;
		}
	}
}