package org.geon.kiosk.service;

import lombok.extern.log4j.Log4j2;
import org.geon.kiosk.dto.MenuDTO;
import org.geon.kiosk.dto.PageRequestDTO;
import org.geon.kiosk.dto.PageResultDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
@Log4j2
public class MenuServiceTests {

    @Autowired
    MenuService menuService;

    @Test
    public void testGetListPage() {

        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        PageResultDTO<MenuDTO, Object[]> result = menuService.getListPage(1L,pageRequestDTO);

        result.getDtoList().forEach(menuDTO -> {
            log.info(menuDTO);
        });
    }

    @Test
    public void testGetMenu(){
        Long mno = 52L;
        log.info(menuService.getMenu(mno));

    }

    @Test
    public void getStoreName(){
        Long sno = 1L;
        log.info(menuService.getStoreName(sno));
    }

}
