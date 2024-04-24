package src;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Forest forest = new Forest();

//        for (int i = 0; i < 500; i++) {
//            forest.plantTree(random(0, 500), random(0, 500), "Oak", Color.green, "OAK");
//            forest.plantTree(random(0, 500), random(0, 500), "kak", Color.orange, "MAPLE");
//        }

        for (int i = 0; i < 500; i++) {
            forest.myPlantTree(new MyTree("Oak", Color.GREEN, "OAK", random(0, 500), random(0, 500)));
            forest.myPlantTree(new MyTree("kak", Color.ORANGE, "MAPLE", random(0, 500), random(0, 500)));
        }

        forest.setSize(500, 500);
        forest.setVisible(true);
    }

    public static int random(int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }
}
