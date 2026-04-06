import java.util.*;

class Bogie {
    private String id;

    public Bogie(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

class Train {
    private List<Bogie> bogies = new ArrayList<>();

    public void addBogie(Bogie bogie) {
        bogies.add(bogie);
    }

    public Bogie searchBogie(String id) {
        if (bogies.isEmpty()) {
            throw new IllegalStateException("Search cannot be performed: No bogies available in the train.");
        }
        for (Bogie b : bogies) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        Train train = new Train();
        try {
            train.searchBogie("B1");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        train.addBogie(new Bogie("B1"));
        train.addBogie(new Bogie("B2"));
        Bogie result = train.searchBogie("B1");
        if (result != null) {
            System.out.println(result.getId());
        } else {
            System.out.println("Bogie not found");
        }
    }
}