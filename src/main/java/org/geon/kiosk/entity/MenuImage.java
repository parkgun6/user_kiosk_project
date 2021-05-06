package org.geon.kiosk.entity;

import lombok.*;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "menu")
@Table(name = "tbl_menu_attach")
public class MenuImage {

    @Id
    private String uuid;

    @Column(name = "FILENAME")
    private String fileName;

    @Column(name = "UPLOADPATH")
    private String uploadPath;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MNO")
    private Menu menu;

}
