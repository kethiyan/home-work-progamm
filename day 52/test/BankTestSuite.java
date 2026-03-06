package bank;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        BankAccountTest.class,
        DepositParameterizedTest.class,
        ExceptionTest.class,
        TimeoutTest.class
})

public class BankTestSuite {

}