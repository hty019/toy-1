package com.yeon.base.api.temp;

import com.yeon.base.domain.Temp;
import javax.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TempDTO {

  private Long id;
  @NotEmpty private String name;

  public TempDTO(final Temp temp) {
    this.id = temp.getId();
    this.name = temp.getName();
  }

  public Temp toTemp() {
    return Temp.builder().id(this.id).name(this.name).build();
  }
}
