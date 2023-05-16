package simulation;

public class Main{
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("\n\n\n");
        Projector GAME = new Projector(200,200);
        for (int i = 0; i < GAME.HEIGHT; i++) {
            for (int j = 0; j < GAME.WIDTH; j++) {
                GAME.ENTITY_MAP[i][j] = " ";
            }
        }
        GAME.start();
    }
}