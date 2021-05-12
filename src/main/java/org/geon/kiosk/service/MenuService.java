package org.geon.kiosk.service;

import org.geon.kiosk.dto.*;
import org.geon.kiosk.entity.Menu;
import org.geon.kiosk.entity.MenuImage;

import java.util.List;
import java.util.stream.Collectors;

public interface MenuService {

    PageResultDTO<MenuDTO,Object[]> getListPage(Long sno, PageRequestDTO pageRequestDTO);

    MenuDTO getMenu(Long mno);

    String getStoreName(Long sno);

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
