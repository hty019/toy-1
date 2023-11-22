package com.yeon.base.domain;

import com.yeon.base.api.todo.TodoDTO;
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
@Entity(name = "todo")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Todo implements Serializable {

  @Serial private static final long serialVersionUID = 4483923328391037325L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String todo;
  private boolean status;

  public Todo change(final TodoDTO todoDTO) {
    this.todo = todoDTO.getTodo();
    this.status = todoDTO.isStatus();
    return this;
  }
}
