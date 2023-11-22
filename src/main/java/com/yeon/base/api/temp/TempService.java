package com.yeon.base.api.temp;

import com.yeon.base.domain.Temp;
import com.yeon.base.repository.TempRepository;
import com.yeon.standard.common.exception.BusinessException;
import com.yeon.standard.common.exception.ExceptionCode;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class TempService {
  private final TempRepository tempRepository;
  private final EntityManager entityManager;

  private Temp persist(final Temp temp) {
    // 인터페이스에 ..... 값을 집어넣는다........ ? 그럼 머가 돌아가는지 ..? JPA는 emtitymanager 라는 것 위에서 동작한다.
    // datasource 나 db 통신하는 것을 이것이 처리한다.
    // 결론은 jpa를 사용하려면 엔티티메니저를 주입받아야한다.
    this.entityManager.persist(temp);
    return temp;
  }

  public TempDTO post(final TempDTO payload) {
    return new TempDTO(this.persist(payload.toTemp()));
  }

  @Transactional(readOnly = true)
  public TempDTO findById(final Long id) {
    return this.tempRepository
        .findById(id)
        .map(TempDTO::new)
        .orElseThrow(() -> new BusinessException(ExceptionCode.FAIL_NO_DATA_SUCCESS));
  }

  @Transactional(readOnly = true)
  public List<TempDTO> findAllBy() {
    return this.tempRepository.findAllBy().map(TempDTO::new).toList();
  }

  public TempDTO change(final Long id, final TempDTO payload) {
    return this.tempRepository
        .findById(id)
        .map(temp -> new TempDTO(temp.change(payload)))
        .orElseThrow(() -> new BusinessException(ExceptionCode.FAIL_NO_DATA_SUCCESS));
  }

  public void deleteById(final Long id) {
    this.tempRepository.deleteById(id);
  }
}
