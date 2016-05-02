import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.util.ArrayDeque;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Queue;
import java.io.IOException;



public class View {
    private JPanel mainPanel;
    public static Game game;
    private Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<>(100);
    private Random randomGenerator = new Random();

    final static String TEXTPANEL = "Game";


    public View() {
        game = new Game(this);
        //game.game = game;
    }

    public static void main(String[] args) {
        View view = new View();
        view.initializeFrame();
        view.game.start();
    }

    private void initializeFrame() {
        JFrame frame = new JFrame("Snake 0.8.7");
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                keyEvents.add(e);
               // View.this.game.processPressedKey(e.getKeyCode());
            }
        });
    }

    private void createUIComponents() throws IOException {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(20, 20));
        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < 20; i++) {
                JPanel panel = new JPanel();
                panel.setBackground(Color.decode("0xB5E8AB"));
                mainPanel.add(panel);
            }
        }
    }

    public boolean hasEvents(){
        return !keyEvents.isEmpty();
    }

    public KeyEvent getEvent(){
        return keyEvents.poll();

    }

    public void GameOver(){
        System.exit(0);
        JLabel label1 = new JLabel();
        label1.setText("simple text");
    }

    public void updateMainPanel(int[][] matrix) {
        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 20; j++) {
                if (matrix[i][j] == 1) {
                    JPanel panel = getPanelByXAndY(i,j);
                    panel.setBackground(Color.blue);
                }
                if (matrix[i][j] == 4) {
                    JPanel panel = getPanelByXAndY(i, j);
                    panel.setBackground(Color.red);
                }
                if (matrix[i][j] == 10) {
                    JPanel panel = getPanelByXAndY(i, j);
                    panel.setBackground(Color.black);
                }
                if (matrix[i][j] == 0){
                    JPanel panel = getPanelByXAndY(i, j);
                    panel.setBackground(Color.decode("0xB5E8AB"));

                }
            }
    }

    public void createFood(){
        int x = randomGenerator.nextInt(20);
        int y = randomGenerator.nextInt(20);
        JPanel panel = getPanelByXAndY(x, y);
        panel.setBackground(Color.red);
        game.food = new Food(x, y);
    }
    private JPanel getPanelByXAndY(int x, int y) {
        return (JPanel) mainPanel.getComponent((20 * x) + y);
    }
}
