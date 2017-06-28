package lb.repo;

import java.util.List;

import org.springframework.data.repository.Repository;

import lb.entity.Books;
import lb.entity.brrow;


public interface BrrowRepository extends Repository<brrow, Long> {

	List<brrow> findAll();



	void save(brrow brrow);
}
