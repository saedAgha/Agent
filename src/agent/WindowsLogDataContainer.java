package agent;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import LogDataEntities.ILogData;
import LogDataEntities.WindowsLogData;

public class WindowsLogDataContainer {

	public WindowsLogDataContainer() {
		Schema = null;
		Data = new ArrayList<ILogData>();
	}

	public List<ILogData> Data;
	public ArrayList<String> Schema;

	public void SetSchema(List<String> values) {
		if(values==null || values.size()==0)return;
		Schema = new ArrayList<String>();
		for (int i = 0; i < values.size(); i++) {
			Schema.add(values.get(i));
		}

	}

	public void InsertNewEventLog(List<String> values) {
		// TODO Auto-generated method stub
		if (Schema == null || Schema.size() != values.size()) {
			// throw exception

		} else {
			Field chap;
			WindowsLogData eventLog = new WindowsLogData();
			Class<?> c = eventLog.getClass();

			try {
				for (int i = 0; i < Schema.size(); i++) {
					chap = c.getDeclaredField(Schema.get(i));
					chap.set(eventLog, values.get(i));
				}
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Data.add(eventLog);
		}

	}

}
