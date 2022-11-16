package SWD4TN020.Music.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
	
	List<Artist> findByName(String name);
	List<Artist> findByArtistId(Long artistId);
}
