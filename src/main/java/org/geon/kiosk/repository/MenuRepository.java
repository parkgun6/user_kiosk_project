package org.geon.kiosk.repository;

import org.geon.kiosk.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("select m, mi " +
            "from Menu m " +
            "left join MenuImage mi on mi.menu = m " +
            "where m.mno = :mno ")
    List<Object[]> getMenuWithAll(@Param("mno")Long mno);

    @Query("select m, mi " +
            "from Menu m " +
            "left join MenuImage mi on mi.menu = m " +
            "where m.sno = :sno" )
    Page<Object[]> getListPage(Long sno, Pageable pageable);

}
