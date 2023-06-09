package simulation;

import simulation.data.CONSTANTS;
import simulation.workers.CSVFileWorker;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import static simulation.Main.num_of_cells;
import static simulation.Main.num_of_weed;
/**
 * Class of Projector
 */
public class Projector {
    int WIDTH;
    int HEIGHT;
    /**
     * Integer describing in which cycles dump data to files
     */
    public ArrayList<Integer>   DATA_DUMP_CYCLES;
    protected boolean running;
    private final long OPTIMAL_TIME = 1000000000 / CONSTANTS.FPS_TARGET;
    /**
     * Integer describing how many cycles have passed
     */
    public int cycle = 0;
    ArrayList<Entity> ENTITY_LIST = new ArrayList<Entity>();
    String[][] ENTITY_MAP;
    CSVFileWorker tabularData;
    Projector(int width, int height){
        this.WIDTH = width;
        this.HEIGHT = height;
        ENTITY_MAP = new String[this.WIDTH][this.HEIGHT];
    }
    /**
     * Game starting method, controlls game
     */
    public void start() {
        try {
            this.tabularData = new CSVFileWorker("tabularData-"+this.cycle+".csv");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
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
    protected void update() {
        this.cycle++;
        Random r = new Random();

        boolean any_organisms_left = false;
        for (int i = ENTITY_LIST.size()-1; i >= 0 ; i--) {
            var ent = ENTITY_LIST.get(i);
            if(ent instanceof Organism){
                var org = (Organism)ent;
                org.age++;
                if(org.DieIfPossible(ENTITY_LIST, ENTITY_MAP)){
                    continue;
                }
                any_organisms_left = true;
                //Sprawdzenie otoczenia / podjęcie akcji
                var toActWith = org.CheckSurroundings(this.ENTITY_LIST);

                if(toActWith != null){
                    if(org.getClass().equals(toActWith.getClass())){
                        if(r.nextInt(1, 50) == 1){
                            org.Breed(ENTITY_LIST);
                        }
                    }
                    org.EatIfPossible(toActWith, ENTITY_LIST, ENTITY_MAP);
                }
                //poruszanie

                if(org instanceof Cat) {
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
                } else if(org instanceof Fish)   {

                    if(r.nextInt(1,100) == 1)    {
                        ((Fish)org).CaughtByFisherman(ENTITY_LIST);
                        ENTITY_MAP[org.position.x][org.position.y] = " ";
                    }   else {
                        ENTITY_MAP[org.position.x][org.position.y] = " ";
                        org.Move(WIDTH,HEIGHT);
                        ENTITY_MAP[org.position.x][org.position.y] = org.SPRITE;
                    }

                } else if(org instanceof Bird) {
                    if(r.nextInt(0,20) > 17){
                        ENTITY_MAP[org.position.x][org.position.y] = " ";
                        ((Bird)org).FlyFast(WIDTH, HEIGHT);
                        ENTITY_MAP[org.position.x][org.position.y] = org.SPRITE;

                    }   else {

                        ENTITY_MAP[org.position.x][org.position.y] = " ";
                        org.Move(WIDTH,HEIGHT);
                        ENTITY_MAP[org.position.x][org.position.y] = org.SPRITE;

                    }
                } else {
                    ENTITY_MAP[org.position.x][org.position.y] = " ";
                    org.Move(WIDTH,HEIGHT);
                    ENTITY_MAP[org.position.x][org.position.y] = org.SPRITE;
                }

                if(org.level < 3){
                    org.EvolveIfPossible(ENTITY_LIST);
                }

            } else if(ent instanceof Weed){
                ENTITY_MAP[ent.position.x][ent.position.y] = ent.SPRITE;
            }

        }

        if(this.DATA_DUMP_CYCLES.size() > 0){
            if(this.cycle == this.DATA_DUMP_CYCLES.get(0)){
                try {
                    this.tabularData.appendData(new int[]{this.cycle, WIDTH,HEIGHT, num_of_cells,num_of_weed,Cat.getNumberOfObjects(),Bird.getNumberOfObjects(),Fish.getNumberOfObjects(),Tiger.getNumberOfObjects(),Cougar.getNumberOfObjects(),Eagle.getNumberOfObjects(),Pike.getNumberOfObjects(),Amfiprion.getNumberOfObjects(),Stork.getNumberOfObjects()});
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                Write2File();
                this.DATA_DUMP_CYCLES.remove(0);
            }
        }else{
            try {
                this.tabularData.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        if(any_organisms_left == false || this.cycle > 1000){
            stop();
        }

    }
    /**
     * Renders a singular frame of game state
     * @param MAP Mapped positions of entities using 2dim array of strings
     * @return Rendered frame to be displayed
     */
    public String render(String[][] MAP){
        String [] processed_rows = new String[this.HEIGHT];
        for (int i = 0; i < this.HEIGHT; i++) {
            processed_rows[i] = String.join(" ",MAP[i]);
        }
        return String.join("\n",processed_rows);
    }
    void Write2File()  {

        String fileName = "output_" + this.cycle + "data.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            writer.println("Size of the map in cycle " + this.cycle + " was: " + HEIGHT + " " + WIDTH + ".");
            writer.println("Simulation started with " + num_of_cells + " cells.");
            writer.println("Simulation started with " + num_of_weed + " weed.");
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
    }
}
