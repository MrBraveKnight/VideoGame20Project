package gameState;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import entity.Enemy;
import entity.Explosion;
import entity.HUD;
import entity.Player;
import main.GamePanel;
import tileMap.Background;
import tileMap.TileMap;

public class LevelTwoState extends GameState {
	
	private TileMap tileMap;
	private Background background;
	
	private Player player;
	
	private ArrayList<Enemy> enemies;
	private ArrayList<Explosion> explosions;
	
	private HUD hud;
	
	public LevelTwoState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		init();
		
	}
	
	public void init() {
		
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tilesets/grasstileset.gif");
		tileMap.loadMap("/Maps/level1-2.map");
		tileMap.setPosition(0, 0);
		tileMap.setTween(0.07);
		
		background = new Background("/Backgrounds/grassbg1.gif", 0.1);
		
		player = new Player(tileMap);
		player.setPosition(100, 100);
		
		explosions = new ArrayList<Explosion>();
		
		hud = new HUD(player);
		
	}
	
	public void update() {
		
		// update player
		player.update();
		
		tileMap.setPosition(GamePanel.WIDTH / 2 - player.getx(), GamePanel.HEIGHT / 2 - player.gety());
		
		// set background
		background.setPosition(tileMap.getx(), tileMap.gety()); 
		
		// attack enemies
		player.checkAttack(enemies);
		
		// update all enemies
		for (int i = 0; i < enemies.size(); i++) {
			
			Enemy e  = enemies.get(i);
			e.update();
			
			if (e.isDead()) {
				
				enemies.remove(i);
				i--;
				
				explosions.add(new Explosion(e.getx(), e.gety()));
				
			}
			
		}
		
		// update all explosions
		for (int i = 0; i < explosions.size(); i ++) {
			
			explosions.get(i).update();
			
			if (explosions.get(i).shouldRemove()) {
				
				explosions.remove(i);
				i--;
				
			}
			
		}
		
	}
	
	public void draw(Graphics2D g) {
		
		// draw background
		background.draw(g); 
		
		// draw tilemap
		tileMap.draw(g);	
		
		// draw player
		player.draw(g);
		
		// draw enemies
		for (int i = 0; i < enemies.size(); i++) {
			
			enemies.get(i).draw(g);
			
		}
		
		// draw explosions
		for (int i = 0; i < explosions.size(); i++) {
			
			explosions.get(i).setMapPosition((int)tileMap.getx(), (int)tileMap.gety());
			explosions.get(i).draw(g);
			
		}
		
		// draw hud
		hud.draw(g);
		
	}
	
	public void keyPressed(int k) {
		
		if(k == KeyEvent.VK_LEFT) {
			
			player.setLeft(true);
			
		}
		
		if (k == KeyEvent.VK_RIGHT) {
			
			player.setRight(true);
			
		}
		
		if (k == KeyEvent.VK_UP) {
			
			player.setUp(true);
			
		}
		
		if (k == KeyEvent.VK_DOWN) {
			
			player.setDown(true);
			
		}
		
		if (k == KeyEvent.VK_W) {
			
			player.setJumping(true);
			
		}
		
		if (k == KeyEvent.VK_E) {
			
			player.setGliding(true);
			
		}
		
		if (k == KeyEvent.VK_R) {
			
			player.setScratching();
			
		}
		
		if (k == KeyEvent.VK_F) {
			
			player.setFiring();
			
		}
		
	}
	
	public void keyReleased(int k) {
		
		if (k == KeyEvent.VK_LEFT) {
			
			player.setLeft(false);
			
		}
		
		if (k == KeyEvent.VK_RIGHT) {
			
			player.setRight(false);
			
		}
		
		if (k == KeyEvent.VK_UP) {
			
			player.setUp(false);
			
		}
		
		if (k == KeyEvent.VK_DOWN) {
			
			player.setDown(false);
			
		}
		
		if (k == KeyEvent.VK_W) {
			
			player.setJumping(false);
			
		}
		
		if (k == KeyEvent.VK_E) {
			
			player.setGliding(false);
			
		}
		
	}
	
}