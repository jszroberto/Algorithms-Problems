package arrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class URLifyTest {

	@Test
	public void TestURLify() {
		char[] s = "Test me  ".toCharArray();
		URLify.URLify(s, 7);
		System.out.println(s);
		assertEquals("Test %20me",String.valueOf(s));
	}
	@Test
	public void TestURLifyMoreSpaces() {
		char[] s = "Test me hola     ".toCharArray();
		URLify.URLify(s, 12);
		System.out.println(s);
		assertEquals("Test %20me%20hola",String.valueOf(s));
	}
	
	
	
	@Test
	public void TestURLifyLongerURL() {
		char[] s = "Test me hola mama      ".toCharArray();
		URLify.URLify(s, 17);
		System.out.println(s);
		assertEquals("Test %20me%20hola%20mama",String.valueOf(s));
	}
	

	

}
