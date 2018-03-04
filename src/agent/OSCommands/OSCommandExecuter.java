package agent.OSCommands;

import java.io.IOException;
 
public class OSCommandExecuter {

	private static OSCommandExecuter instance;
 

	private OSCommandExecuter() {
	}

	public static synchronized OSCommandExecuter getInstance() {
		if (instance == null) {
			instance = new OSCommandExecuter();
		}
		return instance;
	}

	public void runCommand(String command) {
		Process powerShellProcess;
		try {
			powerShellProcess = Runtime.getRuntime().exec(command);
			powerShellProcess.getOutputStream().close();
			try {
			Thread.sleep(60000);
				powerShellProcess.destroy();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
