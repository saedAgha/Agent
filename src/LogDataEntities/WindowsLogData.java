package LogDataEntities;

import java.util.Calendar;
import java.util.Date;

public class WindowsLogData implements ILogData {
	private final String SEPERATOR = ",";
	public static final String EntityName = "WindowsLog";

	public WindowsLogData() {
	}

	public String Message;

	public String Id;

	public String Version;

	public String Qualifiers;

	public String Level;

	public String Task;

	public String Opcode;

	public String Keywords;

	public String RecordId;

	public String ProviderName;

	public String ProviderId;

	public String LogName;

	public String ProcessId;

	public String ThreadId;

	public String MachineName;

	public String UserId;

	public String TimeCreated;

	public String ActivityId;

	public String RelatedActivityId;

	public String ContainerLog;

	public String MatchedQueryIds;

	public String Bookmark;

	public String LevelDisplayName;

	public String OpcodeDisplayName;

	public String TaskDisplayName;

	public String KeywordsDisplayNames;

	public String Properties;
	
	public String GetData ()
	{
		return toString();
	}
 
	public Date GetTimeCreation() {
		return new Date(TimeCreated);
	 
	}
	 
	public String toString() {
		return " Message:" + this.Message.replaceAll("\\s+", " ") + SEPERATOR + " Id:" + this.Id + SEPERATOR + " Version:" + this.Version
				+ SEPERATOR + " Qualifiers:" + this.Qualifiers + SEPERATOR + " Level:" + this.Level + SEPERATOR
				+ " Task:" + this.Task + SEPERATOR + " Opcode:" + this.Opcode + SEPERATOR + " Keywords:" + this.Keywords
				+ SEPERATOR + " RecordId:" + this.RecordId + SEPERATOR + " ProviderName:" + this.ProviderName
				+ SEPERATOR + " ProviderId:" + this.ProviderId + SEPERATOR + " LogName:" + this.LogName + SEPERATOR
				+ " ProcessId:" + this.ProcessId + SEPERATOR + " ThreadId:" + this.ThreadId + SEPERATOR
				+ " MachineName:" + this.MachineName + SEPERATOR + " UserId:" + this.UserId + SEPERATOR
				+ " TimeCreated:" + this.TimeCreated + SEPERATOR + " ContainerLog:" + this.ContainerLog
				 ;

	}

	@Override
	public String GetTimeCreationAsString() {
		Date date = new  Date(TimeCreated);
	 
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

	@Override
	public String GetAdditionalData() {
	   return "";
	}

	@Override
	public void SetAdditionalData(String str) {
		// TODO Auto-generated method stub
		
	}
	 

}
