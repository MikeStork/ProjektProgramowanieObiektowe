package org.example;

import java.io.IOException;
import java.util.ArrayList;

public class Projector {
    static int WIDTH;
    static int HEIGHT;
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
        for (int i = 0; i<ENTITY_LIST.size(); i++) {
            var ent = ENTITY_LIST.get(i);
            if(ent instanceof  Organism){
                var org = (Organism)ent;
                //Sprawdzenie otoczenia / podjęcie akcji
                org.CheckSurroundings(this.ENTITY_LIST);
                //poruszanie
                ENTITY_MAP[org.position.x][org.position.y] = " ";
                org.Move(WIDTH,HEIGHT);
                ENTITY_MAP[org.position.x][org.position.y] = org.SPRITE;


            }
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
}
