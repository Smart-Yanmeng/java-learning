package com.york.pattern.memento.white_box;

public class Client {

    public static void main(String[] args) {

        GameRole gameRole = new GameRole();
        gameRole.initState();
        gameRole.show();

        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setRoleStateMemento(gameRole.saveState());

        gameRole.fight();
        gameRole.show();

        gameRole.recoveryState(roleStateCaretaker.getRoleStateMemento());
        gameRole.show();
    }
}
