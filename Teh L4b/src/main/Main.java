/*package main; // should rename package and class

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	
	public static ImageIcon menuBackground = new ImageIcon("output_br7mrW.gif"); // display image

	public static void main(String[] args) {
		
		JFrame windowFrame = new JFrame(); // game window
		windowFrame.setSize(800, 600); // width, height
		windowFrame.setResizable(false);
		
		JPanel panel = setPanelImage(menuBackground);
		panel.setLayout(null);
		
		KeyListener pressSpace = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// unused
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_SPACE) { // if spacebar pressed
					
					System.out.println("start");
					
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// unused
			}
			
		};
		
		panel.addKeyListener(pressSpace);
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		
		windowFrame.add(panel); // frame > panel > content
		windowFrame.setVisible(true);
		
	}
	
	public static JPanel setPanelImage(ImageIcon image) {
		
		JPanel newPanel = new JPanel() {
			
			@Override
			public void paintComponent(Graphics g) {

				super.paintComponent(g);
				g.drawImage(image.getImage(), 0, 0, this);
			
			}
			
		};
		
		return newPanel;
	
	}

}
*/