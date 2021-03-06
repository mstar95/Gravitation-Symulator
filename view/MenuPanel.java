package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.Controller;

public class MenuPanel extends JPanel 
{
	private JButton buttonTiny, buttonSmall, buttonMedium, 
		buttonLarge, buttonHuge, buttonClear, buttonMove;
	private JTextField textMass;
	private Controller controller;
	
	public MenuPanel(int width,int height,Controller c)
	{
		setPreferredSize(new Dimension(width, height));
		
		setBackground(Color.gray);
		setFocusable(true);
		controller = c;
		setupButtons();
	}
	
	//adds all buttons and labels
	private void setupButtons() 
	{
		setLayout( new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.LINE_END;
		
		JLabel labelMass = new JLabel("Mass:");
		labelMass.setForeground(Color.RED);
		c.gridx = 0;
		c.gridy = 0;
		add(labelMass, c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		buttonTiny = new JButton("Tiny");
		//buttonTiny.setFont(new Font("Arial", Font.PLAIN, 16));
		c.gridx = 0;
		c.gridy = 1;
		add(buttonTiny, c);

		buttonSmall = new JButton("Small");
		c.gridx = 0;
		c.gridy = 2;
		add(buttonSmall, c);

		buttonMedium = new JButton("Medium");
		c.gridx = 0;
		c.gridy = 3;
		add(buttonMedium, c);

		buttonLarge = new JButton("Large");
		c.gridx = 0;
		c.gridy = 4;
		add(buttonLarge, c);
		
		buttonHuge = new JButton("Huge");
		c.gridx = 0;
		c.gridy = 5;
		add(buttonHuge, c);
		
		c.anchor = GridBagConstraints.LINE_START;
		
		textMass = new JTextField(10);
		textMass.setText("1000");
		c.gridx = 1;
		c.gridy = 0;
		add(textMass,c);
		
		buttonMove = new JButton("Stop");
		c.gridx = 1;
		c.gridy = 4;
		add(buttonMove,c);
		
		buttonClear = new JButton("Clear");
		c.gridx = 1;
		c.gridy = 5;
		add(buttonClear,c);
	}
	
	public void setupListeners()
	{
		buttonTiny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textMass.setText("1");
			}
		});
		
		buttonSmall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textMass.setText("1000");
			}
		});
		
		buttonMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textMass.setText("10000");
			}
		});
		
		buttonLarge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textMass.setText("100000");
			}
		});
		
		buttonHuge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textMass.setText("1000000");
			}
		});
		
		buttonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.clearPlanets();
			}
		});
		
		buttonMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buttonMove.getText().equals("Stop"))
				{
					controller.switchPlanetsMove(false);
					buttonMove.setText("Start");
				}
				else
				{
					controller.switchPlanetsMove(true);
					buttonMove.setText("Stop");
				}
			}
		});
	}
	
	public int getMass()
	{
		return Integer.parseInt(textMass.getText());
	}
}
