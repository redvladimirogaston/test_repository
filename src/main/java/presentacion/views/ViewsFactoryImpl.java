package presentacion.views;

import business_logic.local.TestControllerImpl;
import presentacion.ViewsFactory;
import presentacion.TestPresenter;

public class ViewsFactoryImpl extends ViewsFactory {

	@Override
	public Presenter makePresenter() {
		return new TestPresenter(new TestView(), new TestControllerImpl());
	}
}
