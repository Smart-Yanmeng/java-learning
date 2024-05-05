package com.york.principles.demo04.after;

public class Client {

    public static void main(String[] args) {

        MySafetyDoor door = new MySafetyDoor();
        door.antiTheft();
        door.fireproof();
        door.waterproof();

        AnotherSafetyDoor anotherDoor = new AnotherSafetyDoor();
        anotherDoor.antiTheft();
        anotherDoor.fireproof();
    }
}
