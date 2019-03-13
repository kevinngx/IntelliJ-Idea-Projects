import java.util.UUID;

public class UUIDGenerator {
    public static void main(String[] args) {
        for (int i = 0; i < 2605; i++) {
            UUID newUUID = UUID.randomUUID();
            System.out.println(newUUID);

        }
    }
}
