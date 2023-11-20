import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean doneAddingPass = false;
        boolean doneAddingFood = false;
        boolean passengerAdded = false;

        System.out.println("Enter the minivan's nickname: ");
        String minivanNickname = scnr.nextLine();

        RoadTrip roadTrip = new RoadTrip(minivanNickname);
        
        while(!doneAddingPass)
        {
            System.out.println("Type first name to add a passenger or q to quit: ");
            String passResponse = scnr.nextLine();

            if(passResponse.equalsIgnoreCase("q"))
            {
                doneAddingPass = true;
            }
            else
            {
                System.out.println("Enter the passenger's last name: ");
                String passLastName = scnr.nextLine();

                System.out.println("Enter the passenger's phone number: ");
                String passPhoneNum = scnr.nextLine();

                Passenger passenger = new Passenger(passResponse, passLastName, passPhoneNum);
                passengerAdded = roadTrip.addPassenger(passenger);
                
                if(passengerAdded)
                {
                    doneAddingFood = false;
                    while(!doneAddingFood)
                    {
                        System.out.println("Type to add a favorite food or q to quit: ");
                        String foodResponse = scnr.nextLine();

                        if(foodResponse.equalsIgnoreCase("q"))
                        {
                            doneAddingFood = true;
                        }
                        else
                        {
                            roadTrip.addFavoriteFood(passenger, foodResponse);
                        }
                    }
                }
            }
        }

        roadTrip.addDiaryEntry("Day 1: we hiked a huge up a huge mountain, it was hard to breate up there!");
        roadTrip.addDiaryEntry("Day 2: we all tried lobster for the first time.");
        roadTrip.addDiaryEntry("Day 3: we stopped in Maine and went to Arcadia National Park!");

        System.out.println("Passenger Info: ");
        roadTrip.displayPassengers();
        System.out.println();
        System.out.println("RoadTrip Diary: ");
        roadTrip.displayDiary();
    
    }
}
