package kz.iitu.assignment7.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surname;

    private String name;

    @Enumerated(EnumType.STRING)
    private UserType userType;




    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="book_user",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    private List<Book> books;




    public void addBook(Book book){
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        setBooks(bookList);
    }




}
