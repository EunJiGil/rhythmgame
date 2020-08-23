package rhythmgame4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Rhythmgame extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic; //화면 사진을 위한 더블버퍼링 
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../Images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../Images/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../Images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../Images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../Images/finishButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../Images/finishButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../Images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../Images/leftButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../Images/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../Images/rightButtonBasic.png"));
	
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../Images/easyButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../Images/easyButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../Images/hardButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../Images/hardButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../Images/backButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../Images/backButtonBasic.png"));
	
	
	private Image background = new ImageIcon(Main.class.getResource("../Images/introBackground(title).jpg")).getImage(); //이미지를 담을 수 있는 객체
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../Images/menuBar.png")));
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);

	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private Music introMusic = new Music("intro.mp3",true);
	private int nowSelected = 0; //첫번째곡인덱스
	
	public static Game game ; //프로젝트 전체에서 사용되는 변수 선언
	
	public Rhythmgame() {
		trackList.add(new Track("Happy Title Image.png", "Mighty Love Start Image.jpg", "Mighty Love Game Image.jpg", 
				"MBB Happly Selected.mp3", "MBB - Happy.mp3","MBB - Happy"));
		trackList.add(new Track("Bora Title Image.png", "Wild Flower Start Image.jpg", "Wild Flower Game Image.jpg", 
				"MBB Bora Selected.mp3", "MBB - Bora Bora.mp3","MBB - Bora"));
		trackList.add(new Track("Roa Title Image.png", "Energy Start Image.jpg", "Energy Game Image.jpg", 
				"Lights Roa Selected.mp3", "Lights - Roa.mp3","Lights - Roa"));
		
		setUndecorated(true);
		setTitle("Random Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //메인에서 정한 사이즈로!
		setResizable(false); //사이즈 바꿀수 없게
		setLocationRelativeTo(null); //정중앙에 뜨게하는 것
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창을 종료하면프로그램 전체 종료
		setVisible(true); // 화면에 정상적으로 출력되도록
		setBackground(new Color (0, 0, 0, 0));
		setLayout(null); //버튼이나 JLabel 그 위치에 
		
		addKeyListener( new KeyListener ());
		
		introMusic.start();
		
		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000); //종료되기 전에 소리 들리게 해주려고
				}catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		startButton.setBounds(430, 340, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				introMusic.close();
				enterMain();
			}
		});
		add(startButton);
		
		quitButton.setBounds(430, 480, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				try {
					Thread.sleep(1000); //종료되기 전에 소리 들리게 해주려고
				}catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60); //위치 위치 크기 크기
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				//왼쪽 버튼 이벤트
				selectLeft();
			}
		});
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60); //위치 위치 크기 크기
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				//오른쪽 버튼 이벤트
				selectRight();
			}
		});
		add(rightButton);
		
		easyButton.setVisible(false);
		easyButton.setBounds(405, 600, 250, 67); //위치 위치 크기 크기
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				//easy 버튼 이벤트
				gameStart(nowSelected, "Easy");
				
				
			}
		});
		add(easyButton);
		
		hardButton.setVisible(false);
		hardButton.setBounds(685, 600, 250, 67); //위치 위치 크기 크기
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				//hard 버튼 이벤트
				gameStart(nowSelected, "Hard");
				
			}
		});
		add(hardButton);
		
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60); //위치 위치 크기 크기
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				backMain();//메인화면으로 돌아가는 이벤트
				
			}
		});
		add(backButton);
		
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen(); //스크린에 x좌표 가져오기
				int y = e.getYOnScreen(); //스크린에 y좌표 가져오기
				setLocation( x-mouseX, y-mouseY ); //드래그 순간순간마다 좌표 변경
			}
		});
		add(menuBar);//JFrame에 menuBar 추가
		
		
		
		
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic); //스크린그래픽에 어떤 그림을 그려줌
		g.drawImage(screenImage, 0, 0, null); //0,0에 위치해서 스크린 이미지를 그려줌 -> 
	} //paint는 약속된 메소드
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null); //background를 0,0에 그려줌
		if(isMainScreen) 
		{
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		if(isGameScreen) {
			
			game.screenDraw(g);
			
		}
		paintComponents(g); //메뉴바 이미지  고정적이고 항상 존재하는 이미지이므로 paintComponent로 그려줌 add가 된것들은 paint Components가 그림
		try {
			Thread.sleep(5); // 간격을 두면서
		}catch (Exception e) {
			e.printStackTrace();
		}
		this.repaint(); //paint = 화면을 그려주는 함수 repaint = 다시 불러옴 -> 전체화면을 프로그램이 종료되는 순간까지 계속 반복되면서 왔다갔다
	}


public void selectTrack(int nowSelected) {
	if(selectedMusic != null) {
		selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../Images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../Images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(),true);
		selectedMusic.start();
	}
	else
	{
	titleImage = new ImageIcon(Main.class.getResource("../Images/"+ trackList.get(0).getTitleImage())).getImage();
	   selectedImage = new ImageIcon(Main.class.getResource("../Images/"+ trackList.get(0).getStartImage())).getImage();
	   selectedMusic = new Music(trackList.get(0).getStartMusic(), true);
	   selectedMusic.start();
	}
}

public void selectLeft() {
	if(nowSelected == 0) 
		nowSelected = trackList.size()-1;
	else
		nowSelected--;	
	selectTrack(nowSelected); //초기화
}
public void selectRight() {
	if(nowSelected == trackList.size()-1) 
		nowSelected = 0;
	else
		nowSelected++;
	selectTrack(nowSelected);
}
public void gameStart(int nowSelected, String difficulty ) {
	if (selectedMusic != null) {
		selectedMusic.close(); //재생되고 있으면 재생되는 음악 닫기
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../Images/" + trackList.get(nowSelected).getGameImage())).getImage(); //메인으로 넘어가기
		backButton.setVisible(true);
		isGameScreen = true;
		
		game = new Game(trackList.get(nowSelected).getTitleName(),difficulty, trackList.get(nowSelected).getGameMusic());
		game.start();
		setFocusable(true); // 포커스맞추기
	}
}

public void backMain() {
	isMainScreen = true;
	leftButton.setVisible(true);
	rightButton.setVisible(true);
	easyButton.setVisible(true);
	hardButton.setVisible(true);
	background = new ImageIcon(Main.class.getResource("../Images/mainBackground.jpg")).getImage(); //메인으로 넘어가기
	backButton.setVisible(false);
	selectTrack(nowSelected);
	isGameScreen = false;
	game.close();
}

public void enterMain() {
	startButton.setVisible(false);
	quitButton.setVisible(false);
	background = new ImageIcon(Main.class.getResource("../Images/mainBackground.jpg")).getImage(); //메인으로 넘어가기
    leftButton.setVisible(true);
    rightButton.setVisible(true);
    easyButton.setVisible(true);
    hardButton.setVisible(true);
    introMusic.close();
	isMainScreen = true;
	selectTrack(0);
	
}
}

