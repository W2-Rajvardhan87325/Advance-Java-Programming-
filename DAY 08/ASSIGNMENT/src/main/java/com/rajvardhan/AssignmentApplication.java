package com.rajvardhan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rajvardhan.contracts.Senderable;
import com.rajvardhan.entities.HttpSender;
import com.rajvardhan.entities.UdpSender;

@SpringBootApplication
public class AssignmentApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@Autowired
	private ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {

//===============Ambiguity=========================
		/*
		 * Senderable s1 = ctx.getBean(Senderable.class); s1.send(45);
		 */
//==============By name=============================
		Senderable s2 = (Senderable) ctx.getBean("tcpSender");
//		OR
//		Senderable s2 = (Senderable) ctx.getBean(TcpSender.class);
		s2.send(10);

		Senderable s3 = (Senderable) ctx.getBean(UdpSender.class);
		s3.send(20);

		Senderable s4 = (Senderable) ctx.getBean(HttpSender.class);
		s4.send(30);
//==============@Primary============================
		Senderable s1 = ctx.getBean(Senderable.class);
		s1.send(45);

	}

}
