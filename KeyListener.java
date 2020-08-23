package rhythmgame4;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
		if(Rhythmgame.game == null) {
			return; //게임이 진행중이지 않다면 
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			Rhythmgame.game.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			Rhythmgame.game.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			Rhythmgame.game.pressF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			Rhythmgame.game.pressSpace();
					}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			Rhythmgame.game.pressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			Rhythmgame.game.pressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			Rhythmgame.game.pressL();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) { //키보드뗄떼
		if(Rhythmgame.game == null) {
			return;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			Rhythmgame.game.releaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			Rhythmgame.game.releaseD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			Rhythmgame.game.releaseF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			Rhythmgame.game.releaseSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			Rhythmgame.game.releaseJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			Rhythmgame.game.releaseK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			Rhythmgame.game.releaseL();

		}
	}
}
