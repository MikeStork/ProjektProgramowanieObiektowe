package simulation;

import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Projector GAME = new Projector(50,50);
        for (int i = 0; i < GAME.HEIGHT; i++) {
            for (int j = 0; j < GAME.WIDTH; j++) {
                GAME.ENTITY_MAP[i][j] = " ";
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter starting number of cells: ");
        int num_of_cells = scanner.nextInt();

        Cell[] cells = new Cell[num_of_cells];

        System.out.println("Enter starting number of weed: ");
        int num_of_weed = scanner.nextInt();

        Weed[] weed = new Weed[num_of_weed];

        Random random = new Random();

        for(int i = 0; i < num_of_cells; i++)   {
            cells[i] = new Cell(random.nextInt(GAME.HEIGHT), random.nextInt(GAME.WIDTH), Diet.Omnivore, 1);
//            var cell = new Cell(random.nextInt(GAME.HEIGHT), random.nextInt(GAME.WIDTH),"cell", Diet.Omnivore, 1);
            GAME.ENTITY_LIST.add(cells[i]);
            GAME.ENTITY_MAP[cells[i].position.x][cells[i].position.y] = cells[i].SPRITE;
        }

        for(int i = 0; i < num_of_weed; i++)   {
            weed[i] = new Weed(random.nextInt(GAME.HEIGHT), random.nextInt(GAME.WIDTH));
//            var weed = new Weed(random.nextInt(GAME.HEIGHT), random.nextInt(GAME.WIDTH), "weed");
            GAME.ENTITY_LIST.add(weed[i]);
            GAME.ENTITY_MAP[weed[i].position.x][weed[i].position.y] = weed[i].SPRITE;
        }

        GAME.start();
    }
}