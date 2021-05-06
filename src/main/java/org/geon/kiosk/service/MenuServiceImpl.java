package org.geon.kiosk.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.geon.kiosk.dto.MenuDTO;
import org.geon.kiosk.dto.PageRequestDTO;
import org.geon.kiosk.dto.PageResultDTO;
import org.geon.kiosk.entity.Menu;
import org.geon.kiosk.entity.MenuImage;
import org.geon.kiosk.repository.MenuImageRepository;
import org.geon.kiosk.repository.MenuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    private final MenuImageRepository attachRepository;

    @Override
    public PageResultDTO<MenuDTO, Object[]> getListPage(Long sno, PageRequestDTO pageRequestDTO) {

        Pageable pageable = pageRequestDTO.getPageable(Sort.by("mno").ascending());

        Page<Object[]> result = menuRepository.getListPage(sno, pageable);

        log.info("---------------------------------------");

        result.getContent().forEach(arr -> {
            log.info(Arrays.toString(arr));
        });

        Function<Object[], MenuDTO> fn = (arr -> entitiesToDTO(
                (Menu)arr[0],
                (List<MenuImage>) (Arrays.asList((MenuImage)arr[1]))
        ));

        return new PageResultDTO<>(result, fn);
    }

    @Override
    public List<Object[]> getMenuWithAll(Long mno) {
        return null;
    }
}
