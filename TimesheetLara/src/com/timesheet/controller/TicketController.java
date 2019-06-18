package com.timesheet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.timesheet.entity.Ticket;
import com.timesheet.service.TicketService;

@Controller
@RequestMapping("/ticket")
public class TicketController {
	
	//need to inject the ticket service
	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/list")
	public String listTickets(Model theModel) {
		List<Ticket> tickets= ticketService.getTickets();
		
		//add the ticket to the model
		theModel.addAttribute("tickets",tickets);
		
		return "list-tickets";
	}

	
	@GetMapping("/showFormForAdd")
	public String showFormForAddTicket(Model theModel) {
		
		//create model attribute to bind form data
		Ticket theTicket= new Ticket();
		
		theModel.addAttribute("ticket", theTicket);
		return "ticket-form";
	}
	
	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("ticket")Ticket theTicket) {
		
		//save the ticket using the service
		ticketService.saveTicket(theTicket);
		
		return "redirect:/ticket";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("ticketId")int theId,
									Model theModel) {
		
		//get the ticket from service
		Ticket theTicket=ticketService.getTicket(theId);
		
		//set ticket as a model attribute to pre-polate the form
		theModel.addAttribute("ticket", theTicket);
		
		//send over to the form
		return "ticket-form";
	}
	
	@GetMapping("/delete")
	public String deleteTicket(@RequestParam("ticketId")int theId,
								 Model theModel) {
		
		//delete the ticket
		ticketService.deleteTicket(theId);
		
		return "redirect:/ticket/list";
	}

    @GetMapping("/search")
    public String searchTickets(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search ticket from the service
        List<Ticket> theTickets = ticketService.searchTickets(theSearchName);
                
        // add the ticket to the model
        theModel.addAttribute("tickets", theTickets);

        return "list-tickets";        
    }
}
