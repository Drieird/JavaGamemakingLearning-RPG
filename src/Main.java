import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        
        JFrame window = new JFrame();
        
        window.setTitle("Tower Defense Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        ImageIcon icon = new ImageIcon("PlcHldrIcon.png");
        window.setIconImage(icon.getImage());
        
        gamePanel.startGameThread();
    }
}