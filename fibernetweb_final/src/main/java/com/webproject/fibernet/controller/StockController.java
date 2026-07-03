package com.webproject.fibernet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    // Sample stock items - replace with DB entity in production
    private final List<Map<String, Object>> stockItems = new ArrayList<>(List.of(
        Map.of("id", 1, "name", "Fiber Optic Cable (50m)", "quantity", 120, "unit", "rolls"),
        Map.of("id", 2, "name", "SC/APC Connector", "quantity", 340, "unit", "pcs"),
        Map.of("id", 3, "name", "Splitter 1x8", "quantity", 45, "unit", "pcs"),
        Map.of("id", 4, "name", "ONU Device", "quantity", 60, "unit", "units"),
        Map.of("id", 5, "name", "Patch Panel 24-Port", "quantity", 15, "unit", "units")
    ));

    @GetMapping
    public ResponseEntity<?> getAllStock() {
        return ResponseEntity.ok(stockItems);
    }

    @PostMapping
    public ResponseEntity<?> addStockItem(@RequestBody Map<String, Object> item) {
        item.put("id", stockItems.size() + 1);
        stockItems.add(item);
        return ResponseEntity.ok(Map.of("message", "Stock item added", "item", item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateQuantity(@PathVariable int id,
                                             @RequestBody Map<String, Object> body) {
        for (Map<String, Object> item : stockItems) {
            if (id == (int) item.get("id")) {
                item.put("quantity", body.get("quantity"));
                return ResponseEntity.ok(Map.of("message", "Stock updated", "item", item));
            }
        }
        return ResponseEntity.notFound().build();
    }
}
