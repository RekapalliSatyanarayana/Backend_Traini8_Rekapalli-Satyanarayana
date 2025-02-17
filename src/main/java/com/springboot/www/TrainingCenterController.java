package com.springboot.www;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/training-centers")
@Validated
public class TrainingCenterController {

    @Autowired
    private TrainingCenterRepository repository;

    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        trainingCenter.setCreatedOn(Instant.now().getEpochSecond());
        TrainingCenter savedCenter = repository.save(trainingCenter);
        return ResponseEntity.ok(savedCenter);
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state) {
        List<TrainingCenter> centers;
        if (city != null) {
            centers = repository.findByCity(city);
        } else if (state != null) {
            centers = repository.findByState(state);
        } else {
            centers = repository.findAll();
        }
        return ResponseEntity.ok(centers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainingCenter(@PathVariable Long id) {
        Optional<TrainingCenter> trainingCenter = repository.findById(id);
        if (trainingCenter.isPresent()) {
            repository.delete(trainingCenter.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
