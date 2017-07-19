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

		message = "Welcome to Rusty's Game! \n" + "Your game version is: PRE-ALPHA \n";
		
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

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

	}

	// From https://stackoverflow.com/questions/4413132/problems-with-newline-in-graphics2d-drawstring

	public void drawText(Graphics g, String text, int x, int y) {

		for (String line : text.split("\n"))
			g.drawString(line, x, y += g.getFontMetrics().getHeight());

	}

	public static void main(String args[]) throws UnknownHostException, IOException {

		Client client = new Client();
		ClientWindow window = new ClientWindow(ControlIDs.mainMenu, client);

	}

}

/*

In addition to the links that helped make this, thank you to these people for answering my questions:

Reddit: g051051, Rorimac2


*/