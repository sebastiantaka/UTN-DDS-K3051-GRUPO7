package loco;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class ElQueSiempreDiceTrueTest {
	
	ElQueSiempreDiceTrue elVerdadero;
	
	@Before
	public void init() {
		elVerdadero = new ElQueSiempreDiceTrue();
	}
	
	@Test
	public void test() {
		assert(elVerdadero.deciTrue());
	}


}
