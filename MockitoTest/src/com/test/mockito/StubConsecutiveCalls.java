package com.test.mockito;

import static org.mockito.Mockito.*;

import java.util.LinkedList;

import org.junit.Test;
import org.mockito.Mock;
public class StubConsecutiveCalls {
@Test
	public void test()
	{
	//LinkedList mockedList = mock(LinkedList.class);
	
	
	when(mock.someMethod("some arg")).thenThrow(new RuntimeException()).thenReturn("foo");
		 
		//First call: throws runtime exception:
		mock.someMethod("some arg");
		 
		//Second call: prints "foo"
		System.out.println(mock.someMethod("some arg"));
	 
	//Any consecutive call: prints "foo" as well (last stubbing wins).
	System.out.println(mock.someMethod("some arg"));
		
	}
}
