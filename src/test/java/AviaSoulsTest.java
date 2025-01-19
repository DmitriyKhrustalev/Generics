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
        Ticket[] expected = {
                new Ticket("Moscow", "Paris", 12000, 700, 1000),
                new Ticket("Moscow", "Paris", 15000, 600, 900),
                new Ticket("Moscow", "Paris", 18000, 800, 1100)
        };

        assertArrayEquals(expected, searchResults, "Массив билетов должен быть отсортирован по цене");
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
        Ticket[] expected = {
                new Ticket("Moscow", "Paris", 15000, 600, 900),
                new Ticket("Moscow", "Paris", 12000, 700, 1000),
                new Ticket("Moscow", "Paris", 18000, 800, 1100)
        };

        assertArrayEquals(expected, sortedByDuration, "Массив билетов должен быть отсортирован по длительности полета");
    }
}