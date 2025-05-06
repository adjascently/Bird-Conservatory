import java.util.List;

// Class for Shorebirds, inheriting from the WaterBirds parent class
public class Shorebirds extends WaterBirds{

    //Constructor for Shorebirds
    public Shorebirds(String type, String definingCharacteristics, boolean isExtinct, int numberOfWings, List<PreferredFood> preferredFood, String bodyOfWater) {
        super(type, definingCharacteristics, isExtinct, numberOfWings, preferredFood, bodyOfWater);

    }
    // Override the toString method to print the Shorebirds
    @Override
    public String toString() {
        return "Shorebirds: " + super.toString();
    }
}
