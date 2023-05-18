package com.dominika.msjuiceservice.repositories;

import java.util.UUID;

import com.dominika.msjuiceservice.domain.Juice;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JuiceRepository extends PagingAndSortingRepository<Juice, UUID> {


}
