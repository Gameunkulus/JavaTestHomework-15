import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(@NotNull Ticket t1, @NotNull Ticket t2) {
        if (t1.getTimeTo() > t2.getTimeTo()) {
            return 1;
        } else if (t1.getTimeTo() < t2.getTimeTo()) {
            return -1;
        } else {
            return 0;
        }
    }
}
