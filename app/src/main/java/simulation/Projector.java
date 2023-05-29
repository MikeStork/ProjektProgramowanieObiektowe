package simulation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import static simulation.Main.num_of_cells;
import static simulation.Main.num_of_weed;

public class Projector {
    static int WIDTH;
    static int HEIGHT;
    public ArrayList<Integer>   DATA_DUMP_CYCLES;
    private boolean running;
    private final long OPTIMAL_TIME = 1000000000 / CONSTANTS.FPS_TARGET;
    public int cycle = 0;
    ArrayList<Entity> ENTITY_LIST = new ArrayList<Entity>();
    String[][] ENTITY_MAP;

    Projector(int width, int height){
        this.WIDTH = width;
        this.HEIGHT = height;
        ENTITY_MAP = new String[WIDTH][HEIGHT];
    }
    /**
     * Game starting method, controlls game
     */
    public void start() {
        running = true;
        long lastUpdateTime = System.nanoTime();
        while (running) {
            long currentTime = System.nanoTime();
            long elapsedTime = currentTime - lastUpdateTime;

            if (elapsedTime >= OPTIMAL_TIME) {
                if (System.getProperty("os.name").contains("Windows")) {
                    try {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
                update();
                System.out.println(render(ENTITY_MAP));
                for (int i = 0; i < WIDTH; i++) {

                System.out.print("==");
                }
                System.out.println();
                System.out.print("Cykl: "+this.cycle);
                System.out.println();
                lastUpdateTime = currentTime;
            } else {
                long sleepTime = (OPTIMAL_TIME - elapsedTime) / 1000000;
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * Stops the game
     */
    public void stop() {
        running = false;
    }
    /**
     * Updates game state
     */
    private void update() {
        this.cycle++;
        Random r = new Random();

        for (int i = 0; i<ENTITY_LIST.size(); i++) {
            var ent = ENTITY_LIST.get(i);
            if(ent instanceof  Organism){
                var org = (Organism)ent;
                //Sprawdzenie otoczenia / podjęcie akcji
                var toActWith = org.CheckSurroundings(this.ENTITY_LIST);

                if(toActWith != null){
                    org.EatIfPossible(toActWith,ENTITY_LIST);
                }
                //poruszanie

                if(org.getClass() == Cat.class) {

                    if(((Cat) org).if_asleep)   {
                        ((Cat) org).sleep();
                    }   else {

                        if(r.nextInt(0,20) > 17)    {
                            ((Cat) org).if_asleep = true;
                        }   else {

                            ENTITY_MAP[org.position.x][org.position.y] = " ";
                            org.Move(WIDTH,HEIGHT);
                            ENTITY_MAP[org.position.x][org.position.y] = org.SPRITE;

                        }

                    }

                }   else if(org.getClass() == Fish.class)   {

                    if(r.nextInt(0,20) > 18)    {
                        ENTITY_MAP[org.position.x][org.position.y] = " ";
                        ((Fish)org).CaughtByFisherman(ENTITY_LIST, (Fish) org);

                    }   else {

                        ENTITY_MAP[org.position.x][org.position.y] = " ";
                        org.Move(WIDTH,HEIGHT);
                        ENTITY_MAP[org.position.x][org.position.y] = org.SPRITE;

                    }



                } else if(org.getClass() == Bird.class) {

                    if(r.nextInt(0,20) > 17)    {

                        ENTITY_MAP[org.position.x][org.position.y] = " ";
                        ((Bird)org).FlyFast(WIDTH, HEIGHT, org);
                        ENTITY_MAP[org.position.x][org.position.y] = org.SPRITE;

                    }   else {

                        ENTITY_MAP[org.position.x][org.position.y] = " ";
                        org.Move(WIDTH,HEIGHT);
                        ENTITY_MAP[org.position.x][org.position.y] = org.SPRITE;

                    }

                } else  {

                    ENTITY_MAP[org.position.x][org.position.y] = " ";
                    org.Move(WIDTH,HEIGHT);
                    ENTITY_MAP[org.position.x][org.position.y] = org.SPRITE;

                }
                org.EvolveIfPossible(ENTITY_LIST);
            }

        }

        if(this.cycle == this.DATA_DUMP_CYCLES.get(0)){
            //
            //data drop / data dump
            //
            this.DATA_DUMP_CYCLES.remove(0);
        }
    }
    /**
     * Renders singular frame of game state
     * @param MAP Mapped positions of entities using 2dim array of strings
     * @return Rendered frame to be displayed
     */
    public static String render(String[][] MAP){
        String [] processed_rows = new String[HEIGHT];
        for (int i = 0; i < HEIGHT; i++) {
            processed_rows[i] = String.join(" ",MAP[i]);
        }
        return String.join("\n",processed_rows);
    }
    void Write2File()  {

        String fileName = "output_data.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            writer.println("Size of the map in cycle " + this.cycle + " was: " + HEIGHT + " " + WIDTH + ".");
            writer.println("Simulation started with " + num_of_cells + "cells.");
            writer.println("Simulation started with " + num_of_weed + "weed.");
            writer.println("There were " + Cat.getNumberOfObjects() + " cats during simulation.");
            writer.println("There were " + Bird.getNumberOfObjects() + " birds during simulation.");
            writer.println("There were " + Fish.getNumberOfObjects() + " fishes during simulation.");
            writer.println("There were " + Tiger.getNumberOfObjects() + " tigers during simulation.");
            writer.println("There were " + Cougar.getNumberOfObjects() + " cougars during simulation.");
            writer.println("There were " + Eagle.getNumberOfObjects() + " eagles during simulation.");
            writer.println("There were " + Pike.getNumberOfObjects() + " pikes during simulation.");
            writer.println("There were " + Amfiprion.getNumberOfObjects() + " amfiprions during simulation.");
            writer.println("There were " + Stork.getNumberOfObjects() + " storks during simulation.");

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }
        //potentially add .csv service



    }
}