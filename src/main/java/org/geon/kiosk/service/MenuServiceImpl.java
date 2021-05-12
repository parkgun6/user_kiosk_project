package org.geon.kiosk.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.geon.kiosk.dto.MenuDTO;
import org.geon.kiosk.dto.PageRequestDTO;
import org.geon.kiosk.dto.PageResultDTO;
import org.geon.kiosk.dto.StoreDTO;
import org.geon.kiosk.entity.Menu;
import org.geon.kiosk.entity.MenuImage;
import org.geon.kiosk.repository.MenuImageRepository;
import org.geon.kiosk.repository.MenuRepository;
import org.geon.kiosk.repository.StoreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    private final MenuImageRepository attachRepository;

    private final StoreRepository storeRepository;

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
    public MenuDTO getMenu(Long mno) {

        List<Object[]> result = menuRepository.getMenuWithAll(mno);

        Menu menu = (Menu) result.get(0)[0];

        List<MenuImage> menuImageList = new ArrayList<>();

        result.forEach(arr -> {
            MenuImage menuImage = (MenuImage) result.get(0)[1];
            menuImageList.add(menuImage);
        });

        return entitiesToDTO(menu, menuImageList);
    }

    @Override
    public String getStoreName(Long sno) {
        String sname = storeRepository.getStoreName(sno);
        return sname;
    }
}
