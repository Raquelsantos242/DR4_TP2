package parrot;

public class Parrot {

    private static final double BASE_SPEED = 12.0;
    private static final double LOAD_FACTOR = 9.0;
    private static final double MAX_VOLTAGE_SPEED = 24.0;

    private final ParrotTypeEnum type;
    private final int numberOfCoconuts;
    private final double voltage;
    private final boolean isNailed;

    public Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public double getSpeed() {
        switch (type) {
            case EUROPEAN:
                return BASE_SPEED;

            case AFRICAN:
                double load = LOAD_FACTOR * numberOfCoconuts;
                double result = BASE_SPEED - load;
                return Math.max(0, result);

            case NORWEGIAN_BLUE:
                if (isNailed) {
                    return 0;
                }
                double speed = BASE_SPEED * voltage;
                return Math.min(MAX_VOLTAGE_SPEED, speed);

            default:
                throw new IllegalStateException("Tipo desconhecido: " + type);
        }
    }

    public String getCry() {
        switch (type) {
            case EUROPEAN:
                return "Sqoork!";
            case AFRICAN:
                return "Sqaark!";
            case NORWEGIAN_BLUE:
                return voltage > 0 ? "Bzzzzzz" : "...";
            default:
                throw new IllegalStateException("Tipo desconhecido: " + type);
        }
    }
}
