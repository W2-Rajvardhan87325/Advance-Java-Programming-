/**
 * Course: Mobile Computing (DMC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Oct 27, 2024
 */

package com.sunbeam;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HibernateCrudDemo {
	/*
	public static void main(String[] args) {
		// get the session factory
		SessionFactory factory = HbUtil.getSessionFactory();
		// create a new session
		Session session = factory.openSession();
		// perform crud operations
		Product p = session.find(Product.class, 1);
		System.out.println("Found: " + p);
		// close the session
		session.close();
		// close the session factory
		factory.close();
	}
	*/
	
	/*
	public static void main(String[] args) {
		// get the session factory
		SessionFactory factory = HbUtil.getSessionFactory();
		// create a new session
		Session session = factory.openSession();
		// perform crud operations
		Transaction tx = session.beginTransaction();
		try {
			Product p = new Product(0, "Google Pixel", "Excellent Smartphone", 60000.0, 20);
			session.persist(p);
			tx.commit();
			System.out.println("Product Saved.");
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		// close the session
		session.close();
		// close the session factory
		factory.close();
	}
	*/
	
	/*
	public static void main(String[] args) {
		// get the session factory
		SessionFactory factory = HbUtil.getSessionFactory();
		// create a new session
		Session session = factory.openSession();
		// perform crud operations
		Transaction tx = session.beginTransaction();
		try {
			Product p = session.find(Product.class, 3);
			p.setName("Pixel");
			p.setDescription("Google Mobile");
			p.setPrice(50000.0);
			//session.update(p);
			tx.commit();
			System.out.println("Product Updated.");
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		// close the session
		session.close();
		// close the session factory
		factory.close();
	}
	*/
	
	/*
	public static void main(String[] args) {
		// get the session factory
		SessionFactory factory = HbUtil.getSessionFactory();
		// create a new session
		Session session = factory.openSession();
		// perform crud operations
		Transaction tx = session.beginTransaction();
		try {
			Product p = session.find(Product.class, 3);
			session.remove(p);
			tx.commit();
			System.out.println("Product Deleted.");
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		// close the session
		session.close();
		// close the session factory
		factory.close();
	}
	*/
	
	/*
	public static void main(String[] args) {
		// get the session factory
		SessionFactory factory = HbUtil.getSessionFactory();
		// create a new session
		Session session = factory.openSession();
		// perform crud operations
		String hql = "select p from Product p where p.price between :mn and :mx";
		Query<Product> q = session.createQuery(hql);
		q.setParameter("mn", 0.0);
		q.setParameter("mx", 500.0);
		List<Product> list = q.getResultList();
		for (Product p : list)
			System.out.println(p);
		// close the session
		session.close();
		// close the session factory
		factory.close();
	}
	*/
	
	public static void main(String[] args) {
		// get the session factory
		SessionFactory factory = HbUtil.getSessionFactory();
		// create a new session
		Session session = factory.openSession();
		// perform crud operations
		Query<Product> q = session.getNamedQuery("findAll");
		List<Product> list = q.getResultList(); // q.executeUpdate() for update queries
		for (Product p : list)
			System.out.println(p);
		// close the session
		session.close();
		// close the session factory
		factory.close();
	}	
}
