package parrot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParrotTest {

    @Test
    public void europeanParrotAlwaysBaseSpeed() {
        Parrot p = new Parrot(ParrotTypeEnum.EUROPEAN, 3, 5.0, true);
        assertEquals(12.0, p.getSpeed(), 0.0);
        assertEquals("Sqoork!", p.getCry());
    }

    @Test
    public void africanParrotLoadsCoconuts() {
        Parrot p = new Parrot(ParrotTypeEnum.AFRICAN, 1, 0.0, false);
        assertEquals(3.0, p.getSpeed(), 0.0);
        assertEquals("Sqaark!", p.getCry());
    }

    @Test
    public void africanParrotTooManyCoconuts() {
        Parrot p = new Parrot(ParrotTypeEnum.AFRICAN, 2, 0.0, false);
        assertEquals(0.0, p.getSpeed(), 0.0);
    }

    @Test
    public void norwegianBlueNailed() {
        Parrot p = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 3.0, true);
        assertEquals(0.0, p.getSpeed(), 0.0);
    }

    @Test
    public void norwegianBlueWithVoltage() {
        Parrot p = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 1.5, false);
        assertEquals(18.0, p.getSpeed(), 0.0);
        assertEquals("Bzzzzzz", p.getCry());
    }

    @Test
    public void norwegianBlueHighVoltage() {
        Parrot p = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 3.0, false);
        assertEquals(24.0, p.getSpeed(), 0.0);
    }

    @Test
    public void norwegianBlueNoVoltageCry() {
        Parrot p = new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 0.0, false);
        assertEquals("...", p.getCry());
    }
}
