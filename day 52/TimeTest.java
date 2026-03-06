import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

class TimeTest {

    StringOperations obj = new StringOperations();

    @Test
    void testTimeout() {

        assertTimeout(Duration.ofMillis(100), () -> {
            obj.reverseString("performance");
        });

    }
}