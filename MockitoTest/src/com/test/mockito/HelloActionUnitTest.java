package com.test.mockito;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import com.test.mockito.HelloApplication.HelloAction;
import com.test.mockito.HelloApplication.HelloSource;
import static com.test.mockito.HelloApplication.HelloActionImpl;
 
public class HelloActionUnitTest {
 
   HelloSource helloSourceMock;
   Appendable helloWriterMock;
   HelloAction helloAction;
 
   @Before
   public void setUp() {
      helloSourceMock = mock(HelloSource.class);
      helloWriterMock = mock(Appendable.class);
      helloAction = new HelloActionImpl(helloSourceMock, helloWriterMock);
   }
 
   @Test
   public void testSayHello() throws Exception {
      when(helloWriterMock.append(any(String.class))).thenReturn(helloWriterMock);
      when(helloSourceMock.getIntroduction(eq("unitTest"))).thenReturn("unitTest : ");
      when(helloSourceMock.getHello(eq("world"))).thenReturn("hi world");
       helloAction.sayHello("unitTest", "world");
       verify(helloSourceMock).getIntroduction(eq("unitTest"));
      verify(helloSourceMock).getHello(eq("world"));
       verify(helloWriterMock, times(2)).append(any(String.class));
      verify(helloWriterMock, times(1)).append(eq("unitTest : "));
      verify(helloWriterMock, times(1)).append(eq("hi world"));
   }
}
