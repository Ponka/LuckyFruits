import java.math.BigDecimal;


public class Account {
	
	//float money;
	int credits;
	
	BigDecimal money;
	
	BigDecimal creditPrice ;
	
	Account(){
		money = new BigDecimal("0.00");
		creditPrice = new BigDecimal("0.50");
	}
	
	public boolean buyCredit(){
		if(!withdrawMoney(creditPrice))return false;
		credits++;
		return true;
	}
	
	public boolean useCredit(){
		if(credits <= 0)return false;
		credits--;
		return true;
	}
	
	public boolean withdrawMoney(BigDecimal amount){
		if(money.subtract(amount).compareTo(new BigDecimal(0)) == 0)
			return false;
		money = money.subtract(amount);
		return true;
	}
	
	public void depositMoney(int amount){
		BigDecimal tmp  = new BigDecimal(amount);
		money = money.add(tmp);
	}
	
	public void depositMoney(BigDecimal amount){
		money = money.add(amount);
		
	}
	public String toString(){
		return "   Money: "+money+"   Credits: "+credits;
	}
	
	public static void main(String x[]){
		Account a = new Account();
		System.out.println(a);
		a.depositMoney(new BigDecimal("10.20"));
		System.out.println(a);
		a.buyCredit();
		System.out.println(a);
	}
}
