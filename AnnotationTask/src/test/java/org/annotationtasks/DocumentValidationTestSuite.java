package org.annotationtasks;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	AadharCardValidationTest.class,
	PanCardValidationTest.class,
	DocumentConsistencyTest.class
})
public class DocumentValidationTestSuite {


}
