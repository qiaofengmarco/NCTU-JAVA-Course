import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;
import javax.swing.*;
public class Pro2 extends JApplet
{
	public static void paintTree(Graphics g, int x, int y)//tree
	{
		g.setColor(Color.GREEN);
		g.fillArc(x-15,y+20,30,30,-45,270);
		g.fillArc(x-10,y+5,20,20,0,-180);
		Polygon branch = new Polygon();
		branch.addPoint(x,y+35);
		branch.addPoint(x-30,y+65);
		branch.addPoint(x+30,y+65);
		Polygon treetop = new Polygon();
		treetop.addPoint(x-10,y+15);
		treetop.addPoint(x+10,y+15);
		treetop.addPoint(x,y);
		g.fillPolygon(treetop);
		g.fillPolygon(branch);
		g.setColor(Color.ORANGE);
		g.drawLine(x-5,y+65,x-5,y+95);
		g.drawLine(x+5,y+65,x+5,y+95);
		g.setColor(Color.BLACK);		
	}
	public static void paintGrass(Graphics g, int x, int y)//grass
	{
		g.setColor(Color.green);
		Polygon grass = new Polygon();
		grass.addPoint(x,y);
		grass.addPoint(x+5,y+5);
		grass.addPoint(x+10,y-5);
		grass.addPoint(x+15,y+5);
		grass.addPoint(x+20,y-5);
		grass.addPoint(x+25,y+5);
		grass.addPoint(x+30,y);
		grass.addPoint(x+23,y+15);
		grass.addPoint(x+3,y+15);
		g.fillPolygon(grass);
		g.setColor(Color.BLACK);
	}		
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.setColor(Color.ORANGE);
		Polygon roof = new Polygon();//roof
		roof.addPoint(50,200);
		roof.addPoint(125,200);
		roof.addPoint(100,150);
		g.drawPolygon(roof);
		g.drawLine(100,150,175,125);
		g.drawLine(125,200,200,175);
		g.drawLine(175,125,200,175);
		g.setColor(Color.RED);

		g.drawLine(115,300,185,270);//house outline
		g.drawLine(185,270,185,180);
		g.drawRect(65,200,50,100);

		g.setColor(Color.gray);		
		g.drawRect(75,220,30,30); //window
		g.drawLine(75,235,105,235);
		g.drawLine(90,220,90,250);

		g.drawLine(150,245,150,285);//door
		g.drawLine(150,245,162,241);
		g.drawLine(162,241,162,279);

		g.drawOval(75,130,20,10);
		g.drawLine(75,135,75,175);
		g.drawLine(95,135,95,155);

		for (int i = 215; i <= 475; i += 50)//forest
			Pro2.paintTree(g, i, 180);
		Pro2.paintTree(g,30,180);
		
		g.setColor(Color.ORANGE);
		g.drawArc(360,58,50,50,120,120);//moon
		g.drawArc(368,40,87,87,150,60);
		g.setColor(Color.BLACK);
	
		for (int i = 20; i <= 480; i += 50)
			for (int j = 330; j <= 400; j += 30)
				Pro2.paintGrass(g,i,j);
	}	
}