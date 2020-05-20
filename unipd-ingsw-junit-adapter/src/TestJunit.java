import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestJunit {
    @Test
    public void testFromCelsius() {
        double temp = Math.random() % 100;
        Adapter adapter = new Adapter(temp);
        assertEquals(adapter.getCelsius(), temp, 0.20);
        assertEquals(adapter.getKelvin(), temp + 273, 0.20);
        assertEquals(adapter.getKelvin(), temp + 273.15, 0.20);
    }

    @Test
    public void testFromKelvin() {
        double temp = Math.random() % 100;
        Adapter adapter = new Adapter(0);
        adapter.setKelvin(temp);
        assertEquals(adapter.getKelvin(), temp, 0.20);
        assertEquals(adapter.getCelsius(), temp - 273, 0.20);
        assertEquals(adapter.getCelsius(), temp - 273.15, 0.20);
    }
}
