package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu) {
			// play button
			if(mouseOver(mx, my, 220, 150, 200, 64)) {
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2 - 32, Game.HEIGHT/2 - 32, ID.Player, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
			}
			
			// help button
			if(mouseOver(mx, my, 220, 250, 200, 64)) {
				game.gameState = STATE.Help;
			}
			
			// quit button
			if(mouseOver(mx, my, 220, 350, 200, 64)) {
				System.exit(1);
			}
		}
		
		// back button for help screen
		if(game.gameState == STATE.Help) {
			if(mouseOver(mx, my, 220, 350, 200, 64)) {
				game.gameState = STATE.Menu;
				return;
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			} else return false;
		} else return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		if(game.gameState == STATE.Menu) {
			Font font = new Font("arial", 1, 50);
			Font font2 = new Font("arial", 1, 30);
			
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("MENU", 248, 70);
			
			g.setFont(font2);
			g.drawRect(220, 150, 200, 64);
			g.drawString("Play", 288, 190);
			
			g.setColor(Color.white);
			g.drawRect(220, 250, 200, 64);
			g.drawString("Help", 288, 290);
			
			g.setColor(Color.white);
			g.drawRect(220, 350, 200, 64);
			g.drawString("Quit", 288, 390);
		} else if(game.gameState == STATE.Help) {
			Font font = new Font("arial", 1, 50);
			Font font2 = new Font("arial", 1, 30);
			Font font3 = new Font("arial", 1, 20);
			
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("HELP", 248, 70);
			
			g.setFont(font3);
			g.drawString("Use arrow keys to control player and dodge enemies", 65, 200);
			
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawRect(220, 350, 200, 64);
			g.drawString("Back", 284, 390);
		}
	}
}
