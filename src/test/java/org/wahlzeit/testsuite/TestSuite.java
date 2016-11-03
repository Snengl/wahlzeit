package org.wahlzeit.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.handlers.AllHandlerTests;
import org.wahlzeit.model.AllModelTests;
import org.wahlzeit.model.persistence.AllPersistenceTest;
import org.wahlzeit.services.AllServiceTests;
import org.wahlzeit.services.mailing.AllMailingTests;
import org.wahlzeit.utils.AllUtilsTests;

/**
 * Test all Suites in one test
 * 
 * @author Sebastian Engler, snengl, dev@snengl.com
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ AllHandlerTests.class, AllModelTests.class, AllServiceTests.class, AllMailingTests.class,
		AllUtilsTests.class })
public class TestSuite {

}
