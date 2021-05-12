package org.geon.kiosk.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.geon.kiosk.dto.MenuDTO;
import org.geon.kiosk.dto.PageRequestDTO;
import org.geon.kiosk.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
@RequestMapping("/kiosk/")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService service;

    @GetMapping("/{sno}/order")
    public String list(@PathVariable Long sno, PageRequestDTO pageRequestDTO, Model model){

        log.info("list---------------------------------------");

        model.addAttribute("result", service.getListPage(sno, pageRequestDTO));
        model.addAttribute("store", service.getStoreName(sno));
        return "/kiosk/order";
    }

    @GetMapping("/payment")
    public void payment(){

        log.info("main---------------------------------------");

    }

    @GetMapping("/{mno}/menu")
    @ResponseBody
    public ResponseEntity<MenuDTO> getMenu(@PathVariable Long mno){

        log.info("list---------------------------------------");

        MenuDTO menuDTO =  service.getMenu(mno);

        return new ResponseEntity<>(menuDTO, HttpStatus.OK);
    }

    @GetMapping("/main")
    public void main(){

        log.info("main---------------------------------------");

    }

}
