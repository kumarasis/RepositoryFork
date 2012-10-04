package com.test.mockito;

import org.junit.Test;
import static org.mockito.Mockito.*;
import java.util.*;
import org.mockito.InOrder;

public class OrderTest {
	@Test
	public void orderOfExecutionTest()
	{
		List singleMock = mock(List.class);
			 
			//using a single mock
			singleMock.add("was added first");
			singleMock.add("was added second");
			 
			//create an inOrder verifier for a single mock
			InOrder inOrder = inOrder(singleMock);
			 
			//following will make sure that add is first called with "was added first, then with "was added second"
			inOrder.verify(singleMock).add("was added first");
		inOrder.verify(singleMock).add("was added second");
			 
			// B. Multiple mocks that must be used in a particular order
			List firstMock = mock(List.class);
			List secondMock = mock(List.class);
			 
			//using mocks
			firstMock.add("was called first");
			secondMock.add("was called second");
			 
			//create inOrder object passing any mocks that need to be verified in order
		InOrder inOrder1 = inOrder(firstMock, secondMock);
			 
			//following will make sure that firstMock was called before secondMock
			inOrder1.verify(firstMock).add("was called first");
			inOrder1.verify(secondMock).add("was called second");
				
		
	}

}
