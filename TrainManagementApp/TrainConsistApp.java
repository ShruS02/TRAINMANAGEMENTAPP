import java.util.*;
import java.util.stream.*;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
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

        for (int i = 0; i < 100000; i++) {
            bogieList.add(new Bogie("Sleeper", 72));
            bogieList.add(new Bogie("AC Chair", 56));
            bogieList.add(new Bogie("First Class", 24));
        }

        long startLoop = System.nanoTime();
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogieList) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }
        long endLoop = System.nanoTime();

        long startStream = System.nanoTime();
        List<Bogie> streamResult = bogieList.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();

        System.out.println("Loop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());

        System.out.println("Loop Time (ns): " + (endLoop - startLoop));
        System.out.println("Stream Time (ns): " + (endStream - startStream));
    }
}