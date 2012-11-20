
public class PriceCalc {

	PriceCalc(){
		
	}

	public int calculate(Fruit[] fruits){
		int first = fruits[0].getId();
		for(int x = 1 ; x < fruits.length ; x++){
			if(fruits[x].getId() != first)return 0;
		}
		return whatPrice(first);
	}
	
	private int whatPrice(int id){
		switch(id){
		case 0:
			return 10;
		case 1:
			return 20;
		case 3:
			return 50;
		case 2: 
			return 25;
		case 4:
			return 100;
		}
		return 0;
	}
}
