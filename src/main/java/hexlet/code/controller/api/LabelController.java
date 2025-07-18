package hexlet.code.controller.api;

import hexlet.code.dto.label.LabelCreateDTO;
import hexlet.code.dto.label.LabelShowDTO;
import hexlet.code.dto.label.LabelUpdateDTO;

import hexlet.code.service.LabelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/api/labels")
@AllArgsConstructor
public final class LabelController {
    private final LabelService labelService;

    @GetMapping
    public ResponseEntity<List<LabelShowDTO>> getAll() {
        List<LabelShowDTO> result = labelService.getAll();
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(result.size()))
                .body(result);
    }

    @GetMapping(path = "/{id}")
    public LabelShowDTO getById(@PathVariable long id) {
        return labelService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LabelShowDTO create(@Valid @RequestBody LabelCreateDTO data) {
        return labelService.create(data);
    }

    @PutMapping(path = "/{id}")
    public LabelShowDTO update(@Valid @RequestBody LabelUpdateDTO data,
                               @PathVariable long id) {
        return labelService.update(data, id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        labelService.deleteById(id);
    }
}
