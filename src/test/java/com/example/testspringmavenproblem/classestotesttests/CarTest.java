import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void myCarTest() {
        Car mockedCar = Mockito.mock(Car.class);
        mockedCar.driveCar("Ceco");
        Mockito.verify(mockedCar).driveCar("Ceco");
        Mockito.when(mockedCar.getCarWeight()).thenThrow(new IllegalStateException("Ceco"));
        assertTrue(mockedCar != null);
        assertThrows(IllegalStateException.class, () -> mockedCar.getCarWeight());
//        assertTrue(mockedCar.getCarWeight() == 32);

    }
}
