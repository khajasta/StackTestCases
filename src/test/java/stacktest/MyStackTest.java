package stacktest;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MyStackTest {
	 private MyStack stacknode;
	 private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		
		@SuppressWarnings("unused")
		private final PrintStream originalOut = System.out;
		@SuppressWarnings("unused")
		private final PrintStream originalErr = System.err;

	 @Before
	 public void BeforeTest()
	 {
		 stacknode=new MyStack(0);
		 System.setOut(new PrintStream(outContent));
		    System.setErr(new PrintStream(errContent));
	 }
	@Test
	public void testpush() throws Exception {
		 stacknode=new MyStack(2);
		 stacknode.push(10);
		 stacknode.push(20); 
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testpop() throws Exception
	{
		stacknode=new MyStack(2);
		 stacknode.push(40);
		 stacknode.push(50);
		 Assert.assertEquals(50, stacknode.pop());
		 Assert.assertEquals(40, stacknode.pop());
	}
	@Test(expected=Exception.class)
	public void checkexception() throws Exception
	{
		stacknode=new MyStack(2);
		 stacknode.push(40);
		 stacknode.push(50);	
		 stacknode.push(60);
		 stacknode.push(70);
	}
   @Test (expected=Exception.class)
   public void popexception() throws Exception
   {
	   stacknode.pop();
   }
   @Test(expected=Exception.class)
   public void topexception() throws Exception
   {
	   stacknode.top();
   }
   @SuppressWarnings("deprecation")
@Test (timeout=5)
   public void PopTop() throws Exception
   {
	   stacknode=new MyStack(5);
	   for(int i=0;i<5;i++)
	   {
		   stacknode.push(i*10);
	   }
	   Assert.assertEquals(40, stacknode.top());
	   stacknode.pop();
	   Assert.assertEquals(30, stacknode.top());
   }
   @Test
   public void testdisplay() throws Exception
   {
	   stacknode=new MyStack(3);
		 stacknode.push(10);
		 stacknode.push(20);
		 stacknode.push(30);
		 stacknode.displayStack();
	   String compare="Push num : "+"10\r\n"+"Push num : "+"20\r\n"+"Push num : "+"30\r\n";
	   String comparestring=compare+"Stack : [" + " "+"10"+" "+"20"+" "+"30"+" "+"]"+"\r\n";
	   assertEquals(comparestring, outContent.toString());
   }
   @SuppressWarnings("deprecation")
@Test
   public void assertions()
   {
	   Assert.assertEquals(-1, stacknode.topPointer);
	   Assert.assertNotNull(stacknode);
	   Assert.assertSame(0, stacknode.size());
   }
}
