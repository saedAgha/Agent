package agent.OSCommands;

public interface ILogCommand {

	  String GetLogsCommand(String dest);
	  String SortFiles();
	  String GetLogsCommand(String dest, long diffInMinute);
	  String GetLogsCommand(String src,String dest, long diffInMinute);
}
