package HW12RestHibernate;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.identity.SybaseAnywhereIdentityColumnSupport;

public class TicketManager {
	 Configuration cfg;
	 {
		cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");// populates the data of the configuration file
		System.out.println("are we here?");									
	}
	
	
	 public static void main(String[] args){
		 TicketManager ticketManager=new TicketManager();
		 ticketManager.deleteTicket(840);
		// ticketManager.addTicket(new Ticket("najmeh", "tehran", "kerman", "3/5/643", 345, 0));
		 ticketManager.addTicket(new Ticket("mina", "tehran", "kish", "3/5/643", 345, 0));
		 
		 ticketManager.getTicketById(865);
		// ticketManager.deleteAll();
		 List<Ticket> temp=ticketManager.showAllTickets();
		/* System.out.println(temp);
		 System.out.println(temp.get(0));
		 System.out.println(temp.get(0).getcustomerName());
		 System.out.println(temp.get(1).getcustomerName());*/
	 }
	
	
	

	// delete a ticket by id
	public  boolean deleteTicket(int id) {
		SessionFactory factory = cfg.buildSessionFactory();

		// creating session object
		Session session = factory.openSession();

		// creating transaction object
		Transaction t = session.beginTransaction();
		Ticket ticket = new Ticket();
		ticket.setticketCode(id);
		try {
			if(isExist(id)){
				session.delete(ticket);
				t.commit();// transaction is commited
				
				System.out.println("successfully deleted");
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
			factory.close();
		}
	}
	
	//see if a ticket exist or not
	public boolean isExist(int id){
		SessionFactory factory = cfg.buildSessionFactory();

		// creating session object
		Session session = factory.openSession();

		// creating transaction object
		Transaction t = session.beginTransaction();
		Ticket ticket = new Ticket();
		
		ticket = session.get(Ticket.class, id);
		if(ticket==null){
			return false;
		}else{
			return true;
		}
		
	}
	
	// add a Ticket
	public boolean addTicket(Ticket ticket) {
		SessionFactory factory = cfg.buildSessionFactory();

		// creating session object
		Session session = factory.openSession();

		// creating transaction object
		Transaction t = session.beginTransaction();

		try {
			session.persist(ticket);// persisting the object
			t.commit();// transaction is commited
			System.out.println("successfully saved");
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			t.rollback();
			return false;
		} finally {
			session.close();
			factory.close();
		}

	}

	// update a student information
	public boolean updateTicket(Ticket ticket) {

		SessionFactory factory = cfg.buildSessionFactory();

		// creating session object
		Session session = factory.openSession();

		// creating transaction object
		Transaction t = session.beginTransaction();
		try {
			// update
			if(isExist(ticket.getTicketCode())){
				session.update(ticket);
				t.commit();
				System.out.println("updated sucessfully");
				return true;
			}else{
				System.out.println("worng ticket code");
				return false;
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return false;
		}finally{
			
			session.close();
			factory.close();
		
		}

	}

	// show a Ticket by id
	public Ticket getTicketById(int id) {
		SessionFactory factory = cfg.buildSessionFactory();

		// creating session object
		Session session = factory.openSession();

		// creating transaction object
		Transaction t = session.beginTransaction();
		Ticket ticket = new Ticket();
		try {
			ticket = session.get(Ticket.class, id);
			
		} catch (Exception e) {
			e.printStackTrace();

		}finally{
			session.close();
			factory.close();
		}
		return ticket;

	}
	
	
	//delete all the tickets
	
	public void deleteAll(){
		SessionFactory factory = cfg.buildSessionFactory();

		// creating session object
		Session session = factory.openSession();

		// creating transaction object
		Transaction t = session.beginTransaction();
		try{
			//HQL
		session.createSQLQuery("delete from ticket").executeUpdate();
		t.commit();
		System.out.println("are we?");
		}catch(Exception e){
			e.printStackTrace();
			t.rollback();
		}finally{
			session.close();
			factory.close();
		}
	}
	
	
	//show all the tickets
	public  List<Ticket> showAllTickets(){
		List<Ticket> tickets=new ArrayList<Ticket>();
		
		SessionFactory factory = cfg.buildSessionFactory();

		// creating session object
		Session session = factory.openSession();

		// creating transaction object
		Transaction t = session.beginTransaction();
		try{
			//HQL
		tickets=session.createSQLQuery("select * from ticket").list();
		t.commit();
		
		}catch(Exception e){
			e.printStackTrace();
			t.rollback();
		}finally{
			session.close();
			factory.close();
		}
		return tickets;
	}
	
	
}