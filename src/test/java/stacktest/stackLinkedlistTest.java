package stacktest;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class stackLinkedlistTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@Test
	public void TestPush() {
		stackLinkedlist.push(10);
		stackLinkedlist.push(20);
		stackLinkedlist.push(30);
	}
    @Test
    public void TestPop()
    {
    	stackLinkedlist.size=0;
    	stackLinkedlist.head=null;
    	for(int i=0;i<3;i++)
    		stackLinkedlist.push(i*10);
    	for(int i=2;i>-1;i--)
    		assertEquals(i*10,stackLinkedlist.pop());
    }
    @SuppressWarnings("deprecation")
	@Test
    public void testtop()
    {
    	stackLinkedlist.head=null;
    	Assert.assertEquals(-1, stackLinkedlist.top());
    }
    @SuppressWarnings("deprecation")
	@Test (timeout=3)
    public void testsize()
    {
    	Assert.assertTrue(stackLinkedlist.getSize()==0);
    	Assert.assertNull(stackLinkedlist.head);
        Assert.assertNotSame(stackLinkedlist.head, stackLinkedlist.top());
    }
    @Test 
    public void testdisplay()
    {
    	stackLinkedlist.push(10);
		stackLinkedlist.push(20);
		String Compare="Push data : "+"10"+"\r\n"+"Push data : "+"20"+"\r\n";
		assertEquals(Compare, outContent.toString());
    }
    
}
