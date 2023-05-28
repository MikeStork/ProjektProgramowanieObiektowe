package simulation.simulation;

public class Position{
    int x;
    int y;
    Position(int x,int y){
       this.x = x;
       this.y = y;
    }
    /**
     * Calculates distance between given position and self position
     * @param x position on x axis
     * @param y position on y axis
     * @return Floored distance
     */
    public int CalculateDistance(int x, int y){
        return (int)Math.sqrt (Math.pow(this.x-x, 2)+Math.pow(this.y-y, 2));
    }
//    public int CalculateDistanceRoof(int x, int y){
//        return (int)Math.sqrt ((x*x)+(y*y))+1;
//    }
//    public float CalculateDistance(int x, int y){
//        return (float)Math.sqrt ((x*x)+(y*y));
//    }
}
