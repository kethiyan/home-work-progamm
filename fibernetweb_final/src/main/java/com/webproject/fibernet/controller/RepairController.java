package com.webproject.fibernet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/repair")
public class RepairController {

    private final List<Map<String, Object>> tickets = new ArrayList<>();

    @GetMapping
    public ResponseEntity<?> getAllTickets() {
        return ResponseEntity.ok(tickets);
    }

    @PostMapping
    public ResponseEntity<?> createTicket(@RequestBody Map<String, Object> ticket) {
        ticket.put("id", "TKT-" + (tickets.size() + 1001));
        ticket.put("status", "OPEN");
        ticket.put("createdAt", new Date().toString());
        tickets.add(ticket);
        return ResponseEntity.ok(Map.of("message", "Repair ticket created", "ticket", ticket));
    }

    @PutMapping("/{id}/close")
    public ResponseEntity<?> closeTicket(@PathVariable String id) {
        for (Map<String, Object> ticket : tickets) {
            if (id.equals(ticket.get("id"))) {
                ticket.put("status", "CLOSED");
                return ResponseEntity.ok(Map.of("message", "Ticket closed", "ticket", ticket));
            }
        }
        return ResponseEntity.notFound().build();
    }
}
