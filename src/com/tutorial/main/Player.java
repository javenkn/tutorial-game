package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
//import java.awt.image.BufferedImage;
import java.util.Random;

public class Player extends GameObject {

	Random r = new Random();
	Handler handler;
	
//	private BufferedImage player_image;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
//		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
//		player_image = ss.grabImage(1, 1, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 32);
		y = Game.clamp(y, 0, Game.HEIGHT - 54);
		
		collision();
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.BasicEnemy || tempObject.getID() == ID.FastEnemy || tempObject.getID() == ID.SmartEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) { //tempObject = basic enemy
					// collision code
					HUD.HEALTH -= 2;
				}
			} else if(tempObject.getID() == ID.HardEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -= 5;
				}
			} else if(tempObject.getID() == ID.BossEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH = 0;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		
//		Graphics2D g2d = (Graphics2D) g;
//		
//		g.setColor(Color.green);
//		g2d.draw(getBounds());
		
		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, 32, 32);
		
//		g.drawImage(player_image, (int) x, (int) y, null);
	}

}
