package simulation;

public class Main{
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("\n\n\n");
        Projector GAME = new Projector(20,20);
        Organism dog1 = new Organism(3,3, "Dog",Diet.Omnivore,3);
        Organism dog2 = new Organism(7,5, "Dog",Diet.Omnivore,2);
        Organism dog3 = new Organism(10,2, "Dog",Diet.Omnivore,2);
        Weed baobab = new Weed(2,2, "Baobab");
        Water pond = new Water(9,9,"Pond");
        GAME.ENTITY_LIST.add(dog1);
        for (int i = 0; i < GAME.HEIGHT; i++) {
            for (int j = 0; j < GAME.WIDTH; j++) {
                GAME.ENTITY_MAP[i][j] = " ";
            }
        }
        GAME.start();
    }
}