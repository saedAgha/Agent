package agent;

public class Main {
	
	public static void main(String[] args) {
	        
		while(true)
		{
			System.out.println("SIEM Agent begin Processing ...");

		LogsExtractor logExtractor = new LogsExtractor();
		logExtractor.Run();
		try {
			Thread.sleep(200000);//sleep 200 seconds minutes
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	 

}
