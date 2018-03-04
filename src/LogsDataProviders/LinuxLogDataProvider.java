package LogsDataProviders;

import java.io.File;
import LogSplitters.LinuxLogSplitter;
import LogSplitters.LogSplitter;
import agent.OSCommands.ILogCommand;
import agent.OSCommands.LinuxTerminalCommands;
import agent.OSCommands.OSCommandExecuter;
import agent.configuration.LogsConfiguredData;

public class LinuxLogDataProvider implements IDataProvider {
    
	public  final String PROVIDER_NAME = "Linux";
	private LogsConfiguredData configuredData;
	public  final String FILE_EXTENSION = "csv";
	public  final String FILE_NAME = LinuxLogSplitter.SPLITER_NAME+"."+FILE_EXTENSION;
	
	private File inProcessLogsDir;
	private ILogCommand cmd;
	private LogSplitter linuxLogsSplitter;
	public LinuxLogDataProvider() 
	{
		configuredData= new LogsConfiguredData();
		inProcessLogsDir = new File(configuredData.GetLinuxLogsInProcessDir());
		inProcessLogsDir.mkdirs();
		cmd = new LinuxTerminalCommands();
		linuxLogsSplitter= new LinuxLogSplitter();
	}

//	@Override
//	public String CollectLogs() {
//		String getLogsCommand = cmd.GetLogsCommand(inProcessLogsDir);
//		
//		return dest+"\\"+FILE_NAME;
//	}

	@Override
	public String ExtractLogs(String dest) {
		    long diffInMinutes = configuredData.GetMinutesPeriod(PROVIDER_NAME);
	        String inProgressDest = inProcessLogsDir.getPath()+"\\"+FILE_NAME;
	        String getLogsCommand = cmd.GetLogsCommand(inProgressDest);
	        OSCommandExecuter.getInstance().runCommand(getLogsCommand);
	        linuxLogsSplitter.SplitFilePerMinutes(inProgressDest, diffInMinutes);
			 
			return dest+"\\"+FILE_NAME;
	}

}
