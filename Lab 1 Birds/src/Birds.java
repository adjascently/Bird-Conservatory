import java.util.List;

public class Birds {

    /*Attributes for the Birds class which takes into
    * 1. The type of bird
    * 2. Unique characteristics of the bird
    * 3. Indicate if the bird is extinct
    * 4. Number of wings the bird has (usually 2)
    * 5. List of preferred food - Enum Preferred Food*/
    private String type;
    private String definingCharacteristics;
    private boolean isExtinct;
    private int numberOfWings;
    private List<PreferredFood> preferredFood;

    //Birds constructor
    public Birds(String type, String definingCharacteristics, boolean isExtinct, int numberOfWings, List<PreferredFood> preferredFood) {
        // Validate inputs to avoid exceptions, if any input is invalid, exception is thrown
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Bird type cannot be null or empty.");
        }
        if (definingCharacteristics == null || definingCharacteristics.isEmpty()) {
            throw new IllegalArgumentException("Defining characteristics cannot be null or empty.");
        }
        if (numberOfWings < 0) {
            throw new IllegalArgumentException("Number of wings cannot be negative.");
        }
        if (preferredFood == null || preferredFood.size() < 2 || preferredFood.size() > 4) {
            throw new IllegalArgumentException("Preferred food must have between 2 and 4 items.");
        }

        this.type = type;
        this.definingCharacteristics = definingCharacteristics;
        this.isExtinct = isExtinct;
        this.numberOfWings = numberOfWings;
        this.preferredFood = preferredFood;
    }

    //Getter for defining characteristics
    public String getDefiningCharacteristics() {
        return definingCharacteristics;
    }

    // Getter for bird type
    public String getType() {
        return type;
    }

    // Getter for getting the extinct status of the birds
    public boolean getIsExtinct() {
        return isExtinct;
    }

    // Getter for number of wings
    public int getNumberOfWings() {
        return numberOfWings;
    }

    // Getter for preferred food list
    public List<PreferredFood> getPreferredFood() {
        return preferredFood;
    }

    // toString method to return a string representation of the bird object
    @Override
    public String toString() {
        return "Type: " + type +
                ", Characteristics: " + definingCharacteristics +
                ", Extinct: " + (isExtinct ? "Yes" : "No") +
                ", Number of Wings: " + numberOfWings +
                ", Preferred Food: " + preferredFood;
    }
}
