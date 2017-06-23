package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{
	
	private int x;
	private int y;
	private Client client;
	
	public MouseInput() {
		
	}
	
	public void setClient(Client client){
		this.client = client;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		x = e.getX();
		y = e.getY();
		
		client.isClicked(x, y);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
}
