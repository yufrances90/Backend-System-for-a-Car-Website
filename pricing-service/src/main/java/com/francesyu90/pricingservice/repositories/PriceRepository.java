package com.francesyu90.pricingservice.repositories;

import com.francesyu90.pricingservice.models.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PriceRepository extends CrudRepository<Price, Long> {

    List<Price> findByVehicleId(@Param("vehicleId") Long vehicleId);
}
