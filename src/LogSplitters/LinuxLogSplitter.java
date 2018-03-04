package LogSplitters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import LogDataEntities.ILogData;
import LogDataEntities.LinuxLogData;
import agent.hardwareDetails.HardwareDetails;

public class LinuxLogSplitter extends LogSplitter {

	public static final String SPLITER_NAME = "Linux";
	public LinuxLogSplitter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinuxLogSplitter(ArrayList<String> logsToSplit, String destinationDirName, String sourceDirName) {
		super(logsToSplit, destinationDirName, sourceDirName);
		// TODO Auto-generated constructor stub
	}
	
	public String GetProviderName() 
	{
		return SPLITER_NAME;
	}
  
	@Override
	protected List<ILogData> ParseData(String fileName) throws Exception 
	{     
		List<ILogData> linuxLogDataList= new ArrayList<ILogData>();
		File fileTemplate = new File(fileName);
		String logDataStr="";
		Date date=null;
		try (BufferedReader br = new BufferedReader(new FileReader(fileTemplate))) 
		{
		    String line;
		    while ((line = br.readLine()) != null) 
		    {
		    	String [] vals = line.split("Kali");
		    	if(vals.length<=1)continue;
		    	try 
		    	{
		           SimpleDateFormat parser = new SimpleDateFormat("EEE dd HH:mm:ss");
		           parser.parse(vals[0].trim());
		           LinuxLogData logData = new LinuxLogData(date);
		           logData.SetData(logDataStr);
		           linuxLogDataList.add(logData);
		           logDataStr="";
		           for(int i=1;i<vals.length;i++)
					{
		        	   logDataStr+=vals[i];
					}
		           date=parser.parse(vals[0]);
		    	}
		    	catch(Exception ex)
		    	{
		    		
		    	}
		    	if(date!=null)
		    	{
		    		logDataStr=logDataStr+" "+ line;
		    	}
		    	
		    }
		}
		 return linuxLogDataList;
	}

	@Override
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
