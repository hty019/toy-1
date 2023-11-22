package com.yeon.base.repository;

import com.yeon.base.domain.Temp;
import java.util.stream.Stream;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempRepository extends CrudRepository<Temp, Long> {
  Stream<Temp> findAllBy();
}
