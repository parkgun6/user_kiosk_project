package org.geon.kiosk.dto;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@Data
public class PageRequestDTO {


    private Integer page = 1;
    private Integer size = 12;

    private String type;
    private String keyword;

    public void PageRequestDTO(){
        this.page = 1;
        this.size = 12;
    }

    public Pageable getPageable(Sort sort){

        return PageRequest.of(page -1,size, sort);
    }
}
