package UI;

import inputOutput.KeyHandler;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GUI {

    public static int width = 320, height = 576;
    JFrame jf;

    public static Font pixelfont;

    public void create() throws FontFormatException, IOException {

        jf = new JFrame("TETRIS");
        jf.setSize(width + 17 + 200, height + 41); // 10 wide, 18 height
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.addKeyListener(new KeyHandler());
        jf.requestFocus();

        pixelfont = Font.createFont(Font.TRUETYPE_FONT, new File("rsc/fonts/FFFFORWA.TTF")).deriveFont(12f);


        DrawMenu dm = new DrawMenu();
        setupDraw(dm, 0, 0, width +200, height);

        DrawGame dg = new DrawGame();
        setupDraw(dg, 0, 1, width + 1, height + 1);

        DrawInterface di = new DrawInterface();
        setupDraw(di, width + 1, 1, width, height);


        jf.setVisible(true);


    }

    private void setupDraw(JLabel draw, int x, int y, int width, int height) {
        draw.setBounds(x, y, width, height);
        draw.setVisible(true);
        jf.add(draw);
    }

}



