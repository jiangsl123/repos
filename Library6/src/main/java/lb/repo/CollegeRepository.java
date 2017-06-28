package lb.repo;

import org.springframework.data.repository.CrudRepository;

import lb.entity.College;

public interface CollegeRepository extends CrudRepository<College, Long> {

}
