package com.intellier.setup;



import com.intellier.model.Book;
import com.intellier.model.Comment;
import com.intellier.model.Post;
import com.intellier.model.User;
import com.intellier.respository.BookRepository;
import com.intellier.respository.CommentRepository;
import com.intellier.respository.PostRepository;
import com.intellier.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppDefaultUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    public void createUser() {
        if (!userRepository.findById(1L).isPresent()) {
            // create user
            userRepository.save(new User(1L, "author", "author", "1234","ROLE_AUTHOR"));
        }
        if (!userRepository.findById(2L).isPresent()) {
            // create user
            userRepository.save(new User(2L, "user", "user", "1234","ROLE_USER"));
        }

    }

    public void createBook() {
        if (!bookRepository.findById(1L).isPresent()) {
            // create book
            User user = userRepository.findById(1L).get();
            bookRepository.save(new Book(1L, "Cracking the coding interview", "Cracking the coding interview",user,true));
        }
        if (!bookRepository.findById(2L).isPresent()) {
            // create book
            User user = userRepository.findById(2L).get();
            bookRepository.save(new Book(2L, "Man of Supreme", "Man of supreme",user,true));
        }

    }

    public void createPost() {
        //create post
        if(!postRepository.findById(1L).isPresent()){
            Book book = bookRepository.findById(1L).get();
            postRepository.save(new Post(1L, "Post of CCI BOOKS", "This Books is super", book));
        }
        if(!postRepository.findById(2L).isPresent()) {
            Book book = bookRepository.findById(2L).get();
            postRepository.save(new Post(2L, "Great Book", "if you read the book you can learn!!", book));
        }
    }

    public void createComment() {
        //create comment
        if(!commentRepository.findById(1L).isPresent()){
            Post post = postRepository.findById(1L).get();
            User user = userRepository.findById(2L).get();
            commentRepository.save(new Comment(1L, "Nice Book", user, post));
        }
        if(!commentRepository.findById(2L).isPresent()){
            Post post = postRepository.findById(2L).get();
            User user = userRepository.findById(1L).get();
            commentRepository.save(new Comment(2L, "Great Book", user, post));
        }

        if(!commentRepository.findById(3L).isPresent()){
            Post post = postRepository.findById(2L).get();
            User user = userRepository.findById(1L).get();
            commentRepository.save(new Comment(3L, "Great Book Again Same User", user, post));
        }
    }
}
