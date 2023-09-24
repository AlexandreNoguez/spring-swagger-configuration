package erpservice.alexandre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import erpservice.alexandre.entities.PurchaseEntity;

public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {
    
}