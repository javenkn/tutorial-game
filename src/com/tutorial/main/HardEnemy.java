package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HardEnemy extends GameObject {

	private Handler handler;
	
	public HardEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 5;
		velY = 5;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) {
			velY *= -1.1f;
			velY = Game.clamp(velY, -10, 10);
		}
		if(x <= 0 || x >= Game.WIDTH - 14) {
			velX *= -1.1f;
			velX = Game.clamp(velX, -10, 10);
		}
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 16, 16, 0.1f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int) x, (int) y, 16, 16);
	}
	
}