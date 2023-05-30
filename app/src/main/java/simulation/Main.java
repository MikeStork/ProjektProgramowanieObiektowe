package simulation;

import simulation.data.Diet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main{

    public static int num_of_cells;
    public static int num_of_weed;

    public static void main(String[] args) {
        Projector GAME = new Projector(50,50);
        for (int i = 0; i < GAME.HEIGHT; i++) {
            for (int j = 0; j < GAME.WIDTH; j++) {
                GAME.ENTITY_MAP[i][j] = " ";
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter starting number of cells: ");
        num_of_cells = scanner.nextInt();

        Cell[] cells = new Cell[num_of_cells];

        System.out.println("Enter starting number of weed: ");
        num_of_weed = scanner.nextInt();

        Weed[] weed = new Weed[num_of_weed];
        System.out.println("Cycles to dump data of (Pattern \"12 34 56\" or just \"12\"): ");
        scanner.nextLine();
        String input = scanner.nextLine();
        GAME.DATA_DUMP_CYCLES = parseNumbers(input);
        Collections.sort(GAME.DATA_DUMP_CYCLES);

        Random random = new Random();

        for(int i = 0; i < num_of_cells; i++)   {
            cells[i] = new Cell(random.nextInt(GAME.HEIGHT), random.nextInt(GAME.WIDTH), Diet.Omnivore, 1);
            GAME.ENTITY_LIST.add(cells[i]);
            GAME.ENTITY_MAP[cells[i].position.x][cells[i].position.y] = cells[i].SPRITE;
        }

        for(int i = 0; i < num_of_weed; i++)   {
            weed[i] = new Weed(random.nextInt(GAME.HEIGHT), random.nextInt(GAME.WIDTH));
            GAME.ENTITY_LIST.add(weed[i]);
            GAME.ENTITY_MAP[weed[i].position.x][weed[i].position.y] = weed[i].SPRITE;
        }

        GAME.start();
    }


    private static ArrayList<Integer> parseNumbers(String input) {
        ArrayList<Integer> numbers = new ArrayList<>();
        String[] numberStrings = input.split(" ");

        for (String numberString : numberStrings) {
            try {
                int number = Integer.parseInt(numberString);
                numbers.add(number);
            } catch (NumberFormatException e) {
                // Handle invalid number format if needed
                System.out.println("Invalid number format: " + numberString);
            }
        }

        return numbers;
    }
}
