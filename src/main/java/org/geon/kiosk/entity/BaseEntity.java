package org.geon.kiosk.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value= {AuditingEntityListener.class})
@Getter
abstract  class BaseEntity {

    @CreatedDate
    //updateable = false로 regDate는 최초생성 이외에 불변이다.
    @Column(name="regdate" , updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name="moddate")
    public LocalDateTime modDate;
}
