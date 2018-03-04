package agent;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class Utils {

	public Utils() {
		// TODO Auto-generated constructor stub
	}

	public static long GetDatesDiffInMinutes(Date startDate, Date endDate) {
		long minutesPeriod = -1;
		try {
	
		LocalDateTime lastProcessedDateLDT = LocalDateTime.ofInstant(startDate.toInstant(), ZoneId.systemDefault());
		LocalDateTime currentDateLDT = LocalDateTime.ofInstant(endDate.toInstant(), ZoneId.systemDefault());
		minutesPeriod = Duration.between(lastProcessedDateLDT, currentDateLDT).toMinutes();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return minutesPeriod;
	}

	public static void Sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ArrayList<String> listFilesForFolder(final File folder) {
		ArrayList<String> files = new ArrayList<String>();
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isFile()) {
				files.add(fileEntry.getName());
			}
		}
		return files;
	}
	public static boolean isNullOrEmpty(String str)
    {
    	if (str == "" || str==null)
    		return true;
    	else 
    		return false;
    }

}
