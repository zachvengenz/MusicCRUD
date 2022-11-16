package SWD4TN020.Music.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Album {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long albumId;
	@NotEmpty
	private String title;
	
	@ManyToOne // Album many - one Artist
	@JoinColumn(name="artistId")
	private Artist artist;
	@NotNull
	private int releaseYear;
	
	@ManyToOne // Album many - one RecordLabel
	@JoinColumn(name="recordLabelId")
	private RecordLabel recordLabel;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
	private List<Track> tracks;
	
	public Album() {
		super();
	}
	
	public Album(String title, Artist artist, int releaseYear, RecordLabel recordLabel) {
		super();
		this.title = title;
		this.artist = artist;
		this.releaseYear = releaseYear;
		this.recordLabel = recordLabel;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int year) {
		this.releaseYear = year;
	}

	public RecordLabel getRecordLabel() {
		return recordLabel;
	}

	public void setRecordLabel(RecordLabel recordLabel) {
		this.recordLabel = recordLabel;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "Album [id=" + albumId + ", title=" + title + ", artist=" + artist + ", releaseYear=" + releaseYear + ", recordLabel="
				+ recordLabel + "]";
	}
	
	
}
