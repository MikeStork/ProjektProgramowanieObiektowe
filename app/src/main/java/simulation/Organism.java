package simulation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public abstract class Organism extends Entity{
    Diet diet;
    int speed;
    int level;
    public int age;
    public int lifespan;
    Organism(int x, int y, Diet diet, int speed) {
        super(x, y, 1);
        this.diet = diet;
        this.speed = speed;
        this.age = 0;
        this.experience = 0;
    }
    Organism(int x, int y, Diet diet) {
        super(x, y, 1);
        this.diet = diet;
        this.speed = CONSTANTS.DEFAULT_SPEED;
    }

    /**
     * SAMPLE
     *
     * Returns an Image object that can then be painted on the screen.
     * The url argument must specify an absolute <a href="#{@link}">{@link URL}</a>. The name
     * argument is a specifier that is relative to the url argument.
     * <p>
     * This method always returns immediately, whether or not the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     *
     * @param  url  an absolute URL giving the base location of the image
     * @param  name the location of the image, relative to the url argument
     * @return      the image at the specified URL
     * @see         Image
     */


    /**
    * Randomly changes coordinates of Organism
    */
    void Move(int WIDTH, int HEIGHT){
        Random r = new Random();
        int add_to_x = r.nextInt(-1, 2);
        int add_to_y = r.nextInt(-1, 2);
        if(this.position.x + add_to_x > 0 && this.position.x + add_to_x < WIDTH){
            this.position.x += add_to_x;
        }
        if(this.position.y + add_to_y > 0 && this.position.y + add_to_y < HEIGHT){
            this.position.y += add_to_y;
        }

//
//        switch (r.nextInt(1,8)){
//            case 1:
//                if(this.position.x ==0){
//                    this.position.x+=1;
//                }else {
//                    this.position.x+=-1;
//                }
//                if(this.position.y == 0){
//                    this.position.y+=1;
//                }else{
//                    this.position.y+=-1;
//                }
//                break;
//            case 2:
////                this.position.x+=0;
//                if(this.position.y == 0){
//                    this.position.y+=1;
//                }else{
//                    this.position.y+=-1;
//                }
//                break;
//            case 3:
//                if(this.position.x == WIDTH-1){
//                    this.position.x+=-1;
//                }else {
//                    this.position.x+=1;
//                }
//                if(this.position.y == 0){
//                    this.position.y+=1;
//                }else{
//                    this.position.y+=-1;
//                }
//                break;
//            case 4:
//                if(this.position.x == 0){
//                    this.position.x+=1;
//                }else {
//                    this.position.x+=-1;
//                }
////                this.position.y+=0;
//                break;
//            case 5:
//                if(this.position.x == WIDTH-1){
//                    this.position.x+=-1;
//                }else {
//                    this.position.x+=1;
//                }
////                this.position.y+=0;
//                break;
//            case 6:
//                if(this.position.x == WIDTH-1){
//                    this.position.x+=-1;
//                }else {
//                    this.position.x+=1;
//                }
//                if(this.position.y == HEIGHT-1){
//                    this.position.y+=-1;
//                }else{
//                    this.position.y+=1;
//                }
//                break;
//            case 7:
////                this.position.x+=0;
//                if(this.position.y == HEIGHT-1){
//                    this.position.y+=-1;
//                }else{
//                    this.position.y+=1;
//                }
//                break;
//            case 8:
//                if(this.position.x == WIDTH){
//                    this.position.x+=-1;
//                }else {
//                    this.position.x+=1;
//                }
//                if(this.position.y == HEIGHT){
//                    this.position.y+=-1;
//                }else{
//                    this.position.y+=1;
//                }
//                break;
        }

    /**
     * Given list of entities, search for the first entity which is in the distance of Organism.
     * @param entity_list List of games entities
     */
    public Entity CheckSurroundings(ArrayList<Entity> entity_list){
        for(int i = 0; i < entity_list.size(); i++) {
            Entity entity = entity_list.get(i);
            if (entity != this && this.position.CalculateDistance(entity.position.x, entity.position.y) <= 1)
                return entity;
            }
        return null;
    }
    /**
     * Controlls consumption of entity
     * @param e Entity to be eaten
     * @param entity_list List of games entities
     */
    private void Eat(Entity e, ArrayList<Entity> entity_list, String[][] entity_map){
        if(e != null){
            this.experience += e.experience;
            entity_list.remove(e);
            entity_map[e.position.x][e.position.y] = " ";
        }
    }
    /**
     * Checks whether given entity can be consumed
     * @param e Entity to be eaten
     * @param entity_list List of games entities
     */
    public void EatIfPossible(Entity e, ArrayList<Entity> entity_list, String[][] entity_map){
        switch(this.diet){
            case Herbivore:{
                if (e.getClass().equals(Weed.class)) {
                    this.Eat(e, entity_list, entity_map);
                }
                break;
            }
            case Carnivore:{
                if (!this.getClass().equals(e.getClass()) && (!e.getClass().equals(Weed.class)) && (this.size > e.size) ){
                    this.Eat(e, entity_list, entity_map);
                }
                break;
            }
            case Omnivore:{
                if(this.getClass().equals(Cell.class)){
                    this.Eat(e, entity_list, entity_map);
                }
                else if((this.size > e.size) && (!this.getClass().equals(e.getClass()))){
                    this.Eat(e, entity_list, entity_map);
                }
                break;
            }
        }
    }

    void StrongerBehaviour(){}
    void WeakerBehaviour(){}
    public boolean DieIfPossible(ArrayList<Entity> entity_list, String[][] entity_map){
        if(this.age > this.lifespan){
            entity_list.remove(this);
            entity_map[this.position.x][this.position.y] = " ";
            return true;
        }
        return false;
    }
    abstract public void Breed(ArrayList<Entity> entity_list);
    abstract public void EvolveIfPossible(ArrayList<Entity> entity_list);


}
