import java.util.ArrayList;
import java.io.IOException;


public class Projector {
    static int WIDTH;
    static int HEIGHT;
    private boolean running;
    private final int TARGET_FPS = 20;
    private final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

    ArrayList<Entity> ENTITY_LIST = new ArrayList<Entity>();
    String[][] ENTITY_MAP;
    Projector(int width, int height){
        this.WIDTH = width;
        this.HEIGHT = height;
        ENTITY_MAP = new String[HEIGHT][WIDTH];
    }
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

    public void stop() {
        running = false;
    }

    private void update() {
        ///
    }

    public static String render(String [][] MAP){
        String [] processed_rows = new String[HEIGHT];
        for (int i = 0; i < HEIGHT; i++) {
            processed_rows[i] = String.join(" ",MAP[i]);
        }
        return String.join("\n",processed_rows);
    }
}
