package simulation;

import simulation.data.Diet;
import simulation.interfaces.I_Organism;

import java.util.ArrayList;
import java.util.Random;
/**
 * The Organism class represents a type of entity in the simulation.
 */
public abstract class Organism extends Entity implements I_Organism {
    Diet diet;
    int speed;
    /**
     * Field describing level of its owner
     */
    public int level;

    /**
     * Integer describing age of instance of this object
     */
    public int age;
    /**
     * Integer describing lifespan of instance of this object
     */
    public int lifespan;
    Organism(int x, int y, Diet diet, int speed) {
        super(x, y, 1);
        this.diet = diet;
        this.speed = speed;
        this.age = 0;
        this.experience = 0;
    }

    /**
     * SAMPLE
     *
     * Returns an Image object that can then be painted on the screen.
     * The url argument must specify an absolute <a href="#{@link}">{@link URL}</a>. The name
     * argument is a specifier that is relative to the url argument.
     * <p>
     * This method always returns immediately, whether the
     * image exists. When this applet attempts to draw the image on
     * the screen, the data will be loaded. The graphics primitives
     * that draw the image will incrementally paint on the screen.
     *
     * @param  url  an absolute URL giving the base location of the image
     * @param  name the location of the image, relative to the url argument
     * @return the image at the specified URL
     * @see         Image
     */


    /**
    * Randomly changes coordinates of Organism
    */
    public void Move(int WIDTH, int HEIGHT){
        Random r = new Random();
        int add_to_x = r.nextInt(-1, 2);
        int add_to_y = r.nextInt(-1, 2);
        if(this.position.x + add_to_x > 0 && this.position.x + add_to_x < WIDTH){
            this.position.x += add_to_x;
        }
        if(this.position.y + add_to_y > 0 && this.position.y + add_to_y < HEIGHT){
            this.position.y += add_to_y;
        }

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
