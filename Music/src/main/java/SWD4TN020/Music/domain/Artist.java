package SWD4TN020.Music.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Artist {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long artistId;
	@NotEmpty
	@Column(unique = true)
	private String name;
	@NotEmpty
	private String genre;
	@NotEmpty
	private String country;
	@NotNull
	private int yearFounded;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "artist")
	private List<Album> albums;
	
	public Artist() {
		super();
	}
	
	public Artist(String name, String genre, String country, int yearFounded) {
		super();
		this.name = name;
		this.genre = genre;
		this.country = country;
		this.yearFounded = yearFounded;
	}

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "Artist [id=" + artistId + ", name=" + name + ", genre=" + genre + ", country=" + country + ", yearFounded="
				+ yearFounded + "]";
	}
	
	
	
}
