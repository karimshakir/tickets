package com.krew1.Tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class MainController {
    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewTicket(@RequestParam String event){
        Ticket t = new Ticket();
        t.setEvent(event);
        ticketRepository.save(t);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Ticket> getAllUsers(){
        return ticketRepository.findAll();
    }
}
