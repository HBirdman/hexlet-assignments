package exercise.service;

import exercise.dto.*;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAll() {
        var books = bookRepository.findAll();
        var result = books.stream()
                .map(bookMapper::map)
                .toList();
        return result;
    }

    public BookDTO create(BookCreateDTO createDTO) {
        var book = bookMapper.map(createDTO);
        var author = authorRepository.findById(createDTO.getAuthorId())
                .orElseThrow(() -> new ConstraintViolationException("Author not Found", null));
        bookRepository.save(book);
        var dto = bookMapper.map(book);
        return dto;
    }

    public BookDTO show(Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        var dto = bookMapper.map(book);
        return dto;
    }

    public BookDTO update(BookUpdateDTO updateDTO, Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        bookMapper.update(updateDTO, book);
        bookRepository.save(book);
        var dto = bookMapper.map(book);
        return dto;
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    // END
}
