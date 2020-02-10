package org.ixnomad.ponggame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

import org.ixnomad.ponggame.Game;

public class MainComponent extends JPanel {
    
    Menu menu = new Menu(this);
    Game game = new Game(false);
    Graphics g;
    
    public static final int WINDOW_WIDTH    =     1280;
    public static final int WINDOW_HEIGHT   =     640;
    
    private static final String TITLE   =   "Pong Classic";
    /* 0 — menu
       1 — game
       2 — game over */
    public int gameState = 0;
    
    public MainComponent() {
        
    }
    
    public void mainProcess() {
        if(gameState == 0) {
            menu.menuProcess();
        } else if(gameState == 1) {
            game.gameProcess();
        } else if(gameState == 2) {
            
        }
    }
    
    @Override
    public void paint(Graphics g) {
        this.g = g;
        if(gameState == 0) {
            g.setColor(color(0, 0, 0));
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT); 
            menu.drawMenu();
            //g.drawImage(menu.texMenu, WINDOW_WIDTH / 12, WINDOW_HEIGHT / 8, WINDOW_WIDTH/12+130, WINDOW_HEIGHT/8+130, 0, 0, 130, 130, this);
            //g.drawImage(menu.texMenu, (WINDOW_WIDTH - 764) / 2, WINDOW_WIDTH / 2, WINDOW_HEIGHT/8, WINDOW_HEIGHT/8+50, 50, 50, 100, 100, this);
        }
    }
    
    public Color color(int red, int green, int blue) {
        return new Color(red, green, blue);
    }
    
    public static void main(String[] args) {
        MainComponent mainComponent = new MainComponent();
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        
        Dimension size = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setPreferredSize(size);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setTitle(TITLE);
        
        frame.add(mainComponent);
        frame.setVisible(true);
        
        while(true) {
            mainComponent.mainProcess();
            mainComponent.repaint();
        }
    }
}