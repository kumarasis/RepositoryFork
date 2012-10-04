package com.test.mockito;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

import java.util.LinkedList;

import org.junit.Test;

public class NoOfInvocation {
	
	@Test
public void noOfCall()
{
		LinkedList mockedList = mock(LinkedList.class);
		//using mock
			mockedList.add("once");
			mockedList.add("twice");
			mockedList.add("twice");
			mockedList.add("three times");
			mockedList.add("three times");
			mockedList.add("three times");
			 
			
			//following two verifications work exactly the same - times(1) is used by default
		//	verify(mockedList).add("once");
			verify(mockedList, times(1)).add("once");
			 
		//exact number of invocations verification
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");
		 
			//verification using never(). never() is an alias to times(0)
			verify(mockedList, never()).add("never happened");
			//verification using atLeast()/atMost()
			verify(mockedList, atLeastOnce()).add("three times");
			//verify(mockedList, atLeast(2)).add("five times");
			verify(mockedList, atMost(5)).add("three times");
		
}
	
}
