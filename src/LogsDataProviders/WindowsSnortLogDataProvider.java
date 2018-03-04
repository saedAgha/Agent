package LogsDataProviders;

import java.io.File;

import LogSplitters.LogSplitter;
import LogSplitters.SnortLogSplitter;
import agent.configuration.LogsConfiguredData;

public class WindowsSnortLogDataProvider implements IDataProvider {
	
	public  final String PROVIDER_NAME = "WindowsSnort";
	private LogsConfiguredData configuredData;
	public  final String FILE_EXTENSION = "csv";
	public  final String FILE_NAME = SnortLogSplitter.SPLITER_NAME+"."+FILE_EXTENSION;

	private File inProcessLogsDir;
	private LogSplitter windowsSnortLogsSplitter;
	public WindowsSnortLogDataProvider() {
		configuredData= new LogsConfiguredData();
		inProcessLogsDir=new File(configuredData.GetWindowsSnortLogsInProcessDir());
		windowsSnortLogsSplitter = new SnortLogSplitter();
	}
// 
//	@Override
//	public String ExtractLogs(String dest) {
//	    throw new UnsupportedOperationException(); 
//	}

	@Override
	public String ExtractLogs(String dest) {
		System.out.println("ExtractLogs Started");	

		long diffInMinutes = configuredData.GetMinutesPeriod(PROVIDER_NAME);
		String inProgressDest = inProcessLogsDir.getPath();
		windowsSnortLogsSplitter.SplitFilePerMinutes(inProgressDest, diffInMinutes);
		System.out.println("ExtractLogs Finished");	
		return dest+"\\"+FILE_NAME;
	}

}
