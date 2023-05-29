package simulation;

import simulation.bodyparts.Claws;

import java.util.ArrayList;

public class Cat extends Cell {
    Claws claws = new Claws();
    Cat(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
    }

    @Override
    void Breed(ArrayList<Entity> entity_list) {
        entity_list.add(new Cat(this.position.x, this.position.y,this.diet,this.speed));
    }
}
