package agent.OSCommands;

public class LinuxTerminalCommands implements ILogCommand {
	
	public static final String COPY_FILE_FROM_TO = "cp %s %s";
	public static final String COPY_AUTH_FILE_TO = "cp /var/log/auth.log %s";
	
	public LinuxTerminalCommands() {
		// TODO Auto-generated constructor stub
	}

	  
//	public static void main(String args[]) {
//	    try {
//	        Runtime rt = Runtime.getRuntime();
//	        String[] cmd = {"cd /var/log", "cat auth.log > LinuxLogsSIEM.log"};
//	        Process proc = rt.exec(cmd);
//	        proc.getOutputStream().close();
//			try {
//				proc.waitFor();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	     //   printStream(proc.getInputStream());
//	       // System.out.println("Error : ");
//	      //  printStream(proc.getErrorStream());
//	    } catch (Exception ex) {
//	        ex.printStackTrace();
//	    }
//	}

	@Override
	public String GetLogsCommand(String dest, long diffInMinute) {
		return null;
	}

	@Override
	public String GetLogsCommand(String src, String dest, long diffInMinute) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String GetLogsCommand(String dest) {
		//"cp /var/log/auth.log /tmp/poxlo.log"
		String cmd = String.format(COPY_AUTH_FILE_TO,dest);
		return cmd;
	}


 


	@Override
	public String SortFiles() {
		// TODO Auto-generated method stub
		return null;
	}

}
