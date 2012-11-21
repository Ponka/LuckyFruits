import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUIFruit extends JPanel {
	/**
	 * GUIReel is for spinning. Here picture only.
	 * 
	 * 
	 * 
	 * 
	 */
	private static final String IMAGES_DIRECTORY = "pics/";
	
	BufferedImage img;
	GUIFruit(Fruit f){
		String path = IMAGES_DIRECTORY;
		
		switch(f.getId()){
		case Fruit.STRAWBERRY:
			path += "strawberry.jpg" ;
			break;
		case Fruit.CHERRIES:
			path+="cherries.JPG";
			break;
			default:
				path +="default.JPG";
				break;
		}

		try{
			img = ImageIO.read(new File(path));
		}catch(Exception e){
			e.printStackTrace();
		}
		int h = img.getHeight();
		int w = img.getWidth();
		setPreferredSize(new Dimension(h, w));		
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, null);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		GUIFruit fr = new GUIFruit(new Fruit(1));
		f.add(fr);
		f.pack();

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
