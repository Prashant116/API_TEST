package com.example.API_TEST.repository;

import com.example.API_TEST.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Integer> {
}
