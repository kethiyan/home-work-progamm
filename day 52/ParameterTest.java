import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class ParameterTest {

    StringOperations obj = new StringOperations();

    @ParameterizedTest
    @ValueSource(strings = {"java", "hello", "junit"})
    void testLength(String input) {

        int result = obj.findLength(input);

        assertTrue(result > 0);
    }
}