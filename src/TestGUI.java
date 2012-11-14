

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestGUI extends JFrame implements ActionListener{
	
	static final String BUTTON_SPIN  = "Spin";
	static final String BUTTON_HOLD1 = "Hold 1";
	static final String BUTTON_HOLD2 = "Hold 2";
	static final String BUTTON_HOLD3 = "Hold 3";
	static final String BUTTON_QUIT  = "Quit";
	
	String buttonsText[]  = { 
			BUTTON_SPIN, 
			BUTTON_HOLD1,
			BUTTON_HOLD2,
			BUTTON_HOLD3,
			BUTTON_QUIT
		};
	
	JButton b[] ;
	Axle x;
	
	TestGUI(){
		b = new JButton[buttonsText.length];
		setLayout(new GridLayout(0,2));
		for(int x = 0 ; x < b.length ; x++){
			b[x] = new JButton(buttonsText[x]);
			b[x].addActionListener(this);
			add(b[x]);
		}
		x = new Axle();
	}
	
	public void actionPerformed(ActionEvent e){
		String t = ((JButton)e.getSource()).getText();
		System.out.println(t);
		if(t.equals(BUTTON_SPIN)){
			Fruit f[] = x.spin();
			for(int x = 0 ; x < f.length; x++){
				System.out.printf("%3d|",f[x].id);
			}
			System.out.println();
		}
		if(t.equals(BUTTON_HOLD1)){
			x.toggleBlocked(0);
		}
		if(t.equals(BUTTON_HOLD2)){
			x.toggleBlocked(1);
		}
		if(t.equals(BUTTON_HOLD3)){
			x.toggleBlocked(2);
		}
		if(t.equals(BUTTON_QUIT)){
			System.exit(0);
		}
	}
	
	public static void main(String s[]){
		TestGUI t = new TestGUI();
		t.pack();
		t.setDefaultCloseOperation(EXIT_ON_CLOSE);
		t.setVisible(true);
	}
	
}
