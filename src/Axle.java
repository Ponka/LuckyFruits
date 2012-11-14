
public class Axle {

	public static final int AXLE_SIZE = 3;
	
	Reel reels[];
	boolean blocked[];
	
	
	Axle(){
		reels = new Reel[AXLE_SIZE];
		for(int x = 0 ; x < reels.length ; x++){
			reels[x] = new Reel();
		}
		blocked = new boolean[AXLE_SIZE];
	}
	
	public Fruit[] spin(){
		Fruit ret[] = new Fruit[AXLE_SIZE];
		for(int x = 0 ; x < AXLE_SIZE ; x++){
			ret[x] = reels[x].spin();
		}
		return ret;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Axle a = new Axle();
		Fruit f[] = a.spin();
		for(int x = 0 ; x < f.length; x++){
			System.out.printf("%3d|",f[x].id);
		}
		System.out.println();
	}

}
