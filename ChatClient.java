
import java.io.*;
import java.net.*;
import java.util.*;


public class ChatClient{

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("codebank.xyz", 38001);
		Scanner kb = new Scanner(System.in);
		
		try {


			//BufferedReader br =  new BufferedReader(
				//new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			PrintStream out = new PrintStream(socket.getOutputStream(), true, "UTF-8");
			
			ReaderThread reader = new ReaderThread(socket);
			reader.start();


			String username = "";
			username = kb.nextLine();
			out.printf(username + "%n");
			
			
			String userinput = "";
			
			while (reader.isAlive()){         	
                userinput = kb.nextLine();
                out.println(userinput);   

	        }

		}catch (IOException e){

		}
	}

	private static class ReaderThread extends Thread {
		private Socket socket = null;

		public ReaderThread(Socket socket){
			this.socket = socket;
		}

		public void run() {
			try{

				BufferedReader br =  new BufferedReader(
				new InputStreamReader(socket.getInputStream(), "UTF-8"));
				
				String userinput = " "; 
				while ((userinput = br.readLine()) != null){
	               	System.out.println(userinput);	
	                if (userinput.equals("Name in use.")){
	                	System.exit(0);
	                }
	                
	            }

			} catch(IOException e){
				System.out.println("Abruptly Disconnected");
			}
		}
	}
}
