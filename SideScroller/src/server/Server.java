package server;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import enums.ControlIDs;

public class Server {
	
	// Multiple Client-Server tutorial from ZA JAVA Language: https://www.youtube.com/watch?v=2cQJJwoSNLk
	public static final int PORT = 4444;
	
	public void runServer() throws IOException {

		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("Server up and ready for connections...");
		
		while (true) {
			Socket socket = serverSocket.accept();
			new ServerThread(socket).start();
		}
		
	}

	public static void main(String args[]) throws IOException {

		ServerWindow window = new ServerWindow();
		
	}
	
	public class ServerThread extends Thread{

		Socket socket;
		
		ServerThread(Socket socket){
			
			this.socket = socket;
			
		}
		
		public void run(){
			
			try {
				String message = null;
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while (( message = bufferedReader.readLine()) != null) {
					System.out.println("incoming client message: " + message);
				}
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
