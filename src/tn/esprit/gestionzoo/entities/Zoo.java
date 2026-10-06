package tn.esprit.gestionzoo.entities;

public class Zoo {
    public static final int MAX_CAGES = 25;

    private Animal[] animals;
    private String name;
    private String city;
    private int nbrCages;
    private int animalCount;

    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        if (nbrCages < 0) {
            this.nbrCages = 0;
        } else if (nbrCages > MAX_CAGES) {
            this.nbrCages = MAX_CAGES;
        } else {
            this.nbrCages = nbrCages;
        }
        this.animals = new Animal[this.nbrCages];
        this.animalCount = 0;
    }

    public void displayZoo() {
        System.out.println("Zoo name: " + name);
        System.out.println("City: " + city);
        System.out.println("Number of cages: " + nbrCages);
    }

    public void displayAnimals() {
        if (animalCount == 0) {
            System.out.println(name + " has no animals.");
            return;
        }
        System.out.println("Animals in " + name + " (" + animalCount + "/" + nbrCages + "):");
        for (int i = 0; i < animalCount; i++) {
            System.out.println("  [" + i + "] " + animals[i]);
        }
    }

    /**
     * Adds an animal if it is not already present (unique by name)
     * and the zoo still has a free cage. Returns true only when the
     * animal was actually stored.
     */
    public boolean addAnimal(Animal animal) {
        if (animal == null || animal.getName() == null) {
            return false;
        }
        if (searchAnimal(animal) != -1) {
            return false;
        }
        if (animalCount >= nbrCages) {
            return false;
        }
        animals[animalCount] = animal;
        animalCount++;
        return true;
    }

    /**
     * Searches by name. Returns the index of the first match, or -1.
     */
    public int searchAnimal(Animal animal) {
        if (animal == null || animal.getName() == null) {
            return -1;
        }
        for (int i = 0; i < animalCount; i++) {
            if (animal.getName().equals(animals[i].getName())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes the animal with the same name and closes the gap in the array.
     */
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        return true;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    @Override
    public String toString() {
        return "Zoo{name='" + name + "', city='" + city + "', nbrCages=" + nbrCages
                + ", animals=" + animalCount + "}";
    }
}
