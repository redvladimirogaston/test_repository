
public class Application {

	public String makeGreeting() {
		return "Hello";
	}
	
	public void printGreeting(String greeting) {
		System.out.println(greeting);
	}
	
	public static void main(String[] args) {
		
		Application app = new Application();
		app.printGreeting(app.makeGreeting());
	}

}
