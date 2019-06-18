package com.timesheet.dao;

import java.util.List;
import com.timesheet.entity.Ticket;

public interface TicketDao {

	public List<Ticket> getTickets();

	public void saveTicket(Ticket theTicket);

	public Ticket getTicket(int theId);

	public void deleteTicket(int theId);

	public List<Ticket> searchTicket(String theSearchName);
}
