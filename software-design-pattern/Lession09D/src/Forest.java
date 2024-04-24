package src;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Forest extends JFrame {

    List<Tree> trees = new ArrayList<>();

    List<MyTree> myTrees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    public void myPlantTree(MyTree tree) {
        myTrees.add(tree);
    }

    @Override
    public void paint(Graphics g) {
//        for (Tree tree : trees) {
//            tree.draw(g);
//        }
        for (MyTree tree : myTrees) {
            tree.draw(g);
        }
    }
}
