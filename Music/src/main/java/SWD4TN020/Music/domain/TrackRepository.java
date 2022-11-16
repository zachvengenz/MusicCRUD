package SWD4TN020.Music.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TrackRepository extends CrudRepository<Track, Long> {
	
	List<Track> findByTitle(String title);
	List<Track> findByAlbum(Album album);
}
