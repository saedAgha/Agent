package agent.OSCommands;

public class PowerShellCommands  implements ILogCommand{
	// TODO Support Filtering mechanism
	public static final String EXE_NAME = "powershell.exe";
	public static final String GET_WIN_EVENT = "Get-WinEvent  -LogName";
	private final String SPACE = " ";
	private final String ExportCSVAppend = " |Export-Csv -Append %s ";
	private final String ExportCSV = " |Export-Csv %s ";
	private final String PATH = " -Path %s ";
	private final String WHERE_QUERY = " |Where-Object ";
	private final String DATE_MINUTE_FILTERING = "{$_.TimeCreated %s (Get-Date)- (New-TimeSpan -Minute %d)}";
	private final String GREATER_OPERATOR = " -ge ";
 
 
	
	private final String GET_LOGS_UNSORTED = " $files = (Get-WinEvent -ListLog *security*).LogName; " + 
			"for ($i=0; $i -lt $files.Count; $i++) {Get-WinEvent -LogName $files[$i]| Where-Object {$_.TimeCreated  -ge  (Get-Date)- (New-TimeSpan -Minute %d)} |Export-Csv -Append C:\\\\SEIM\\\\LogsInProcess\\\\WindowsLogs\\\\WindowsLogUnSorted.csv} "; 
    private final String SORT = " Import-Csv C:\\SEIM\\LogsInProcess\\WindowsLogs\\WindowsLogUnSorted.csv | sort TimeCreated -Descending |Export-Csv -Append C:\\SEIM\\LogsInProcess\\WindowsLogs\\WindowsLog.evtx.csv";
		 
			
 
	private final String LOG_NAME = " -LogName Microsoft-Windows-SMBServer%4Security ";
	//private final String LOG_NAME = " -LogName */Security ";
	private final String SORTBY = " | Sort-Object -Property @{Expression = 'TimeCreated'; Descending = $False} ";
   //Get-WinEvent -LogName */Security |Export-Csv -Append C:\testSMB.csv
	
	
	public String ExportCSV(String src, String dest) {
		return EXE_NAME + SPACE + GET_WIN_EVENT + SPACE + String.format(ExportCSV, src, dest);
	}

	public String ExportCSV(String dest, long diffInMinute) {
		String cmd = "";
		
		cmd = EXE_NAME + SPACE  +String.format(GET_LOGS_UNSORTED,diffInMinute);
//		cmd = EXE_NAME + SPACE + GET_WIN_EVENT + LOG_NAME + WHERE_QUERY
//				+ String.format(DATE_MINUTE_FILTERING, GREATER_OPERATOR, diffInMinute) + SORTBY
//				+ String.format(ExportCSVAppend, dest);
		return cmd;
	}
	
	
	public String SortFiles() {
		String cmd = EXE_NAME + SPACE  +SORT;
		return cmd;
	}
	
	
	
//	public String ExportCSV(String dest, long diffInMinute) {
//		String cmd = "";
//		cmd = EXE_NAME + SPACE + GET_WIN_EVENT + LOG_NAME + WHERE_QUERY
//				+ String.format(DATE_MINUTE_FILTERING, GREATER_OPERATOR, diffInMinute) + SORTBY
//				+ String.format(ExportCSVAppend, dest);
//		return cmd;
//	}
	
	 

	public PowerShellCommands() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String GetLogsCommand(String dest, long diffInMinute) {
		return ExportCSV( dest,  diffInMinute);
	}

	@Override
	public String GetLogsCommand(String src, String dest, long diffInMinute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String GetLogsCommand(String dest) {
		// TODO Auto-generated method stub
		return null;
	}

	 

}
