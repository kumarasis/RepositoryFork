package com.test.mockito;

import static org.mockito.Mockito.*;

import java.util.LinkedList;

import org.junit.Test;





public class ArgumentMatcher {
	@Test
	public void argumentMatcher()
	{
		LinkedList mockedList = mock(LinkedList.class);

		//stubbing using built-in anyInt() argument matcher
			when(mockedList.get(anyInt())).thenReturn("element");
		 
			//stubbing using hamcrest (let's say isValid() returns your own hamcrest matcher):
		//	when(mockedList.contains(argThat(isValid()))).thenReturn("element");
			 
			//following prints "element"
			System.out.println(mockedList.get(999));
			 
			//you can also verify using an argument matcher
			verify(mockedList).get(anyInt());
	}

}
