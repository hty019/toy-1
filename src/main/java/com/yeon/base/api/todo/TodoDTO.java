package com.yeon.base.api.todo;

import com.yeon.base.domain.Todo;
import javax.validation.constraints.NotEmpty;
import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TodoDTO {
  private Long id;
  @NotEmpty private String todo;
  private boolean status; // boolean 은 초기값이 false 라 @NotEmpty  적지 않아도 된다.

  public TodoDTO(final Todo todo) {
    this.id = todo.getId();
    this.todo = todo.getTodo();
    this.status = todo.isStatus();
  }

  public Todo toTodo() {
    return Todo.builder().id(this.id).todo(this.todo).status(this.status).build();
  }
}
