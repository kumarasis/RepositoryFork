package com.test.mockito;
import java.io.IOException;
	public class HelloApplication {
	 
	   public static interface HelloSource {
	      String getHello(String subject);
	      String getIntroduction(String actor);
	   }
	 
	   public static class HelloSourceImpl implements HelloSource {
	      private String hello;
	      private String column;
	 
	      public HelloSourceImpl(String hello, String column) {
	         this.hello = hello;
	         this.column = column;
	      }
	      public String getHello(String subject) {
	         return hello + " " + subject; 
	      }
	      public String getIntroduction(String actor) {
	         return actor+column;
	      }
	   }
	 
	   public static interface HelloAction {
	      void sayHello(String actor, String subject) throws IOException;
	   }
	 
	   public static class HelloActionImpl implements HelloAction {
	      private HelloSource helloSource;
	      private Appendable helloWriter;
	 
	      public HelloActionImpl(HelloSource helloSource, Appendable helloWriter) {
	         super();
	         this.helloSource = helloSource;
	         this.helloWriter = helloWriter;
	      }
	      public void sayHello(String actor, String subject) throws IOException { 
	         helloWriter.append(helloSource.getIntroduction(actor)).append(helloSource.getHello(subject));
	      }
	   }
	 
	   public static void main(String... args) throws IOException {
	      new HelloActionImpl(new HelloSourceImpl("hello", ": "), System.out).sayHello("application", "world");
	   }
	 
	}


