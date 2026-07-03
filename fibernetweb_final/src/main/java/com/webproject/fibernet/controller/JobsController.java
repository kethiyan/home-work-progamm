package com.webproject.fibernet.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {

    private final List<Map<String, Object>> jobs = new ArrayList<>();

    @GetMapping
    public ResponseEntity<?> getAllJobs() {
        return ResponseEntity.ok(jobs);
    }

    @PostMapping
    public ResponseEntity<?> createJob(@RequestBody Map<String, Object> job) {
        job.put("id", UUID.randomUUID().toString());
        job.put("status", "PENDING");
        job.put("createdAt", new Date().toString());
        jobs.add(job);
        return ResponseEntity.ok(Map.of("message", "Job created successfully", "job", job));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateJobStatus(@PathVariable String id,
                                              @RequestBody Map<String, String> body) {
        for (Map<String, Object> job : jobs) {
            if (id.equals(job.get("id"))) {
                job.put("status", body.get("status"));
                return ResponseEntity.ok(Map.of("message", "Status updated", "job", job));
            }
        }
        return ResponseEntity.notFound().build();
    }
}
