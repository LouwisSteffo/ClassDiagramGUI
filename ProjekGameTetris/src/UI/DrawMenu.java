package UI;

import game.Game;
import game.GameState;

import javax.swing.*;
import java.awt.*;

public class DrawMenu extends JLabel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (Game.gamestate == GameState.start) {
            g.setColor(new Color(24, 70, 145));
            g.fillRect(0, GUI.height / 2 - 50, GUI.width+200, 100);
            g.setColor(Color.WHITE);
            g.setFont(GUI.pixelfont.deriveFont(14f));
            g.drawString("PRESS ENTER TO START", GUI.width/2, GUI.height / 2 +10);
        }else if(Game.gamestate == GameState.pause) {
            g.setColor(new Color(100, 100, 100));
            g.fillRect(0, GUI.height / 2 - 50, GUI.width+200, 100);
            g.setColor(Color.WHITE);
            g.setFont(GUI.pixelfont.deriveFont(14f));
            g.drawString("PRESS ESC TO CONTINUE", GUI.width/2 -10, GUI.height / 2 +10);
        }else if(Game.gamestate == GameState.gameover){
            g.setColor(new Color(28, 99, 175));
            g.fillRect(0, GUI.height / 2 - 50, GUI.width+200, 100);
            g.setColor(Color.WHITE);
            g.setFont(GUI.pixelfont.deriveFont(14f));
            g.drawString("YOU LOST. PRESS ENTER TO START AGAIN", 75, GUI.height / 2 +10);
        }

        repaint();

    }
}