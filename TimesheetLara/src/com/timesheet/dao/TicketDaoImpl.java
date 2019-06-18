package com.timesheet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.timesheet.entity.Ticket;

@Repository
public class TicketDaoImpl implements TicketDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Ticket> getTickets() {
		
		Session currentSession= sessionFactory.getCurrentSession();
		
		//create a query sort by priority
		Query<Ticket>theQuery=currentSession.createQuery("from Ticket",
															Ticket.class);
		
		//execute query and get result list
				List<Ticket>tickets=theQuery.getResultList();
		
		//return the result
		return tickets;
	}

	@Override
	public void saveTicket(Ticket theTicket) {
		
		Session currentSession= sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theTicket);
		
	}

	@Override
	public Ticket getTicket(int theId) {
		
		Session currentSession= sessionFactory.getCurrentSession();
		
		//retrieve from database using the primary key
		Ticket theTicket= currentSession.get(Ticket.class, theId);
		
		return theTicket;
	}

	@Override
	public void deleteTicket(int theId) {
	
		Session currenSession= sessionFactory.getCurrentSession();
		
		Query theQuery= currenSession.createQuery("delete from Ticket where idTicket=:ticketId" );
		theQuery.setParameter("ticketId", theId);
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Ticket> searchTicket(String theSearchName) {
		
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for productionOrder or client ... case insensitive
            theQuery =currentSession.createQuery("from Tikcet where lower(productionOrder) like :theName or lower(client) like :theName", Ticket.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all tickets
            theQuery =currentSession.createQuery("from Ticket", Ticket.class);            
        }
        
        // execute query and get result list
        List<Ticket> tickets = theQuery.getResultList();
                
        // return the results        
        return tickets;
        
    }

}
