package org.geon.kiosk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuImageDTO {

    private String uuid;

    private String fileName;

    private String uploadPath;


    public String getLink() {

        String fileLinkName = fileName.replace(".", "#");

        String str = uploadPath+"/s_"+uuid+"_"+fileLinkName;

        String enStr = "";

        try {

            //URL에 맞는 형식으로 인코딩하는코드
            enStr = URLEncoder.encode(str,"UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        return enStr;
    }

}
