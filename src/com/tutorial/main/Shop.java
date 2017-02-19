package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter{
	private Handler handler;
	private HUD hud;
	
	private int box1 = 500;
	private int box2 = 500;
	private int box3 = 500;

	public Shop(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("arial", 0, 48));
		g.drawString("Shop", Game.WIDTH / 2 - 72, 50);
		
		// box 1
		g.setFont(new Font("arial", 0, 12));
		g.drawString("Upgrade Health", 110, 120);
		g.drawString("Cost: " + box1, 110, 140);
		g.drawRect(100, 100, 110, 80);
		
		// box 2
		g.setFont(new Font("arial", 0, 12));
		g.drawString("Upgrade Speed", 260, 120);
		g.drawString("Cost: " + box2, 260, 140);
		g.drawRect(250, 100, 110, 80);
		
		// box 3
		g.setFont(new Font("arial", 0, 12));
		g.drawString("Refill Health", 410, 120);
		g.drawString("Cost: " + box3, 410, 140);
		g.drawRect(400, 100, 100, 80);
		
		g.drawString("Score: " + hud.getScore(), Game.WIDTH/2 - 72, 300);
		g.drawString("Press SPACE to go back", Game.WIDTH/2 - 72, 330);
		
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		// box 1
		if(mx >= 100 && mx <= 210) {
			if(my >= 100 && my <= 180) { // selected box 1
				if(hud.getScore() >= box1) {
					hud.setScore(hud.getScore() - box1);
					box1 += 500;
					hud.bounds += 20;
					HUD.HEALTH = 100 + (hud.bounds/2);
				}
			}
		}
		
		// box 2
		if(mx >= 250 && mx <= 360) {
			if(my >= 100 && my <= 180) { // selected box 2
				if(hud.getScore() >= box2) {
					hud.setScore(hud.getScore() - box2);
					box2 += 500;
					handler.speed++;
				}
			}
		}
		
		// box 3
		if(mx >= 400 && mx <= 500) {
			if(my >= 100 && my <= 180) { // selected box 3
				if(hud.getScore() >= box3) {
					hud.setScore(hud.getScore() - box3);
					HUD.HEALTH = 100 + (hud.bounds/2);
				}
			}
		 }
	}
}
