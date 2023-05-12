package inputOutput;

import data.Collision;
import game.Game;
import game.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(Game.gamestate == GameState.start){
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                Game.gamestate = GameState.ingame;
            }
        }

        if(Game.gamestate == GameState.ingame){
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                try {
                    if(!Collision.collideInRotation(Game.currentBlock)){
                        Game.currentBlock.rotate();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                Game.speedup = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                try {
                    if(!Collision.collideWithWall(Game.currentBlock, 1) && !Collision.collideWithBlock(Game.currentBlock, 1)){
                        Game.currentBlock.setX(Game.currentBlock.getX() + 1);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                try {
                    if(!Collision.collideWithWall(Game.currentBlock, -1) && !Collision.collideWithBlock(Game.currentBlock, -1)){
                        Game.currentBlock.setX(Game.currentBlock.getX() - 1);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                Game.gamestate = GameState.pause;
            }
        } else if (Game.gamestate == GameState.pause) {
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                Game.gamestate = GameState.ingame;
            }
        } else if (Game.gamestate == GameState.gameover) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                Game.gamestate = GameState.ingame;
                Game.clear();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(Game.gamestate == GameState.ingame){
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                Game.speedup = false;
            }
        }
    }
}
