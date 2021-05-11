package org.geon.kiosk.repository;

import org.geon.kiosk.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query("select s.sname " +
            "from Store s " +
            "where s.sno = :sno")
    String getStoreName(Long sno);
}
