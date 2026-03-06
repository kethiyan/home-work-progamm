import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        ParameterTest.class,
        ExceptionTest.class,
        TimeTest.class
})

public class AllTestSuite {

}