import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {

    protected TreeMap<LocalDateTime, String> missCalls = new TreeMap<>();

    public void addMissCals(LocalDateTime time, String phone) {
        missCalls.put(time, phone);
    }

    public void addMissCals(LocalDateTime time, Contact contact) {
        missCalls.put(time, contact.toString());
    }

    public void clearMissedCalls() {
        missCalls.clear();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Map.Entry<LocalDateTime, String> entry : missCalls.entrySet()) {
            output.append(entry.getKey() + " " + entry.getValue() + "\n");
        }
        return output.toString();
    }
}