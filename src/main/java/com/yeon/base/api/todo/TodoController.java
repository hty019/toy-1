package com.yeon.base.api.todo;

import com.yeon.standard.common.response.ApiResult;
import com.yeon.standard.common.response.Result;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/todos/")
public class TodoController {

  private final TodoService todoService;

  @GetMapping
  ResponseEntity<ApiResult<List<TodoDTO>>> findAllBy(final String keyword) {
    return StringUtils.hasText(keyword)
        ? Result.ok(this.todoService.search(keyword))
        : Result.ok(this.todoService.findAllBy());
  }

  @GetMapping(value = "{id}")
  ResponseEntity<ApiResult<TodoDTO>> findById(@PathVariable(value = "id") final Long id) {
    return Result.ok(this.todoService.findById(id));
  }

  @PostMapping
  ResponseEntity<ApiResult<TodoDTO>> post(@RequestBody @Valid final TodoDTO todoDTO) {
    return Result.created(this.todoService.post(todoDTO));
  }

  @DeleteMapping(value = "{id}")
  ResponseEntity<ApiResult<?>> delete(@PathVariable(value = "id") final Long id) {
    this.todoService.delete(id);
    return Result.ok();
  }

  @PatchMapping("{id}")
  ResponseEntity<ApiResult<?>> patch(
      @PathVariable(value = "id") final Long id, @RequestBody @Valid final TodoDTO todoDTO) {
    this.todoService.patch(id, todoDTO);
    return Result.ok();
  }
}
