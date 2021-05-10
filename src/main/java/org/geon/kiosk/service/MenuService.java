package org.geon.kiosk.service;

import org.geon.kiosk.dto.MenuDTO;
import org.geon.kiosk.dto.MenuImageDTO;
import org.geon.kiosk.dto.PageRequestDTO;
import org.geon.kiosk.dto.PageResultDTO;
import org.geon.kiosk.entity.Menu;
import org.geon.kiosk.entity.MenuImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Collectors;

public interface MenuService {

    PageResultDTO<MenuDTO,Object[]> getListPage(Long sno, PageRequestDTO pageRequestDTO);

    MenuDTO getMenu(Long mno);

    default MenuDTO entitiesToDTO(Menu menu, List<MenuImage> menuImages){
        MenuDTO menuDTO = MenuDTO.builder()
                .mno(menu.getMno())
                .sno(menu.getSno())
                .name(menu.getName())
                .explanation(menu.getExplanation())
                .price(menu.getPrice())
                .build();

        List<MenuImageDTO> menuImageList = menuImages.stream().map(menuImage -> {
            return MenuImageDTO.builder()
                    .uuid(menuImage.getUuid())
                    .fileName(menuImage.getFileName())
                    .uploadPath(menuImage.getUploadPath())
                    .build();
        }).collect(Collectors.toList());

        menuDTO.setImageDTOList(menuImageList);

        return menuDTO;
    }
}
