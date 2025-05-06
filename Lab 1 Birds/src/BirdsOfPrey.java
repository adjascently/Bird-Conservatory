import java.util.List;

//Class for BirdsOfPrey, inheriting from the Birds Parent class
public class BirdsOfPrey extends Birds {

    //Constructor for BirdsOfPrey
    public BirdsOfPrey(String type, String definingCharacteristics, boolean isExtinct, int numberOfWings, List<PreferredFood> preferredFood) {
        super(type, definingCharacteristics, isExtinct, numberOfWings, preferredFood);
    }

    // Override the toString method to print the BirdsOfPrey
    @Override
    public String toString() {
        return "BirdsOfPrey: " + super.toString();
    }

}
