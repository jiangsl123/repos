package lb.repo;

import java.util.List;

import org.springframework.data.repository.Repository;

import lb.entity.Books;


public interface BooksRepository extends Repository<Books, Long> {
	List<Books> findAll();
	Books findOne(Long id);
	Books save(Books student);
	void delete(Long id);
	int count();

	List<Books> findByNumLike(String num);

	List<Books> findByBooknameLike(String name);
	
}
