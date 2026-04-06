class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String shape;
    private String cargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargoType) {
        try {
            if (shape.equalsIgnoreCase("Rectangular") &&
                    cargoType.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Unsafe cargo! Petroleum cannot be assigned to Rectangular bogie.");
            }
            this.cargo = cargoType;
            System.out.println("Cargo assigned successfully: " + cargoType);
        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Cargo assignment attempt completed for " + shape + " bogie.\n");
        }
    }

    public String getCargo() {
        return cargo;
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        b1.assignCargo("Petroleum");

        GoodsBogie b2 = new GoodsBogie("Rectangular");
        b2.assignCargo("Petroleum");

        GoodsBogie b3 = new GoodsBogie("Rectangular");
        b3.assignCargo("Grain");

        System.out.println("Program continues safely after handling exceptions.");
    }
}