package com.york.principles.demo04.before;

public class Client {

    public static void main(String[] args) {

        MySafetyDoor door = new MySafetyDoor();
        door.antiTheft();
        door.fireproof();
        door.waterproof();
    }
}
