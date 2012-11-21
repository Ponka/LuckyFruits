import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUIReel extends JComponent implements ActionListener{
	
	private static int SPINNING_ANIMATION_FRAMES_COUNT = 3;
	boolean spinning;
	GUIFruit f ;
	
	BufferedImage bi[];
	int id;
	long animStartTime; 
	public GUIReel() {
		id = 0;
		bi = new BufferedImage[SPINNING_ANIMATION_FRAMES_COUNT];
		for(int x = 0 ; x < SPINNING_ANIMATION_FRAMES_COUNT ; x++){
			try{
				bi[x] = ImageIO.read(new File("pics/spinning"+x+".JPG"));
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		spinning = false;
		f = new GUIFruit(new Fruit(1));
		setPreferredSize(f.getPreferredSize());
		
	    Timer timer = new Timer(30, this);
        // initial delay while window gets set up
        timer.setInitialDelay(0);
        animStartTime = 1000 + System.nanoTime() / 1000000;
        timer.start();
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand() != null)
		if(e.getActionCommand().equals("PONKA")){
			spinning = !spinning;
			return;
		}
		System.out.println(""+e);
		id++;
		if(id == bi.length)
			id =0;
		repaint();
	}
	
	public void setSpinning(boolean b){
		spinning = b;
	}
	
	public void paintComponent(Graphics g){
		if(!spinning)f.paintComponent(g);
		else {
			g.drawImage(bi[id],0,0,null);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//	boolean done = false;
	//	System.out.println("START");
		//try {
			//t.wait(10);
//		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
		//}
		System.out.println("END");
		GUIReel r = new GUIReel();
		f.add(r);
		f.pack();
		f.setVisible(true);
		r.setSpinning(true);
		Timer t = new Timer(1000,r);
		t.setActionCommand("PONKA");
		t.start();
	}	

}
