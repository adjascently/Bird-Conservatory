import java.util.List;

//Class for Parrots, inheriting from the Birds Parent class
public class Parrots extends Birds {

    /*Attributes for the Parrots class which takes into
     * 1. The number of words in their vocabulary
     * 2. Their single favourite saying */
    private int vocabularySize;
    private String favouriteSaying;

    //Constructor for Parrots
    public Parrots(String type, String definingCharacteristics, boolean isExtinct, int numberOfWings, List<PreferredFood> preferredFood, int vocabularySize, String favouriteSaying) {
        super(type, definingCharacteristics, isExtinct, numberOfWings, preferredFood);
        this.vocabularySize = vocabularySize;
        this.favouriteSaying = favouriteSaying;
    }

    //Getter for vocabulary size
    public int getVocabularySize() {
        return vocabularySize;
    }

    //Getter for parrot's favourite saying
    public String getFavouriteSaying() {
        return favouriteSaying;
    }

    // Override the toString method to print the Parrots
    @Override
    public String toString() {
        return "Parrots: " + super.toString();
    }


}
