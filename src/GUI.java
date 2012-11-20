import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI extends JPanel{
	
	private Fruit[] fruits;
	
	GUI(Fruit fruits[]){
		
		showMachine();
	}
	
	private void showMachine(){
		
	}

	private void startSpinning(){}
	private void stopSpinning(){}
	private void setFruits(Fruit [] fruits){}
	private void setButtonPressed(){}
	
	static public void main(String args[]){
		Axle a = new Axle();
		GUI gui = new GUI(a.spin());
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(gui);
		f.pack();
		f.setVisible(true);
	}
}
