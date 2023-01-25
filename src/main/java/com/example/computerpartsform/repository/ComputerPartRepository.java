package com.example.computerpartsform.repository;

import com.example.computerpartsform.model.ComputerPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerPartRepository extends JpaRepository<ComputerPart,Long> {
}
