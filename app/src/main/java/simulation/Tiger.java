package simulation;

public class Tiger extends Cat {

    static int camouflage_ratio = 2;
    private static int t_count;
    Tiger(int x, int y, Diet diet, int speed, boolean if_asleep, int sleep_count) {
        super(x, y, diet, speed, if_asleep,sleep_count);
        t_count++;
    }
    void LookForPray(){}

    public static int getNumberOfObjects() {
        return t_count;
    }

}
