public class FahrenheitTemperature {
    private double degree;

    public FahrenheitTemperature(double degree) {
        this.degree = degree;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public double toCelsius() {
        return (degree - 32) / 1.8;
    }

    public void fromCelsius(double celsius) {
        degree = celsius * 1.8 + 32;
    }

    @Override
    public String toString() {
        return "FahrenheitTemperature: " + degree + "°F";
    }
}
