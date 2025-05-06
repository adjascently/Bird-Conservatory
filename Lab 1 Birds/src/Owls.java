import java.util.List;

//Class for Owls, inheriting from the Birds Parent class
public class Owls extends Birds{

    //Constructor for Owls
    public Owls(String type, String definingCharacteristics, boolean isExtinct, int numberOfWings, List<PreferredFood> preferredFood) {
        super(type, definingCharacteristics, isExtinct, numberOfWings, preferredFood);
    }

    // Override the toString method to print the BirdsOfPrey
    @Override
    public String toString() {
        return "Owls: " + super.toString();
    }
}
