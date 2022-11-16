package SWD4TN020.Music.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RecordLabel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long recordLabelId;
	@NotEmpty
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recordLabel")
	private List<Album> albums;
	
	public RecordLabel() {
		super();
	}
	
	public RecordLabel(String name) {
		super();
		this.name = name;
	}

	public Long getRecordLabelId() {
		return recordLabelId;
	}

	public void setRecordLabelId(Long recordLabelId) {
		this.recordLabelId = recordLabelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "RecordLabel [id=" + recordLabelId + ", name=" + name + "]";
	}
	
	
	
}
