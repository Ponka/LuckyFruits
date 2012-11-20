

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TestGUI extends JFrame implements ActionListener{
	
	static final String LABEL_ACCOUNT = "Account: ";
	static final String BUTTON_BUY_CREDITS  = "Buy credits";
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
			BUTTON_QUIT,
			BUTTON_BUY_CREDITS
			
		};
	
	JButton b[] ;
	Axle x;
	JLabel accountLabel;
	JPanel topPanel;
	JPanel bottomPanel;
	
	Account account;
	
	TestGUI(){
		setLayout(new BorderLayout());
		
		
		b = new JButton[buttonsText.length];
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(0,2));
		for(int x = 0 ; x < b.length ; x++){
			b[x] = new JButton(buttonsText[x]);
			b[x].addActionListener(this);
			bottomPanel.add(b[x]);
		}
		x = new Axle();
		
		account = new Account();
		account.depositMoney(200);
		
		topPanel = new JPanel();
		accountLabel = new JLabel(LABEL_ACCOUNT + account.toString());
		topPanel.add(accountLabel);
		
		add(topPanel,BorderLayout.NORTH);
		add(bottomPanel,BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e){
		String t = ((JButton)e.getSource()).getText();
		System.out.println(t);
		if(t.equals(BUTTON_SPIN)){
			
			if(!account.useCredit()){
				JOptionPane.showMessageDialog(this, "NO CREDITS!");

				return;
			}
			Fruit f[] = x.spin();
			for(int x = 0 ; x < f.length; x++){
				System.out.printf("%3d|",f[x].getId());
			}
			System.out.println();
			accountLabel.setText(LABEL_ACCOUNT + account.toString());
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
		if(t.equals(BUTTON_BUY_CREDITS)){
			if(!account.buyCredit()){
				JOptionPane.showMessageDialog(this, "ACCOUNT IS EMPTY! INSERT A COIN");
				return;
			}
			accountLabel.setText(LABEL_ACCOUNT + account.toString());
		}
	}
	
	public static void main(String s[]){
		TestGUI t = new TestGUI();
		t.pack();
		t.setDefaultCloseOperation(EXIT_ON_CLOSE);
		t.setVisible(true);
	}
	
}
