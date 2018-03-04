package LogSplitters;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import LogDataEntities.ILogData;
import LogDataEntities.WindowsLogData;
import agent.Utils;
import agent.WindowsLogDataContainer;
import agent.configuration.LogsConfiguredData;
import agent.csvParser.CSVParser;
import agent.hardwareDetails.HardwareDetails;

public abstract class LogSplitter {

	protected ArrayList<String> logsToSplit;
 
	protected File destinationDir;
	protected File sourceDir;
	protected LogsConfiguredData configuredData;

	//ctor's
	public LogSplitter() 
	{
		InitFields();
		destinationDir=new File(configuredData.GetLogsDestinationDir());
	}
	
	public String GetProviderName() 
	{
		return "baseProvider";
	}
	public LogSplitter( String destinationDirName, String sourceDirName) {
		 
		this.destinationDir = new File(destinationDirName);
		this.sourceDir = new File(sourceDirName);
		InitFields();
	}
	public LogSplitter(ArrayList<String> logsToSplit, String destinationDirName, String sourceDirName) {
		this.logsToSplit = logsToSplit;
		this.destinationDir = new File(destinationDirName);
		this.sourceDir = new File(sourceDirName);
		InitFields();
	}
	
	//abstract methods
	protected abstract List<ILogData> ParseData(String fileName) throws Exception; 
	protected abstract String GetFileNameByDate(Date date);

	//protected methods
	protected void InitFields() {
		configuredData = new LogsConfiguredData();
	}
	protected void generateFile(ArrayList<String> rows, String fileName) throws IOException
	{
		
		File newFile = new File(
				destinationDir.getPath() + "\\" + fileName.replace(':', '-').replace('/', '-') + ".csv");
		newFile.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(newFile, true));
		for (String row : rows) {
			writer.append(row);
		}
		writer.close();
			System.out.println("newFileName created with "+rows.size()+" rows");	

	}
	
	//public methods
	public void SplitFilePerMinutes(String fileName, long diffInMinutes) 
	{
			System.out.println("splitting function started");	
		int minutes = Integer.valueOf(configuredData.GetMinutesThreshold());
		String logsDateFormat = configuredData.GetLogDateFormat();
		SimpleDateFormat formatter = new SimpleDateFormat(logsDateFormat);
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		SimpleDateFormat dataformatter = new SimpleDateFormat("dd/mm-HH:mm:ss");
		
		List<ILogData> logsList = null;
		Date firstLogDate=null,currentDate=null;
		Date nowDate= new Date();
		String newFileName = "";
		ArrayList<String> fileRows = new ArrayList<String>();
		try {

			logsList = ParseData(fileName);
			System.out.println("number of parsed data "+logsList.size()+" logs");	

            if(logsList.size()>0)
            {
		
		    firstLogDate = logsList.get(0).GetTimeCreation();
		    currentDate=firstLogDate;
		   
			fileRows.add( logsList.get(0).GetAdditionalData()+ logsList.get(0).GetTimeCreationAsString()+" "+logsList.get(0).GetData() +"\n" );

			for (int i = 0; i < logsList.size(); i++) {
				  currentDate = logsList.get(i).GetTimeCreation();
				if (Utils.GetDatesDiffInMinutes(firstLogDate, currentDate) > minutes) {
					newFileName = GetFileNameByDate(firstLogDate);
					generateFile(fileRows, newFileName);
					fileRows.clear();
					firstLogDate = currentDate;
				}
				fileRows.add(logsList.get(i).GetAdditionalData() +logsList.get(i).GetTimeCreationAsString()+" "+logsList.get(i).GetData()+"\n"  );
			}
			if(fileRows.size()>0)
			{
				newFileName = GetFileNameByDate(firstLogDate);
				generateFile(fileRows, newFileName);
				fileRows.clear();
				firstLogDate = currentDate;
			}
       		Calendar cal = Calendar.getInstance();
 			cal.setTime(nowDate);
 		    cal.add(Calendar.MINUTE, (int) Utils.GetDatesDiffInMinutes(firstLogDate, nowDate));
			currentDate =firstLogDate;
			while (Utils.GetDatesDiffInMinutes(currentDate, nowDate) > minutes) 
			{
 				newFileName = GetFileNameByDate(currentDate); 
   			     generateFile(fileRows, newFileName);
   				fileRows.clear();
   				currentDate.setMinutes(currentDate.getMinutes()+minutes);
			}
            }
            else
            {
				Calendar cal = Calendar.getInstance();
				cal.setTime(nowDate);
				cal.add(Calendar.MINUTE, -1*minutes);
				currentDate = cal.getTime();
				boolean once=true;
    			while (Utils.GetDatesDiffInMinutes(currentDate, nowDate) > minutes ||once) 
    			{
     				newFileName = GetFileNameByDate(currentDate); 
	   			     generateFile(fileRows, newFileName);
	   				fileRows.clear();
	   				currentDate.setMinutes(currentDate.getMinutes()+minutes);
	   				once=false;
    			}
            }
			 
			String lastProcessedDate = formatter.format(currentDate);
			configuredData.SetLogLastProcessedDate(lastProcessedDate,GetProviderName());
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("splitting function finished");	

	}
 

}
