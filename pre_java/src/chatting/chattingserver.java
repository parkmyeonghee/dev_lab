package chatting;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class chattingserver {
	private Socket socket =null;
	private ServerSocket server = null;
	private DataInputStream streamln = null;
	JTextArea jta_display= new JTextArea();
	JScrollPane jsp_display=
			new JScrollPane(jta_display
					,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
					,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);



public chattingserver(int port){

	try {
		System.out.println("binding to port"+port+",please wiat");
		server = new ServerSocket(port);
		System.out.println("server started:"+server);
		System.out.println("waiting for a client");
		socket=server.accept();
		System.out.println("client accpet:"+socket);
		open();
		boolean done = false;
		while(!done){
			try {
				String line=streamln.readUTF();
				System.out.println(line);
				done=line.equals(".bye");
			} catch (IOException ioe) {
				done=true;
			}
		}
		close();
	} catch (IOException ioe) {
		System.out.println(ioe);
	}
	
}


public void open() throws IOException
{
	streamln = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
	
}
public void close() throws IOException
{
	if(socket !=null) socket.close();
	if(streamln !=null) streamln.close();
}
	public static void main(String[] args) {
		chattingserver server =null;
		if(args.length !=1)
			System.out.println("usage: java chatServer port");
		else
			server = new chattingserver(Integer.parseInt(args[0]));
	}

}
