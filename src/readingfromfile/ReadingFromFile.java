package readingfromfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadingFromFile {
    
    ArrayList<Entity> entityList = new ArrayList();
    BufferedReader bufferedReader;
    Scanner scanner;
    
    public void loadEntityParams(String filePath) {
        for(int i = 0; i < 10; i++) {
            entityList.add(new Entity("entity"+i)); //creating entities
        }
        File dataFile;
        try {
            dataFile = new File(filePath);
            scanner = new Scanner(dataFile);
            if(!dataFile.exists()) dataFile.createNewFile();
            bufferedReader = new BufferedReader(new FileReader(filePath));
            
            //There is main code, I have a problem here
            while(bufferedReader.readLine() != null) {
                int t = 0;
                while(t < entityList.size()) {
                    Entity e = entityList.get(t); //selection of the required object
                    for(int i = 0; i < 3; i++) {  //3 —> each object has three parameters
                        if(scanner.hasNext("#")) { //"#" —> ending of the entity.data
                            break;
                        } else if(scanner.hasNextInt()) {
                            if(i == 0) {
                                e.setParam1(scanner.nextInt()); //trying setting param1
                            } else if(i == 1) {
                                e.setParam2(scanner.nextInt());
                            } else if(i == 2) {
                                e.setParam3(scanner.nextInt());
                            }
                        } else if(scanner.hasNext("]")) { //"]" —> ending of the line
                            scanner.nextLine();
                        } else {
                            scanner.next();
                        }
                    }
                    t++; //next object
                }
            }
            
            //Ending
            scanner.close();
            bufferedReader.close();
            
            //Checking
            System.out.print("\n");
            for(int i = 0; i < entityList.size(); i++) {
                Entity e = entityList.get(i);
                System.out.print("\n" + e.getParam1() + " " + e.getParam2() + " " + e.getParam3());
            }
        } catch (IOException e) {
            System.out.println("Error: falied to load " + filePath + "/n" + e);
        }
    }
    
    public static void main(String[] args) {
        ReadingFromFile m = new ReadingFromFile();
        m.loadEntityParams("src/readingfromfile/entity.data");
    }
}
