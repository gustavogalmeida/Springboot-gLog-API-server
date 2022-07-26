package com.gproject.glog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gproject.glog.domain.model.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>{

}
