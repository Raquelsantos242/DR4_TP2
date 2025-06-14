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
            case EUROPEAN -> getEuropeanSpeed();
            case AFRICAN -> getAfricanSpeed();
            case NORWEGIAN_BLUE -> getNorwegianBlueSpeed();
            default -> throw new IllegalStateException("Tipo desconhecido: " + type);
        };
    }

    private double getEuropeanSpeed() {
        return BASE_SPEED;
    }

    private double getAfricanSpeed() {
        double coconutLoad = LOAD_FACTOR * numberOfCoconuts;
        double speedAfterLoad = BASE_SPEED - coconutLoad;
        return Math.max(0, speedAfterLoad);
    }

    private double getNorwegianBlueSpeed() {
        if (isNailed) {
            return 0;
        }
        double voltageSpeed = BASE_SPEED * voltage;
        return Math.min(MAX_VOLTAGE_SPEED, voltageSpeed);
    }

    public String getCry() {
        return switch (type) {
            case EUROPEAN -> getEuropeanCry();
            case AFRICAN -> getAfricanCry();
            case NORWEGIAN_BLUE -> getNorwegianBlueCry();
            default -> throw new IllegalStateException("Tipo desconhecido: " + type);
        };
    }

    private String getEuropeanCry() {
        return "Sqoork!";
    }

    private String getAfricanCry() {
        return "Sqaark!";
    }

    private String getNorwegianBlueCry() {
        return voltage > 0 ? "Bzzzzzz" : "...";
    }
}
