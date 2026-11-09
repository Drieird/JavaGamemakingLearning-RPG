import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    
    //Screen Settings
    final int originalTileSize = 16;
    final int scale = 3;
    
    final int tileSize = originalTileSize * scale;//48x48
    final int maxScreenColumn= 16;
    final int maxScreenRow= 12;
    final int screenWidth = tileSize * maxScreenColumn;
    final int screenHeight = tileSize * maxScreenRow;
    
    //FPS
    int FPS = 60;
    
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    
    //Player default position & speed
    int playerX = 100;
    int playerY = 100;
    int playerSpd = 5;
    
    public GamePanel() {
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.darkGray);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    public void startGameThread() {
        
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;// 1 frame every 16.666 nanoseconds or 0,016666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int frameCount = 0;
        
        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;
            
            if(delta >=1) {
                update();
                repaint(); 
                delta--;
                frameCount++;
            }
            
            if(timer >= 1000000000){
                System.out.println("FPS : "+ frameCount);
                frameCount = 0;
                timer = 0;
            }
        }
    }
    
    public void update() {

        if(keyH.upKeyPressed || keyH.downKeyPressed == true) {
            if(keyH.upKeyPressed && keyH.downKeyPressed) {
                playerY += (playerSpd-playerSpd);
            }
            else if(keyH.downKeyPressed) {
                playerY += playerSpd;
            }
            else if(keyH.upKeyPressed) {
                playerY -= playerSpd;
            }
        }
        else if(keyH.leftKeyPressed || keyH.rightKeyPressed == true) {
            if(keyH.leftKeyPressed && keyH.rightKeyPressed) {
                playerX += (playerSpd-playerSpd);
            }
            else if(keyH.rightKeyPressed) {
                playerX += playerSpd;
            }
            else if(keyH.leftKeyPressed) {
                playerX -= playerSpd;
            }
        }
    }
    
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.red);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        
        g2.dispose();
    }
}