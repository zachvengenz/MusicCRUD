package SWD4TN020.Music.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface AlbumRepository extends CrudRepository<Album, Long> {

	List<Album> findByTitle(String title);
	List<Album> findByAlbumId(Long albumId);
	List<Album> findByArtist(Artist artist);
	List<Album> findTopByOrderByAlbumIdDesc();
}
