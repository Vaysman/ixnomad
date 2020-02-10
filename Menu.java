package org.ixnomad.ponggame;

import org.ixnomad.ponggame.TextureLoader.TextureLoader;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

public class Menu {

    TextureLoader tex = new TextureLoader();
    Graphics g;
    MainComponent m;
    public Image texMenu = new ImageIcon("src/org/ixnomad/ponggame/data/texture_menu.png").getImage();;
    
    public Menu(MainComponent mainComponent) {
        this.m = mainComponent;
        this.tex.loadTextureParams("src/org/ixnomad/ponggame/data/tex_loc.data");
    }
       
    public void menuProcess() {
        
    }
    
    public void drawMenu() {
        m.g.drawImage(this.texMenu, MainComponent.WINDOW_WIDTH / 12, MainComponent.WINDOW_HEIGHT / 8, MainComponent.WINDOW_WIDTH/12+130, MainComponent.WINDOW_HEIGHT/8+130, 0, 0, 130, 130, m);
        //m.g.drawImage(texMenu, MainComponent.WIDTH - , dy1, dx2, dy2, sx1, sy1, sx2, sy2, m);
    }
}
