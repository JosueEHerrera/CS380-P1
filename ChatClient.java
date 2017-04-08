
import java.io.*;
import java.net.*;
import java.util.*;


public class ChatClient{

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("codebank.xyz", 38001);
		Scanner kb = new Scanner(System.in);
		try {
			BufferedReader br =  new BufferedReader(
				new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintStream out = new PrintStream(socket.getOutputStream(), true, "UTF-8");
			
			String username = "";
			username = kb.nextLine();
			out.printf(username + "%n");
		
			String userinput = "";
			
			while (true){
            	 	
               	while (br.ready()){
	                userinput = br.readLine();
	                System.out.println(userinput);	
	            }
	            
	            System.out.print(username + ": "); 
                userinput = kb.nextLine();
                out.printf(userinput + "%n");   
                userinput = br.readLine();
	            System.out.println(userinput);	

	        }
			

		}catch (Exception e){

		}
	}
}
