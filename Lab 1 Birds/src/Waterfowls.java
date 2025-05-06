import java.util.List;

// Class for Waterfowls, inheriting from the WaterBirds parent class
public class Waterfowls extends WaterBirds{

    //Constructor for Waterfowls
    public Waterfowls(String type, String definingCharacteristics, boolean isExtinct, int numberOfWings, List<PreferredFood> preferredFood, String bodyOfWater) {
        super(type, definingCharacteristics, isExtinct, numberOfWings, preferredFood, bodyOfWater);
    }

    // Override the toString method to print the Waterfowls
    @Override
    public String toString() {
        return "Waterfowls: " + super.toString();
    }

}
