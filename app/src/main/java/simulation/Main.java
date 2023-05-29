package simulation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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

        int[] output_data = new int[13];
        output_data[0] = GAME.HEIGHT;
        output_data[1] = GAME.WIDTH;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter starting number of cells: ");
        int num_of_cells = scanner.nextInt();
        output_data[2] = num_of_cells;

        Cell[] cells = new Cell[num_of_cells];

        System.out.println("Enter starting number of weed: ");
        int num_of_weed = scanner.nextInt();
        output_data[3] = num_of_weed;

        Weed[] weed = new Weed[num_of_weed];
        System.out.println("Download data after which cycles (enter each cycle natural number differentiating them with spaces. Pattern \"12 34 56\" or just \"12\"):");
        String input = scanner.nextLine();

        GAME.DATA_DUMP_CYCLES = parseNumbers(input);
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

        GAME.start(output_data);


    }

    void Write2File(int[] tab)  {

        String fileName = "output_data.txt";

        tab[4] = Cat.getNumberOfObjects();
        tab[5] = Bird.getNumberOfObjects();
        tab[6] = Fish.getNumberOfObjects();
        tab[7] = Tiger.getNumberOfObjects();
        tab[8] = Cougar.getNumberOfObjects();
        tab[9] = Eagle.getNumberOfObjects();
        tab[10] = Pike.getNumberOfObjects();
        tab[11] = Amfiprion.getNumberOfObjects();
        tab[12] = Stork.getNumberOfObjects();

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            writer.println("Size of the map was: " + tab[0] + " " + tab[1] + ".");
            writer.println("Simulation started with " + tab[2] + "cells.");
            writer.println("Simulation started with " + tab[3] + "weed.");
            writer.println("There were " + tab[4] + " cats during simulation.");
            writer.println("There were " + tab[5] + " birds during simulation.");
            writer.println("There were " + tab[6] + " fishes during simulation.");
            writer.println("There were " + tab[7] + " tigers during simulation.");
            writer.println("There were " + tab[8] + " cougars during simulation.");
            writer.println("There were " + tab[9] + " eagles during simulation.");
            writer.println("There were " + tab[10] + " pikes during simulation.");
            writer.println("There were " + tab[11] + " amfiprions during simulation.");
            writer.println("There were " + tab[12] + " storks during simulation.");
            writer.println("Simulation ended after " + tab[13] + "cycles.");


        } catch (IOException e) {

            System.out.println(e.getMessage());

        }




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
