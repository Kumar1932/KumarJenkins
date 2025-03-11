package TestNG_Basics;

import org.testng.annotations.Test;

public class InvocationCount 
{
@Test(invocationCount=10)
public void print()
{
	System.out.println("Luffy");
}
}
