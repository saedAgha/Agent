package agent.configuration;

import java.util.Calendar;
import java.util.Date;
import agent.LogsConsts;
import agent.Utils;

public class LogsConfiguredData { //need to do inheretence here also

	private Configuration configuration;

	private String WindowsLogsSourceDir;
	private String LinuxLogsSourceDir;
	private String WindowsSnortLogsSourceDir;
	private String LinuxSnortLogsSourceDir;
	
	private String WindowsLogsInProcessDir;
	private String LinuxLogsInProcessDir;
	private String WindowsSnortLogsInProcessDir;
	private String LinuxSnortLogsInProcessDir;
	
	private String LogsDestinationDir;
 
	private String LinuxApplicationRootDir;
	private String WindowsApplicationRootDir;
	private int MinutesThreshold;
	private String SearchKeyWords;
	private long MinutesPeriod;
	private String LogBaseDate;
	private String[] LogDataProvidersNames;
	private String LogDateFormat;
	private String AgentID;

	public LogsConfiguredData() {
		configuration = new Configuration();
	}

	
	
	public String GetWindowsLogsSourceDir() {
		WindowsLogsSourceDir = configuration.Get(LogsConsts.LOGS_SOURCE_DIR_KEY_WINDOWS);
		if (Utils.isNullOrEmpty(WindowsLogsSourceDir)) {
			// for better implementation throw an error , make the user configure some data
			// for this key
			// for application to run load default values
			configuration.Set(LogsConsts.LOGS_SOURCE_DIR_KEY_WINDOWS, LogsConsts.WindowsLogsSourceDefaultValue);
			WindowsLogsSourceDir = LogsConsts.WindowsLogsSourceDefaultValue;
		}
		return WindowsLogsSourceDir;
	}
	
	public String GetLinuxLogsSourceDir() {
		LinuxLogsSourceDir = configuration.Get(LogsConsts.LOGS_SOURCE_DIR_KEY_LINUX);
		if (Utils.isNullOrEmpty(LinuxLogsSourceDir)) {
			// for better implementation throw an error , make the user configure some data
			// for this key
			// for application to run load default values
			configuration.Set(LogsConsts.LOGS_SOURCE_DIR_KEY_LINUX, LogsConsts.LinuxSnortLogsSourceDefaultValue);
			LinuxLogsSourceDir = LogsConsts.LinuxSnortLogsSourceDefaultValue;
		}
		return LinuxLogsSourceDir;
	}
	
	public String GetWindowsSnortLogsSourceDir() {
		WindowsSnortLogsSourceDir = configuration.Get(LogsConsts.LOGS_SOURCE_DIR_KEY_WINDOWS_SNORT);
		if (Utils.isNullOrEmpty(WindowsSnortLogsSourceDir)) {
			// for better implementation throw an error , make the user configure some data
			// for this key
			// for application to run load default values
			configuration.Set(LogsConsts.LOGS_SOURCE_DIR_KEY_WINDOWS_SNORT, LogsConsts.WindowsSnortLogsSourceDefaultValue);
			WindowsSnortLogsSourceDir = LogsConsts.WindowsSnortLogsSourceDefaultValue;
		}
		return WindowsSnortLogsSourceDir;
	}
	
	public String GetLinuxSnortLogsSourceDir() {
		LinuxSnortLogsSourceDir = configuration.Get(LogsConsts.LOGS_SOURCE_DIR_KEY_LINUX_SNORT);
		if (Utils.isNullOrEmpty(LinuxSnortLogsSourceDir)) {
			// for better implementation throw an error , make the user configure some data
			// for this key
			// for application to run load default values
			configuration.Set(LogsConsts.LOGS_SOURCE_DIR_KEY_LINUX_SNORT, LogsConsts.LinuxSnortLogsSourceDefaultValue);
			LinuxSnortLogsSourceDir = LogsConsts.LinuxSnortLogsSourceDefaultValue;
		}
		return LinuxSnortLogsSourceDir;
	}
    
	public String[] GetLogDataProvidersNames() {
		String NamesStr = configuration.Get(LogsConsts.LOG_DATA_PROVIDERS_NAMES);
		if (Utils.isNullOrEmpty(NamesStr)) {
			// for better implementation throw an error , make the user configure some data
			// for this key
			// for application to run load default values
			configuration.Set(LogsConsts.LOG_DATA_PROVIDERS_NAMES, LogsConsts.LogDataProvidersNameDefaultValue);
			NamesStr = LogsConsts.LogDataProvidersNameDefaultValue;
		}
		LogDataProvidersNames = NamesStr.split(",");
		return LogDataProvidersNames;
	}
 
	public String GetLogsDestinationDir() {
		LogsDestinationDir = configuration.Get(LogsConsts.CONVERTED_LOGS_DESTINATON_DIR_KEY);
		if (Utils.isNullOrEmpty(LogsDestinationDir)) {
			// for better implementation throw an error , make the user configure some data
			// for this key
			// for application to run load default values
			configuration.Set(LogsConsts.CONVERTED_LOGS_DESTINATON_DIR_KEY, LogsConsts.ConvertedLogsDefaultValue);
			LogsDestinationDir = LogsConsts.ConvertedLogsDefaultValue;
		}
		return LogsDestinationDir;
	}
	
	public String GetWindowsApplicationRootDir() {
		WindowsApplicationRootDir = configuration.Get(LogsConsts.CONVERTED_LOGS_DESTINATON_DIR_KEY);
		if (Utils.isNullOrEmpty(WindowsApplicationRootDir)) {
			// for better implementation throw an error , make the user configure some data
			// for this key
			// for application to run load default values
			configuration.Set(LogsConsts.APP_WINDOWS_ROOT_DIR, LogsConsts.AppWindowsRootDirDefaultValue);
			WindowsApplicationRootDir = LogsConsts.APP_WINDOWS_ROOT_DIR;
		}
		return WindowsApplicationRootDir;
	}
	
	public String GetLinuxApplicationRootDir() {
		LinuxApplicationRootDir = configuration.Get(LogsConsts.CONVERTED_LOGS_DESTINATON_DIR_KEY);
		if (Utils.isNullOrEmpty(LinuxApplicationRootDir)) {
			// for better implementation throw an error , make the user configure some data
			// for this key
			// for application to run load default values
			configuration.Set(LogsConsts.APP_LINUX_ROOT_DIR, LogsConsts.AppLinuxRootDirDefaultValue);
			LinuxApplicationRootDir = LogsConsts.APP_LINUX_ROOT_DIR;
		}
		return LinuxApplicationRootDir;
	}

 
	public String GetWindowsLogsInProcessDir() {
		WindowsLogsInProcessDir = configuration.Get(LogsConsts.WINDOWS_LOGS_IN_PROCESS_DIR_KEY);
		if (Utils.isNullOrEmpty(WindowsLogsInProcessDir)) {
			// for better implementation throw an error , make the user configure some data
			// for this key
			// for application to run load default values
			configuration.Set(LogsConsts.WINDOWS_LOGS_IN_PROCESS_DIR_KEY, LogsConsts.WindowsLogsInProcessDefaultValue);
			WindowsLogsInProcessDir = LogsConsts.WindowsLogsInProcessDefaultValue;
		}
		return WindowsLogsInProcessDir;
	}
	
	public String GetLinuxLogsInProcessDir() {
		LinuxLogsInProcessDir = configuration.Get(LogsConsts.LINUX_LOGS_IN_PROCESS_DIR_KEY);
		if (Utils.isNullOrEmpty(LinuxLogsInProcessDir)) {
			// for better implementation throw an error , make the user configure some data
			// for this key
			// for application to run load default values
			configuration.Set(LogsConsts.LINUX_LOGS_IN_PROCESS_DIR_KEY, LogsConsts.LinuxLogsInProcessDefaultValue);
			LinuxLogsInProcessDir = LogsConsts.LinuxLogsInProcessDefaultValue;
		}
		return LinuxLogsInProcessDir;
	}
	
	public String GetWindowsSnortLogsInProcessDir() {
		WindowsSnortLogsInProcessDir = configuration.Get(LogsConsts.WINDOWS_SNORT_LOGS_IN_PROCESS_DIR_KEY);
		if (Utils.isNullOrEmpty(WindowsSnortLogsInProcessDir)) {
			// for better implementation throw an error , make the user configure some data
			// for this key
			// for application to run load default values
			configuration.Set(LogsConsts.WINDOWS_SNORT_LOGS_IN_PROCESS_DIR_KEY, LogsConsts.WindowsSnortLogsInProcessDefaultValue);
			WindowsSnortLogsInProcessDir = LogsConsts.WindowsSnortLogsInProcessDefaultValue;
		}
		return WindowsSnortLogsInProcessDir;
	}
	
	public String GetLinuxSnortLogsInProcessDir() {
		LinuxSnortLogsInProcessDir = configuration.Get(LogsConsts.LINUX_SNORT_LOGS_IN_PROCESS_DIR_KEY);
		if (Utils.isNullOrEmpty(LinuxSnortLogsInProcessDir)) {
			// for better implementation throw an error , make the user configure some data
			// for this key
			// for application to run load default values
			configuration.Set(LogsConsts.LINUX_SNORT_LOGS_IN_PROCESS_DIR_KEY, LogsConsts.LinuxSnortLogsInProcessDefaultValue);
			LinuxSnortLogsInProcessDir = LogsConsts.LinuxSnortLogsInProcessDefaultValue;
		}
		return LinuxSnortLogsInProcessDir;
	}
	

	public int GetMinutesThreshold() {
		String MinutesThresholdStr = configuration.Get(LogsConsts.MINUTES_TO_SPLIT_LOGS_KEY);
		if (Utils.isNullOrEmpty(MinutesThresholdStr)) {
			// for better implementation throw an error , make the user configure some data
			// for this key
			// for application to run load default values
			configuration.Set(LogsConsts.MINUTES_TO_SPLIT_LOGS_KEY, LogsConsts.MinuteToSplitDefaultValue);
			MinutesThresholdStr = configuration.Get(LogsConsts.MINUTES_TO_SPLIT_LOGS_KEY);
		}
		MinutesThreshold = Integer.parseInt(MinutesThresholdStr);
		return MinutesThreshold;
	}

	public String GetSearchKeyWords() {
		SearchKeyWords = configuration.Get(LogsConsts.SEARCH_SUFFIX_FILTER_KEY_WORDS);
		if (Utils.isNullOrEmpty(SearchKeyWords)) {
			// for better implementation throw an error , make the user configure some data
			// for this key
			// for application to run load default values
			configuration.Set(LogsConsts.SEARCH_SUFFIX_FILTER_KEY_WORDS, LogsConsts.SearchKeywordDefaultValue);
			SearchKeyWords = LogsConsts.SearchKeywordDefaultValue;
		}
		return SearchKeyWords;
	}

	public String GetLogDateFormat() {
		LogDateFormat = configuration.Get(LogsConsts.LOG_DATE_FORMAT_KEY);
		if (Utils.isNullOrEmpty(LogDateFormat)) {
			// for better implementation throw an error , make the user configure some data
			// for this key
			// for application to run load default values
			configuration.Set(LogsConsts.LOG_DATE_FORMAT_KEY, LogsConsts.LogDateFormatDefaultValue);
			LogDateFormat = LogsConsts.LogDateFormatDefaultValue;
		}
		return LogDateFormat;
	}
	
	public String GetAgentID() {
		AgentID = configuration.Get(LogsConsts.AGENT_ID);
		if (Utils.isNullOrEmpty(AgentID)) {
			// for better implementation throw an error , make the user configure some data
			// for this key
			// for application to run load default values
			configuration.Set(LogsConsts.AGENT_ID, LogsConsts.AgentIDDefaultValue);
			AgentID = LogsConsts.AgentIDDefaultValue;
		}
		return AgentID;
	}

	public long GetMinutesPeriod(String providerName)   {
		long minutesPeriod = 2880;// last 48 hours by default
		Date currentDate = new Date();
		Date lastProcessedDate;
		
		String lastProcessedDateStr ="";
		if(providerName=="Windows")
		{
			lastProcessedDateStr = GetWindowsLogLastProcessedDate();
		}
		else if (providerName=="Linux")
		{
			lastProcessedDateStr = GetLinuxLogLastProcessedDate();
		}
		else if (providerName=="WindowsSnort")
		{
			lastProcessedDateStr = GetWindowsSnortLogLastProcessedDate();
		}
		else if (providerName=="LinuxSnort")
		{
			lastProcessedDateStr = GetLinuxSnortLogLastProcessedDate();
		}
	    System.out.println("configuration "+lastProcessedDateStr);
		if (!Utils.isNullOrEmpty(lastProcessedDateStr)) {
			lastProcessedDate = new Date(lastProcessedDateStr);
			minutesPeriod = Math.abs(Utils.GetDatesDiffInMinutes(lastProcessedDate, currentDate));
		}
		return minutesPeriod;

	}

	// this field is optional to fill by the user, it can be empty string
	public String GetWindowsLogLastProcessedDate() {
		LogBaseDate = configuration.Get(LogsConsts.WINDOWS_LOG_BASE_DATE_KEY);
		return LogBaseDate;
	}
	
	public String GetLinuxLogLastProcessedDate() {
		LogBaseDate = configuration.Get(LogsConsts.LINUX_LOG_BASE_DATE_KEY);
		return LogBaseDate;
	}
	
	public String GetWindowsSnortLogLastProcessedDate() {
		LogBaseDate = configuration.Get(LogsConsts.WINDOWS_SNORT_LOG_BASE_DATE_KEY);
		return LogBaseDate;
	}
	
	public String GetLinuxSnortLogLastProcessedDate() {
		LogBaseDate = configuration.Get(LogsConsts.LINUX_SNORT_LOG_BASE_DATE_KEY);
		return LogBaseDate;
	}

	public void SetLogLastProcessedDate(String dateStr,String providerName) {
		if(providerName=="Windows")
		{
			configuration.Set(LogsConsts.WINDOWS_LOG_BASE_DATE_KEY, dateStr);
		}
		else if (providerName=="Linux")
		{
			configuration.Set(LogsConsts.LINUX_LOG_BASE_DATE_KEY, dateStr);
		}
		else if (providerName=="Snort")
		{
			configuration.Set(LogsConsts.WINDOWS_SNORT_LOG_BASE_DATE_KEY, dateStr);
		}
//		else if (providerName=="Snort")//to change
//		{
//			configuration.Set(LogsConsts.LINUX_SNORT_LOG_BASE_DATE_KEY, dateStr);
//		}
	}


	public void SetMinutesPeriod(String minutePeriod) {
		configuration.Set(LogsConsts.MINUTES_PERIOD, minutePeriod);
	}

}
