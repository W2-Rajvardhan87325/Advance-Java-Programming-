package com.rajvardhan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.printf("\t\tAnnotations Configuration using the Setters\n");
		Box b1 = (Box) anno.getBean("b1");
		System.out.println("Bean 1 Volume ::" + b1.calculateVolume());

		System.out.printf("\t\tAnnotations Configuration using Parameterized Constructor\n");
		Box b2 = (Box) anno.getBean("b2");
		System.out.println("Bean 1 Volume ::" + b2.calculateVolume());
		
		anno.close();
	}

}
