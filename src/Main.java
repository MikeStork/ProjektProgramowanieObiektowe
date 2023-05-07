public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("\n\n\n");
        Projector GAME = new Projector(20,20);
        Animal dog = new Animal(3,3,Diet.Omnivore,3);
        GAME.ENTITY_LIST.add(dog);
        for (int i = 0; i < GAME.HEIGHT; i++) {
            for (int j = 0; j < GAME.WIDTH; j++) {
                GAME.ENTITY_MAP[i][j] = " ";
            }
        }
        GAME.ENTITY_MAP[dog.position.y][dog.position.x]=dog.SPRITE;
        GAME.start();
    }
}