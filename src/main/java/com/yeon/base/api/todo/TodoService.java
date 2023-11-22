package com.yeon.base.api.todo;

import com.yeon.base.domain.Todo;
import com.yeon.base.repository.TodoRepository;
import com.yeon.standard.common.exception.BusinessException;
import com.yeon.standard.common.exception.ExceptionCode;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TodoService {

  private final TodoRepository todoRepository;
  @PersistenceContext private final EntityManager entityManager;

  private Todo persist(final Todo todo) {
    this.entityManager.persist(todo);
    return todo;
  }

  @Transactional(readOnly = true)
  public List<TodoDTO> findAllBy() {
    return this.todoRepository.findAllBy().map(TodoDTO::new).toList();
  }

  @Transactional(readOnly = true)
  public TodoDTO findById(final Long id) {
    return this.todoRepository
        .findById(id)
        .map(TodoDTO::new)
        .orElseThrow(() -> new BusinessException(ExceptionCode.FAIL_NO_DATA_SUCCESS));
  }

  @Transactional(readOnly = true)
  public List<TodoDTO> search(final String keyword) {
    return this.todoRepository
        .findByTodoContaining(keyword)
        .map(TodoDTO::new)
        .toList();
  }

  @Transactional
  public TodoDTO post(final TodoDTO todoDTO) {
    return new TodoDTO(persist(todoDTO.toTodo()));
  }

  @Transactional
  public void delete(final Long id) {
    todoRepository.deleteById(id);
  }

  @Transactional
  public void patch(Long id, final TodoDTO todoDTO) {
    todoRepository
        .findById(id)
        .map(todo -> todo.change(todoDTO))
        .orElseThrow(() -> new BusinessException(ExceptionCode.FAIL_NO_DATA_SUCCESS));
  }
}
