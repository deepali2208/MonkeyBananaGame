package Function;

import Function.Wonderland;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;


public class Banana {
	private int bananaposition_x;
	private int bananaposition_y;
	private int width_bananaimage = Wonderland.STEP_SIZE;
	private int height_bananaimage = Wonderland.STEP_SIZE;
	private Image bananaImage;
	
	public int getwidth_bananaimage() {
		return width_bananaimage;
	}

	public void setwidth_bananaimage(int width_bananaimage) {
		this.width_bananaimage = width_bananaimage;
	}

	public int getheight_bananaimage() {
		return height_bananaimage;
	}

	public void setheight_bananaimage(int height_bananaimage) {
		this.height_bananaimage = height_bananaimage;
	}
	public Image getBananaImage() {
		return bananaImage;
	}

	public void setBananaImage(Image bananaImage) {
		this.bananaImage = bananaImage;
	}

	public int getbananaposition_x() {
		return bananaposition_x;
	}

	public void setbananaposition_x(int bananaposition_x) {
		this.bananaposition_x = bananaposition_x;
	}

	public int getbananaposition_y() {
		return bananaposition_y;
	}
	public void setbananaposition_y(int bananaposition_y) {
		this.bananaposition_y = bananaposition_y;
	}
	public Banana(){
		locationBanana();
	}
	
	private void locationBanana() {
		ImageIcon bananaimage_icon = new ImageIcon("Images/banana.png");
		Image scaleImage_banana = bananaimage_icon.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
		bananaImage = ( new ImageIcon(scaleImage_banana)).getImage();
		putBananaRandomly();
	}

	public void putBananaRandomly() {
		Random random = new Random();
		bananaposition_x = Wonderland.STEP_SIZE*random.nextInt(Wonderland.GRID_COUNT);
		bananaposition_y = Wonderland.STEP_SIZE*random.nextInt(Wonderland.GRID_COUNT);
	}
}
