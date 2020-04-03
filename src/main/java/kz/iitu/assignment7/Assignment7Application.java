package kz.iitu.assignment7;
import kz.iitu.assignment7.model.*;
import kz.iitu.assignment7.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Assignment7Application {

	@Autowired
	private  UserRepository userRepository;

	@Autowired
	private  BookRepository bookRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private GenreRepository genreRepository;

	@Autowired
	private AuthorRepository authorRepository;


	private static final Logger log = LoggerFactory.getLogger(Assignment7Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Assignment7Application.class, args);
	}

	@Bean
 	CommandLineRunner runner() {
		return (args) -> {

			User user = new User();
			user.setName("Anna");
			user.setSurname("Anderson");
			user.setUserType(UserType.ADMIN);
			userRepository.save(user);



			Author author = new Author();
			author.setName("Stephen");
			author.setSurname("King");
			authorRepository.save(author);

			Category category = new Category();
			category.setName("Horror");
			categoryRepository.save(category);

			Category category1 = new Category();
			category1.setName("Biographies");
			categoryRepository.save(category1);

			Category category2 = new Category();
			category2.setName("Kids");
			categoryRepository.save(category2);

			Genre genre = new Genre();
			genre.setName("Fantasy");
			genreRepository.save(genre);

			Genre genre1 = new Genre();
			genre1.setName("Mystery");
			genreRepository.save(genre1);

			Book book = new Book();
			List<Author> authors = new ArrayList<>();
			authors.add(author);
			List<Genre> genres = new ArrayList<>();
			genres.add(genre1);
			genres.add(genre);
			book.setTitle("IT1");
			book.setCategory(category1);
			book.setDescription("Some description");
			book.setAuthors(authors);
			book.setGenres(genres);
			bookRepository.saveAndFlush(book);

			Book book2 = new Book();
			List<Author> authors2 = new ArrayList<>();
			authors2.add(author);
			List<Genre> genres2 = new ArrayList<>();
			genres2.add(genre);
			book2.setTitle("Second book");
			book2.setCategory(category2);
			book2.setDescription("Some description of second book");
			book2.setAuthors(authors2);
			book2.setGenres(genres2);
			bookRepository.saveAndFlush(book2);

			Book book3 = new Book();
			List<Author> authors3 = new ArrayList<>();
			authors2.add(author);
			List<Genre> genres3 = new ArrayList<>();
			genres2.add(genre);
			book3.setTitle("Third book");
			book3.setCategory(category2);
			book3.setDescription("Some description of third book");
			book3.setAuthors(authors2);
			book3.setGenres(genres2);
			bookRepository.saveAndFlush(book3);




			User user1 = new User();
			List<Book> bookList = new ArrayList<>();
			bookList.add(book2);
			user1.setName("Aru");
			user1.setSurname("Yelemes");
			user1.setUserType(UserType.LIBRARYUSER);
			user1.setBooks(bookList);
			userRepository.save(user1);

			User user2= new User();
			user2.addBook(bookRepository.findById(1L).orElse(null));
			user2.setName("Kate");
			user2.setSurname("Smith");
			user2.setUserType(UserType.LIBRARYUSER);
			userRepository.save(user2);






			log.info("Books");
			log.info("-------------------------------");
			for (Book books : bookRepository.findAll()) {

				log.info(books.toString());
			}
			log.info("");


		};
	}

}
