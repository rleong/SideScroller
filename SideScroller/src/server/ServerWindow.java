package server;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;

import enums.ControlIDs;
import gfx.Images;
import util.JTextAreaOutputStream;

public class ServerWindow {

	// Attributes
	private JFrame frame;
	private static Dimension dm = new Dimension();
	private String title;

	// Server Specific
	private JButton startButton = new JButton("Start");
	private JButton endButton = new JButton("End");
	private Dimension buttonSize = new Dimension(75, 25);
	private JTextArea textArea;
	private JScrollPane scroller;

	// Borders count for some reason
	private final int hOffset = 29, wOffset = 6;

	public ServerWindow() {
		frame = new JFrame();
		frame.setLayout(null);

		textArea = new JTextArea(780, 400);
		title = "Rusty's Game: Server";
		dm.setSize(800 + wOffset, 450 + hOffset);

		startButton.setSize(buttonSize);
		startButton.setLocation(10, 25);

		endButton.setSize(buttonSize);
		endButton.setLocation(100, 25);

		textArea.setEditable(false);
		scroller = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setLocation(10, 85);
		scroller.setSize(780, 355);

		frame.add(startButton);
		frame.add(endButton);
		frame.add(scroller);

		JTextAreaOutputStream out = new JTextAreaOutputStream(textArea);
		System.setOut(new PrintStream(out));

		startButton.addActionListener(startButtonPressed);

		frame.setTitle(title);
		frame.setSize(dm);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);

		// debug();
	}

	public void updateConsole(String text) {
		System.out.println(text);
	}

	private void debug() {

		while (true) {
			System.out.println("Current time: " + System.currentTimeMillis());
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	// Action Listeners

	ActionListener startButtonPressed = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				new Server().runServer();
				System.out.println("Server has started...");
			} catch (IOException e1) {
				System.out.println("Server has encountered a problem: ");
				System.out.println(e1);
				e1.printStackTrace();
			}
			// System.out.println("LOL");
		}

	};

}
