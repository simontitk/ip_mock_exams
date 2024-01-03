import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class SmartGarden {

    private int roomLight;
    private int waterTankLevel;
    private List<Plant> plants;


    public SmartGarden(int roomLight, int waterTankLevel) {
        this.roomLight = roomLight;
        this.waterTankLevel = waterTankLevel;
        this.plants = new ArrayList<>();
    }


    public void addPlant(Plant plant) {
        this.plants.add(plant);
    }
    
    
    public void waterPlants() {

        for (Plant plant : this.plants) {
            int requiredWater = plant.getRequiredWater();
            if (requiredWater > this.waterTankLevel) {
                throw new LowWaterLevelException("there is not enough water");
            }
            this.waterTankLevel -= requiredWater;
            plant.water(requiredWater);
            
        }
    }


    public void checkLighting() {

        for (Plant plant : plants) {
            if (this.roomLight < plant.getOptimalLightingLevel()) {
                System.out.println("plant " + plant.getName() + " requires more light");
            }
            else if (this.roomLight > plant.getOptimalLightingLevel()) {
                System.out.println("plant " + plant.getName() + " requires less light");
            }
            else {
                System.out.println("plant " + plant.getName() + " has the perfect amount of light");
            }
        }
    }


    public Map<Plant, Integer> numberOfPlants() {
        Map<Plant, Integer> plantMap = new HashMap<>();

        for (Plant plant : plants) {
            plantMap.merge(plant, 1, Integer::sum);   
        }
        return plantMap;
    }

    
    public void printReport() {
        this.numberOfPlants().keySet().forEach(Plant::printReport);
    }    
    
}
