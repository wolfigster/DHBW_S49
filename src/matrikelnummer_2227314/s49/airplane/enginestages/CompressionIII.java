package matrikelnummer_2227314.s49.airplane.enginestages;

public class CompressionIII extends Compression {
    public CompressionIII() {
        super(96);
    }

    @Override
    public String compress(String airflow) {
        return airflow.replaceAll("4a2b", "2(2ab)").replaceAll("4b2a", "2(2ba)");
    }
}
