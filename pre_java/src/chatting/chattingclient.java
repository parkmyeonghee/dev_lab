package chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class chattingclient {
	private Socket socket = null;
	private DataInputStream console=null;
	private DataOutputStream streamout = null;
	
	public chattingclient(String serverName, int serverPort){
		System.out.println("Esta connection");
		try {
			socket= new Socket(serverName,serverPort);
			System.out.println("host know");
		} catch (IOException ioe) {
			System.out.println("unexpectes exception:"+ioe.getMessage());
		}
		String line="";
		while(!line.equals(".bye"))
		{
			try {
				line=console.readLine();
				streamout.writeUTF(line);
				streamout.flush();
			} catch (IOException ioe) {
				System.out.println("sending error"+ioe.getMessage());
			}
		}
	}
	public void start() throws IOException
	{
		console= new DataInputStream(System.in);
		streamout= new DataOutputStream(socket.getOutputStream());
	}
	public void stop(){
		try {
			if(console !=null) console.close();
			if(streamout !=null) streamout.close();
			if(socket !=null)socket.close();
		} catch (IOException ioe) {
			System.out.println("error closing...");
		}
	}
	public static void main(String[] args) {
		chattingclient client =  null;
		if(args.length !=2)
			System.out.println("chattingclient host port");
		else
			client= new chattingclient(args[0],Integer.parseInt(args[1]));
	}

}
