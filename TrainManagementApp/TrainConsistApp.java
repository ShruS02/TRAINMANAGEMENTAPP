import java.util.*;

class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " - Capacity: " + capacity;
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        List<Bogie> bogieList = new ArrayList<>();

        try {
            bogieList.add(new Bogie("Sleeper", 72));
            bogieList.add(new Bogie("AC Chair", 56));
            bogieList.add(new Bogie("First Class", 0));
        } catch (InvalidCapacityException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Valid Bogies:");
        bogieList.forEach(System.out::println);
    }
}