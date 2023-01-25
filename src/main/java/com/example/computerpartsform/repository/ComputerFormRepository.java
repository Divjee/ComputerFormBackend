package com.example.computerpartsform.repository;

import com.example.computerpartsform.model.ComputerForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerFormRepository extends JpaRepository<ComputerForm,Long> {
}
