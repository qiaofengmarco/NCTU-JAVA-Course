import java.awt.*;	
import javax.swing.*;
import java.awt.Color;

public class SortPanel101 extends JPanel
{	int number1[ ] = new int [100];
     int number2[ ] = new int [100];
	
public SortPanel101( )
	{
	 for(int j = 0; j < number1.length; ++j)
		  { number1[j] = (int)(Math.random()*101);
		    number2[j]=number1[j];  }	
	 setSize(500,600);
	 setVisible(true);      }

public void paintComponent(Graphics g)
      {  int i,j;
         super.paintComponent(g);
         g.setColor(Color.magenta);
             
        for(j = 0; j < number1.length; ++j)
              g.drawLine( 10, 10+3*j, 10 + number1[j], 10+3*j );
             		  
        g.drawString("The original array", 10, 325);
        System.out.println(" Original");
        bubblesort();
              
         for(j = 0; j < number2.length; ++j)
              g.drawLine(225, 10+3*j, 225 + number2[j], 10+3*j);
              
         g.drawString("The sorted array", 225,325);  
         System.out.println(" After sort");
          }      

public void bubblesort()
{	//we can obtain the size of a Java array like this:
     int size = number2.length;
	int x, y, temp;
	for(x = 0; x < size - 1; ++x)
	  {   for( y = 0; y < size - 1 - x; ++y)
	        if(number2[y] > number2[y +1] )
	        {	temp = number2[y];
	                number2[y] = number2[y+1];
	                number2[y+1] = temp; }    
	  }
}
public static void main(String args[ ])
{	    
SortPanel101  p = new SortPanel101( );
         JFrame w = new JFrame();
	    w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	 
	    w.add(p);
	    w.setSize(500,600);
	    w.setVisible(true);	  
}
}
