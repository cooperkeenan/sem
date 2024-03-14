import com.napier.sem.App;
import com.napier.sem.Country;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MyTest {

    @Test
    void testListCorrectlyOrdered() {
        App app = new App();
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Japan", 126714000));
        countries.add(new Country("Germany", 82164700));
        countries.add(new Country("Croatia", 4473000));
        // Assert that the method returns true, indicating the countries list is correctly ordered by descending population
        assertTrue(app.isListCorrectlyOrdered(countries));
    }

    @Test
    void testListNotCorrectlyOrdered() {
        App app = new App();
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Japan", 126714000));
        countries.add(new Country("Croatia", 4473000)); // This should make the order incorrect
        countries.add(new Country("Germany", 82164700));
        // Assert that the method returns false, indicating the countries list is not correctly ordered by descending population
        assertFalse(app.isListCorrectlyOrdered(countries));
    }
}
