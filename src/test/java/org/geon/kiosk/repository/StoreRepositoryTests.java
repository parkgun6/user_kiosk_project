package org.geon.kiosk.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class StoreRepositoryTests {

    @Autowired
    StoreRepository storeRepository;

    @Test
    public void getStoreName(){
        Long sno = 1L;

        log.info(storeRepository.getStoreName(sno));
    }
}
