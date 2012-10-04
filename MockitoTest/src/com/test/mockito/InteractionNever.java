package com.test.mockito;

import static org.mockito.Mockito.*;
import java.util.LinkedList;
import org.junit.Test;


public class InteractionNever {
	@Test
public void test(){
		LinkedList mockOne=mock(LinkedList.class);
		//using mocks - only mockOne is interacted
			mockOne.add("one");
			//mockOne.add("two");
			 
			//ordinary verification
			verify(mockOne).add("one");
			 
			//verify that method was never called on a mock
			verify(mockOne, never()).add("two");
			LinkedList mockTwo=mock(LinkedList.class);
			LinkedList mockThree=mock(LinkedList.class);
			mockThree.add("pqr");
			//verify that other mocks were not interacted
			verifyZeroInteractions(mockTwo, mockThree);
		
}
}
