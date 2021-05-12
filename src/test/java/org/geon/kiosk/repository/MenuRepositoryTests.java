package org.geon.kiosk.repository;

import lombok.extern.log4j.Log4j2;
import org.geon.kiosk.entity.Menu;
import org.geon.kiosk.entity.MenuImage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@Log4j2
public class MenuRepositoryTests {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    MenuImageRepository menuImageRepository;

    @Transactional
    @Commit
    @Test
    public void insertAttach() {

        Menu menu = Menu.builder()
                .name("Menu...")
                .sno(1L)
                .explanation("Test.....")
                .price(13000)
                .build();

        log.info("--------------------------------------------");
        menuRepository.save(menu);

        log.info("----------------------" + menu.getMno());
        log.info(menu);
        MenuImage menuImage = MenuImage.builder()
                .uuid(UUID.randomUUID().toString())
                .menu(menu)
                .fileName("test.jpg")
                .uploadPath("2021\\05\\03")
                .build();

        log.warn(menuImageRepository.save(menuImage));
    }


    @Test
    public void testWithAll() {

        Long mno = 43L;

        List<Object[]> result = menuRepository.getMenuWithAll(mno);

        result.forEach(arr -> {
            log.info(Arrays.toString(arr));
        });
    }

    @Test
    public void testList1(){

        Pageable pageable = PageRequest.of(0,10, Sort.by("mno").ascending());

        Page<Object[]> result = menuRepository.getListPage(1L, pageable);

        result.getContent().forEach(arr -> {
            log.info(Arrays.toString(arr));
        });
    }

}
