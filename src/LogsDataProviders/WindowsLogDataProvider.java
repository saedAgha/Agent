package LogsDataProviders;

import java.io.File;

import LogDataEntities.WindowsLogData;
import LogSplitters.LogSplitter;
import LogSplitters.WindowsLogSplitter;
import agent.OSCommands.ILogCommand;
import agent.OSCommands.OSCommandExecuter;
import agent.OSCommands.PowerShellCommands;
import agent.configuration.LogsConfiguredData;

public class WindowsLogDataProvider implements IDataProvider {
	
	private LogsConfiguredData configuredData;
	public  final String PROVIDER_NAME = "Windows";
	public  final String FILE_EXTENSION = "evtx.csv";
	public  final String FILE_NAME = WindowsLogData.EntityName+"."+FILE_EXTENSION;

	private File inProcessLogsDir;
	private ILogCommand cmd;
	private LogSplitter windowsLogsSplitter;
	
	
	private void cleanDirectory(File dir) {
		File[] files = dir.listFiles();
		boolean success=true;
		for (File file : files) {
			  success = file.delete();
				System.out.println(success);

			// TODO: in case file didn't delete log this scenario
		}
	}
	
	public WindowsLogDataProvider() 
	{
		configuredData= new LogsConfiguredData();
		inProcessLogsDir = new File(configuredData.GetWindowsLogsInProcessDir()+"\\"+FILE_NAME);
		inProcessLogsDir.mkdirs();
		cmd = new PowerShellCommands();
		windowsLogsSplitter= new WindowsLogSplitter(configuredData.GetLogsDestinationDir(),configuredData.GetWindowsLogsInProcessDir());
	}
    public void CollectLogs (String dest,long FileSlotTimeinMinutes)
    {
		inProcessLogsDir = new File(configuredData.GetWindowsLogsInProcessDir());
		inProcessLogsDir.mkdirs();
    	cleanDirectory(inProcessLogsDir);
    	String getLogsCommand = cmd.GetLogsCommand(dest,FileSlotTimeinMinutes);
	    OSCommandExecuter.getInstance().runCommand(getLogsCommand);
		
    	  getLogsCommand = cmd.SortFiles();
		 OSCommandExecuter.getInstance().runCommand(getLogsCommand);
		
    }
 
	@Override
	public String ExtractLogs(String dest) 
	{
      
		long diffInMinutes = configuredData.GetMinutesPeriod(PROVIDER_NAME);
	    String inProgressDest = inProcessLogsDir.getPath();
		CollectLogs(inProgressDest,diffInMinutes);
		windowsLogsSplitter.SplitFilePerMinutes(inProgressDest, diffInMinutes);
		 
		return dest+"\\"+FILE_NAME;
		
	}

	 

}
