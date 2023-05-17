package simulation;

import java.util.ArrayList;

public class Organism extends Entity{
    Diet diet;
    int speed;

    int level=1;
    Organism(int x, int y, String name, Diet diet, int speed) {
        super(x, y, name);
        this.diet = diet;
        this.speed = CONSTANTS.DEFAULT_SPEED;
        this.SPRITE = "O";
        this.color = "A";
    }
    Organism(int x, int y, String name, Diet diet) {
        super(x, y, name);
        this.diet = diet;
        this.speed = CONSTANTS.DEFAULT_SPEED;
        this.SPRITE = "O";
        this.color = "A";
    }

    /**
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
     * Checks whether organism can or cannot evolve
     * If it can, it will return new organism that matches corresponding evolution state
     */
    void EvolveIfPossible(){}
    /**
    * Destroys instance of this object
    */
    public void Move(){

    }
    void Destroy(){}

    /**
     * Given list of entities, search for the first entity which is in the distance of Organism.
     * @param entity_list
     */
    public Entity CheckSurroundings(ArrayList<Entity> entity_list){
        for(int i = 0; i < entity_list.size(); i++) {
            Entity entity = entity_list.get(i);
            if (entity != this && this.position.CalculateDistance(entity.position.x, entity.position.y) <= 1)
                return entity;
            }
        return null;
    }

    private void Eat(Entity e, ArrayList<Entity> entity_list){
        this.experience += e.experience;
        entity_list.remove(e);
    }
    public void EatIfPossible(Entity e, ArrayList<Entity> entity_list){
        switch(this.diet){
            case Herbivore:{
                if (e.getClass().equals(Weed.class)) {
                    this.Eat(e, entity_list);
                }
                break;
            }
            case Carnivore:{
                break;
            }
            case Omnivore:{
                break;
            }
        }
    }
    void StrongerBehaviour(){}
    void WeakerBehaviour(){}
    void Breed(){

    }
}
