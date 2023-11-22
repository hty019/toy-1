package com.yeon.base.repository;

import com.yeon.base.domain.Todo;
import java.util.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
  Stream<Todo> findAllBy();

  Stream<Todo> findByTodoContaining(String todo);
}
