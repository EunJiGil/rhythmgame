package rhythmgame4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
	
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../Images/noteRouteLine.png")).getImage(); //이미지를 담을 수 있는 객체
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../Images/judgementLine.png")).getImage(); 
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../Images/gameInfo.png")).getImage(); 
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../Images/noteRoute.png")).getImage(); 
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../Images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../Images/noteRoute.png")).getImage(); //이미지를 담을 수 있는 객체
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../Images/noteRoute.png")).getImage(); 
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../Images/noteRoute.png")).getImage(); 
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../Images/noteRoute.png")).getImage(); 
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../Images/noteRoute.png")).getImage(); 
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../Images/noteRoute.png")).getImage(); //이미지를 담을 수 있는 객체
	private Image blueFlareImage;
	private Image judgeImage;
	private Image keyPadSImage = new ImageIcon(Main.class.getResource("../Images/keyboardBasic.png")).getImage(); 
	private Image keyPadDImage = new ImageIcon(Main.class.getResource("../Images/keyboardBasic.png")).getImage(); 
	private Image keyPadFImage = new ImageIcon(Main.class.getResource("../Images/keyboardBasic.png")).getImage(); 
	private Image keyPadSpace1Image = new ImageIcon(Main.class.getResource("../Images/keyboardBasic.png")).getImage(); 
	private Image keyPadSpace2Image = new ImageIcon(Main.class.getResource("../Images/keyboardBasic.png")).getImage(); 
	private Image keyPadJImage = new ImageIcon(Main.class.getResource("../Images/keyboardBasic.png")).getImage(); 
	private Image keyPadKImage = new ImageIcon(Main.class.getResource("../Images/keyboardBasic.png")).getImage(); 
	private Image keyPadLImage = new ImageIcon(Main.class.getResource("../Images/keyboardBasic.png")).getImage(); 
	
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>(); //노트를 담을 리스트
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName; //초기화
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false); //한번만 실행되고 말도록
		
			}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for(int i =0; i<noteList.size(); i++) {
			Note note = noteList.get(i);
			if(note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i); //진행중이 아니라면 노트리스트에서 뺌
				i--;
			}
			else {
			note.screenDraw(g);
			}
		}
		
		
		g.setColor(Color.white); //하단 곡정보
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); //글자 화질깨짐 개선
		g.setColor(Color.white);
		g.setFont(new Font ("Arial", Font.BOLD, 30));
		g.drawString(titleName,20, 702 );
		g.drawString(difficulty,1190, 702); //하단 곡 난이도
		g.setFont(new Font ("Arial", Font.PLAIN, 30));
		g.setColor(Color.DARK_GRAY); //하단 곡정보
		g.drawString("S", 270, 609); //노트 키 정보
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font ("Elephant", Font.BOLD, 30));
		g.drawImage(blueFlareImage, 150, 200, null);
		g.drawImage(judgeImage, 460, 420, null);
		
		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);
		
	}
	
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../Images/noteRoutePressed.png")).getImage(); 
		keyPadSImage = new ImageIcon(Main.class.getResource("../Images/keyboardPressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../Images/noteRoute.png")).getImage(); 
		keyPadSImage = new ImageIcon(Main.class.getResource("../Images/keyboardBasic.png")).getImage(); 
		
	}
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../Images/noteRoutePressed.png")).getImage(); 
		keyPadDImage = new ImageIcon(Main.class.getResource("../Images/keyboardPressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../Images/noteRoute.png")).getImage(); 
		keyPadDImage = new ImageIcon(Main.class.getResource("../Images/keyboardBasic.png")).getImage(); 
		
	}
	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../Images/noteRoutePressed.png")).getImage(); 
		keyPadFImage = new ImageIcon(Main.class.getResource("../Images/keyboardPressed.png")).getImage(); 
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../Images/noteRoute.png")).getImage(); 
		keyPadFImage = new ImageIcon(Main.class.getResource("../Images/keyboardBasic.png")).getImage();
	}
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../Images/noteRoutePressed.png")).getImage(); 
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../Images/keyboardPressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../Images/noteRoutePressed.png")).getImage(); 
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../Images/keyboardPressed.png")).getImage();
		new Music("drumBig1.mp3",false).start();
	}
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../Images/noteRoute.png")).getImage(); 
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../Images/keyboardBasic.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../Images/noteRoute.png")).getImage(); 
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../Images/keyboardBasic.png")).getImage();
	}
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../Images/noteRoutePressed.png")).getImage(); 
		keyPadJImage = new ImageIcon(Main.class.getResource("../Images/keyboardPressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../Images/noteRoute.png")).getImage(); 
		keyPadJImage = new ImageIcon(Main.class.getResource("../Images/keyboardBasic.png")).getImage();
	}
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../Images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../Images/keyboardPressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../Images/noteRoute.png")).getImage(); 
		keyPadKImage = new ImageIcon(Main.class.getResource("../Images/keyboardBasic.png")).getImage();
	}
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../Images/noteRoutePressed.png")).getImage(); 
		keyPadLImage = new ImageIcon(Main.class.getResource("../Images/keyboardPressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../Images/noteRoute.png")).getImage(); 
		keyPadLImage = new ImageIcon(Main.class.getResource("../Images/keyboardBasic.png")).getImage();
	}
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if(titleName.equals("MBB - Happy") && difficulty.equals("Easy")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125; //박자에 맞게 떨어뜨리기 위해서
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime + gap * 3, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 9, "F"),
					new Beat(startTime + gap * 12, "S"),
					new Beat(startTime + gap * 15, "D"),
					new Beat(startTime + gap * 18, "F"),
					new Beat(startTime + gap * 21, "S"),
					new Beat(startTime + gap * 24, "D"),
					new Beat(startTime + gap * 27, "F"),
					new Beat(startTime + gap * 30, "J"),
					new Beat(startTime + gap * 33, "K"),
					new Beat(startTime + gap * 36, "L"),
					new Beat(startTime + gap * 39, "J"),
					new Beat(startTime + gap * 42, "K"),
					new Beat(startTime + gap * 45, "L"),
					new Beat(startTime + gap * 45, "J"),
					new Beat(startTime + gap * 48, "K"),
					new Beat(startTime + gap * 51, "L"),
					new Beat(startTime + gap * 54, "S"),
					new Beat(startTime + gap * 57, "D"),
					new Beat(startTime + gap * 60, "D"),
					new Beat(startTime + gap * 63, "D"),
					new Beat(startTime + gap * 66, "L"),
					new Beat(startTime + gap * 69, "K"),
					new Beat(startTime + gap * 72, "K"),
					new Beat(startTime + gap * 75, "K"),
					new Beat(startTime + gap * 78, "Space"),
					new Beat(startTime + gap * 81, "Space"),
					new Beat(startTime + gap * 84, "Space"),
					new Beat(startTime + gap * 87, "S"),
					new Beat(startTime + gap * 90, "L"),
					new Beat(startTime + gap * 93, "D"),
					new Beat(startTime + gap * 96, "K"),
					new Beat(startTime + gap * 99, "S"),
					new Beat(startTime + gap * 102, "L"),
					new Beat(startTime + gap * 105, "D"),
					new Beat(startTime + gap * 108, "K"),
					new Beat(startTime + gap * 111, "F"),
					new Beat(startTime + gap * 114, "F"),
					new Beat(startTime + gap * 117, "F"),	
					new Beat(startTime + gap * 120, "J"),
					new Beat(startTime + gap * 123, "J"),
					new Beat(startTime + gap * 126, "J"),
					new Beat(startTime + gap * 129, "Space"),
					new Beat(startTime + gap * 132, "Space"),
					new Beat(startTime + gap * 135, "Space"),
					new Beat(startTime + gap * 138, "Space"),
					new Beat(startTime + gap * 141, "S"),
					new Beat(startTime + gap * 144, "D"),
					new Beat(startTime + gap * 147, "F"),
					new Beat(startTime + gap * 150, "L"),
					new Beat(startTime + gap * 153, "K"),				
					new Beat(startTime + gap * 156, "J"),
					new Beat(startTime + gap * 159, "Space"),
					new Beat(startTime + gap * 162, "Space"),
					new Beat(startTime + gap * 165, "Space"),
					new Beat(startTime + gap * 168, "S"),
					new Beat(startTime + gap * 171, "D"),
					new Beat(startTime + gap * 174, "F"),
					new Beat(startTime + gap * 177, "L"),
					new Beat(startTime + gap * 180, "K"),				
					new Beat(startTime + gap * 183, "J"),
					new Beat(startTime + gap * 186, "Space"),
					new Beat(startTime + gap * 189, "Space"),
					new Beat(startTime + gap * 192, "Space"),
					new Beat(startTime + gap * 195, "F"),
					new Beat(startTime + gap * 198, "F"),
					new Beat(startTime + gap * 201, "Space"),
					new Beat(startTime + gap * 204, "Space"),
					new Beat(startTime + gap * 207, "F"),				
					new Beat(startTime + gap * 210, "F"),
					new Beat(startTime + gap * 213, "Space"),
					new Beat(startTime + gap * 216, "Space"),
					new Beat(startTime + gap * 219, "J"),
					new Beat(startTime + gap * 222, "J"),
					new Beat(startTime + gap * 225, "Space"),
					new Beat(startTime + gap * 228, "Space"),
					new Beat(startTime + gap * 231, "J"),
					new Beat(startTime + gap * 234, "J"),
					new Beat(startTime + gap * 237, "S"),
					new Beat(startTime + gap * 240, "D"),
					new Beat(startTime + gap * 243, "F"),				
					new Beat(startTime + gap * 246, "S"),
					new Beat(startTime + gap * 249, "D"),
					new Beat(startTime + gap * 252, "F"),
					new Beat(startTime + gap * 255, "Space"),
					new Beat(startTime + gap * 258, "Space"),
					new Beat(startTime + gap * 261, "Space"),
					new Beat(startTime + gap * 264, "J"),
					new Beat(startTime + gap * 267, "K"),
					new Beat(startTime + gap * 270, "L"),				
					new Beat(startTime + gap * 273, "J"),
					new Beat(startTime + gap * 276, "K"),
					new Beat(startTime + gap * 279, "L"),
					new Beat(startTime + gap * 282, "Space"),
					new Beat(startTime + gap * 285, "Space"),
					new Beat(startTime + gap * 288, "Space"),
					new Beat(startTime + gap * 291, "Space"),
					new Beat(startTime + gap * 294, "S"),
					new Beat(startTime + gap * 297, "D"),
					new Beat(startTime + gap * 300, "F"),
					new Beat(startTime + gap * 303, "S"),
					new Beat(startTime + gap * 306, "D"),
					new Beat(startTime + gap * 309, "F"),
					new Beat(startTime + gap * 312, "S"),
					new Beat(startTime + gap * 315, "D"),
					new Beat(startTime + gap * 318, "F"),
					new Beat(startTime + gap * 321, "J"),
					new Beat(startTime + gap * 324, "K"),
					new Beat(startTime + gap * 327, "L"),
					new Beat(startTime + gap * 330, "J"),
					new Beat(startTime + gap * 333, "K"),
					new Beat(startTime + gap * 336, "L"),
					new Beat(startTime + gap * 339, "J"),
					new Beat(startTime + gap * 342, "K"),
					new Beat(startTime + gap * 345, "L"),
					new Beat(startTime + gap * 348, "S"),
					new Beat(startTime + gap * 351, "D"),
					new Beat(startTime + gap * 354, "D"),
					new Beat(startTime + gap * 357, "D"),
					new Beat(startTime + gap * 360, "L"),
					new Beat(startTime + gap * 363, "K"),
					new Beat(startTime + gap * 366, "K"),
					new Beat(startTime + gap * 369, "K"),
					new Beat(startTime + gap * 372, "Space"),
					new Beat(startTime + gap * 375, "Space"),
					new Beat(startTime + gap * 378, "Space"),
					

			};
		}
		else if(titleName.equals("MBB - Bora")&& difficulty.equals("Easy")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125; //박자에 맞게 떨어뜨리기 위해서
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime + gap * 3, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 9, "F"),
					new Beat(startTime + gap * 12, "S"),
					new Beat(startTime + gap * 15, "D"),
					new Beat(startTime + gap * 18, "F"),
					new Beat(startTime + gap * 21, "S"),
					new Beat(startTime + gap * 24, "D"),
					new Beat(startTime + gap * 27, "F"),
					new Beat(startTime + gap * 30, "J"),
					new Beat(startTime + gap * 33, "K"),
					new Beat(startTime + gap * 36, "L"),
					new Beat(startTime + gap * 39, "J"),
					new Beat(startTime + gap * 42, "K"),
					new Beat(startTime + gap * 45, "L"),
					new Beat(startTime + gap * 45, "J"),
					new Beat(startTime + gap * 48, "K"),
					new Beat(startTime + gap * 51, "L"),
					new Beat(startTime + gap * 54, "S"),
					new Beat(startTime + gap * 57, "D"),
					new Beat(startTime + gap * 60, "D"),
					new Beat(startTime + gap * 63, "D"),
					new Beat(startTime + gap * 66, "L"),
					new Beat(startTime + gap * 69, "K"),
					new Beat(startTime + gap * 72, "K"),
					new Beat(startTime + gap * 75, "K"),
					new Beat(startTime + gap * 78, "Space"),
					new Beat(startTime + gap * 81, "Space"),
					new Beat(startTime + gap * 84, "Space"),
					new Beat(startTime + gap * 87, "S"),
					new Beat(startTime + gap * 90, "L"),
					new Beat(startTime + gap * 93, "D"),
					new Beat(startTime + gap * 96, "K"),
					new Beat(startTime + gap * 99, "S"),
					new Beat(startTime + gap * 102, "L"),
					new Beat(startTime + gap * 105, "D"),
					new Beat(startTime + gap * 108, "K"),
					new Beat(startTime + gap * 111, "F"),
					new Beat(startTime + gap * 114, "F"),
					new Beat(startTime + gap * 117, "F"),	
					new Beat(startTime + gap * 120, "J"),
					new Beat(startTime + gap * 123, "J"),
					new Beat(startTime + gap * 126, "J"),
					new Beat(startTime + gap * 129, "Space"),
					new Beat(startTime + gap * 132, "Space"),
					new Beat(startTime + gap * 135, "Space"),
					new Beat(startTime + gap * 138, "Space"),
					new Beat(startTime + gap * 141, "S"),
					new Beat(startTime + gap * 144, "D"),
					new Beat(startTime + gap * 147, "F"),
					new Beat(startTime + gap * 150, "L"),
					new Beat(startTime + gap * 153, "K"),				
					new Beat(startTime + gap * 156, "J"),
					new Beat(startTime + gap * 159, "Space"),
					new Beat(startTime + gap * 162, "Space"),
					new Beat(startTime + gap * 165, "Space"),
					new Beat(startTime + gap * 168, "S"),
					new Beat(startTime + gap * 171, "D"),
					new Beat(startTime + gap * 174, "F"),
					new Beat(startTime + gap * 177, "L"),
					new Beat(startTime + gap * 180, "K"),				
					new Beat(startTime + gap * 183, "J"),
					new Beat(startTime + gap * 186, "Space"),
					new Beat(startTime + gap * 189, "Space"),
					new Beat(startTime + gap * 192, "Space"),
					new Beat(startTime + gap * 195, "F"),
					new Beat(startTime + gap * 198, "F"),
					new Beat(startTime + gap * 201, "Space"),
					new Beat(startTime + gap * 204, "Space"),
					new Beat(startTime + gap * 207, "F"),				
					new Beat(startTime + gap * 210, "F"),
					new Beat(startTime + gap * 213, "Space"),
					new Beat(startTime + gap * 216, "Space"),
					new Beat(startTime + gap * 219, "J"),
					new Beat(startTime + gap * 222, "J"),
					new Beat(startTime + gap * 225, "Space"),
					new Beat(startTime + gap * 228, "Space"),
					new Beat(startTime + gap * 231, "J"),
					new Beat(startTime + gap * 234, "J"),
					new Beat(startTime + gap * 237, "S"),
					new Beat(startTime + gap * 240, "D"),
					new Beat(startTime + gap * 243, "F"),				
					new Beat(startTime + gap * 246, "S"),
					new Beat(startTime + gap * 249, "D"),
					new Beat(startTime + gap * 252, "F"),
					new Beat(startTime + gap * 255, "Space"),
					new Beat(startTime + gap * 258, "Space"),
					new Beat(startTime + gap * 261, "Space"),
					new Beat(startTime + gap * 264, "J"),
					new Beat(startTime + gap * 267, "K"),
					new Beat(startTime + gap * 270, "L"),				
					new Beat(startTime + gap * 273, "J"),
					new Beat(startTime + gap * 276, "K"),
					new Beat(startTime + gap * 279, "L"),
					new Beat(startTime + gap * 282, "Space"),
					new Beat(startTime + gap * 285, "Space"),
					new Beat(startTime + gap * 288, "Space"),
					new Beat(startTime + gap * 291, "Space"),
					new Beat(startTime + gap * 294, "S"),
					new Beat(startTime + gap * 297, "D"),
					new Beat(startTime + gap * 300, "F"),
					new Beat(startTime + gap * 303, "S"),
					new Beat(startTime + gap * 306, "D"),
					new Beat(startTime + gap * 309, "F"),
					new Beat(startTime + gap * 312, "S"),
					new Beat(startTime + gap * 315, "D"),
					new Beat(startTime + gap * 318, "F"),
					new Beat(startTime + gap * 321, "J"),
					new Beat(startTime + gap * 324, "K"),
					new Beat(startTime + gap * 327, "L"),
					new Beat(startTime + gap * 330, "J"),
					new Beat(startTime + gap * 333, "K"),
					new Beat(startTime + gap * 336, "L"),
					new Beat(startTime + gap * 339, "J"),
					new Beat(startTime + gap * 342, "K"),
					new Beat(startTime + gap * 345, "L"),
					new Beat(startTime + gap * 348, "S"),
					new Beat(startTime + gap * 351, "D"),
					new Beat(startTime + gap * 354, "D"),
					new Beat(startTime + gap * 357, "D"),
					new Beat(startTime + gap * 360, "L"),
					new Beat(startTime + gap * 363, "K"),
					new Beat(startTime + gap * 366, "K"),
					new Beat(startTime + gap * 369, "K"),
					new Beat(startTime + gap * 372, "Space"),
					new Beat(startTime + gap * 375, "Space"),
					new Beat(startTime + gap * 378, "Space"),
					

			};
		}
		else if(titleName.equals("Lights - Roa")&& difficulty.equals("Easy")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125; //박자에 맞게 떨어뜨리기 위해서
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime + gap * 3, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 9, "F"),
					new Beat(startTime + gap * 12, "S"),
					new Beat(startTime + gap * 15, "D"),
					new Beat(startTime + gap * 18, "F"),
					new Beat(startTime + gap * 21, "S"),
					new Beat(startTime + gap * 24, "D"),
					new Beat(startTime + gap * 27, "F"),
					new Beat(startTime + gap * 30, "J"),
					new Beat(startTime + gap * 33, "K"),
					new Beat(startTime + gap * 36, "L"),
					new Beat(startTime + gap * 39, "J"),
					new Beat(startTime + gap * 42, "K"),
					new Beat(startTime + gap * 45, "L"),
					new Beat(startTime + gap * 45, "J"),
					new Beat(startTime + gap * 48, "K"),
					new Beat(startTime + gap * 51, "L"),
					new Beat(startTime + gap * 54, "S"),
					new Beat(startTime + gap * 57, "D"),
					new Beat(startTime + gap * 60, "D"),
					new Beat(startTime + gap * 63, "D"),
					new Beat(startTime + gap * 66, "L"),
					new Beat(startTime + gap * 69, "K"),
					new Beat(startTime + gap * 72, "K"),
					new Beat(startTime + gap * 75, "K"),
					new Beat(startTime + gap * 78, "Space"),
					new Beat(startTime + gap * 81, "Space"),
					new Beat(startTime + gap * 84, "Space"),
					new Beat(startTime + gap * 87, "S"),
					new Beat(startTime + gap * 90, "L"),
					new Beat(startTime + gap * 93, "D"),
					new Beat(startTime + gap * 96, "K"),
					new Beat(startTime + gap * 99, "S"),
					new Beat(startTime + gap * 102, "L"),
					new Beat(startTime + gap * 105, "D"),
					new Beat(startTime + gap * 108, "K"),
					new Beat(startTime + gap * 111, "F"),
					new Beat(startTime + gap * 114, "F"),
					new Beat(startTime + gap * 117, "F"),	
					new Beat(startTime + gap * 120, "J"),
					new Beat(startTime + gap * 123, "J"),
					new Beat(startTime + gap * 126, "J"),
					new Beat(startTime + gap * 129, "Space"),
					new Beat(startTime + gap * 132, "Space"),
					new Beat(startTime + gap * 135, "Space"),
					new Beat(startTime + gap * 138, "Space"),
					new Beat(startTime + gap * 141, "S"),
					new Beat(startTime + gap * 144, "D"),
					new Beat(startTime + gap * 147, "F"),
					new Beat(startTime + gap * 150, "L"),
					new Beat(startTime + gap * 153, "K"),				
					new Beat(startTime + gap * 156, "J"),
					new Beat(startTime + gap * 159, "Space"),
					new Beat(startTime + gap * 162, "Space"),
					new Beat(startTime + gap * 165, "Space"),
					new Beat(startTime + gap * 168, "S"),
					new Beat(startTime + gap * 171, "D"),
					new Beat(startTime + gap * 174, "F"),
					new Beat(startTime + gap * 177, "L"),
					new Beat(startTime + gap * 180, "K"),				
					new Beat(startTime + gap * 183, "J"),
					new Beat(startTime + gap * 186, "Space"),
					new Beat(startTime + gap * 189, "Space"),
					new Beat(startTime + gap * 192, "Space"),
					new Beat(startTime + gap * 195, "F"),
					new Beat(startTime + gap * 198, "F"),
					new Beat(startTime + gap * 201, "Space"),
					new Beat(startTime + gap * 204, "Space"),
					new Beat(startTime + gap * 207, "F"),				
					new Beat(startTime + gap * 210, "F"),
					new Beat(startTime + gap * 213, "Space"),
					new Beat(startTime + gap * 216, "Space"),
					new Beat(startTime + gap * 219, "J"),
					new Beat(startTime + gap * 222, "J"),
					new Beat(startTime + gap * 225, "Space"),
					new Beat(startTime + gap * 228, "Space"),
					new Beat(startTime + gap * 231, "J"),
					new Beat(startTime + gap * 234, "J"),
					new Beat(startTime + gap * 237, "S"),
					new Beat(startTime + gap * 240, "D"),
					new Beat(startTime + gap * 243, "F"),				
					new Beat(startTime + gap * 246, "S"),
					new Beat(startTime + gap * 249, "D"),
					new Beat(startTime + gap * 252, "F"),
					new Beat(startTime + gap * 255, "Space"),
					new Beat(startTime + gap * 258, "Space"),
					new Beat(startTime + gap * 261, "Space"),
					new Beat(startTime + gap * 264, "J"),
					new Beat(startTime + gap * 267, "K"),
					new Beat(startTime + gap * 270, "L"),				
					new Beat(startTime + gap * 273, "J"),
					new Beat(startTime + gap * 276, "K"),
					new Beat(startTime + gap * 279, "L"),
					new Beat(startTime + gap * 282, "Space"),
					new Beat(startTime + gap * 285, "Space"),
					new Beat(startTime + gap * 288, "Space"),
					new Beat(startTime + gap * 291, "Space"),
					new Beat(startTime + gap * 294, "S"),
					new Beat(startTime + gap * 297, "D"),
					new Beat(startTime + gap * 300, "F"),
					new Beat(startTime + gap * 303, "S"),
					new Beat(startTime + gap * 306, "D"),
					new Beat(startTime + gap * 309, "F"),
					new Beat(startTime + gap * 312, "S"),
					new Beat(startTime + gap * 315, "D"),
					new Beat(startTime + gap * 318, "F"),
					new Beat(startTime + gap * 321, "J"),
					new Beat(startTime + gap * 324, "K"),
					new Beat(startTime + gap * 327, "L"),
					new Beat(startTime + gap * 330, "J"),
					new Beat(startTime + gap * 333, "K"),
					new Beat(startTime + gap * 336, "L"),
					new Beat(startTime + gap * 339, "J"),
					new Beat(startTime + gap * 342, "K"),
					new Beat(startTime + gap * 345, "L"),
					new Beat(startTime + gap * 348, "S"),
					new Beat(startTime + gap * 351, "D"),
					new Beat(startTime + gap * 354, "D"),
					new Beat(startTime + gap * 357, "D"),
					new Beat(startTime + gap * 360, "L"),
					new Beat(startTime + gap * 363, "K"),
					new Beat(startTime + gap * 366, "K"),
					new Beat(startTime + gap * 369, "K"),
					new Beat(startTime + gap * 372, "Space"),
					new Beat(startTime + gap * 375, "Space"),
					new Beat(startTime + gap * 378, "Space"),
};
		}
		else if(titleName.equals("MBB - Happy")&& difficulty.equals("Hard")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 100; //박자에 맞게 떨어뜨리기 위해서
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime, "F"),
					new Beat(startTime, "J"),
					new Beat(startTime + gap * 3, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 9, "F"),
					new Beat(startTime + gap * 12, "S"),
					new Beat(startTime + gap * 15, "D"),
					new Beat(startTime + gap * 18, "F"),
					new Beat(startTime + gap * 21, "S"),
					new Beat(startTime + gap * 24, "D"),
					new Beat(startTime + gap * 27, "F"),
					new Beat(startTime + gap * 30, "J"),
					new Beat(startTime + gap * 33, "K"),
					new Beat(startTime + gap * 36, "L"),
					new Beat(startTime + gap * 39, "J"),
					new Beat(startTime + gap * 42, "K"),
					new Beat(startTime + gap * 45, "L"),
					new Beat(startTime + gap * 45, "J"),
					new Beat(startTime + gap * 48, "K"),
					new Beat(startTime + gap * 51, "L"),
					new Beat(startTime + gap * 54, "S"),
					new Beat(startTime + gap * 57, "D"),
					new Beat(startTime + gap * 60, "D"),
					new Beat(startTime + gap * 63, "D"),
					new Beat(startTime + gap * 66, "L"),
					new Beat(startTime + gap * 69, "K"),
					new Beat(startTime + gap * 72, "K"),
					new Beat(startTime + gap * 75, "K"),
					new Beat(startTime + gap * 78, "Space"),
					new Beat(startTime + gap * 78, "F"),
					new Beat(startTime + gap * 78, "J"),
					new Beat(startTime + gap * 81, "Space"),
					new Beat(startTime + gap * 81, "F"),
					new Beat(startTime + gap * 81, "J"),
					new Beat(startTime + gap * 84, "Space"),
					new Beat(startTime + gap * 84, "F"),
					new Beat(startTime + gap * 84, "J"),
					new Beat(startTime + gap * 87, "S"),
					new Beat(startTime + gap * 90, "L"),
					new Beat(startTime + gap * 93, "D"),
					new Beat(startTime + gap * 96, "K"),
					new Beat(startTime + gap * 99, "S"),
					new Beat(startTime + gap * 102, "L"),
					new Beat(startTime + gap * 105, "D"),
					new Beat(startTime + gap * 108, "K"),
					new Beat(startTime + gap * 111, "F"),
					new Beat(startTime + gap * 114, "F"),
					new Beat(startTime + gap * 117, "F"),	
					new Beat(startTime + gap * 120, "J"),
					new Beat(startTime + gap * 123, "J"),
					new Beat(startTime + gap * 126, "J"),
					new Beat(startTime + gap * 129, "Space"),
					new Beat(startTime + gap * 132, "Space"),
					new Beat(startTime + gap * 135, "Space"),
					new Beat(startTime + gap * 138, "Space"),
					new Beat(startTime + gap * 141, "S"),
					new Beat(startTime + gap * 144, "D"),
					new Beat(startTime + gap * 147, "F"),
					new Beat(startTime + gap * 150, "L"),
					new Beat(startTime + gap * 153, "K"),				
					new Beat(startTime + gap * 156, "J"),
					new Beat(startTime + gap * 159, "Space"),
					new Beat(startTime + gap * 162, "Space"),
					new Beat(startTime + gap * 165, "Space"),
					new Beat(startTime + gap * 168, "S"),
					new Beat(startTime + gap * 171, "D"),
					new Beat(startTime + gap * 174, "F"),
					new Beat(startTime + gap * 177, "L"),
					new Beat(startTime + gap * 180, "K"),				
					new Beat(startTime + gap * 183, "J"),
					new Beat(startTime + gap * 186, "Space"),
					new Beat(startTime + gap * 189, "Space"),
					new Beat(startTime + gap * 192, "Space"),
					new Beat(startTime + gap * 195, "F"),
					new Beat(startTime + gap * 198, "F"),
					new Beat(startTime + gap * 201, "Space"),
					new Beat(startTime + gap * 204, "Space"),
					new Beat(startTime + gap * 207, "F"),				
					new Beat(startTime + gap * 210, "F"),
					new Beat(startTime + gap * 213, "Space"),
					new Beat(startTime + gap * 216, "Space"),
					new Beat(startTime + gap * 219, "J"),
					new Beat(startTime + gap * 222, "J"),
					new Beat(startTime + gap * 225, "Space"),
					new Beat(startTime + gap * 228, "Space"),
					new Beat(startTime + gap * 231, "J"),
					new Beat(startTime + gap * 234, "J"),
					new Beat(startTime + gap * 237, "S"),
					new Beat(startTime + gap * 240, "D"),
					new Beat(startTime + gap * 243, "F"),				
					new Beat(startTime + gap * 246, "S"),
					new Beat(startTime + gap * 249, "D"),
					new Beat(startTime + gap * 252, "F"),
					new Beat(startTime + gap * 255, "Space"),
					new Beat(startTime + gap * 258, "Space"),
					new Beat(startTime + gap * 261, "Space"),
					new Beat(startTime + gap * 264, "J"),
					new Beat(startTime + gap * 267, "K"),
					new Beat(startTime + gap * 270, "L"),				
					new Beat(startTime + gap * 273, "J"),
					new Beat(startTime + gap * 276, "K"),
					new Beat(startTime + gap * 279, "L"),
					new Beat(startTime + gap * 282, "Space"),
					new Beat(startTime + gap * 285, "Space"),
					new Beat(startTime + gap * 288, "Space"),
					new Beat(startTime + gap * 291, "Space"),
					new Beat(startTime + gap * 294, "S"),
					new Beat(startTime + gap * 297, "D"),
					new Beat(startTime + gap * 300, "F"),
					new Beat(startTime + gap * 303, "S"),
					new Beat(startTime + gap * 306, "D"),
					new Beat(startTime + gap * 309, "F"),
					new Beat(startTime + gap * 312, "S"),
					new Beat(startTime + gap * 315, "D"),
					new Beat(startTime + gap * 318, "F"),
					new Beat(startTime + gap * 321, "J"),
					new Beat(startTime + gap * 324, "K"),
					new Beat(startTime + gap * 327, "L"),
					new Beat(startTime + gap * 330, "J"),
					new Beat(startTime + gap * 333, "K"),
					new Beat(startTime + gap * 336, "L"),
					new Beat(startTime + gap * 339, "J"),
					new Beat(startTime + gap * 342, "K"),
					new Beat(startTime + gap * 345, "L"),
					new Beat(startTime + gap * 348, "S"),
					new Beat(startTime + gap * 351, "D"),
					new Beat(startTime + gap * 354, "D"),
					new Beat(startTime + gap * 357, "D"),
					new Beat(startTime + gap * 360, "L"),
					new Beat(startTime + gap * 363, "K"),
					new Beat(startTime + gap * 366, "K"),
					new Beat(startTime + gap * 369, "K"),
					new Beat(startTime + gap * 372, "Space"),
					new Beat(startTime + gap * 375, "Space"),
					new Beat(startTime + gap * 378, "Space"),
};
		}
		else if(titleName.equals("MBB - Bora")&& difficulty.equals("Hard")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 100; //박자에 맞게 떨어뜨리기 위해서
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime, "F"),
					new Beat(startTime, "J"),
					new Beat(startTime + gap * 3, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 9, "F"),
					new Beat(startTime + gap * 12, "S"),
					new Beat(startTime + gap * 15, "D"),
					new Beat(startTime + gap * 18, "F"),
					new Beat(startTime + gap * 21, "S"),
					new Beat(startTime + gap * 24, "D"),
					new Beat(startTime + gap * 27, "F"),
					new Beat(startTime + gap * 30, "J"),
					new Beat(startTime + gap * 33, "K"),
					new Beat(startTime + gap * 36, "L"),
					new Beat(startTime + gap * 39, "J"),
					new Beat(startTime + gap * 42, "K"),
					new Beat(startTime + gap * 45, "L"),
					new Beat(startTime + gap * 45, "J"),
					new Beat(startTime + gap * 48, "K"),
					new Beat(startTime + gap * 51, "L"),
					new Beat(startTime + gap * 54, "S"),
					new Beat(startTime + gap * 57, "D"),
					new Beat(startTime + gap * 60, "D"),
					new Beat(startTime + gap * 63, "D"),
					new Beat(startTime + gap * 66, "L"),
					new Beat(startTime + gap * 69, "K"),
					new Beat(startTime + gap * 72, "K"),
					new Beat(startTime + gap * 75, "K"),
					new Beat(startTime + gap * 78, "Space"),
					new Beat(startTime + gap * 78, "F"),
					new Beat(startTime + gap * 78, "J"),
					new Beat(startTime + gap * 81, "Space"),
					new Beat(startTime + gap * 81, "F"),
					new Beat(startTime + gap * 81, "J"),
					new Beat(startTime + gap * 84, "Space"),
					new Beat(startTime + gap * 84, "F"),
					new Beat(startTime + gap * 84, "J"),
					new Beat(startTime + gap * 87, "S"),
					new Beat(startTime + gap * 90, "L"),
					new Beat(startTime + gap * 93, "D"),
					new Beat(startTime + gap * 96, "K"),
					new Beat(startTime + gap * 99, "S"),
					new Beat(startTime + gap * 102, "L"),
					new Beat(startTime + gap * 105, "D"),
					new Beat(startTime + gap * 108, "K"),
					new Beat(startTime + gap * 111, "F"),
					new Beat(startTime + gap * 114, "F"),
					new Beat(startTime + gap * 117, "F"),	
					new Beat(startTime + gap * 120, "J"),
					new Beat(startTime + gap * 123, "J"),
					new Beat(startTime + gap * 126, "J"),
					new Beat(startTime + gap * 129, "Space"),
					new Beat(startTime + gap * 132, "Space"),
					new Beat(startTime + gap * 135, "Space"),
					new Beat(startTime + gap * 138, "Space"),
					new Beat(startTime + gap * 141, "S"),
					new Beat(startTime + gap * 144, "D"),
					new Beat(startTime + gap * 147, "F"),
					new Beat(startTime + gap * 150, "L"),
					new Beat(startTime + gap * 153, "K"),				
					new Beat(startTime + gap * 156, "J"),
					new Beat(startTime + gap * 159, "Space"),
					new Beat(startTime + gap * 162, "Space"),
					new Beat(startTime + gap * 165, "Space"),
					new Beat(startTime + gap * 168, "S"),
					new Beat(startTime + gap * 171, "D"),
					new Beat(startTime + gap * 174, "F"),
					new Beat(startTime + gap * 177, "L"),
					new Beat(startTime + gap * 180, "K"),				
					new Beat(startTime + gap * 183, "J"),
					new Beat(startTime + gap * 186, "Space"),
					new Beat(startTime + gap * 189, "Space"),
					new Beat(startTime + gap * 192, "Space"),
					new Beat(startTime + gap * 195, "F"),
					new Beat(startTime + gap * 198, "F"),
					new Beat(startTime + gap * 201, "Space"),
					new Beat(startTime + gap * 204, "Space"),
					new Beat(startTime + gap * 207, "F"),				
					new Beat(startTime + gap * 210, "F"),
					new Beat(startTime + gap * 213, "Space"),
					new Beat(startTime + gap * 216, "Space"),
					new Beat(startTime + gap * 219, "J"),
					new Beat(startTime + gap * 222, "J"),
					new Beat(startTime + gap * 225, "Space"),
					new Beat(startTime + gap * 228, "Space"),
					new Beat(startTime + gap * 231, "J"),
					new Beat(startTime + gap * 234, "J"),
					new Beat(startTime + gap * 237, "S"),
					new Beat(startTime + gap * 240, "D"),
					new Beat(startTime + gap * 243, "F"),				
					new Beat(startTime + gap * 246, "S"),
					new Beat(startTime + gap * 249, "D"),
					new Beat(startTime + gap * 252, "F"),
					new Beat(startTime + gap * 255, "Space"),
					new Beat(startTime + gap * 258, "Space"),
					new Beat(startTime + gap * 261, "Space"),
					new Beat(startTime + gap * 264, "J"),
					new Beat(startTime + gap * 267, "K"),
					new Beat(startTime + gap * 270, "L"),				
					new Beat(startTime + gap * 273, "J"),
					new Beat(startTime + gap * 276, "K"),
					new Beat(startTime + gap * 279, "L"),
					new Beat(startTime + gap * 282, "Space"),
					new Beat(startTime + gap * 285, "Space"),
					new Beat(startTime + gap * 288, "Space"),
					new Beat(startTime + gap * 291, "Space"),
					new Beat(startTime + gap * 294, "S"),
					new Beat(startTime + gap * 297, "D"),
					new Beat(startTime + gap * 300, "F"),
					new Beat(startTime + gap * 303, "S"),
					new Beat(startTime + gap * 306, "D"),
					new Beat(startTime + gap * 309, "F"),
					new Beat(startTime + gap * 312, "S"),
					new Beat(startTime + gap * 315, "D"),
					new Beat(startTime + gap * 318, "F"),
					new Beat(startTime + gap * 321, "J"),
					new Beat(startTime + gap * 324, "K"),
					new Beat(startTime + gap * 327, "L"),
					new Beat(startTime + gap * 330, "J"),
					new Beat(startTime + gap * 333, "K"),
					new Beat(startTime + gap * 336, "L"),
					new Beat(startTime + gap * 339, "J"),
					new Beat(startTime + gap * 342, "K"),
					new Beat(startTime + gap * 345, "L"),
					new Beat(startTime + gap * 348, "S"),
					new Beat(startTime + gap * 351, "D"),
					new Beat(startTime + gap * 354, "D"),
					new Beat(startTime + gap * 357, "D"),
					new Beat(startTime + gap * 360, "L"),
					new Beat(startTime + gap * 363, "K"),
					new Beat(startTime + gap * 366, "K"),
					new Beat(startTime + gap * 369, "K"),
					new Beat(startTime + gap * 372, "Space"),
					new Beat(startTime + gap * 375, "Space"),
					new Beat(startTime + gap * 378, "Space"),
};
		}
		else if(titleName.equals("Lights - Roa")&& difficulty.equals("Hard")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 100; //박자에 맞게 떨어뜨리기 위해서
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime, "F"),
					new Beat(startTime, "J"),
					new Beat(startTime + gap * 3, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 9, "F"),
					new Beat(startTime + gap * 12, "S"),
					new Beat(startTime + gap * 15, "D"),
					new Beat(startTime + gap * 18, "F"),
					new Beat(startTime + gap * 21, "S"),
					new Beat(startTime + gap * 24, "D"),
					new Beat(startTime + gap * 27, "F"),
					new Beat(startTime + gap * 30, "J"),
					new Beat(startTime + gap * 33, "K"),
					new Beat(startTime + gap * 36, "L"),
					new Beat(startTime + gap * 39, "J"),
					new Beat(startTime + gap * 42, "K"),
					new Beat(startTime + gap * 45, "L"),
					new Beat(startTime + gap * 45, "J"),
					new Beat(startTime + gap * 48, "K"),
					new Beat(startTime + gap * 51, "L"),
					new Beat(startTime + gap * 54, "S"),
					new Beat(startTime + gap * 57, "D"),
					new Beat(startTime + gap * 60, "D"),
					new Beat(startTime + gap * 63, "D"),
					new Beat(startTime + gap * 66, "L"),
					new Beat(startTime + gap * 69, "K"),
					new Beat(startTime + gap * 72, "K"),
					new Beat(startTime + gap * 75, "K"),
					new Beat(startTime + gap * 78, "Space"),
					new Beat(startTime + gap * 78, "F"),
					new Beat(startTime + gap * 78, "J"),
					new Beat(startTime + gap * 81, "Space"),
					new Beat(startTime + gap * 81, "F"),
					new Beat(startTime + gap * 81, "J"),
					new Beat(startTime + gap * 84, "Space"),
					new Beat(startTime + gap * 84, "F"),
					new Beat(startTime + gap * 84, "J"),
					new Beat(startTime + gap * 87, "S"),
					new Beat(startTime + gap * 90, "L"),
					new Beat(startTime + gap * 93, "D"),
					new Beat(startTime + gap * 96, "K"),
					new Beat(startTime + gap * 99, "S"),
					new Beat(startTime + gap * 102, "L"),
					new Beat(startTime + gap * 105, "D"),
					new Beat(startTime + gap * 108, "K"),
					new Beat(startTime + gap * 111, "F"),
					new Beat(startTime + gap * 114, "F"),
					new Beat(startTime + gap * 117, "F"),	
					new Beat(startTime + gap * 120, "J"),
					new Beat(startTime + gap * 123, "J"),
					new Beat(startTime + gap * 126, "J"),
					new Beat(startTime + gap * 129, "Space"),
					new Beat(startTime + gap * 132, "Space"),
					new Beat(startTime + gap * 135, "Space"),
					new Beat(startTime + gap * 138, "Space"),
					new Beat(startTime + gap * 141, "S"),
					new Beat(startTime + gap * 144, "D"),
					new Beat(startTime + gap * 147, "F"),
					new Beat(startTime + gap * 150, "L"),
					new Beat(startTime + gap * 153, "K"),				
					new Beat(startTime + gap * 156, "J"),
					new Beat(startTime + gap * 159, "Space"),
					new Beat(startTime + gap * 162, "Space"),
					new Beat(startTime + gap * 165, "Space"),
					new Beat(startTime + gap * 168, "S"),
					new Beat(startTime + gap * 171, "D"),
					new Beat(startTime + gap * 174, "F"),
					new Beat(startTime + gap * 177, "L"),
					new Beat(startTime + gap * 180, "K"),				
					new Beat(startTime + gap * 183, "J"),
					new Beat(startTime + gap * 186, "Space"),
					new Beat(startTime + gap * 189, "Space"),
					new Beat(startTime + gap * 192, "Space"),
					new Beat(startTime + gap * 195, "F"),
					new Beat(startTime + gap * 198, "F"),
					new Beat(startTime + gap * 201, "Space"),
					new Beat(startTime + gap * 204, "Space"),
					new Beat(startTime + gap * 207, "F"),				
					new Beat(startTime + gap * 210, "F"),
					new Beat(startTime + gap * 213, "Space"),
					new Beat(startTime + gap * 216, "Space"),
					new Beat(startTime + gap * 219, "J"),
					new Beat(startTime + gap * 222, "J"),
					new Beat(startTime + gap * 225, "Space"),
					new Beat(startTime + gap * 228, "Space"),
					new Beat(startTime + gap * 231, "J"),
					new Beat(startTime + gap * 234, "J"),
					new Beat(startTime + gap * 237, "S"),
					new Beat(startTime + gap * 240, "D"),
					new Beat(startTime + gap * 243, "F"),				
					new Beat(startTime + gap * 246, "S"),
					new Beat(startTime + gap * 249, "D"),
					new Beat(startTime + gap * 252, "F"),
					new Beat(startTime + gap * 255, "Space"),
					new Beat(startTime + gap * 258, "Space"),
					new Beat(startTime + gap * 261, "Space"),
					new Beat(startTime + gap * 264, "J"),
					new Beat(startTime + gap * 267, "K"),
					new Beat(startTime + gap * 270, "L"),				
					new Beat(startTime + gap * 273, "J"),
					new Beat(startTime + gap * 276, "K"),
					new Beat(startTime + gap * 279, "L"),
					new Beat(startTime + gap * 282, "Space"),
					new Beat(startTime + gap * 285, "Space"),
					new Beat(startTime + gap * 288, "Space"),
					new Beat(startTime + gap * 291, "Space"),
					new Beat(startTime + gap * 294, "S"),
					new Beat(startTime + gap * 297, "D"),
					new Beat(startTime + gap * 300, "F"),
					new Beat(startTime + gap * 303, "S"),
					new Beat(startTime + gap * 306, "D"),
					new Beat(startTime + gap * 309, "F"),
					new Beat(startTime + gap * 312, "S"),
					new Beat(startTime + gap * 315, "D"),
					new Beat(startTime + gap * 318, "F"),
					new Beat(startTime + gap * 321, "J"),
					new Beat(startTime + gap * 324, "K"),
					new Beat(startTime + gap * 327, "L"),
					new Beat(startTime + gap * 330, "J"),
					new Beat(startTime + gap * 333, "K"),
					new Beat(startTime + gap * 336, "L"),
					new Beat(startTime + gap * 339, "J"),
					new Beat(startTime + gap * 342, "K"),
					new Beat(startTime + gap * 345, "L"),
					new Beat(startTime + gap * 348, "S"),
					new Beat(startTime + gap * 351, "D"),
					new Beat(startTime + gap * 354, "D"),
					new Beat(startTime + gap * 357, "D"),
					new Beat(startTime + gap * 360, "L"),
					new Beat(startTime + gap * 363, "K"),
					new Beat(startTime + gap * 366, "K"),
					new Beat(startTime + gap * 369, "K"),
					new Beat(startTime + gap * 372, "Space"),
					new Beat(startTime + gap * 375, "Space"),
					new Beat(startTime + gap * 378, "Space"),
};
		}
		int i = 0;
		gameMusic.start();
		while(i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note); //노트리스트에 방금만든 노트 추가
				i++; //i를 1씩 증가해서 각 note에 하나씩 접근하면서 떨어뜨릴수 있게함
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
			}
	
	public void judge(String input) {
		for(int i =0; i<noteList.size(); i++) { //앞에 인덱스 부터 -> 가장 먼저 입력된 노트부터 탐색 
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				//break;
			}
		}
	}
	
	public void judgeEvent(String judgement) {
		if(!judgement.equals("None")) { //현재 판정이 존재하는 경우
			blueFlareImage = new ImageIcon(Main.class.getResource("../Images/blueFlare.png")).getImage();
		}
		if(judgement.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../Images/judgeEarly.png")).getImage();
		}
		if(judgement.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../Images/judgeMiss.png")).getImage();
		}
		else {
			judgeImage = new ImageIcon(Main.class.getResource("../Images/judgeGood.png")).getImage();
			
		}
	}
	
}
