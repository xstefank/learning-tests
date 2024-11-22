package academy.learnprogramming.javacode;

public class RoadBike extends Bicycle {

    // In millimetres
    private int tireWidth;

    public RoadBike(int cadence,
                    int speed,
                    int gear,
                    int tireWidth) {
        super(cadence, speed, gear);
        this.tireWidth = tireWidth;
    }

    public int getTireWidth() {
        return tireWidth;
    }

    public void printDescription() {
        super.printDescription();
        System.out.println("The road bike has a tire width of " + tireWidth + " MM.");
    }

}
