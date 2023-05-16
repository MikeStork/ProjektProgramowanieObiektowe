package simulation;

import java.util.ArrayList;

public class Organism extends Entity{
    Diet diet;
    int speed;

    int experience=0;
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
    void Move(){

    }
    void Destroy(){}

    void CheckSurroundings(ArrayList<Entity> entity_list){
        for(int i = 0; i < entity_list.size(); i++){
            Entity entity = entity_list.get(i);
            if(entity != this){
                if(this.position.CalculateDistance(entity.position.x, entity.position.y) <= 1){
                    System.out.println("w zasięgu pzdr");
                }
            }
        }
    }
    void EatIfPossible(){}
    void StrongerBehaviour(){}
    void WeakerBehaviour(){}
    void Breed(){

    }
}
