package com.ptm.fullstackbackendPTM.repository;

import com.ptm.fullstackbackendPTM.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
