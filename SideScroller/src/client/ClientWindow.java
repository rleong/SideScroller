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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private final Dimension BUTTONSIZE = new Dimension(100, 50);
	private final Dimension MENUSIZE = new Dimension(600, 500);
	
	// Main Menu
	private ImageIcon loginButtonImg = new ImageIcon("graphics/gui/buttons/LoginButton.png");
	private ImageIcon signUpButtonImg = new ImageIcon("graphics/gui/buttons/SignUpButton.png");
	private ImageIcon optionsButtonImg = new ImageIcon("graphics/gui/buttons/OptionsButton.png");
	private ImageIcon updateButtonImg = new ImageIcon("graphics/gui/buttons/UpdateButton.png");
	private ImageIcon creditsButtonImg = new ImageIcon("graphics/gui/buttons/LoginButton.png");
	
	private JButton loginButton = new JButton(loginButtonImg);
	private JButton signUpButton = new JButton(signUpButtonImg);
	private JButton optionsButton = new JButton(optionsButtonImg);
	private JButton updateButton = new JButton(updateButtonImg);
	private JButton creditsButton = new JButton(creditsButtonImg);
	
	private JLabel mainMenuBG = new JLabel(new ImageIcon("graphics/gui/MainMenu.png"));
	
	// Borders count for some reason
	private final int hOffset = 29, wOffset = 6;
	
	public ClientWindow(ControlIDs id, Canvas canvas){
		frame = new JFrame();
		frame.setLayout(null);
		
		if (id == ControlIDs.mainMenu){
			title = "Rusty's Game: Main Menu";
			dm.setSize(600 + wOffset, 500 + hOffset);
			
			loginButton.setSize(BUTTONSIZE);
			signUpButton.setSize(BUTTONSIZE);
			optionsButton.setSize(BUTTONSIZE);
			updateButton.setSize(BUTTONSIZE);
			creditsButton.setSize(BUTTONSIZE);
			
			loginButton.setLocation(20, 430);
			signUpButton.setLocation(135, 430);
			optionsButton.setLocation(250, 430);
			updateButton.setLocation(365, 430);
			creditsButton.setLocation(480, 430);
			
			mainMenuBG.setSize(MENUSIZE);
		}
		else if (id == ControlIDs.loginMenu){
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
		
		if (id == ControlIDs.mainMenu){
			frame.add(mainMenuBG);
			frame.add(loginButton);
			frame.add(signUpButton);
			frame.add(optionsButton);
			frame.add(updateButton);
			frame.add(creditsButton);
		}
		else if (id == ControlIDs.loginMenu){
		}
		else if (id == ControlIDs.clientWindow){
		}
		else{
		}
		
	}
	
}
