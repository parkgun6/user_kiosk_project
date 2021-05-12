package org.geon.kiosk.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "store")
@Table(name = "tbl_menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Builder.Default
    private Long mno = null;

    @Column(name = "sno")
    private Long sno;

    @Column(name = "name")
    private String name;

    @Column(name = "explanation")
    private String explanation;

    @Column(name = "price")
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="SNO")
    private Store store;
}
