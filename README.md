# Zoo management (Prosit 2)

Java classes for a zoo that stores animals in a fixed set of cages. This covers instructions 5 to 13: `Animal` and `Zoo`, parameterized constructors, display, `toString`, add, search, uniqueness, the 25-cage limit, and removal.

## Layout

```
src/tn/esprit/gestionzoo/entities/Animal.java
src/tn/esprit/gestionzoo/entities/Zoo.java
src/tn/esprit/gestionzoo/main/ZooManagement.java
```

## Run

From the project root, with JDK 17 or newer:

```bash
javac -d out src/tn/esprit/gestionzoo/entities/*.java src/tn/esprit/gestionzoo/main/*.java
java -cp out tn.esprit.gestionzoo.main.ZooManagement
```

## What the classes do

`Animal` holds `family`, `name`, `age`, and `isMammal`.

`Zoo` holds the zoo `name`, `city`, `nbrCages`, and an `Animal[]`. A zoo never keeps more than 25 cages. If the constructor is given a larger number, the cage count is set to 25.

`addAnimal` appends the next free slot and returns `true` only when the animal was stored. It returns `false` when the zoo is full or an animal with the same name is already inside.

`searchAnimal` returns the index of an animal with the same name, or `-1`.

`removeAnimal` deletes that animal, shifts the later entries left, and returns whether a removal happened.

`displayZoo` prints the zoo name, city, and cage count. `displayAnimals` prints each stored animal.

## Notes from the instructions

After the parameterized constructors are added, `new Animal()` and `new Zoo()` no longer compile. The main method has to pass the arguments.

`System.out.println(myZoo)` and `System.out.println(myZoo.toString())` print the same text. Before `toString` is overridden they only show the class name and a hash, such as `Zoo@1a2b3c`. Overriding `toString` on `Zoo` and `Animal` makes that text show the attributes.

Searching a second object that has the same name still returns the first animal's index, because the search compares names.

Adding more animals than there are cages returns `false` and leaves the array unchanged. The same happens for a duplicate name.
