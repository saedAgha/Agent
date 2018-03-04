package LogsDataProviders;

public class LogDataProvidersManager {

	public LogDataProvidersManager() {
		// TODO Auto-generated constructor stub
	}
	
	public IDataProvider GetLogDataProvider(String providerName)
	{
		IDataProvider provider=null;
		switch(providerName)
		{
		case "Windows":
			provider=new WindowsLogDataProvider();
			break;
		case "Linux":
			provider=new LinuxLogDataProvider();
			break;
		case "WindowsSnort":
			provider=new WindowsSnortLogDataProvider();
			break;
		case "LinuxSnort":
			provider=new LinuxSnortLogDataProvider();
			break;
		}
		return provider;
	}

}
