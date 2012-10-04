package com.test.mockito;

import org.junit.Test;
import static org.mockito.Mockito.*;
import java.util.*;

public class MockitoTest {
	@Test
	public void mockitoTest()
	{
	//mock creation
		List mockList=mock(List.class);
		
		//using mock object does not throw any "unexpected interaction" exception
		mockList.add("test123");
		mockList.contains("123");
		mockList.clear();
		
		//selective and explicit verification
		
		verify(mockList).add("test123");
		verify(mockList).clear();
		verify(mockList).contains("123");
		
			}
	

}
