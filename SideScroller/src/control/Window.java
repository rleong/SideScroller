package control;

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

public class Window {

	
	// Attributes
	private JFrame frame;
	private static Dimension dm = new Dimension();
	private String title;
	
	// Server Specific
	private JButton startButton = new JButton("Start");
	private JButton endButton = new JButton("End");
	private Dimension buttonSize = new Dimension(75, 25);
	private Server server;
	private JTextArea textArea;
	private JScrollPane scroller = new JScrollPane(textArea,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	// Borders count for some reason
	private final int hOffset = 29, wOffset = 6;
	
	public Window(ControlIDs id, Server server){
		frame = new JFrame();
		frame.setLayout(null);
		
		if (id == ControlIDs.serverWindow){
			textArea = new JTextArea(780, 400);
			title = "Russell's Game: Server";
			dm.setSize(800 + wOffset, 450 + hOffset);
			
			startButton.setSize(buttonSize);
			startButton.setLocation(10, 25);
			
			endButton.setSize(buttonSize);
			endButton.setLocation(100, 25);
			
			textArea.setEditable(false);
			scroller.setLocation(10, 85);
			scroller.setSize(780, 355);
			
			frame.add(startButton);
			frame.add(endButton);
			frame.add(scroller);
			
			VisualOutputStream out = new VisualOutputStream (textArea);
			System.setOut(new PrintStream (out));
			this.server = server;
			
			startButton.addActionListener(startButtonPressed);
		}
		else{
			title = "Russell's Game: ERROR!! OH NO!!!";
			dm.setSize(450 + wOffset, 450 + hOffset);
		}
		
		frame.setTitle(title);
		frame.setSize(dm);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		
		//debug();
	}
	
	public Window(ControlIDs id, Canvas canvas){
		frame = new JFrame();
		
		if (id == ControlIDs.loginMenu){
			title = "Russell's Game: Log In";
			dm.setSize(600 + wOffset, 500 + hOffset);
		}
		else if (id == ControlIDs.clientWindow){
			title = "Rusell's Game: Client";
			dm.setSize(800 + wOffset, 450 + hOffset);
		}
		else{
			title = "Russell's Game: ERROR!! OH NO!!!";
			dm.setSize(450 + wOffset, 450 + hOffset);
		}
		
		frame.setTitle(title);
		frame.setSize(dm);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.add(canvas);
		
	}
	
	public void updateConsole(String text){
		System.out.println(text);
	}
	
	private void debug(){
		
		while (true)
        {
            System.out.println ("Current time: " + System.currentTimeMillis ());
            try {
				Thread.sleep (1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
		
	}
	
	// Action Listeners
	
	ActionListener startButtonPressed = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			server.startServer();
			System.out.println("Server has started...");
		}
		
	};
	
}
