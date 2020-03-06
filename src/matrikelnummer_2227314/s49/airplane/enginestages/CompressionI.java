package matrikelnummer_2227314.s49.airplane.enginestages;

public class CompressionI extends Compression {
    public CompressionI() {
        super(48);
    }

    @Override
    public String compress(String airflow) {
        return airflow.replaceAll("2a2a", "4a").replaceAll("2b2b", "4b");
    }
}
