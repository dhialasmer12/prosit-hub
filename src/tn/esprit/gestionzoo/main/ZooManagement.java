package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

/**
 * Prosit 2 — instructions 5 to 13.
 *
 * Instruction 6: once Animal and Zoo only expose a parameterized constructor,
 * a main that still does {@code new Animal()} / {@code new Zoo()} no longer
 * compiles, because the implicit no-arg constructor disappears.
 * Instruction 7 fixes that by constructing the objects with arguments.
 *
 * Instruction 8: {@code System.out.println(myZoo)} calls {@code toString()}.
 * Before it is overridden, both lines print the default identity
 * ({@code Zoo@1a2b3c}), which does not show the zoo's data.
 * Instruction 9 overrides {@code toString()} on Zoo and Animal so the same
 * lines print a readable description.
 *
 * Instruction 11: {@code searchAnimal} compares names, not object identity.
 * A second Animal built with the same name is found at the same index.
 *
 * Instruction 12: {@code addAnimal} rejects a duplicate name and refuses to
 * write past the last cage. A requested cage count above 25 is capped at 25.
 */
public class ZooManagement {
    public static void main(String[] args) {
        Animal lion = new Animal("Felidae", "Lion", 5, true);
        Zoo myZoo = new Zoo("myZoo", "Tunis", 25);

        System.out.println("=== Instruction 8: displayZoo ===");
        myZoo.displayZoo();

        System.out.println();
        System.out.println("=== Instruction 9: toString ===");
        System.out.println(myZoo);
        System.out.println(myZoo.toString());
        System.out.println(lion);

        System.out.println();
        System.out.println("=== Instructions 10-12: addAnimal ===");
        Zoo smallZoo = new Zoo("Belvedere", "Tunis", 3);
        Animal tiger = new Animal("Felidae", "Tiger", 4, true);
        Animal elephant = new Animal("Elephantidae", "Elephant", 10, true);
        Animal giraffe = new Animal("Giraffidae", "Giraffe", 7, true);
        Animal penguin = new Animal("Spheniscidae", "Penguin", 3, false);
        Animal lionAgain = new Animal("Felidae", "Lion", 8, true);

        System.out.println("add lion: " + smallZoo.addAnimal(lion));
        System.out.println("add tiger: " + smallZoo.addAnimal(tiger));
        System.out.println("add elephant: " + smallZoo.addAnimal(elephant));
        System.out.println("add giraffe (zoo is full): " + smallZoo.addAnimal(giraffe));
        System.out.println("add lion again (duplicate name): " + smallZoo.addAnimal(lionAgain));

        Zoo tooBig = new Zoo("Overflow", "Ariana", 40);
        System.out.println("requested 40 cages, stored: " + tooBig.getNbrCages());

        System.out.println();
        System.out.println("=== Instruction 11: display and search ===");
        smallZoo.displayAnimals();

        int lionIndex = smallZoo.searchAnimal(lion);
        System.out.println("search lion -> " + lionIndex);

        Animal anotherLion = new Animal("Felidae", "Lion", 2, true);
        int sameNameIndex = smallZoo.searchAnimal(anotherLion);
        System.out.println("search a different Lion object with the same name -> " + sameNameIndex);

        int missing = smallZoo.searchAnimal(penguin);
        System.out.println("search penguin (not in the zoo) -> " + missing);

        System.out.println();
        System.out.println("=== Instruction 13: removeAnimal ===");
        System.out.println("remove tiger: " + smallZoo.removeAnimal(tiger));
        System.out.println("remove penguin (absent): " + smallZoo.removeAnimal(penguin));
        smallZoo.displayAnimals();
        System.out.println("add giraffe after a removal: " + smallZoo.addAnimal(giraffe));
        smallZoo.displayAnimals();
    }
}
