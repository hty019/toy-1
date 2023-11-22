package com.yeon.base.api.temp;

import com.yeon.standard.common.response.ApiResult;
import com.yeon.standard.common.response.Result;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/temps/")
public class TempController {

  private final TempService tempService;

  @PostMapping
  ResponseEntity<ApiResult<TempDTO>> post(@RequestBody @Valid final TempDTO payload) {
    return Result.created(this.tempService.post(payload));
  }

  @GetMapping(value = "{id}")
  ResponseEntity<ApiResult<TempDTO>> findById(@PathVariable(value = "id") final Long id) {
    return Result.ok(this.tempService.findById(id));
  }

  @GetMapping
  ResponseEntity<ApiResult<List<TempDTO>>> findAllBy() {
    return Result.ok(this.tempService.findAllBy());
  }

  @PutMapping(value = "{id}")
  ResponseEntity<ApiResult<TempDTO>> put(
      @PathVariable("id") final Long id, @RequestBody @Valid final TempDTO payload) {
    return Result.ok(this.tempService.change(id, payload));
  }

  @DeleteMapping(value = "{id}")
  ResponseEntity<ApiResult<?>> delete(@PathVariable final Long id) {
    this.tempService.deleteById(id);
    return Result.ok();
  }
}
