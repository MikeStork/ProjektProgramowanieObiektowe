package simulation;

import java.util.ArrayList;
import java.util.Random;

public class Organism extends Entity{
    Diet diet;
    int speed;

    int experience=0;
    int level=1;
    Organism(int x, int y, String name, Diet diet, int speed) {
        super(x, y, name);
        this.diet = diet;
        this.speed = speed;
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
    void EvolveIfPossible(ArrayList<Entity> entity_list, Cell cell) {

        if (this.experience > 5) {

            Random random = new Random();

            int r = random.nextInt(3);


            if (r == 1) {
                Cat cat = new Cat(cell.position.x, cell.position.y, "cat", Diet.Carnivore, 1);
                entity_list.add(cat);
                cat.experience = 6;
                entity_list.remove(cell);
            } else if (r == 2) {
                Bird bird = new Bird(cell.position.x, cell.position.y, "cat", Diet.Carnivore, 1);
                entity_list.add(bird);
                bird.experience = 6;
                entity_list.remove(cell);

            } else {
                Fish fish = new Fish(cell.position.x, cell.position.y, "cat", Diet.Carnivore, 1);
                entity_list.add(fish);
                fish.experience = 6;
                entity_list.remove(cell);
            }

        }
    }

      void EvolveIfPossible(ArrayList<Entity> entity_list, Fish fish)  {

            if(this.experience > 10)    {

                Random random = new Random();

                int r = random.nextInt(2);

                if(r == 1)  {

                    Amfiprion amfiprion = new Amfiprion(this.position.x, this.position.y,"cat", Diet.Carnivore, 1);
                    entity_list.add(amfiprion);
                    amfiprion.experience = 11;
                    entity_list.remove(fish);

                }   else {

                    Pike pike = new Pike(this.position.x, this.position.y,"cat", Diet.Carnivore, 1);
                    entity_list.add(pike);
                    pike.experience = 11;
                    entity_list.remove(fish);

                }
            }
        }

        void EvolveIfPossible(ArrayList<Entity> entity_list, Cat cat)  {

            if(this.experience > 10)    {

                Random random = new Random();

                int r = random.nextInt(2);

                if(r == 1)  {

                    Cougar cougar = new Cougar(this.position.x, this.position.y,"cat", Diet.Carnivore, 1);
                    entity_list.add(cougar);
                    cougar.experience = 11;
                    entity_list.remove(cat);

                }   else {

                    Tiger tiger = new Tiger(this.position.x, this.position.y,"cat", Diet.Carnivore, 1);
                    entity_list.add(tiger);
                    tiger.experience = 11;
                    entity_list.remove(cat);

                }
            }
        }

        void EvolveIfPossible(ArrayList<Entity> entity_list, Bird bird)  {

            if(this.experience > 10)    {

                Random random = new Random();

                int r = random.nextInt(2);

                if(r == 1)  {

                    Stork stork = new Stork(this.position.x, this.position.y,"cat", Diet.Carnivore, 1);
                    entity_list.add(stork);
                    stork.experience = 11;
                    entity_list.remove(bird);

                }   else {

                    Eagle eagle = new Eagle(this.position.x, this.position.y,"cat", Diet.Carnivore, 1);
                    entity_list.add(eagle);
                    eagle.experience = 11;
                    entity_list.remove(bird);

                }
            }
    }

    /**
    * Destroys instance of this object
    */
    void Move(){
        Random r = new Random();
        switch (r.nextInt(1,9)){
            case 1:
                this.position.x+=-1;
                this.position.y+=-1;
                break;
            case 2:
//                this.position.x+=0;
                this.position.y+=-1;
                break;
            case 3:
                this.position.x+=1;
                this.position.y+=-1;
                break;
            case 4:
                this.position.x+=-1;
//                this.position.y+=0;
                break;
            case 5:
                this.position.x+=1;
//                this.position.y+=0;
                break;
            case 6:
                this.position.x+=-1;
                this.position.y+=1;
                break;
            case 7:
//                this.position.x+=0;
                this.position.y+=1;
                break;
            case 8:
                this.position.x+=1;
                this.position.y+=1;
                break;


        }
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

    void Breed(ArrayList<Entity> entity_list, Amfiprion amfiprion){

        Amfiprion amfiprion1 = new Amfiprion(this.position.x, this.position.y,"amfiprion", Diet.Herbivore, 1);
        entity_list.add(amfiprion1);

    }
    void Breed(ArrayList<Entity> entity_list, Bird bird){

        Bird bird1 = new Bird(this.position.x, this.position.y,"bird", Diet.Herbivore, 1);
        entity_list.add(bird1);

    }

    void Breed(ArrayList<Entity> entity_list, Cat cat){

        Cat cat1 = new Cat(this.position.x, this.position.y,"cat", Diet.Carnivore, 1);
        entity_list.add(cat1);

    }

    void Breed(ArrayList<Entity> entity_list, Cougar cougar){

       Cougar cougar1 = new Cougar(this.position.x, this.position.y,"cougar", Diet.Carnivore, 1);
        entity_list.add(cougar1);
    }

    void Breed(ArrayList<Entity> entity_list, Eagle eagle){

        Eagle eagle1 = new Eagle(this.position.x, this.position.y,"eagle", Diet.Omnivore, 1);
        entity_list.add(eagle1);
    }

    void Breed(ArrayList<Entity> entity_list, Fish fish){

        Fish fish1 = new Fish(this.position.x, this.position.y,"fish", Diet.Herbivore, 1);
        entity_list.add(fish1);

    }

    void Breed(ArrayList<Entity> entity_list, Pike pike){
        Pike pike1 = new Pike(this.position.x, this.position.y,"pike", Diet.Carnivore, 1);
        entity_list.add(pike1);
    }

    void Breed(ArrayList<Entity> entity_list, Stork stork){
        Stork stork1 = new Stork(this.position.x, this.position.y,"stork", Diet.Omnivore, 1);
        entity_list.add(stork1);
    }

    void Breed(ArrayList<Entity> entity_list, Tiger tiger){
        Tiger tiger1 = new Tiger(this.position.x, this.position.y,"tiger", Diet.Carnivore, 1);
        entity_list.add(tiger1);
    }




}
