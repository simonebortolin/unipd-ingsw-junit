public class ObjectAdapter implements Temperature {
    private final FahrenheitTemperature fahrenheitTemperature;

    public ObjectAdapter(double celsius) {
        fahrenheitTemperature = new FahrenheitTemperature(0);
        fahrenheitTemperature.fromCelsius(celsius);
    }

    @Override
    public double getCelsius() {
        return fahrenheitTemperature.toCelsius();
    }

    @Override
    public void setCelsius(double celsius) {
        fahrenheitTemperature.fromCelsius(celsius);
    }

    @Override
    public double getKelvin() {
        return fahrenheitTemperature.toCelsius() + 273.15;
    }

    @Override
    public void setKelvin(double kelvin) {
        fahrenheitTemperature.fromCelsius(kelvin - 273.15);
    }
}
