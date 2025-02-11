package Task_2;

import java.time.LocalTime;

public record ClientRequest(String user, int priority, LocalTime time)
        implements Comparable<ClientRequest> {
    @Override
    public int compareTo(ClientRequest other) {
        return Integer.compare(this.priority(), other.priority());
    }
}
