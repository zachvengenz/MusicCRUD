package SWD4TN020.Music;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import SWD4TN020.Music.domain.Album;
import SWD4TN020.Music.domain.AlbumRepository;
import SWD4TN020.Music.domain.Artist;
import SWD4TN020.Music.domain.ArtistRepository;
import SWD4TN020.Music.domain.RecordLabelRepository;
import SWD4TN020.Music.domain.Track;
import SWD4TN020.Music.domain.TrackRepository;
import SWD4TN020.Music.web.AlbumController;
import SWD4TN020.Music.web.ArtistController;
import SWD4TN020.Music.web.RecordLabelController;
import SWD4TN020.Music.web.TrackController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MusicRepositoryTests {
	
	@Autowired
	private AlbumController acontroller;
	
	@Autowired
	private ArtistController artcontroller;
	
	@Autowired
	private TrackController tcontroller;
	
	@Autowired
	private RecordLabelController rcontroller;
	
	@Autowired
	private ArtistRepository artrepository;
	
	@Autowired
	private AlbumRepository arepository;
	
	@Autowired
	private TrackRepository trepository;
	
	@Autowired
	private RecordLabelRepository rrepository;
	
	@Test
	void contextLoadsAlbum() {
		assertThat(acontroller).isNotNull();
	}
	
	@Test
	void contextLoadsArtist() {
		assertThat(artcontroller).isNotNull();
	}
	
	@Test
	void contextLoadsTrack() {
		assertThat(tcontroller).isNotNull();
	}
	
	@Test
	void contextLoadsRecordLabel() {
		assertThat(rcontroller).isNotNull();
	}
	
	@Test
	public void findByNameShouldReturnCountry() throws Exception {
		List<Artist> art = artrepository.findByName("Slipknot");
		
		assertThat(art).hasSize(1);
		assertThat(art.get(0).getCountry()).isEqualTo("USA");
	}
	
	@Test
	public void findByTrackTitleShouldReturnArtistGenre() throws Exception {
		List<Track> t = trepository.findByTitle("Metabolic");
		
		assertThat(t).hasSize(1);
		assertThat(t.get(0).getAlbum().getArtist().getGenre()).isEqualTo("Alternative Metal");
	}
	
	@Test
	public void createNewArtist() throws Exception {
		Artist art = new Artist("Trivium", "Metal", "USA",
		1999);
		artrepository.save(art);
		assertThat(art.getArtistId()).isNotNull();
	}
	
	@Test
	public void createNewAlbum() throws Exception {
		Album a = new Album("All Hope Is Gone", artrepository.findByName("Slipknot").get(0), 2008, rrepository.findByName("Roadrunner Records").get(0));
		arepository.save(a);
		assertThat(a.getAlbumId()).isNotNull();
	}
	
	@Test
	public void deleteArtist() {
		artrepository.deleteById((long) 5);
		assertThat(artrepository.findById((long) 5)).isEmpty();
	}

}
