public class InheritanceAdapter extends FahrenheitTemperature implements Temperature {
    public InheritanceAdapter(double celsius) {
        super(0);
        this.fromCelsius(celsius);
    }

    @Override
    public double getCelsius() {
        return toCelsius();
    }

    @Override
    public void setCelsius(double celsius) {
        fromCelsius(celsius);
    }

    @Override
    public double getKelvin() {
        return toCelsius() + 273.15;
    }

    @Override
    public void setKelvin(double kelvin) {
        fromCelsius(kelvin - 273.15);
    }
}
