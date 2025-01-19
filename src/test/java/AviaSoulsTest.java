import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AviaSoulsTest {

    @Test
    public void testSearchWithDefaultPriceSorting() {
        AviaSouls manager = new AviaSouls();

        manager.add(new Ticket("Moscow", "Paris", 15000, 600, 900));
        manager.add(new Ticket("Moscow", "Paris", 12000, 700, 1000));
        manager.add(new Ticket("Moscow", "Paris", 18000, 800, 1100));
        manager.add(new Ticket("Moscow", "Berlin", 10000, 600, 800));

        Ticket[] searchResults = manager.search("Moscow", "Paris");

        assertEquals(3, searchResults.length);
        assertEquals(12000, searchResults[0].getPrice());
        assertEquals(15000, searchResults[1].getPrice());
        assertEquals(18000, searchResults[2].getPrice());
    }

    @Test
    public void testSearchAndSortByDuration() {
        AviaSouls manager = new AviaSouls();

        manager.add(new Ticket("Moscow", "Paris", 15000, 600, 900));
        manager.add(new Ticket("Moscow", "Paris", 12000, 700, 1000));
        manager.add(new Ticket("Moscow", "Paris", 18000, 800, 1100));
        manager.add(new Ticket("Moscow", "Berlin", 10000, 600, 800));

        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] sortedByDuration = manager.searchAndSortBy("Moscow", "Paris", timeComparator);

        assertEquals(3, sortedByDuration.length);
        assertEquals(300, sortedByDuration[0].getTimeTo() - sortedByDuration[0].getTimeFrom());
    }
}
