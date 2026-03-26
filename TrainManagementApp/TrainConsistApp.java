import java.util.*;

class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return type + " - Cargo: " + cargo;
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        List<GoodsBogie> goodsList = new ArrayList<>();

        goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsList.add(new GoodsBogie("Rectangular", "Coal"));
        goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));

        System.out.println("Goods Bogies:");
        goodsList.forEach(System.out::println);

        boolean isSafe = goodsList.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical") ||
                                b.getCargo().equalsIgnoreCase("Petroleum")
                );

        if (isSafe) {
            System.out.println("\nTrain is Safety Compliant");
        } else {
            System.out.println("\nTrain is NOT Safety Compliant");
        }
    }
}
