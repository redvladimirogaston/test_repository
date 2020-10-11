
package main;

import presentacion.ViewsFactory;
import presentacion.views.ViewsFactoryImpl;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import business_logic.ControllersFactory;
import business_logic.local.ControllersFactoryImpl;
import repositories.DaosFactory;
import repositories.jdbc.DaosFactoryImpl;
import repositories.jdbc.DataSource;
import repositories.jdbc.DataSourceFactory;
import repositories.jdbc.DataSourceFactory.DataSourceType;
import repositories.jdbc.DataSourceFactoryImpl;

public class Application {

	public Application setUpLookAndFeel() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			try {
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return this;
	}

	public Application presentationLogic(ViewsFactory factory) {
		ViewsFactory.setFactory(factory);
		ViewsFactory.getFactory().setControllers(ControllersFactory.getFactory());
		return this;
	}

	public Application persitenceLogic(DaosFactory factory) {
		DaosFactory.setFactory(factory);
		return this;
	}

	public Application domainLogic(ControllersFactory factory) {
		ControllersFactory.setFactory(factory);
		ControllersFactory.getFactory().setDaosFactory(DaosFactory.getFactory());
		return this;
	}

	public void onInit() {
		ViewsFactory.getFactory().makePresenter().onInit();
	}

	public static void main(String[] args) {
		DataSourceFactory.setFactory(new DataSourceFactoryImpl());
		DataSource ds = DataSourceFactory.getFactory().makeDataSource(DataSourceType.IN_MEMORY);
		ds.getConnection();

		new Application().setUpLookAndFeel().persitenceLogic(new DaosFactoryImpl(ds.getConnection()))
				.domainLogic(new ControllersFactoryImpl()).presentationLogic(new ViewsFactoryImpl()).onInit();
	}
}