package Testngpackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotationorderofexec {
    int order=0;
	@BeforeSuite
	public void beforsuite() {
		order++;
		System.out.println("Beforesuite"+order);
	}
/*	@BeforeClass
	public void Beforeclass() {
		order++;
		System.out.println("Beforeclass"+order);
	}
*/	
	@BeforeTest
	public void Beforetest() {
		order++;
		System.out.println("BeforeTest"+order);
	}
	@BeforeGroups
	public void Beforegroup() {
		order++;
		System.out.println("Beforegroups"+order);
	}
	@BeforeMethod
	public void beforemethod() {
		order++;
		System.out.println("beforemethod"+order);
	}
	@Test(groups="group12")
	public void testmethod() {
		System.out.println("TestMethod executed");
	}
	@Test(groups="group1")
	public void testmethod2() {
		System.out.println("Another method excuted");
	}
	@AfterMethod
	public void Aftermethod() {
		order++;
		System.out.println("Aftermethod"+order);
	}
	@AfterGroups
	public void Aftergroup() {
		order++;
		System.out.println("Aftergroups"+order);
	}
	@AfterTest
	public void Aftertest() {
		order++;
		System.out.println("AFtertest"+order);
	}
	
	/*@AfterClass
	public void Afterclass() {
		order++;
		System.out.println("Afterclass"+order);
	}*/
	@AfterSuite
	public void Aftersuite() {
		order++;
		System.out.println("Aftersuite"+order);
	}
	
}
