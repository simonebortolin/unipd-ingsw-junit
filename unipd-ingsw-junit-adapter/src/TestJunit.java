import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestJunit {
    @Test
    public void testFromCelsiusO() {
        double temp = Math.random() % 100;
        ObjectAdapter objectAdapter = new ObjectAdapter(temp);
        assertEquals(objectAdapter.getCelsius(), temp, 0.20);
        assertEquals(objectAdapter.getKelvin(), temp + 273, 0.20);
        assertEquals(objectAdapter.getKelvin(), temp + 273.15, 0.20);
    }

    @Test
    public void testFromKelvinO() {
        double temp = Math.random() % 100;
        ObjectAdapter objectAdapter = new ObjectAdapter(0);
        objectAdapter.setKelvin(temp);
        assertEquals(objectAdapter.getKelvin(), temp, 0.20);
        assertEquals(objectAdapter.getCelsius(), temp - 273, 0.20);
        assertEquals(objectAdapter.getCelsius(), temp - 273.15, 0.20);
    }

    @Test
    public void testFromCelsiusI() {
        double temp = Math.random() % 100;
        InheritanceAdapter objectAdapter = new InheritanceAdapter(temp);
        assertEquals(objectAdapter.getCelsius(), temp, 0.20);
        assertEquals(objectAdapter.getKelvin(), temp + 273, 0.20);
        assertEquals(objectAdapter.getKelvin(), temp + 273.15, 0.20);
    }

    @Test
    public void testFromKelvinI() {
        double temp = Math.random() % 100;
        InheritanceAdapter objectAdapter = new InheritanceAdapter(0);
        objectAdapter.setKelvin(temp);
        assertEquals(objectAdapter.getKelvin(), temp, 0.20);
        assertEquals(objectAdapter.getCelsius(), temp - 273, 0.20);
        assertEquals(objectAdapter.getCelsius(), temp - 273.15, 0.20);
    }
}
