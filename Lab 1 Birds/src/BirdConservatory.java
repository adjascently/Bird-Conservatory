import java.util.*;

public class BirdConservatory {
    private static final int MAX_AVIARIES = 20;
    private Map<String, Aviary> aviaries;

    public BirdConservatory() {
        aviaries = new HashMap<>();
    }

    //This method will add the aviary
    public void addAviary(String aviaryName) {
        //Throws an exception if the input is empty
        if (aviaryName == null || aviaryName.trim().isEmpty()) {
            throw new IllegalArgumentException("Aviary name cannot be null or empty.");
        }

        // Check if the aviary already exists
        if (aviaries.containsKey(aviaryName)) {
            System.out.println("Aviary already exists: " + aviaryName);
            return; // Exit if the aviary exists
        }

        if (aviaries.size() < MAX_AVIARIES) {
            aviaries.put(aviaryName, new Aviary(5));
            System.out.println("Aviary created: " + aviaryName);
            return;
        }
        else {
            System.out.println("Maximum number of aviaries reached.");
            return;
        }
    }

    //This method is add the bird to the given aviary
    public String rescueBird(String aviaryName, Birds bird) {
        Aviary aviary = aviaries.get(aviaryName);
        //Throws an exception if the aviaryname or bird name is empty
        if (aviaryName == null || bird == null) {
            throw new IllegalArgumentException("Aviary name and bird cannot be null.");
        }

        //Checks if the aviary is empty
        if (aviary == null) {
            return "Aviary does not exist. Please add the aviary first.";
        }

        //It adds if it can be added, but if it is mixed then returns failed message
        if (aviary.addBird(bird)) {
            return "Rescued a new bird: " + bird.getType() + " in aviary: " + aviaryName;
        } else {
            return "Failed to rescue bird: " + bird.getType();
        }
    }

    //This method retrieves the list of all the birds in the aviary
    public List<Birds> getBirdsInAviary(String aviaryName) {
        Aviary aviary = aviaries.get(aviaryName);
        return aviary != null ? aviary.getBirds() : Collections.emptyList();
    }

    //This method retrieves the list of all aviaries
    public List<String> getAviaries() {
        List<String> sortedAviaries = new ArrayList<>(aviaries.keySet());
        Collections.sort(sortedAviaries); // Sort the list alphabetically
        return sortedAviaries;
    }

    // This method creates a map to hold the food requirements, where the key is the type of preferred foodand the value is the total count needed.
    public Map<PreferredFood, Integer> calculateFoodRequirements() {
        Map<PreferredFood, Integer> foodRequirements = new HashMap<>();

        // Iterate through each aviary in the conservatory.
        for (Aviary aviary : aviaries.values()) {
            for (Birds bird : aviary.getBirds()) {
                for (PreferredFood food : bird.getPreferredFood()) {
                    foodRequirements.put(food, foodRequirements.getOrDefault(food, 0) + 1);
                }
            }
        }
        // Return the complete map of food requirements.
        return foodRequirements;
    }

    // This method iterates through each entry in the aviaries map, where the key is the aviary name and the value is the Aviary object.
    public String findAviaryByBirdType(String birdType) {
        for (Map.Entry<String, Aviary> entry : aviaries.entrySet()) {
            for (Birds bird : entry.getValue().getBirds()) {
                if (bird.getType().equalsIgnoreCase(birdType)) {
                    return entry.getKey(); // Return the aviary name
                }
            }
        }
        // If no matching bird is found in any aviary, return a message indicating this.
        return "Bird not found in any aviary.";
    }

    //This method showcases the aviary, the birds and their details
    public String generateAviarySign(String aviaryName) {
        Aviary aviary = aviaries.get(aviaryName);
        // Check if the aviary exists
        if (aviary == null) {
            return "Aviary " + aviaryName + " does not exist. Please create it first";
        }

        //Checking if the aviary is empty
        if (aviary.getBirds().isEmpty()){
            return "Aviary " + aviaryName + " is currently empty.";
        }

        // Iterate through each bird in the aviary to add its details to the sign.
        StringBuilder sign = new StringBuilder("Welcome to the ").append(aviaryName).append(" Aviary!\n\n");
        for (Birds bird : aviary.getBirds()) {
            sign.append("Bird Type: ").append(bird.getType()).append("\n");
            sign.append("Characteristics: ").append(bird.getDefiningCharacteristics()).append("\n");
            sign.append("Extinct: ").append(bird.getIsExtinct() ? "Yes" : "No").append("\n");
            sign.append("Number of Wings: ").append(bird.getNumberOfWings()).append("\n");
            sign.append("Preferred Food: ").append(bird.getPreferredFood()).append("\n\n");
        }

        //Return the complete sign
        return sign.toString();
    }



    public String generateAviaryMap() {

        StringBuilder map = new StringBuilder("===========Aviary Map===========\n\n");

        // Check if there are any aviaries.
        if (aviaries.isEmpty()) {
            return "No aviaries available.\n";
        }

        // Iterate through each entry in the aviaries map to build the map.
        for (Map.Entry<String, Aviary> entry : aviaries.entrySet()) {
            String aviaryName = entry.getKey(); // Get the name of the aviary
            Aviary aviary = entry.getValue(); // Get the corresponding Aviary object

            // Append the aviary name to the map.
            map.append("Aviary: ").append(aviaryName).append("\n");

            // Check if the aviary contains any birds.
            if (aviary.getBirds().isEmpty()) {
                // If no birds, indicate that the aviary is empty.
                map.append("  - This aviary is currently empty.\n");
            } else {
                // If there are birds, list them.
                map.append("  Birds housed:\n");
                for (Birds bird : aviary.getBirds()) {
                    // Append each bird's type to the map.
                    map.append("  - ").append(bird.getType()).append("\n");
                }
            }
            map.append("\n");
        }

        // Return the complete aviary map.
        return map.toString();
    }


    public String generateBirdIndex() {
        List<String> birdIndex = new ArrayList<>();

        // Iterate through each entry in the aviaries map.
        for (Map.Entry<String, Aviary> entry : aviaries.entrySet()) {
            String aviaryName = entry.getKey();
            for (Birds bird : entry.getValue().getBirds()) {
                birdIndex.add(bird.getType() + " - Aviary: " + aviaryName);
            }
        }

        // Sort the bird index alphabetically.
        Collections.sort(birdIndex);

        StringBuilder index = new StringBuilder("============Bird Index=============\n\n");
        // Append each entry in the sorted bird index
        for (String entry : birdIndex) {
            index.append(entry).append("\n");
        }

        // Return the complete bird index as a string.
        return index.toString();
    }
}
