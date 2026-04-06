public class TrainConsistApp {
    public static void main(String[] args) {
        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};
        String searchKey = "BG309";
        boolean found = false;

        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(searchKey)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Bogie ID found");
        } else {
            System.out.println("Bogie ID not found");
        }
    }
}