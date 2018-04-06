package Function;
import Function.Wonderland;
import State.idleMonkey;
import State.changeState;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.ImageIcon;


public class Monkey {
	private int monkeyposition_x;
	private int monkeyposition_y;
	private changeState current_state;
	private int monkeypropogate_x;
	private int monkeypropogate_y;
	private Image image;
	private int height_monkeyimage = Wonderland.STEP_SIZE;
	private int width_monkeyimage = Wonderland.STEP_SIZE;
	
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getMonkeymonkeyposition_x() {
		return monkeyposition_x;
	}

	public void setMonkeymonkeyposition_x(int monkeyposition_x) {
		this.monkeyposition_x = monkeyposition_x;
	}

	public int getMonkeymonkeyposition_y() {
		return monkeyposition_y;
	}

	public void setMonkeymonkeyposition_y(int monkeyposition_y) {
		this.monkeyposition_y = monkeyposition_y;
	}
	
	public int monkeypropogate_x() {
		return monkeypropogate_x;
	}
	public void setmonkeypropogate_x(int monkeypropogate_x) {
		this.monkeypropogate_x = monkeypropogate_x;
	}
	public int getmonkeypropogate_y() {
		return monkeypropogate_y;
	}
	public void setmonkeypropogate_y(int monkeypropogate_y) {
		this.monkeypropogate_y = monkeypropogate_y;
	}
	public int getwidth_monkeyimage() {
		return width_monkeyimage;
	}
	public void setwidth_monkeyimage(int width_monkeyimage) {
		this.width_monkeyimage = width_monkeyimage;
	}
	public int getheight_monkeyimage() {
		return height_monkeyimage;
	}
	public void setheight_monkeyimage(int height_monkeyimage) {
		this.height_monkeyimage = height_monkeyimage;
	}
	public void keyReleased(KeyEvent event) {
		current_state = current_state.KeyReleased(this,event);
		
	}
	public void keyPressed(KeyEvent event) {
		current_state = current_state.keyPressed(this,event);
	} 
	
	public Monkey(){
		current_state = new idleMonkey();
		locationMonkey();
		}
	
	private void locationMonkey(){
		ImageIcon monkeyimage_icon = new ImageIcon("Images/monkey.png");
		Image scaleImage_monkey = monkeyimage_icon.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
		image = (new ImageIcon(scaleImage_monkey)).getImage();
		Random random = new Random();
		monkeyposition_x = Wonderland.STEP_SIZE*random.nextInt(Wonderland.GRID_COUNT);
		monkeyposition_y = Wonderland.STEP_SIZE*random.nextInt(Wonderland.GRID_COUNT);
	}
	
	 public void move_Monkey() {
	    	int temp_x = monkeyposition_x+ monkeypropogate_x;
	    	int temp_y = monkeyposition_y+ monkeypropogate_y;
	        if(temp_x >= 0 && temp_x<=(Wonderland.SCREEN_WIDTH-width_monkeyimage)) {
	          	monkeyposition_x = monkeyposition_x + monkeypropogate_x;
	  	    }
	        if(temp_y >= 0 && temp_y<=(Wonderland.SCREEN_HEIGHT-height_monkeyimage)){
	        	monkeyposition_y = monkeyposition_y + monkeypropogate_y;
	        }
	    }
	
}
