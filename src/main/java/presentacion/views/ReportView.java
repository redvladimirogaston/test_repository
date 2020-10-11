package presentacion.views;

import java.util.List;

public interface ReportView<T> {

	void setData(List<T> entities);

	void open();
}
