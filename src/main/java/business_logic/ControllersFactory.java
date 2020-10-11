package business_logic;

import repositories.DaosFactory;

public abstract class ControllersFactory {

	private static ControllersFactory concreteFactory;
	protected DaosFactory daos;

	public void setDaosFactory(DaosFactory daosf) {
		this.daos = daosf;
	}

	public static void setFactory(ControllersFactory factory) {
		assert factory != null;
		concreteFactory = factory;
	}

	public static ControllersFactory getFactory() {
		assert concreteFactory != null;
		return concreteFactory;
	}
}
