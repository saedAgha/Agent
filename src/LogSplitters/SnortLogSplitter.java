package LogSplitters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import LogDataEntities.ILogData;
import LogDataEntities.SnortLogData;
import agent.Utils;
import agent.hardwareDetails.HardwareDetails;

public class SnortLogSplitter extends LogSplitter {

	public static final String SPLITER_NAME = "Snort";
	

  
	public SnortLogSplitter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SnortLogSplitter(ArrayList<String> logsToSplit, String destinationDirName, String sourceDirName) {
		super(logsToSplit, destinationDirName, sourceDirName);
		// TODO Auto-generated constructor stub
	}
    
	public String GetProviderName() 
	{
		return SPLITER_NAME;
	}
	public boolean isValidDateString(String dateStr)
	{
		
		boolean validDate=false;
		if(dateStr!=null && dateStr.length()>=20 &&dateStr.charAt(2) == '/' && dateStr.charAt(5) == '-' && dateStr.charAt(8) == ':'&& dateStr.charAt(11) == ':'&& dateStr.charAt(14) == '.')
			validDate=true;
		return validDate; 
	}
	public Date ParseDate(String dateStr)
	{
		//01/10-18:34:37.156193
		int day,month,hour,minute,seconds,year;
		month=Integer.parseInt(dateStr.substring(0, 2));
		day=Integer.parseInt(dateStr.substring(3, 5));
		hour=Integer.parseInt(dateStr.substring(6, 8));
		minute=Integer.parseInt(dateStr.substring(9, 11));
		seconds=Integer.parseInt(dateStr.substring(12, 14));
		Calendar cal = Calendar.getInstance();
		year=cal.get(Calendar.YEAR);
		cal.clear();
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.HOUR, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, seconds);
		cal.set(Calendar.YEAR, year);
		Date predefined = cal.getTime();
		return predefined;
	}
	@Override
	protected List<ILogData> ParseData(String fileName) throws Exception {     
		List<ILogData> SnortLogDataList= new ArrayList<ILogData>();
		File fileTemplate = new File(fileName);
		String logDataStr="";
		Date date=null;
		String line="";
		String additionalData="";
		
		String  baseDateStr= configuredData.GetWindowsSnortLogLastProcessedDate();
		Date baseDate   = new Date(baseDateStr);
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileTemplate))) 
		{
			synchronized(br) {
			boolean skip =false;
		    SnortLogData logData =null;
		 	while((line = br.readLine()) != null   )
		 	{
		 		 
		 		while(line!=null && !line.equals(""))
		 		{
			    	   if(line.length()>=21)
			    	   {
			    		   String [] vals =line!=null? line.split(" "): new String[0];
			    		   if(vals.length>1)
			    		   {
			    			   if(vals[0]!=null&&vals[0].length()>=21 && isValidDateString(vals[0].substring(0, 21)))
					    		{
					    			date= ParseDate(vals[0].substring(0, 21));
			    				    logData= new SnortLogData(date);
			    				    logData.SetAdditionalData(additionalData);
			    				    additionalData="";
			    				    for(int i=1;i<vals.length;i++)
									 {
				    				   additionalData+=vals[i]+" ";
									 }
			    				   
			    				 
			    				    line = br.readLine();
			    				    continue;
							           
					    		}
			    		   }
			    	   }
			    	   if(additionalData.equals(""))
			    	   {
			    		   additionalData= line;
			    	   }
			    	   else
			    	   {
			    	       additionalData= additionalData +"\n"+line;
			    	   } 
			    	   line = br.readLine();
			    	}
		 		if(logData!=null &&Utils.GetDatesDiffInMinutes(baseDate, logData.GetTimeCreation())>0) 
		 		{
		 			  logData.SetData(additionalData);
		              SnortLogDataList.add(logData);
		              additionalData="";
		 		}
		 		else
		 		{
		 		   additionalData="";
		 		}
		             
		 	}
			}
		 	
		}
 
		 return SnortLogDataList;
	}


	@Override
	   protected String GetFileNameByDate(Date date)
		{
			String machineMacAddress = HardwareDetails.GetMacAddress();
			String logsDateFormat = configuredData.GetLogDateFormat();
			SimpleDateFormat formatter = new SimpleDateFormat(logsDateFormat);
			String newFileName = formatter.format(date);
			newFileName = configuredData.GetAgentID()+"_"+machineMacAddress + "_" + HardwareDetails.GetIP()+"_"+SPLITER_NAME+"_"+newFileName; 
			return newFileName;
			
		}

}
