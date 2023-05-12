package infrastrucure;

import UI.GUI;
import game.Block;
import game.Game;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main extends JFrame {
    public static void main(String[] args) throws IOException, FontFormatException {
        Game.currentBlock=new Block();
        Game.blocks.add(Game.currentBlock);
        Game.nextBlock=new Block();
        GUI gui = new GUI();
        gui.create();
        startLoop();
    }

    private static void startLoop() {
        GameLoop loop = new GameLoop();
        loop.start();
    }

}
