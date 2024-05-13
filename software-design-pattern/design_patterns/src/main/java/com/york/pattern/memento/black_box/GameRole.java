package com.york.pattern.memento.black_box;

public class GameRole {

    private int vit;

    private int atk;

    private int def;

    public void initState() {
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }

    public void fight() {
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }

    public void show() {
        System.out.println("角色当前状态：");
        System.out.println("生命力：" + vit);
        System.out.println("攻击力：" + atk);
        System.out.println("防御力：" + def);
    }

    public Memento saveState() {
        return new RoleStateMemento(vit, atk, def);
    }

    public void recoveryState(Memento memento) {
        RoleStateMemento roleStateMemento = (RoleStateMemento) memento;
        this.vit = roleStateMemento.getVit();
        this.atk = roleStateMemento.getAtk();
        this.def = roleStateMemento.getDef();
    }

    private static class RoleStateMemento implements Memento {

        private int vit;

        private int atk;

        private int def;

        public RoleStateMemento(int vit, int atk, int def) {
            this.vit = vit;
            this.atk = atk;
            this.def = def;
        }

        public RoleStateMemento() {
        }

        public int getVit() {
            return vit;
        }

        public void setVit(int vit) {
            this.vit = vit;
        }

        public int getAtk() {
            return atk;
        }

        public void setAtk(int atk) {
            this.atk = atk;
        }

        public int getDef() {
            return def;
        }

        public void setDef(int def) {
            this.def = def;
        }
    }
}
