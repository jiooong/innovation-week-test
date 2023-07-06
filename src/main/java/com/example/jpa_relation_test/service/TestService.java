package com.example.jpa_relation_test.service;

import com.example.jpa_relation_test.entity.Book;
import com.example.jpa_relation_test.entity.BookStore;
import com.example.jpa_relation_test.entity.Member;
import com.example.jpa_relation_test.repository.BookRepository;
import com.example.jpa_relation_test.repository.BookStoreRepository;
import com.example.jpa_relation_test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final BookStoreRepository bookStoreRepository;

    @Transactional
    public void signup(Member member) {
        memberRepository.save(member);
    }

    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }

    @Transactional
    public void updateBook(Book book, Long bookStoreId, Long bookId) {
        List<Book> findBooks = findBook(bookStoreId);
        Book book1 = findBookOne(bookId);

        book1.setAuthor(book.getAuthor());
        book1.setTitle(book.getTitle());
        book1.setPrice(book.getPrice());
        book1.setStock(book.getStock());

        // entity 에 메서드를 만들어서 값을 수정해주는 것이 좋은지 이 방식이 좋은지 ! 그리고 entity에 메서드를 만들어서
        //하는 방식도 생각해보기
    }
    public Book findBookOne(Long bookId) {
        //왜 orElseThrow 해주지 않으면 빨간줄인가 ?!?!?orElseThrow를 통해 Optinal에서 원하는 객체를 바로 얻거나 예외를 던질 수 있다.
        return bookRepository.findById(bookId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "게시글이 존재하지 않습니다.")
        );
    }
    @Transactional
    public List<Book> findBook(Long bookStoreId) {
        return bookRepository.findByBookStoreId(bookStoreId);
    }


    public void transferBook(Long bookId, Long bookStoreId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow();
        // orElseThrow를 통해 Optinal에서 원하는 객체를 바로 얻거나 예외를 던질 수 있다.
        BookStore bookStore = bookStoreRepository.findById(bookStoreId)
                .orElseThrow();
        bookStore.addBook(book);
        bookRepository.save(book);
    }
}
