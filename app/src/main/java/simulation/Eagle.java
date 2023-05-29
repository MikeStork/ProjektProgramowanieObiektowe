package simulation;

public class Eagle extends Bird {
    private static int e_count;
    Eagle(int x, int y, Diet diet, int speed) {
        super(x, y, diet, speed);
        e_count++;
    }
    void PerformAnAirStrike(){}
    void LookForPray(){}
    public static int getNumberOfObjects() {
        return e_count;
    }
}
