package matrikelnummer_2227314.s49.airplane;

public enum EngineType {
    ROLLS_ROYCE_TRENT_900("Rolls-Royce Trent 900")
    ;

    private String name;

    EngineType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
