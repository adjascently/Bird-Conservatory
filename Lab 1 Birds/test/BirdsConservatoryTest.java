import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class BirdsConservatoryTest {

    private Aviary aviary;
    private BirdConservatory birdConservatory;

    // Different types of bird instances for testing
    private Birds birdsOfPrey;
    private FlightlessBirds flightlessBirds;
    private FlightlessBirds flightlessBirdsExtinct;
    private Owls owls;
    private Pigeons pigeons;
    private Parrots parrots;
    private Shorebirds shorebirds;
    private Waterfowls waterfowls;

    // Names for aviaries used in tests
    String aviaryName1 = "Tropical Aviary";
    String aviaryName2 = "Rainforest Haven";
    String aviaryName3 = "Skyward Santuary";
    String aviaryName4 = "Aviary Oasis";

    // Setup method to initialize test objects
    @Before
    public void setUp() {
        birdConservatory = new BirdConservatory();
        aviary = new Aviary(5);

        List<PreferredFood> birdsOfPreyFood = new ArrayList<>(Arrays.asList(PreferredFood.OTHER_BIRDS, PreferredFood.SMALL_MAMMALS));
        birdsOfPrey = new BirdsOfPrey("Hawks", "Sharp Hooked Beaks", false, 2, birdsOfPreyFood);

        List<PreferredFood> flightlessBirdsFood = new ArrayList<>(Arrays.asList(PreferredFood.BUDS, PreferredFood.SEEDS));
        flightlessBirds = new FlightlessBirds("Kiwis", "Live on the ground", false, 0, flightlessBirdsFood);
        flightlessBirdsExtinct = new FlightlessBirds("Emus", "Extinct bird", true, 0, flightlessBirdsFood);

        List<PreferredFood> owlsFood = new ArrayList<>(Arrays.asList(PreferredFood.FISH, PreferredFood.AQUATIC_INVERTEBRATES));
        owls = new Owls("Owls", " Facial disks framing eyes and the bill", false, 2, owlsFood);

        List<PreferredFood> parrotsFood = new ArrayList<>(Arrays.asList(PreferredFood.BERRIES, PreferredFood.SEEDS, PreferredFood.FRUIT, PreferredFood.NUTS));
        parrots = new Parrots("Rose-ringed parakeet", " Intelligence and ability to mimic sounds", false, 2, parrotsFood, 50, "Hello");

        List<PreferredFood> pigeonsFood = new ArrayList<>(Arrays.asList(PreferredFood.SEEDS, PreferredFood.BUDS));
        pigeons = new Pigeons("Doves", "Feed their young ones 'bird milk' similar to mammals", false, 2, pigeonsFood);

        List<PreferredFood> waterfowlsFood = new ArrayList<>(Arrays.asList(PreferredFood.FISH, PreferredFood.AQUATIC_INVERTEBRATES, PreferredFood.EGGS));
        waterfowls = new Waterfowls("Ducks", "Lives near water sources", false, 2, waterfowlsFood, "Fresh Water");

        List<PreferredFood> shorebirdsFood = new ArrayList<>(Arrays.asList(PreferredFood.FISH, PreferredFood.AQUATIC_INVERTEBRATES, PreferredFood.EGGS));
        shorebirds = new Shorebirds("Great auk", "Live near greater water bodies", false, 2, shorebirdsFood, "Wetlands");

        birdConservatory.addAviary(aviaryName1);
    }

    //===========================================BIRDS TEST===================================
    // Test creating a valid bird
    @Test
    public void testValidBirdCreation() {
        List<PreferredFood> preferredFoods = Arrays.asList(PreferredFood.SEEDS, PreferredFood.BERRIES);
        Birds bird = new Birds("Parrot", "Colorful feathers", false, 2, preferredFoods);
        assertNotNull(bird);
        assertEquals("Parrot", bird.getType());
    }

    // Test creating a bird with an invalid type
    @Test
    public void testInvalidBirdType() {
        List<PreferredFood> preferredFoods = Arrays.asList(PreferredFood.SEEDS, PreferredFood.BERRIES);
        try {
            new Birds("", "Colorful feathers", false, 2, preferredFoods);
            fail("Expected IllegalArgumentException for empty bird type");
        } catch (IllegalArgumentException e) {
            assertEquals("Bird type cannot be null or empty.", e.getMessage());
            System.err.println(e.getMessage()); // Print the error message if the exception is caught
        }
    }

    // Test creating a bird with invalid defining characteristics
    @Test
    public void testInvalidDefiningCharacteristics() {
        List<PreferredFood> preferredFoods = Arrays.asList(PreferredFood.SEEDS, PreferredFood.BERRIES);
        try {
            new Birds("Parrot", "", false, 2, preferredFoods);
            fail("Expected IllegalArgumentException for empty defining characteristics");
        } catch (IllegalArgumentException e) {
            assertEquals("Defining characteristics cannot be null or empty.", e.getMessage());
            System.err.println(e.getMessage()); // Print the error message if the exception is caught
        }
    }

    // Test creating a bird with a negative number of wings
    @Test
    public void testNegativeWings() {
        List<PreferredFood> preferredFoods = Arrays.asList(PreferredFood.SEEDS, PreferredFood.BERRIES);
        try {
            new Birds("Parrot", "Colorful feathers", false, -1, preferredFoods);
            fail("Expected IllegalArgumentException for negative number of wings");
        } catch (IllegalArgumentException e) {
            assertEquals("Number of wings cannot be negative.", e.getMessage());
            System.err.println(e.getMessage()); // Print the error message if the exception is caught
        }
    }

    // Test creating a bird with invalid preferred food list size
    @Test
    public void testInvalidPreferredFoodSize() {
        try {
            List<PreferredFood> preferredFoods = Arrays.asList(PreferredFood.SEEDS); // Only 1 item
            new Birds("Parrot", "Colorful feathers", false, 2, preferredFoods);
            fail("Expected IllegalArgumentException for invalid preferred food size");
        } catch (IllegalArgumentException e) {
            assertEquals("Preferred food must have between 2 and 4 items.", e.getMessage());
            System.err.println(e.getMessage()); // Print the error message if the exception is caught
        }
    }

    //==================================================PARROT TEST==============================================
    // Test to check the vocabulary size of the parrot
    @Test
    public void testParrotVocabularySize(){
        assertEquals(50, parrots.getVocabularySize());
    }

    // Test to check the favorite saying of the parrot
    @Test
    public void testParrotFavouriteSaying(){
        assertEquals("Hello", parrots.getFavouriteSaying());
    }

    //==================================================WATERBIRD TEST==============================================
    // Test to check the body of water for shorebirds and waterfowls
    @Test
    public void testWaterBirdsBodyOfWater(){
        assertEquals("Wetlands", shorebirds.getBodyOfWater());
        assertEquals("Fresh Water", waterfowls.getBodyOfWater());
    }

//==================================================BIRDS CONSERVATORY TEST==============================================

    // Test adding aviaries to the conservatory
    @Test
    public void testAddAviary() {
            birdConservatory.addAviary(aviaryName2);
            birdConservatory.addAviary(aviaryName1); // Should fail since it already exists
            System.out.println(birdConservatory.getAviaries());
    }

    // Test for exception when adding a null aviary name
    @Test
    public void testAddAviaryException() {
        try {
            birdConservatory.addAviary(null);
            fail("Expected IllegalArgumentException not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Aviary name cannot be null or empty.", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
            System.err.println(e.getMessage()); // Print the error message if the exception is caught

        }
    }

    // Test rescuing a bird into an aviary
    @Test
    public void testRescueBird() {
        birdConservatory.rescueBird(aviaryName1, parrots);
        List<Birds> birdsInAviary = birdConservatory.getBirdsInAviary(aviaryName1);
        System.out.println(birdsInAviary);
        assertEquals(1, birdsInAviary.size());
        assertEquals(parrots.getType(), birdsInAviary.get(0).getType());

        birdConservatory.rescueBird(aviaryName1, pigeons);
        assertEquals(2, birdsInAviary.size());
        assertEquals(pigeons.getType(), birdsInAviary.get(1).getType());
        System.out.println(birdsInAviary);
    }

    // Test for exception when rescuing a bird with null values
    @Test
    public void testRescueBirdException(){
        try {
            String result = birdConservatory.rescueBird("Forest Aviary", null);
            fail("Expected IllegalArgumentException not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Aviary name and bird cannot be null.", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
            System.err.println(e.getMessage()); // Print the error message if the exception is caught
        }
    }


    // Test rescuing an extinct bird in an existing aviary
    @Test
    public void testRescueExtinctBirdInExisting() {
        testRescueBird();
        birdConservatory.rescueBird(aviaryName1, flightlessBirdsExtinct);
        List<Birds> birdsInAviary = birdConservatory.getBirdsInAviary(aviaryName1);
        assertEquals(2, birdsInAviary.size());
    }

    // Test rescuing an extinct bird in a new aviary
    @Test
    public void testRescueExtinctBirdInNew() {
        birdConservatory.rescueBird(aviaryName3, flightlessBirdsExtinct);
        List<Birds> birdsInAviary = birdConservatory.getBirdsInAviary(aviaryName3);
        assertEquals(0, birdsInAviary.size());
        System.out.println(birdsInAviary);
    }

    // Test rescuing a mix of bird types
    @Test
    public void testAddingMixedTypeBirds() {
        testRescueBird();
        birdConservatory.rescueBird(aviaryName1, birdsOfPrey);
        System.out.println(birdConservatory.rescueBird(aviaryName1, birdsOfPrey));
    }

    // Test rescuing a mixed bird to a new aviary
    @Test
    public void addMixedBirdToNewAviary() {
        birdConservatory.addAviary(aviaryName3);
        System.out.println(birdConservatory.getBirdsInAviary(aviaryName1));
        System.out.println(birdConservatory.getBirdsInAviary(aviaryName3));
        birdConservatory.rescueBird(aviaryName3, birdsOfPrey);
        System.out.println(birdConservatory.rescueBird(aviaryName3, birdsOfPrey));
    }

    // Test calculating food requirements for rescued birds
    @Test
    public void testCalculateFoodRequirements(){
        birdConservatory.addAviary(aviaryName2);
        birdConservatory.rescueBird(aviaryName1, pigeons);
        birdConservatory.rescueBird(aviaryName2, owls);
        birdConservatory.rescueBird(aviaryName1, parrots);

        Map<PreferredFood, Integer> foodRequirements = birdConservatory.calculateFoodRequirements();

        // Check the expected food requirements
        assertEquals(Integer.valueOf(2), foodRequirements.get(PreferredFood.SEEDS));
        assertEquals(Integer.valueOf(1), foodRequirements.get(PreferredFood.BUDS));
        assertEquals(Integer.valueOf(1), foodRequirements.get(PreferredFood.BERRIES));
        assertEquals(Integer.valueOf(1), foodRequirements.get(PreferredFood.FRUIT));
        assertEquals(Integer.valueOf(1), foodRequirements.get(PreferredFood.FISH));
        assertEquals(Integer.valueOf(1), foodRequirements.get(PreferredFood.AQUATIC_INVERTEBRATES));

        // Check that no other food types are present
        assertNull(foodRequirements.get(PreferredFood.OTHER_BIRDS)); // No fruits should be required

        System.out.println(foodRequirements);
    }

    // Test finding the aviary by bird type
    @Test
    public void testFindAviaryByBirdType() {
        birdConservatory.rescueBird(aviaryName1, pigeons);
        String birdPresent = birdConservatory.findAviaryByBirdType(pigeons.getType());
        assertEquals(aviaryName1, birdPresent);
        System.out.println(pigeons.getType() + " are present in "+ birdPresent);

        String birdAbsent = birdConservatory.findAviaryByBirdType("eagle");
        assertEquals("Bird not found in any aviary.", birdAbsent);
        System.out.println(birdAbsent);
    }

    // Test generating a sign for an aviary with birds
    @Test
    public void testGenerateAviarySign() {
        birdConservatory.rescueBird(aviaryName1, parrots);
        birdConservatory.rescueBird(aviaryName1, pigeons);
        String sign = birdConservatory.generateAviarySign(aviaryName1);
        System.out.println(sign);

        //Empty Aviary with no birds in it.
        birdConservatory.addAviary(aviaryName2);
        String sign1 = birdConservatory.generateAviarySign(aviaryName2);
        System.out.println(sign1);

        //Aviary does not exist
        String sign2 = birdConservatory.generateAviarySign("Test Aviary");
        System.out.println(sign2);
    }

    // Test generating a map of aviaries
    @Test
    public void testGenerateAviaryMap() {
        birdConservatory.rescueBird(aviaryName1, pigeons);
        birdConservatory.rescueBird(aviaryName1, parrots);
        birdConservatory.rescueBird(aviaryName1, birdsOfPrey); //Should not be added in the code
        String map = birdConservatory.generateAviaryMap();
        assertTrue(map.contains("Tropical Aviary")); // Map should include aviary name
        System.out.println(map);

        birdConservatory.addAviary(aviaryName2);
        birdConservatory.rescueBird(aviaryName2, owls);
        birdConservatory.rescueBird(aviaryName2, shorebirds);
        String map1 = birdConservatory.generateAviaryMap();
        System.out.println(map1);
    }

    // Test generating an index of birds in aviaries
    @Test
    public void testGenerateBirdIndex() {
        birdConservatory.addAviary(aviaryName2);
        birdConservatory.rescueBird(aviaryName1, pigeons);
        birdConservatory.rescueBird(aviaryName1, parrots);
        birdConservatory.rescueBird(aviaryName2, owls);
        birdConservatory.rescueBird(aviaryName2, shorebirds);
        birdConservatory.rescueBird(aviaryName2, waterfowls);
        String index = birdConservatory.generateBirdIndex();
        assertTrue(index.contains("Doves - Aviary: Tropical Aviary")); // Index should include bird and location
        System.out.println(index);
    }

//================================================== AVIARY TEST==============================================

    // Test adding more aviaries than the limit
    @Test
    public void addAviaryMoreThanSize() {
        for (int i = 0; i < 20; i++) {
            birdConservatory.addAviary( "Aviary : " + (i+1) );
        }
        System.out.println(birdConservatory.getAviaries());
    }

    // Test checking the capacity of the aviary
    @Test
    public void testGetCapacity() {
        try {
            for (int i = 0; i < 5; i++) {
                List<PreferredFood> preferredFoods = Arrays.asList(PreferredFood.BERRIES, PreferredFood.LARVAE);
                if (preferredFoods.size() < 2 && preferredFoods.size() > 4) {
                    throw new IllegalArgumentException("Preferred food must have at least 2 items.");
                }
                aviary.addBird(new Birds("Bird" + i, "Common Bird", false, 2, preferredFoods));
            }
            System.out.println(aviary.getCapacity());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage()); // Print the error message if the exception is caught
        }
    }


    // Test counting the current number of birds in the aviary
    @Test
    public void testCurrentBirdCount() {
        try {
            for (int i = 0; i < 3; i++) {
                List<PreferredFood> preferredFoods = Arrays.asList(PreferredFood.BERRIES, PreferredFood.SEEDS, PreferredFood.FRUIT);
                if (preferredFoods.size() < 2 && preferredFoods.size() > 4) {
                    throw new IllegalArgumentException("Preferred food must have at least 2 items and not more than 4.");
                }
                aviary.addBird(new Birds("Bird" + i, "Common Bird", false, 2, preferredFoods));
            }
            System.out.println(aviary.getCurrentBirdCount());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage()); // Print the error message if the exception is caught
        }
    }

    // Test trying to add more birds than the aviary capacity allows
    @Test
    public void testAddBirdsExceedingCapacity() {
        try {
            for (int i = 0; i < 5; i++) {
                List<PreferredFood> preferredFoods = Arrays.asList(PreferredFood.BERRIES, PreferredFood.FRUIT);
                if (preferredFoods.size() < 2 && preferredFoods.size() > 4) {
                    throw new IllegalArgumentException("Preferred food must have at least 2 items.");
                }
                aviary.addBird(new Birds("Bird" + i, "Common Bird", false, 2, preferredFoods));
            }
            // Attempt to add an additional bird
            assertFalse(aviary.addBird(parrots)); // Should not allow adding a sixth bird
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage()); // Print the error message if the exception is caught
        }
    }


    // Test getting a description of the aviary
    @Test
    public void testGetDescription() {
        aviary.addBird(parrots);
        String description = aviary.getDescription();
        assertTrue(description.contains("Rose-ringed parakeet")); // Should include the bird type
        System.out.print(description);
    }
}
