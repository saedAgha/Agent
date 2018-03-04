package LogDataEntities;

import java.util.Date;

public interface ILogData {
	
	 public String toString() ;

	 public String GetTimeCreationAsString();
	 public String GetData ();
	 public Date GetTimeCreation();
	 public String GetAdditionalData();
	 public void SetAdditionalData(String str);
	 
}
