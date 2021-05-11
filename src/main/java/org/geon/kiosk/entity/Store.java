package org.geon.kiosk.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "tbl_store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Builder.Default
    private Long sno = null;

    @Column(name = "userid")
    private String userid;

    @Column(name = "sname")
    private String sname;

    @Column(name = "info")
    private String info;

    @Column(name = "guide")
    private String guide;

    @Column(name = "tel")
    private String tel;

    @Column(name = "address")
    private String address;

    @Column(name = "businessHour")
    private String businessHour;

    @Column(name = "Holiday")
    private String Holiday;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "fixcode")
    private boolean fixcode;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lng")
    private Double lng;
}
