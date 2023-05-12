package game;

import java.util.concurrent.ThreadLocalRandom;

public enum BlockType {
    //Sebuah enum merupakan sebuah class khusus yang merepresentasikan sebuah grup dari constants (variable yang tidak dapat diubah, seperti variabel final). Enum merupakan kependekan dari “enumerations”, yang berarti “terdaftar secara khusus”.
    I,O,T,L,J,Z,S;

    public static BlockType random(){
        return values()[ThreadLocalRandom.current().nextInt(0,values().length)];
    }

}
