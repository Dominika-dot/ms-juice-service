package com.dominika.msjuiceservice.repositories;

import java.util.UUID;

import com.dominika.msjuiceservice.domain.Juice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuiceRepository extends JpaRepository<Juice, UUID> {


}
