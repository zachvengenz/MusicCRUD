package SWD4TN020.Music.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Track {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long trackId;
	@NotEmpty
	private String title;
	
	@ManyToOne
	@JoinColumn(name="albumId") // Track many - one Album
	private Album album;
	
	public Track() {
		super();
	}
	
	public Track(String title, Album album) {
		super();
		this.title = title;
		this.album = album;
	}

	public Long getTrackId() {
		return trackId;
	}

	public void setId(Long trackId) {
		this.trackId = trackId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Track [id=" + trackId + ", title=" + title + ", album=" + album + "]";
	}
	
	

}
