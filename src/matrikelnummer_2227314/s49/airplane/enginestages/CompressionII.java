package matrikelnummer_2227314.s49.airplane.enginestages;

public class CompressionII extends Compression {
    public CompressionII() {
        super(72);
    }

    @Override
    public String compress(String airflow) {
        return airflow.replaceAll("2a2b", "2(ab)").replaceAll("2b2a", "2(ba)");
    }
}
