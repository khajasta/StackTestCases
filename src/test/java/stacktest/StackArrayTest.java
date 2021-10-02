package stacktest;



import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.model.TestTimedOutException;

public class StackArrayTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@SuppressWarnings("unused")
	private final PrintStream originalOut = System.out;
	@SuppressWarnings("unused")
	private final PrintStream originalErr = System.err;
	@Before
	public void Beforeall()
	{
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@Test
	public void TestPush() {
		@SuppressWarnings("unused")
		StackArray array=new StackArray();
		StackArray.push(20);
		StackArray.push(30);
		StackArray.push(40);
	}
	@Test
	public void TestPop()
	{
		@SuppressWarnings("unused")
		StackArray array=new StackArray();
		StackArray.push(60);
		StackArray.push(70);
		StackArray.push(80);
		Assert.assertEquals(80, StackArray.pop());
		Assert.assertEquals(70, StackArray.pop());
		Assert.assertEquals(60, StackArray.pop());
		Assert.assertEquals(0, StackArray.addPointer);
	}
	@Test()
	public void checkpointer()
	{
		StackArray.pop();
		Assert.assertTrue(StackArray.pop()==-1);
	}
	@SuppressWarnings("unused")
	@Test
	public void checksize()
	{
		StackArray array=new StackArray();
		for(int i=0;i<10;i++)
			StackArray.push(20);
		Assert.assertEquals(10, StackArray.size);
	}
	@Test
	public void update()
	{
		Assert.assertFalse(StackArray.size==0);
		@SuppressWarnings("unused")
		StackArray stackl=new StackArray();
		Assert.assertSame(StackArray.size,StackArray.addPointer);
	}
	@Test (timeout=3)
	public void samearrays() throws TestTimedOutException
	{
		int[] array=new int[100];
		@SuppressWarnings("unused")
		StackArray stackg=new StackArray();
		Assert.assertArrayEquals(array, StackArray.array);
	}
	@SuppressWarnings("unused")
	@Test
	public void testdisplay()
	{
		StackArray stackg=new StackArray();
		StackArray.push(60);
		StackArray.push(70);
		StackArray.display();
		String comparison="Push Operation : "+"60"+"\r\n"+"Push Operation : "+"70"+"\r\n";
		String compare=comparison+"Stack : "+"60"+" "+"70"+" "+"\r\n";
		assertEquals(compare, outContent.toString());
	}

}
