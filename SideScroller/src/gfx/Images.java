package gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	
	// GUI related
	BufferedImage loginMenu;
	BufferedImage serverMenu;
	BufferedImage loginButton;
	BufferedImage optionsButton;
	BufferedImage signUpButton;
	BufferedImage updateButton;
	
	public Images(){
		
		// GUI related
		loginMenu = createImage("gui/LoginMenu.png");
		serverMenu = createImage("gui/ServerMenu.png");
		loginButton = createImage("gui/buttons/LoginButton.png");
		optionsButton = createImage("gui/buttons/OptionsButton.png");
		signUpButton = createImage("gui/buttons/SignUpButton.png");
		updateButton = createImage("gui/buttons/UpdateButton.png");
		
	}
	
	// Easy creating images
	
	public BufferedImage createImage(String location){
		
		BufferedImage bufferedImage;
		try{
			bufferedImage = ImageIO.read(new File("graphics/" + location));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	// Getters
	
	public BufferedImage getLoginMenu(){
		return loginMenu;
	}
	
	public BufferedImage getServerMenu(){
		return serverMenu;
	}
	
	public BufferedImage getLoginButton(){
		return loginButton;
	}
	
	public BufferedImage getOptionsButton(){
		return optionsButton;
	}
	
	public BufferedImage getSignUpButton(){
		return signUpButton;
	}
	
	public BufferedImage getUpdateButton(){
		return updateButton;
	}

}
