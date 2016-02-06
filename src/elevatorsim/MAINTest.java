package elevatorsim;

import static org.junit.Assert.*;

import org.junit.Test;

public class MAINTest {

	@Test(expected=UnknownSimTypeException.class)
	public void testLookupSimType() {
		assertEquals(MAIN.lookupSimType(1), Config.simType.ASSENT);
		assertEquals(MAIN.lookupSimType(2), Config.simType.DESCENT);
		assertEquals(MAIN.lookupSimType(3), Config.simType.NORMAL);
		MAIN.lookupSimType(4);
	}

}
