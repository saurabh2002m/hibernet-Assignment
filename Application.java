package com.manish;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class Application
{
	public static SessionFactory createConfiguration() 
	{
		Configuration conf = new Configuration().configure().addAnnotatedClass(Book.class);
		SessionFactory ss = conf.buildSessionFactory();
		return ss;
	}
	public static void createBook(Session ss, Transaction t) 
	{

		Book b1 = new Book(106, "LIFE LESSON",1200,"Shin-Harii","West-Library");
		Book b2 = new Book(107, "TRUE BEAUTY", 5310, "Lee-Jin-Suu","East-Library");
		Book b3 = new Book(108, "START-UP", 800, "Jin-Sooo","South-Library");
		Book b4 = new Book(109, "CRAZY LOVE", 862, "NOH GOJIN","North-Library");
		Book b5 = new Book(110, "Business Proposal", 910, "Kang Tae Moo","City-Hall Library");
		ss.save(b1);
		ss.save(b2);
		ss.save(b3);
		ss.save(b4);
		ss.save(b5);
		t.commit();
	}
	
	public static void getAllBook(Session ss, Transaction t) 
	{
		Query query = ss.createQuery("from Book");

		List<Book> books = query.list();
		for (Book book : books) {
			System.out.println(book.getBookId()+book.getBookName()+book.getBookPrice()+book.getAuthorName()+book.getLibraryName());
		}
	}
	
	public static void updateBook(Session ss, Transaction t) 
	{
		t.begin();
		Book b = ss.find(Book.class, 2);
		b.setBookName("RICH DAD POOR DAD");
		ss.save(b);
		t.commit();

	}
	
	public static void deleteBook(Session ss, Transaction t) 
	{
		t.begin();
		Book b = ss.find(Book.class, 2);

		ss.delete(b);
		t.commit();

	}
	
		public static void main(String[] args)

		{
			SessionFactory sessionfactory = createConfiguration();
			Session session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();
			createBook(session, t);
			updateBook(session,t);
			deleteBook(session,t);
			getAllBook(session, t);
			System.out.println("____________<DONE>___________");
		}
	}
