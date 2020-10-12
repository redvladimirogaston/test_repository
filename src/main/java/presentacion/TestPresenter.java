package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import business_logic.TestController;
import presentacion.views.Presenter;
import presentacion.views.TestView;

public class TestPresenter implements Presenter {

	private TestView view;

	private TestController controller;
	
	public TestPresenter(TestView view, TestController controller) {
		super();
		this.view = view;
		this.controller = controller;
		injectActions();
	}

	private void injectActions() {
		view.addSaveAction(a->onSave(a));
		view.addColorInputFocusAction(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				view.setColorInputBackground(Color.WHITE);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
			}
		});
	}
		
	public void onSave(ActionEvent a) {
		String value = view.getValue();
		if(!value.trim().isEmpty()) {
			controller.store(value);
		} else {
			view.setColorInputBackground(Color.YELLOW);
		}
	}
	
	@Override
	public void onInit() {
		view.display();
	}
}
