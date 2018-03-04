package LogDataEntities;

import java.util.Calendar;
import java.util.Date;

public class SnortLogData implements ILogData
{

	private Date timeCreation;
	private String data;
	private String additionalData;
 
	public SnortLogData(Date timeCreation) {
		this.timeCreation=timeCreation;
	}
	public SnortLogData(String timeCreationStr) {
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
		Date date = timeCreation;
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
 
 
	
	public void SetAdditionalData(String str) {
		  additionalData=str;
	 
	}
	@Override
	public String GetAdditionalData() {
		if(additionalData.equals(""))
			return "";
		else
			return additionalData+"\n"; 
	}
	 
	 
}
