import java.util.Random;

public class Reel {

	public static final int WHEEL_SIZE = 5;
	
	Fruit fruits[] ;
	
	Random rand = null;
	
	Reel(){
		fruits = new Fruit[WHEEL_SIZE];
		for( int x = 0 ; x < fruits.length ; x++){
			fruits[x] = new Fruit(x);
		}

		rand = new Random();
		
	}
	
	public Fruit spin(){
		return fruits[rand.nextInt(WHEEL_SIZE)];
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
