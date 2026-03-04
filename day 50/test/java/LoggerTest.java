
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LoggerTest {

    @Test
    void testSingletonInstanceNotNull() {
        Logger logger = Logger.getInstance();
        assertNotNull(logger);
    }

    @Test
    void testMultipleCallsReturnSameInstance() {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        assertSame(logger1, logger2);
    }
}