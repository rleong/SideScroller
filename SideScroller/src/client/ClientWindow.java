package client;

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

public class ClientWindow {

	
	// Attributes
	private JFrame frame;
	private static Dimension dm = new Dimension();
	private String title;
	
	// Borders count for some reason
	private final int hOffset = 29, wOffset = 6;
	
	public ClientWindow(ControlIDs id, Canvas canvas){
		frame = new JFrame();
		
		if (id == ControlIDs.loginMenu){
			title = "Rusty's Game: Log In";
			dm.setSize(600 + wOffset, 500 + hOffset);
		}
		else if (id == ControlIDs.clientWindow){
			title = "Rusty's Game: Client";
			dm.setSize(800 + wOffset, 450 + hOffset);
		}
		else{
			title = "Rusty's Game: ERROR!! OH NO!!!";
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
	
}
