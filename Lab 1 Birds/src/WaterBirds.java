import java.util.List;

//Class for Water birds, inheriting from the Birds Parent class and is the parent for Shorebirds and Waterfowls
public class WaterBirds extends Birds{

    //The specific body of water associated with the water bird
    private String bodyOfWater;

    // //Constructor for WaterBirds
    public WaterBirds(String type, String definingCharacteristics, boolean isExtinct, int numberOfWings, List<PreferredFood> preferredFood, String bodyOfWater) {
        super(type, definingCharacteristics, isExtinct, numberOfWings, preferredFood);
        this.bodyOfWater = bodyOfWater;
    }

    //Getter for accessing the body of water
    public String getBodyOfWater(){
        return bodyOfWater;
    }

    // Override the toString method to print the Waterbirds
    @Override
    public String toString() {
        return "WaterBirds: " +
                "Type: " + getType() + ", " +
                "Characteristics: " + getDefiningCharacteristics() + ", " +
                "Extinct: " + (getIsExtinct() ? "Yes" : "No") + ", " +
                "Number of Wings: " + getNumberOfWings() + ", " +
                "Preferred Food: " + getPreferredFood() + ", " +
                "Body of Water: " + bodyOfWater; // Include the specific body of water
    }

}
