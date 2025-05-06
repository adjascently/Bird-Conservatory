import java.util.List;

//Class for Pigeons, inheriting from the Birds Parent class
public class Pigeons extends Birds {

    //Constructor for Pigeons
    public Pigeons(String type, String definingCharacteristics, boolean isExtinct, int numberOfWings, List<PreferredFood> preferredFood) {
        super(type, definingCharacteristics, isExtinct, numberOfWings, preferredFood);
    }

    // Override the toString method to print the Pigeons
    @Override
    public String toString() {
        return "Pigeons: " + super.toString();
    }
}
