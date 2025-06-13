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
        return switch (type) {
            case EUROPEAN -> europeSpeed();
            case AFRICAN -> africanSpeed();
            case NORWEGIAN_BLUE -> norwegianBlueSpeed();
        };
    }

    private double europeSpeed() {
        return BASE_SPEED;
    }

    private double africanSpeed() {
        double adjusted = BASE_SPEED - LOAD_FACTOR * numberOfCoconuts;
        return Math.max(0, adjusted);
    }

    private double norwegianBlueSpeed() {
        if (isNailed) {
            return 0;
        }
        return Math.min(MAX_VOLTAGE_SPEED, voltage * BASE_SPEED);
    }

    public String getCry() {
        return switch (type) {
            case EUROPEAN -> "Sqoork!";
            case AFRICAN -> "Sqaark!";
            case NORWEGIAN_BLUE -> voltage > 0 ? "Bzzzzzz" : "...";
        };
    }
}
