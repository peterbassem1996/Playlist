public class Song{
	private int songId;
	private String artist;
	private String songTitle;
	private int yearPublished;
	private int playTime;
	private int mins;
	private int secs;
	
	public Song(){
		songId = 0;
		artist = "";
		songTitle = "";
		yearPublished = 0;
		playTime = 0;
		mins = 0;
		secs = 0;
	}
	
	public int songId(){
		return songId;
	}
	public void songId(int id){
		songId = id;
	}
	
	public String artist(){
		return artist;
	}
	public void artist(String name){
		artist = name;
	}
	
	public String songTitle(){
		return songTitle;
	}
	public void songTitle(String title){
		songTitle = title;
	}
	
	public int yearPublished(){
		return yearPublished;
	}
	public void yearPublished(int year){
		yearPublished = year;
	}
	
	public int playTime(){
		return playTime;
	}
	public void playTime(int time){
		playTime = time;
		secs = playTime % 60;
		mins = (playTime-secs) / 60;
	}
	
	public int mins(){
		return mins;
	}
	
	public int secs(){
		return secs;
	}
}