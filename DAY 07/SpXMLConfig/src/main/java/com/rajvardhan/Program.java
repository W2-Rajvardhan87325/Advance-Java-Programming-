package com.rajvardhan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		System.out.printf("\t\tXML Configuration using the Setters\n");
		Box b1 = (Box) ctx.getBean("b1");
		System.out.println("Bean 1 Volume ::" + b1.calculateVolume());
		
		System.out.printf("\t\tXML Configuration using Parameterized Constructor\n");
		Box b2 = (Box) ctx.getBean("b2");
		System.out.println("Bean 1 Volume ::" + b2.calculateVolume());
		
		ctx.close();
	}
	
}
