package com.york.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class Home {

    private final List<Animal> nodeList = new ArrayList<Animal>();

    public void addAnimal(Animal animal) {
        nodeList.add(animal);
    }

    public void action(Person person) {
        for (Animal animal : nodeList) {
            animal.accept(person);
        }
    }
}
