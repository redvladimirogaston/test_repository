package business_logic.local;

import business_logic.TestController;

public class TestControllerImpl implements TestController {

	private String value;

	@Override
	public void store(String value) {
		this.value = value;
	}
	
	@Override
	public String retrieve() {
		return value;
	}
}
