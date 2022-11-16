package SWD4TN020.Music.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RecordLabelRepository extends CrudRepository<RecordLabel, Long> {
	
	List<RecordLabel> findByName(String name);

}
