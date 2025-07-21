package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private BookRepository bookRepository;

    public List<AuthorDTO> getAll() {
        var authors = authorRepository.findAll();
        var result = authors.stream()
                .map(authorMapper::map)
                .toList();
        return result;
    }

    public AuthorDTO create(AuthorCreateDTO createDTO) {
        var author = authorMapper.map(createDTO);
        authorRepository.save(author);
        var dto = authorMapper.map(author);
        return dto;
    }

    public AuthorDTO show(Long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        var dto = authorMapper.map(author);
        return dto;
    }

    public AuthorDTO update(AuthorUpdateDTO updateDTO, Long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        authorMapper.update(updateDTO, author);
        authorRepository.save(author);
        var dto = authorMapper.map(author);
        return dto;
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
    // END
}
