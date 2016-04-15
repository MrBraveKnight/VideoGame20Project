package gameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import tileMap.Background;
import gameState.LevelOneState;

public class MenuState extends GameState {
	
	private Background background;
	
	private int currentChoice = 0;
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	private String [] options1 = {"Start", "Help", "Quit"};
	private String [] options2 = {"Level 2", "Help", "Quit"};
	
	public MenuState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try {
			
			background = new Background("/Backgrounds/menubg.gif", 1);
			background.setVector(-0.1, 0);
			
			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 28);
			
			font = new Font("Arial", Font.PLAIN, 12);
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void init() {}
	
	public void update() {
		
		background.update();
		
	}
	
	public void draw(Graphics2D g ) {
		
		// draw bg
		background.draw(g);
		
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Dragon Tale", 80, 70);
		
		//draw menu options
		g.setFont(font);
		
		for (int i = 0; i < options1.length; i++) {
			
			if (i == currentChoice) {
				
				g.setColor(Color.BLACK);
				
			}
			else 
			{
				g.setColor(Color.RED);
				
			}
			
			g.drawString(options1[i], 145, 140 + i * 15);
			
		}
		
	}
	
	private void select() {
		
		if (currentChoice == 0) {
			
			// start
			gsm.setState(GameStateManager.LEVEL1STATE);
			
		}
		
		if (currentChoice == 1) {
			
			// help
			
		}
		
		if (currentChoice == 2) {
			
			// quit
			System.exit(0);
			
		}
		
	}
	
	public void keyPressed(int k) {
		
		if (k == KeyEvent.VK_ENTER) {
			
			select();
			
		}
		
		if (k == KeyEvent.VK_UP) {
			
			currentChoice --;
			
			if (currentChoice == -1) {
				
				currentChoice = options1.length -1;
				
			}
			
		}
		
		if (k == KeyEvent.VK_DOWN) {
			
			currentChoice ++;
			
			if (currentChoice == options1.length) {
				
				currentChoice = 0;
				
			}
			
		}
		
	}
	
	public void keyReleased(int k) {}
	
}