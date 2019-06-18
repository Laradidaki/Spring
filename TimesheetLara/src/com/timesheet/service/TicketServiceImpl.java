package com.timesheet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timesheet.dao.TicketDao;
import com.timesheet.entity.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDao ticketDao;
	
	@Override
	@Transactional
	public List<Ticket> getTickets() {
		return ticketDao.getTickets();
	}

	@Override
	@Transactional
	public void saveTicket(Ticket theTicket) {
		ticketDao.saveTicket(theTicket);
		
	}

	@Override
	@Transactional
	public Ticket getTicket(int theId) {
		return ticketDao.getTicket(theId);
	}

	@Override
	@Transactional
	public void deleteTicket(int theId) {
		ticketDao.deleteTicket(theId);
		
	}

	@Override
	@Transactional
	public List<Ticket> searchTickets(String theSearchName) {
		return ticketDao.searchTicket(theSearchName);
	}



}