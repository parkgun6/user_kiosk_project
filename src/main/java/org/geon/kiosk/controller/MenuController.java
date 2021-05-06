package org.geon.kiosk.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.geon.kiosk.dto.PageRequestDTO;
import org.geon.kiosk.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

        return "/kiosk/order";
    }

    @GetMapping("/main")
    public void main(){

        log.info("main---------------------------------------");

    }

}
