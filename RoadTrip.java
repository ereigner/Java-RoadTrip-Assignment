import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
public class RoadTrip{
    private HashMap<Passenger, HashSet<String>> favFoodByPassenger = new HashMap();
    private ArrayList<String> diaryEntries = new ArrayList();
    private ArrayList<Passenger> passengers = new ArrayList();
    private String minivanNickname;

    public RoadTrip(String minivanNickname)
    {
        this.minivanNickname = minivanNickname;
    }

    
    public boolean addPassenger(Passenger passenger)
    {
        if(passengers.size() >= 8)
        {
            System.out.println("minivan full!");
            return false;
        }
        else
        {
            // Adds the passenger that was passed in to the ArrayList of passengers and then is put into the HashMap where it creates an empty HashSet
            passengers.add(passenger);
            favFoodByPassenger.put(passenger, new HashSet());
            return true;
        }
    }

    public void displayPassengers()
    {
        Iterator<Passenger> passIter = passengers.iterator();

        while(passIter.hasNext())
        {
            // Create a passenger object and set it equal to whatever is next in the iteration of the ArrayList
            Passenger passenger = passIter.next();
            System.out.println(passenger);
            // Sets a new HashSet of type String to the value of whatever passenger the iterator is one in the loop from the HashMap
            HashSet<String> foods = favFoodByPassenger.get(passenger);
            System.out.println("Favorite Foods: " + foods);
            System.out.println();
        }
    }

    public void addDiaryEntry(String diaryEntry)
    {
        diaryEntries.add(diaryEntry);
    }

    public void displayDiary()
    {
        Iterator diaryIter = diaryEntries.iterator();

        while(diaryIter.hasNext())
        {
            System.out.println(diaryIter.next());
        }
    }

    public void addFavoriteFood(Passenger passenger, String favFood)
    {
        if(favFoodByPassenger.containsKey(passenger) == false)
        {
            System.out.println("Error: Passenger doesn't exist!");
        }
        else
        {
            // Finds the correct passenger and adds the correctly passed in favorite foods to it
            favFoodByPassenger.get(passenger).add(favFood);
        }
    }




}
