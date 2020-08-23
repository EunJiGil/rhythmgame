package rhythmgame4;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../Images/noteBasic.png")).getImage();
	private int x,y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) *Main.REACH_TIME; //노트를 만들어준지 정확히 1초뒤에 노트 판정라인에 도달, -120에서 노트가 만들어짐, 1초에 700만큼 이동
	private String noteType;
	private boolean proceeded = true;
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	
	public Note(String noteType) {
		//y좌표는 노트스피드와 슬립타임에 따라 달라짐
		if(noteType.equals("S")) {
			x= 228;
		}
		else if(noteType.equals("D")) {
			x= 332;
		}
		else if(noteType.equals("F")) {
			x= 436;
		}
		else if(noteType.equals("Space")) {
			x= 540;
		}
		else if(noteType.equals("J")) {
			x= 744;
		}
		else if(noteType.equals("K")) {
			x= 848;
		}
		else if(noteType.equals("L")) {
			x= 952;
		}
		this.noteType = noteType; //초기화
	}
	
	public void screenDraw(Graphics2D g) {//하나의 노트에 대한 이미지를 그려줄수 있도록
		if(!noteType.equals("Space"))
		{
			g.drawImage(noteBasicImage, x, y, null); //자신이 위치한 공간에 그려줌 		
		}
		else
		{
			g.drawImage(noteBasicImage, x, y, null);  		
			g.drawImage(noteBasicImage, x+100, y, null); // 스페이스바 길어서 
		}
	}
	
	public void drop() {
		y += Main.NOTE_SPEED;
		if(y> 620) { //노트가 판정바를 벗어나는 시점
			System.out.println("Miss");
			close();
		}
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);  //계속 움직이는 동안이라면 한번 노트 떨어뜨리고 0.001초 쉼
				}
				else {
					interrupt();
					break;
				}
			}
		}catch(Exception e){
			System.err.println(e.getMessage()); //에러메시지
		}
	}
	public String judge() {
		
		if( getY() >= 550) {
			System.out.println("Good");
			close();
			return "Good";
		}
		else if( getY() >= 535) {
			System.out.println("Early");
			close();
			return "Early";
		}
		return"None";
	}
	
	public int getY() {
		return y;
	}
	
	
}
