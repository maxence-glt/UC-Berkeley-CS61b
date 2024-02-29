package Discussions.Discussion4.regular;

public class TestAnimal {
    public static void main(String[] args) {
        /*
        Animal a = new Dog("Pluto");
        Animal b = new Animal("Bear");
        Cat c = new Cat("Garfield");
        Dog d = new Dog("Lucky");

                                        Line    Compile time (static)       Runtime (dynamic)       Output
        Cat e = new Animal("Kitty");    8       Error                       N/A                     Error
        a.greet(c);                     9       Animal's greet(Animal)      Dog's greet(Animal)     "Dog Pluto says: Woof!"
        a.sleep();                      10      Animal's sleep()            N/A - sleep is static   "Naptime!"
        c.play(":D");                   11      Cat's play(String)          Cat's play(String)      "Woo it is so much fun being a cat!:D"
        c.greet(d);                     12      Cat's greet(Animal)         Cat's greet(Animal)     "Cat Garfield says Meow!"
        ((Animal) c).greet(d);          13      Animal's greet(String)      Cat's greet(Animal)     "Cat Garfield says Meow!"
        d.sleep();                      14      Dog's sleep()               N/A - sleep is static   "Naptime"
        a = c;                          15      no error                    no error
        a.play(14);                     16      Animal's play() ERROR                               Compiler error
        ((Cat) b).play();               17      Animal's play()             ERROR                   Runtime error
        d = (Dog) a;                    18      no error                    ERROR                   Runtime error
        c = a;                          19      ERROR
         */

        System.out.println();
    }
}
