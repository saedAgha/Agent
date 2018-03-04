package LogsDataProviders;

import java.io.File;

import LogSplitters.LogSplitter;
import LogSplitters.SnortLogSplitter;
import agent.configuration.LogsConfiguredData;

public class LinuxSnortLogDataProvider implements IDataProvider {
	
	public  final String PROVIDER_NAME = "LinuxSnort";
	private LogsConfiguredData configuredData;
	public  final String FILE_EXTENSION = "csv";
	public  final String FILE_NAME = SnortLogSplitter.SPLITER_NAME+"."+FILE_EXTENSION;

	private File inProcessLogsDir;
	private LogSplitter linuxSnortLogsSplitter;
	public LinuxSnortLogDataProvider() 
	{
		configuredData= new LogsConfiguredData();
		inProcessLogsDir = new File(configuredData.GetLinuxSnortLogsInProcessDir());
		inProcessLogsDir.mkdirs();
		linuxSnortLogsSplitter=new SnortLogSplitter();
	}

 
	@Override
	public String ExtractLogs(String dest) {
		long diffInMinutes = configuredData.GetMinutesPeriod(PROVIDER_NAME);
		String inProgressDest = inProcessLogsDir.getPath();
		linuxSnortLogsSplitter.SplitFilePerMinutes(inProgressDest, diffInMinutes);
		 
		return dest+"\\"+FILE_NAME;
	}

}
