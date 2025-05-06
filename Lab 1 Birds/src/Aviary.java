import java.util.ArrayList;
import java.util.List;

//Class representing an Aviary that houses various types of birds
public class Aviary {
    private List<Birds> birds;
    private final int capacity;

    // Constructor to initialize the aviary taking capacity as parameter
    public Aviary(int capacity) {
        this.capacity = capacity;
        this.birds = new ArrayList<>();
    }

    // Method to add a bird to the aviary
    public boolean addBird(Birds bird) {
        // Check if the bird is extinct
        // Extinct birds cannot be added
        if (bird.getIsExtinct()) {
            System.out.println("Cannot add extinct birds to an aviary.");
            return false;
        }
        // Check if there is space to add the bird
        if (birds.size() < capacity ) {
            // Check for mixed bird types
            if (isCompatibleBirdType(birds, bird)) {
                birds.add(bird);
                return true;
            }
            else
            {
                return false;  //Bird cannot be added
            }
        }

        // Check if the aviary can accommodate more birds
        if (birds.size() >= capacity) {
            System.out.println("Aviary is full. Cannot add more birds.");
            return false;  //Aviary is full
        }

        return true;
    }

    //Method to check if the birds can be added based on the given constraint
    private boolean isCompatibleBirdType(List<Birds> birdsInAviary, Birds newBird) {
        if (birdsInAviary.isEmpty()) {
            return true; // An empty aviary can take any bird
        }
        // Check the type of the first bird in the aviary
        Birds firstBird = birds.get(0);

        boolean isFirstTypeMixed = isFlightless(firstBird) || isBirdOfPrey(firstBird) || isWaterfowl(firstBird);
        boolean isSecondTypeMixed = isFlightless(newBird) || isBirdOfPrey(newBird) || isWaterfowl(newBird);

        // If the first bird is a mixed type and the new bird is also a mixed type, allow addition
        if (isFirstTypeMixed && isSecondTypeMixed) {
            return true; // Allow adding mixed types together
        }

        // If the first bird is a mixed type but the new bird is not, reject the addition
        if (isFirstTypeMixed) {
            System.out.println("Cannot add this bird type with mixed birds: " + newBird.getType());
            return false;
        }

        // If the first bird is not a mixed type and the new bird is, reject the addition
        if (!isFirstTypeMixed && (isSecondTypeMixed)) {
            System.out.println("Cannot mix bird types together: Mixed birds cannot coexist with other types.");
            return false;
        }

        // If both birds are non-mixed, they can coexist
        return true;

    }

    //Method to check if it is Flightless Bird
    private boolean isFlightless(Birds bird) {
        return bird instanceof FlightlessBirds;
    }

    //Method to check if it is Bird of Prey
    private boolean isBirdOfPrey(Birds bird) {
        return bird instanceof BirdsOfPrey;
    }

    //Method to check if it is Waterfowl
    private boolean isWaterfowl(Birds bird) {
        return bird instanceof Waterfowls;
    }

    // Method to retrieve the list of birds in the aviary
    public List<Birds> getBirds() {
        return birds;
    }

    // Method to get the capacity of the aviary
    public int getCapacity() {
        return capacity;
    }

    // Method to get the current count of birds in the aviary
    public int getCurrentBirdCount() {
        return birds.size();
    }

    // Method to get a description of the birds in the aviary
    public String getDescription() {
        StringBuilder description = new StringBuilder("Aviary contains:\n");
        for (Birds bird : birds) {
            description.append("- ").append(bird.getType()).append("\n");
        }
        return description.toString();
    }

    // Override toString method to provide detailed information about the aviary
    @Override
    public String toString() {
        StringBuilder description = new StringBuilder("Aviary:\n");
        description.append("Capacity: ").append(capacity).append("\n");
        description.append("Current Bird Count: ").append(birds.size()).append("\n");
        description.append("Birds:\n");

        for (Birds bird : birds) {
            description.append(" - ").append(bird.getType()).append("\n");
        }

        return description.toString();
    }
}
