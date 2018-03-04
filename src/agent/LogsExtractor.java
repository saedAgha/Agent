package agent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import LogsDataProviders.IDataProvider;
import LogsDataProviders.LogDataProvidersManager;
import agent.configuration.LogsConfiguredData;

public class LogsExtractor {


	private File deliveryLogsDir;
	private LogsConfiguredData configuredData;
	 
	private LogDataProvidersManager logsDataProvidersFactory;

	private void cleanDirectory(File dir) {
		File[] files = dir.listFiles();
		for (File file : files) {
			file.delete();
			// TODO: in case file didn't delete log this scenario
		}
	}

	private void initHandlerDirectories() {
		deliveryLogsDir = new File(configuredData.GetLogsDestinationDir());
		deliveryLogsDir.mkdirs();
	//	cleanDirectory(deliveryLogsDir);
		
	}

	public LogsExtractor() {
		configuredData = new LogsConfiguredData();
		logsDataProvidersFactory = new LogDataProvidersManager();
		initHandlerDirectories();
	}
	
	public void Run()
	{
		System.out.println("LogExtractor Processing ...");
 
		String [] dataProvidersNames = configuredData.GetLogDataProvidersNames();
		List<IDataProvider>providerList = new ArrayList<IDataProvider>();
		boolean isWindowsOS=false;
		for(String dataProviderName : dataProvidersNames)
		{
			if(dataProviderName.toLowerCase().contains("windows"))isWindowsOS=true;
			providerList.add(logsDataProvidersFactory.GetLogDataProvider(dataProviderName));
		}
		if(isWindowsOS)
		{
			File file  = new File(configuredData.GetWindowsApplicationRootDir());
			file.mkdirs();
		}
		else
		{
			File file  = new File(configuredData.GetLinuxApplicationRootDir());
			file.mkdirs();
		}
		for(IDataProvider dataProvider:providerList )
		{
			dataProvider.ExtractLogs(deliveryLogsDir.getPath());
		}
		
		System.out.println("LogExtractor Finish!");	
	}
    
 

//	public void SplitLogsPerConfiguredMinutes() {
//		ArrayList<String> winLogs = listFilesForFolder(downloadedLogsDir);
//		LogSplitter splitter = new LogSplitter(winLogs, deliveryLogsDir.getPath(), downloadedLogsDir.getPath());
//		splitter.SplitPerConfiguredMinutes();
//	}

//	private String getSearchKeyWords() {
//
//		String value = configuredData.GetSearchKeyWords();
//
//		return value;
//	}

	

//	public void CollectLogs() {
//
//		try {
//
//			long minutesPeriod = GetMinutesPeriod();
//			String searchKeywords = getSearchKeyWords();
//			CollectLogData(searchKeywords, minutesPeriod);
//		} catch (IOException e) {
//			// log error
//			e.printStackTrace();
//		}
//
//	}

//	public List<String> GetLogFileNames() {
//		File folder = new File(windowsLogsDir.getPath());
//		String suffix = "Security.evtx";
//		File[] listOfFiles = folder.listFiles();
//		List<String> list = new ArrayList<String>();
//		String fileName = "";
//		for (int i = 0; i < listOfFiles.length; i++) {
//			if (listOfFiles[i].isFile()) {
//				fileName = listOfFiles[i].getName();
//				if (fileName.endsWith(suffix) && !fileName.contains(" ")) {
//					list.add(fileName.replace(".evtx", ""));
//				}
//			}
//		}
//		return list;
//
//	}

//	public void CollectLogData(String logFileName, long minutesPeriod) throws IOException {
//		System.out.println("DownloadLogs Begin");
//	 
//		String dest = downloadedLogsDir.getPath() + "\\Logs.evtx.csv";
//		psExecuter.ExportLogsToCSV(dest, minutesPeriod);
//		 
//		// check with Segie how to do it because it doesn't work well
//		
//
//		System.out.println("DownloadLogs End");
//	}

}
