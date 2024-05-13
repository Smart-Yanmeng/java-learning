package com.york.pattern.memento.black_box;

public class Client {

    public static void main(String[] args) {

        GameRole gameRole = new GameRole();
        gameRole.initState();
        gameRole.show();

        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setMemento(gameRole.saveState());

        gameRole.fight();
        gameRole.show();

        gameRole.recoveryState(roleStateCaretaker.getMemento());
        gameRole.show();
    }
}
