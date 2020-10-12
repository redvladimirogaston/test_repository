package presentacion;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import business_logic.TestController;
import presentacion.views.TestView;
import presentacion.views.ViewUtils;

class WorkbenchPresenterTest {

	TestView view =  new TestView();
	TestController controller =  Mockito.mock(TestController.class);
	TestPresenter presenter = new TestPresenter(view, controller);
	
	@Test
	void testColorInputChange() {
		JTextField input = (JTextField) ViewUtils.getChildNamed(view, TestView.INPUT);
		input.setText("");
		JButton button = (JButton) ViewUtils.getChildNamed(view, TestView.BUTTON);
		button.doClick();
		Assertions.assertTrue(input.getBackground().equals(Color.YELLOW));
	}
	
	@Test
	void testColorInputDoesntChange() {
		JTextField input = (JTextField) ViewUtils.getChildNamed(view, TestView.INPUT);
		input.setText("Susan Doe");
		JButton button = (JButton) ViewUtils.getChildNamed(view, TestView.BUTTON);
		button.doClick();
		Assertions.assertTrue(input.getBackground().equals(Color.WHITE));
	}
}