package inputOutput;

import game.Game;

import java.io.*;
import java.util.Scanner;

public class DataHandler {
    public static void load() {
        File file = new File("rsc/data/save.txt");

        try {
            Scanner sc =  new Scanner(file);
            Game.highscore = sc.nextInt();
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void save(){
        File file = new File("rsc/data/save.txt");

        try {
            OutputStream stream = new FileOutputStream(file);
            try {
                stream.write(Integer.toString(Game.highscore).getBytes());
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
