
public class Machine {

	
	public static final int STATE_WAITING  = 0b00000000000000000000000000000001; 
	
	public static final int BUTTON_SPIN 	= 1;
	public static final int BUTTON_HOLD1 	= 2;
	public static final int BUTTON_HOLD2 	= 3;
	public static final int BUTTON_HOLD3 	= 4;
	public static final int BUTTON_BUY 		= 5;
	public static final int BUTTON_CASHOUT 	= 6;
	//public static final int BUTTON_SPIN = 1;
	
	private static final int DEFAULT_MAX_SPINS_ON_HOLD = 2;
	
	private Axle axle;
	private Account account;
	private Fruit fruitsOnDisplay[];
	
	private int spinsOnHold;
	private int state;
	
	Machine(){
		axle = new Axle();
		account = new Account();
		fruitsOnDisplay = axle.spin();
		state = STATE_WAITING;
		spinsOnHold = 0;
	}		
	
	public void hold(int id){
		axle.toggleBlocked(id);
	}

	public void hold1(){
		this.hold(0);
	}
	
	public void hold2(){
		this.hold(1);
	}
	
	public void hold3(){
		this.hold(2);
	}
	
	public void spin() throws OutOfCredits {
		/* TODO: >?< async spinning machine?  */
		if(spinsOnHold == DEFAULT_MAX_SPINS_ON_HOLD)axle.unblockAll();
		
		if(!account.useCredit())throw new OutOfCredits();
		
		fruitsOnDisplay = axle.spin();
		
		// TODO:  Calculate the price 
		if(axle.isAnyBlocked())spinsOnHold++;
	}
	
	public Fruit[] getFruitsOnDisplay(){
		return fruitsOnDisplay;
	}
	
	public void cashOut(){
		// TODO: ?????? hi score needed >game over<
	}
	
	public void buyCredit() throws OutOfMoney{
		if(!account.buyCredit())throw new OutOfMoney();
	}

	public void pressButton(int id) throws OutOfMoney, OutOfCredits{
		switch(id){
		case BUTTON_BUY:
			this.buyCredit();
			break;
		case BUTTON_CASHOUT:
			break;
		case BUTTON_HOLD1:
			this.hold1();;
			break;
		case BUTTON_HOLD2:
			this.hold2();
			break;
		case BUTTON_HOLD3:
			this.hold3();
			break;
		case BUTTON_SPIN:
			this.spin();
			break;
		}
	}
	
	public int getState(){
		return state;
	}
	
	public void putIn(int amount){
		account.depositMoney(amount);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
