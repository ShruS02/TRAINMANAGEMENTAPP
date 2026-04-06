import java.util.Arrays;

public class TrainConsistApp {
    public static void main(String[] args) {
        String[] bogieNames = {"Sleeper","AC Chair","First Class","General","Luxury"};
        Arrays.sort(bogieNames);
        System.out.println(Arrays.toString(bogieNames));
    }
}