import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public boolean upKeyPressed, leftKeyPressed, downKeyPressed, rightKeyPressed;
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W) {
            upKeyPressed = true;
        }
        if(code == KeyEvent.VK_A) {
            leftKeyPressed = true;
        }
        if(code == KeyEvent.VK_S) {
            downKeyPressed = true;
        }
        if(code == KeyEvent.VK_D) {
            rightKeyPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W) {
            upKeyPressed = false;
        }
        if(code == KeyEvent.VK_A) {
            leftKeyPressed = false;
        }
        if(code == KeyEvent.VK_S) {
            downKeyPressed = false;
        }
        if(code == KeyEvent.VK_D) {
            rightKeyPressed = false;
        }
    }
}