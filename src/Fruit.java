public class Fruit {

	public static final int STRAWBERRY = 0;
	public static final int CHERRIES = 1;
	
	public final static int FRUIT_MAX = 5;
	
	private int id;
	
	Fruit(int id){
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
