package com.yeon.base.domain;

import com.yeon.base.api.temp.TempDTO;
import java.io.Serial;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity(name = "temp") // jpa에서 관리하는 엔티티가 된다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Temp implements Serializable {

  @Serial private static final long serialVersionUID = 4483923328391037325L;

  @Id // pk
  @GeneratedValue(strategy = GenerationType.IDENTITY) // DB전영에서 시퀀스 값 자동 생성
  private Long id;

  private String name;

  public Temp change(final TempDTO tempDTO) {
    this.name = tempDTO.getName();
    return this;
  }
}
