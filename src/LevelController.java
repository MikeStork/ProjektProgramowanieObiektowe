public class LevelController {
    static int [] LEVELBARS= new int[]{10,22,34,57,69};
    public static void increaseLevelIfPosible(Animal an){
        if(an.experience>LEVELBARS[an.level-1]){
            an.level++;
        }
    }
}
