
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class panel extends JPanel implements MouseListener, MouseMotionListener{
	

	public panel(){
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	//MouseListener
	public void mousePressed(MouseEvent event){
		//int x = event.getX();
	}
	public void mouseReleased(MouseEvent event){}
    public void mouseClicked(MouseEvent event){}
    public void mouseEntered(MouseEvent event){}
    public void mouseExited(MouseEvent event){}
	
	//MouseMotionListener
	public void mouseDragged( MouseEvent event ){}
    public void mouseMoved( MouseEvent event ){}

    public void paintComponent(Graphics g){
		
    }

}