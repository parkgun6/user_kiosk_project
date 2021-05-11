package org.geon.kiosk.dto;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class StoreDTO {

    private Long sno;

    private String userid;

    private String sname;

    private String info;

    private String guide;

    private String tel;

    private String address;

    private String businessHour;

    private String Holiday;

    private boolean enabled;

    private boolean fixcode;

    private Double lat;

    private Double lng;
}
