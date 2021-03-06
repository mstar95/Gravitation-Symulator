package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.Timer;

import controller.Controller;
import model.Mark;
import model.Observer;
import model.Params;
import model.Planet;

public class BoardPanel extends JPanel  implements ActionListener, Observer
{
	private Params params;
	private Timer timer;
	private Controller controller;
	private final int DELAY = 50;
	public BoardPanel(int width,int height,Controller c)
	{
		setPreferredSize(new Dimension(width, height));
		
		setBackground(Color.black);
		setFocusable(true);
		
		timer = new Timer(DELAY,this);
		params = new Params();
		
		controller = c;
		
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		controller.update();
		repaint();
	}

	@Override
	public void update(Params params) 
	{
		this.params = params;
	}
	
	public void paintComponent(Graphics g) 
	{
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        drawMauseVector(g2d);
        drawPaths(g2d);
        drawPlanets(g2d);
        repaint();
     }
	
	private void drawMauseVector(Graphics2D g2d)
	{
		if(params.isMousePressed == true)
		{    	
	       	g2d.setColor(Color.GREEN);
	       	g2d.drawLine(params.getMouseVector().getA().getIntX(),
	       		params.getMouseVector().getA().getIntY(),
	       		params.getMouseVector().getB().getIntX(),
        		params.getMouseVector().getB().getIntY());
        }
		repaint();
	}
	
	private void drawPlanets(Graphics2D g2d)
	{
		if (params.getPlanets() == null)
			return;
		for(Planet p : params.getPlanets())
		{
			g2d.setColor(p.getType());
			g2d.fillOval(p.getIntX(), p.getIntY(), p.getIntRadius(), p.getIntRadius());
		}
		repaint();
	}
	
	private void drawPaths(Graphics2D g2d)
	{
		if (params.getPaths() == null)
			return;
		LinkedList<Mark> paths = params.getPaths();
		paths.forEach(m->{
			g2d.setColor(m.getColor());
			g2d.fillOval(m.getIntX(), m.getIntY(), 3,3);
		});
		repaint();
	}
}
