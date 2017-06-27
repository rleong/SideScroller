package client;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import enums.ControlIDs;
import gfx.Images;

public class Client extends Canvas {

	private Images images = new Images();
	private String message;
	private MouseInput mouseInput = new MouseInput();

	public Client() {

		this.addMouseListener(mouseInput);
		mouseInput.setClient(this);
		message = "Welcome to Russell's Game! \n" + "Your game version is: PRE-ALPHA \n";
		
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.drawImage(images.getLoginMenu(), 0, 0, null);
		g.drawImage(images.getLoginButton(), 20, 430, null);
		g.drawImage(images.getSignUpButton(), 135, 430, null);
		g.drawImage(images.getUpdateButton(), 250, 430, null);
		g.drawImage(images.getOptionsButton(), 365, 430, null);
		g.drawImage(images.getUpdateButton(), 480, 430, null);

		drawText(g, getStats(), 45, 35);

		// Debugging Only
		//System.out.println("painted");
	}

	public String getStats() {
		return message;
		// This stupid method cost me 6 hours of stress
		// Screw this method
		// I'm a freaking idiot
	}

	public void updateStats(String s) {
		message += "You clicked " + s + "!\n";
		repaint(); 
	}

	public void isClicked(double x, double y) {

		// 20, 135, 250, 365, 480
		if (y >= 430 && y <= 480) {

			if (x >= 20 && x <= 120) {
				updateStats("Log In");
				System.out.println(message);
			} else if (x >= 135 && x <= 235) {
				updateStats("Sign Up");
			} else if (x >= 250 && x <= 350) {
				updateStats("Update");
			} else if (x >= 365 && x <= 465) {
				updateStats("Options");
			} else if (x >= 480 && x <= 580) {
				updateStats("TBA");
			}

		}

	}

	// From https://stackoverflow.com/questions/4413132/problems-with-newline-in-graphics2d-drawstring

	public void drawText(Graphics g, String text, int x, int y) {

		for (String line : text.split("\n"))
			g.drawString(line, x, y += g.getFontMetrics().getHeight());

	}

	public static void main(String args[]) throws UnknownHostException, IOException {

		Client client = new Client();
		ClientWindow window = new ClientWindow(ControlIDs.loginMenu, client);
		
		String name = "Test";
		Socket socket = new Socket("localhost", 4444);
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			String readerInput = bufferedReader.readLine();
			printWriter.println(name + ": " + readerInput);
		}

	}

}
