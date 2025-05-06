import java.util.List;

//Class for Flightless birds, inheriting from the Birds Parent class
public class FlightlessBirds extends Birds{
    //Constructor for FlightlessBirds
    public FlightlessBirds(String type, String definingCharacteristics, boolean isExtinct, int numberOfWings, List<PreferredFood> preferredFood) {
        super(type, definingCharacteristics, isExtinct, numberOfWings, preferredFood);
    }

    // Override the toString method to print the FlightlessBirds
    @Override
    public String toString() {
        return "Flightless Birds: " + super.toString();
    }
}
