
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
		for(int x = 0 ; x < blocked.length ; x++){
			blocked[x] = false;
		}
	}
	
	public Fruit[] spin(){
		Fruit ret[] = new Fruit[AXLE_SIZE];
		for(int x = 0 ; x < AXLE_SIZE ; x++){
			if(!blocked[x]){
				ret[x] = reels[x].spin();
			}else{
				ret[x] = reels[x].getCurrent();
			}
		}
		return ret;
	}
	
	public void unblockAll(){
		for(int x = 0 ; x < blocked.length ; x++){
			blocked[x] = false;
		}
	}
	
	public boolean[] getBlocked(){
		return blocked;
	}
	
	public void setBlocked(int id, boolean b){
		blocked[id] = b;
	}
	
	public void toggleBlocked(int r){
		blocked[r] = !blocked[r];
	}
	
	public boolean isAnyBlocked(){
		for(int x = 0 ; x < blocked.length ; x++){
			if(blocked[x])return true;
		}
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Axle a = new Axle();
		Fruit f[] = a.spin();
		for(int x = 0 ; x < f.length; x++){
			System.out.printf("%3d|",f[x].getId());
		}
		System.out.println();
		
		
		a.toggleBlocked(0);
		f = a.spin();
		for(int x = 0 ; x < f.length; x++){
			System.out.printf("%3d|",f[x].getId());
		}
		System.out.println();
		
		a.toggleBlocked(1);
		f = a.spin();
		for(int x = 0 ; x < f.length; x++){
			System.out.printf("%3d|",f[x].getId());
		}
		System.out.println();

		a.unblockAll();
		f = a.spin();
		for(int x = 0 ; x < f.length; x++){
			System.out.printf("%3d|",f[x].getId());
		}
		System.out.println();
	}
}
