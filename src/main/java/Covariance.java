import com.sun.corba.se.spi.activation.Server;

import java.net.InetAddress;
import java.util.ArrayList;

abstract class Animal {
}

class Bird extends Animal {
}

class Dog extends Animal {
}

public class Covariance {

    void quizz() {
        Bird bird = new Bird();
        Animal animal;
        //animal = bird;                                    //Does this compile?

        ArrayList<Bird> birds = new ArrayList<>();
        ArrayList<Animal> animals;
        //animals = birds;                                  //Does this compile?

        Bird[] birdArr = new Bird[1];
        Animal[] animalArr = new Animal[1];
        animalArr = birdArr;                                //Does this compile?
    }
}

