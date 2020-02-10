
package org.ixnomad.ponggame.TextureLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class TextureLoader {
    
    ArrayList<Texture> texList = new ArrayList();
    BufferedReader bufferedReader;
    Scanner scanner;
    
    public TextureLoader() {
    }
    
    public void loadTextureParams(String filePath) {
        File texFile;
        try {
            texFile = new File(filePath);
            scanner = new Scanner(texFile);
            for(int i = 0; i < 32; i++) {
                texList.add(new Texture("tex"+i));
            }
            if(!texFile.exists()) texFile.createNewFile();
            bufferedReader = new BufferedReader(new FileReader(filePath));
            while(bufferedReader.readLine() != null) {
                
                int t = 0;
                Texture tex = texList.get(t);
                for(int i = 0; i < texList.size(); i++) {

                }
                t++;
            }
            
            scanner.close();
            bufferedReader.close();
            System.out.print("\n");

            for(int ii = 0; ii < 10; ii++) {
                Texture tex1 = texList.get(ii);
                System.out.print("\n" + tex1.sx1 + " " + tex1.sy1 + " " + tex1.sx2 + " " + tex1.sy2);
            }
        } catch (IOException e) {
            System.out.println("Error: falied to load " + filePath + "/n" + e);
        }
    }
    
    private class Texture {
        public int dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2;
        private final String name;
        public Texture(String name) {
            this.name = name;
        }
        String getName() {
            return name;
        }
    }
}
