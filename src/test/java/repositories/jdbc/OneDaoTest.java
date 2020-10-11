package repositories.jdbc;

import repositories.DaosFactory;

public class OneDaoTest {

	private DaosFactory factory = setup();

	public DaosFactory setup() {
		DataSource ds = new H2DataSource();
		DaosFactory.setFactory(new DaosFactoryImpl(ds.getConnection()));
		return DaosFactory.getFactory();
	}
}