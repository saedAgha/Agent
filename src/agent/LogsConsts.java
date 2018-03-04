package agent;

public class LogsConsts {

	public static final String MINUTES_TO_SPLIT_LOGS_KEY = "minutesForSplitingLogs";
	public static final String SEARCH_SUFFIX_FILTER_KEY_WORDS = "SearchKeyWords";
	public static final String WINDOWS_LOGS_IN_PROCESS_DIR_KEY = "WindowsApplicationInProcessLogs";
	public static final String LINUX_LOGS_IN_PROCESS_DIR_KEY = "LinuxApplicationInProcessLogs";
	public static final String WINDOWS_SNORT_LOGS_IN_PROCESS_DIR_KEY = "WindowsSnortApplicationInProcessLogs";
	public static final String LINUX_SNORT_LOGS_IN_PROCESS_DIR_KEY = "LinuxSnortApplicationInProcessLogs";
	public static final String CONVERTED_LOGS_DESTINATON_DIR_KEY = "ConvertedLogsDestinationDir";
	public static final String APP_WINDOWS_ROOT_DIR = "ApplicationWindowsRootDir";
	public static final String APP_LINUX_ROOT_DIR = "ApplicationLinuxRootDir";
	public static final String LOGS_SOURCE_DIR_KEY_WINDOWS = "ApplicationLogsSourceDirForWindows";
	public static final String LOGS_SOURCE_DIR_KEY_LINUX = "ApplicationLogsSourceDirForLinux";
	public static final String LOGS_SOURCE_DIR_KEY_WINDOWS_SNORT = "ApplicationLogsSourceDirForWindowsSnort";
	public static final String LOGS_SOURCE_DIR_KEY_LINUX_SNORT = "ApplicationLogsSourceDirForLinuxSnort";
	public static final String MINUTES_PERIOD = "MinutesPeriod";
	public static final String LOG_LAST_PROCESSED_DATE = "logLastProcessedDate";
	public static final String WINDOWS_LOG_BASE_DATE_KEY = "windowsbaseDate";
	public static final String LINUX_LOG_BASE_DATE_KEY = "linuxbaseDate";
	public static final String WINDOWS_SNORT_LOG_BASE_DATE_KEY = "windowssnortbaseDate";
	public static final String LINUX_SNORT_LOG_BASE_DATE_KEY = "linuxsnortbaseDate";
	
	
	
	
	public static final String LOG_DATA_PROVIDERS_NAMES="LogDataProvidersName";
	public static final String LOG_DATE_FORMAT_KEY = "logDateFormat";
	public static final String AGENT_ID = "AgentID";
	
	public static final String MinuteToSplitDefaultValue = "3";
	public static final String SearchKeywordDefaultValue = "security.evtx";
	public static final String WindowsLogsSourceDefaultValue = "C:\\\\Windows\\\\System32\\\\winevt\\\\Logs";
	public static final String LinuxLogsSourceDefaultValue = "/var/log/auth.log";
	public static final String WindowsSnortLogsSourceDefaultValue = "C:\\SEIM\\SnortLogs";
	public static final String LinuxSnortLogsSourceDefaultValue = "/SnortLogs";
	public static final String ConvertedLogsDefaultValue = "C:\\SEIM\\DeliveryLogs";
	
	public static final String WindowsLogsInProcessDefaultValue = "C:\\SEIM\\LogsInProcess\\WindowsLogs";
	public static final String LinuxLogsInProcessDefaultValue = "/LogExtractor/LogsInProcess/LinuxLogs";
	public static final String WindowsSnortLogsInProcessDefaultValue = "C:\\SEIM\\LogsInProcess\\WindowsSnort\\Alert.ids";
	public static final String LinuxSnortLogsInProcessDefaultValue = "/LogExtractor/LogsInProcess/LinuxSnort/Alert.ids";
	
	public static final String LogsBaseDateDefaultValue = "12/01/2017 01:00:00 PM";
	public static final String LogDataProvidersNameDefaultValue = "WindowsSnort,Windows";
	public static final String LogDateFormatDefaultValue = "MM/dd/yyyy hh\\:mm\\:ss aaa";
	public static final String AgentIDDefaultValue = "109";
	public static final String AppWindowsRootDirDefaultValue = "C:\\LogExtractor";
	public static final String AppLinuxRootDirDefaultValue = "/LogExtractor";
 
}
