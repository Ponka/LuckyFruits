import java.util.Random;

public class Reel {

	public static final int REEL_SIZE = Fruit.FRUIT_MAX;
	
	Fruit fruits[] ;
	int current;
	Random rand = null;
	
	Reel(){
		fruits = new Fruit[REEL_SIZE];
		for( int x = 0 ; x < fruits.length ; x++){
			fruits[x] = new Fruit(x);
		}

		rand = new Random();
		randomizeCurrent();
	}
	
	public Fruit getCurrent(){
		return fruits[current];
	}
	
	private void randomizeCurrent(){
		current = rand.nextInt(REEL_SIZE);
	}
	
	public Fruit spin(){
		randomizeCurrent();
		return getCurrent();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
