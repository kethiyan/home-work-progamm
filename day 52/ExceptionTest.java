import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionTest {

    StringOperations obj = new StringOperations();

    @Test
    void testException() {

        assertThrows(NullPointerException.class, () -> {
            obj.findLength(null);
        });

    }
}