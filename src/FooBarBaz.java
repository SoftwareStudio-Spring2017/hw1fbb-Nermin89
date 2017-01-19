

public class FooBarBaz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintFooBarGame();
		
	}

	public static void PrintFooBarGame(){
		
		for(int i=1; i <=50; i++){
			//If divisible by 3 and 5, say “Foo Bar”
			if(i%3==0 && i%5==0){
				System.out.println("Foo Bar");
			}
			//If your number is divisible by 3, say “Foo” 
			if(i%3==0){
				System.out.println("Foo");
			}
			////If your number is divisible by 5, say “Bar” 
			else if(i%5==0){
				System.out.println("Bar");
			}
			 
			else {
				System.out.println(i);
			}
		}
	}
}
