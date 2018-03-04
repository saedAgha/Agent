package LogDataEntities;

import java.util.Calendar;
import java.util.Date;

public class LinuxLogData implements ILogData {
	
	public static final String EntityName = "LinuxLog";
	
	private Date timeCreation;
	private String timeCreationStr;
	private String data;
 
	public LinuxLogData(Date timeCreation) {
		this.timeCreation=timeCreation;
	}
	public LinuxLogData(String timeCreationStr) {
		this.timeCreationStr=timeCreationStr;
	}
	public void SetData (String data)
	{
		this.data=data;
	}
	public String GetData ()
	{
		return this.data;
	}
	@Override
	public String GetTimeCreationAsString() {
		Date date = new Date( timeCreationStr);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min=cal.get(Calendar.MINUTE);
		int seconds=cal.get(Calendar.SECOND);
		

		String dateStr = day+"/"+(month+1)+"-"+hour+":"+min+":"+seconds;
    	return	dateStr;
    	
	 
	}
	public Date GetTimeCreation() {
		return timeCreation;
	 
	}
	@Override
	public String GetAdditionalData() {
		// TODO Auto-generated method stub
		return "";
	}
	@Override
	public void SetAdditionalData(String str) {
		// TODO Auto-generated method stub
		
	}
	 

}
