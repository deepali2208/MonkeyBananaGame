package Function;
import Function.Banana;
import Function.Monkey;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Wonderland extends JPanel{

	public static final int SCREEN_WIDTH = 650;
	public static final int SCREEN_HEIGHT = 650;
    public static final int OUTER_HEIGHT = 700;
    public static final int GRID_COUNT = 32;
	public static final int STEP_SIZE = SCREEN_WIDTH/GRID_COUNT;
	
	private Monkey monkey;
	private Banana banana;
	private JLabel statusbar;
	private JPanel topPanel;
	private JLabel timeLabel;
	private int bananaCount = 15;

	Image backgroundimage;
	int bananaTime = 0;
	private int gameState = 0;
	
	
	public int getbananaCount() {
		return bananaCount;
	}

	public void setbananaCount(int bananaCount) {
		this.bananaCount = bananaCount;
	}

	public Wonderland() {
    	addKeyListener(new TAdapter()); 
        setFocusable(true);
        setPreferredSize(new Dimension(Wonderland.SCREEN_WIDTH, Wonderland.OUTER_HEIGHT));
        startGame();
	}
	
	private void startGame() {
		monkey = new Monkey();
		banana = new Banana();
		ImageIcon monkey_icon = new ImageIcon("Images/grass.jpg");
		Image scaleImage_banana = monkey_icon.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
		backgroundimage = ( new ImageIcon(scaleImage_banana)).getImage();
		setLayout(new BorderLayout());
		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(600, 50));
		
		statusbar = new JLabel("Bananas left to eat:"+bananaCount);
		timeLabel = new JLabel("Time Limit");
		
		topPanel.add(statusbar);
		topPanel.add(timeLabel);
		add(topPanel, BorderLayout.SOUTH);
		
		Timer t1 = new Timer(1000, new ActionListener() {
		    public int count = 60;
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if(bananaCount == 0 && count>0){
		        	timeLabel.setText("You won!");
		        	((Timer)e.getSource()).stop();
		        	gameState = 1;
		        	repaint();
		        }else if(count<=0 && bananaCount!=0){
		        	 timeLabel.setText("You Lost it!" );
		        	 ((Timer)e.getSource()).stop();
		        	 gameState = 2;
		        	 repaint();
		        }else {
		            timeLabel.setText(" Time Left "+Integer.toString(count));
		            count--;
		            bananaTime++;
		            resetBanana();
		        }
		    }
		    
			private void resetBanana() {
							
							if (bananaTime == 8){
								banana.putBananaRandomly();
								repaint();
								bananaTime = 0;
							}else{
							}
							
						}
					});
					t1.start();
				}

	@Override
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
	if (gameState == 0){
		drawGraphics(g);	
	}else if (gameState == 1){
		gameOver(g2d,gameState);
	}else if (gameState == 2){
		gameOver(g2d,gameState);
	}
	
	Toolkit.getDefaultToolkit().sync();
	}
	

	private void drawGraphics(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(backgroundimage, 0, 0, 700, 700, this);
		g2d.drawImage(monkey.getImage(), monkey.getMonkeymonkeyposition_x(), monkey.getMonkeymonkeyposition_y(), this);
		g2d.setColor(Color.DARK_GRAY);
		g2d.drawImage(banana.getBananaImage(), banana.getbananaposition_x(), banana.getbananaposition_y(), this);
		g2d.setBackground(Color.GREEN);
	}

	private void checkStrike() {
		Rectangle rec1 = new Rectangle(monkey.getMonkeymonkeyposition_x(), monkey.getMonkeymonkeyposition_y(), monkey.getwidth_monkeyimage(),monkey.getheight_monkeyimage());
		Rectangle rec2 = new Rectangle(banana.getbananaposition_x(), banana.getbananaposition_y(), banana.getwidth_bananaimage(),banana.getheight_bananaimage());
		if(rec1.intersects(rec2)) {
			bananaCount--;
			System.out.println(bananaCount + "\n");
			statusbar.setText("Bananas Remaining: " + getbananaCount());
			banana.putBananaRandomly();
			bananaTime = 0;
		}
		
	}
	
	private void gameOver(Graphics2D g2d, int gameState2) {

		if (gameState2 == 1){
			screenDisplay("You Win this game ! Your score is "+(15-bananaCount) , g2d);
		}else {
			screenDisplay("You Lost this game! Your score is "+(15-bananaCount), g2d);
		}
	   
	}

	private void screenDisplay(String string, Graphics2D g2d) {
		 Font font = new Font("Jokerman", Font.BOLD, 16);
		    FontMetrics metr = this.getFontMetrics(font); 
		    g2d.setColor(Color.BLUE);
		    g2d.setFont(font);
		    g2d.drawString(string,
		            (Wonderland.SCREEN_WIDTH - metr.stringWidth(string)) / 2,
		            Wonderland.SCREEN_HEIGHT / 2);
		    statusbar.setText("");		
	}

	 private class TAdapter extends KeyAdapter {
	        @Override
	        public void keyReleased(KeyEvent e) {
	            	monkey.keyReleased(e);
	            	checkStrike();
	            	repaint();
	        }
	        @Override
	        public void keyPressed(KeyEvent e) {
	            monkey.keyPressed(e);
	            checkStrike();
	            repaint();
	        }
	          
	    }	
	
}
