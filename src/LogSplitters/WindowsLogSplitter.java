package LogSplitters;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import LogDataEntities.ILogData;
import agent.WindowsLogDataContainer;
import agent.csvParser.CSVParser;
import agent.hardwareDetails.HardwareDetails;

public class WindowsLogSplitter extends LogSplitter {

	public static final String SPLITER_NAME = "Windows";
	public WindowsLogSplitter(String destinationDirName, String sourceDirName) {
		super();
		// TODO Auto-generated constructor stub
	}

	public WindowsLogSplitter(ArrayList<String> logsToSplit, String destinationDirName, String sourceDirName) {
		super(logsToSplit, destinationDirName, sourceDirName);
		// TODO Auto-generated constructor stub
	}
 
	public String GetProviderName() 
	{
		return SPLITER_NAME;
	}
    protected List<ILogData> ParseData(String fileName) throws Exception {

		WindowsLogDataContainer container = new WindowsLogDataContainer();

		File fileTemplate = new File(fileName);
		FileInputStream fis = new FileInputStream(fileTemplate);
		Reader fr = new InputStreamReader(fis, "UTF-8");
		List<String> values = new ArrayList<String>();
	    values = CSVParser.parseLine(fr);// remove first line
		values = CSVParser.parseLine(fr);
		container.SetSchema(values);
		values = CSVParser.parseLine(fr);

		while (values != null && values.size()>0) {
			container.InsertNewEventLog(values);
			values = CSVParser.parseLine(fr);
		}
		fr.close();
		return container.Data;
	}
    
    protected String GetFileNameByDate(Date date)
	{
		String machineMacAddress = HardwareDetails.GetMacAddress();
		String logsDateFormat = configuredData.GetLogDateFormat();
		SimpleDateFormat formatter = new SimpleDateFormat(logsDateFormat);
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String newFileName = formatter.format(date);
		newFileName = configuredData.GetAgentID()+"_"+machineMacAddress + "_" + HardwareDetails.GetIP()+"_"+SPLITER_NAME+"_"+newFileName; 
		return newFileName;
		
	}
    
}
