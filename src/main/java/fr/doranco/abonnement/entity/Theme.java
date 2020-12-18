package fr.doranco.abonnement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "theme", catalog = "abonnement")
@NamedQueries({
	@NamedQuery(name = "Theme:findByTitle", query = "from Theme th WHERE th.title =:title")
})
public class Theme implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4463689148870001855L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty
	@Size(min = 2, max = 45, message="La longueur du titre doit être comprise entre 2 et 45 caractères")
	@Column(name = "title", length = 45, nullable = false)
	private String title;
	@NotEmpty
	@Size(min = 2, max = 100, message="La longueur du lien du site doit être comprise entre 2 et 100 caractères")
	@Column(name = "lien_du_site", length = 100, nullable = false)
	private String lienDuSite;
	@NotEmpty
	@Size(min = 2, max = 100, message="La longueur du lien de résiliation doit être comprise entre 2 et 100 caractères")
	@Column(name = "lien_de_resiliation", length = 100, nullable = false)
	private String lienDeResiliation;
	@NotEmpty
	@Size(min = 2, max = 500, message="La longueur de la description doit être comprise entre 2 et 500 caractères")
	@Column(name = "description", length = 500, nullable = false)
	private String description;
	
	
	
	public Theme() {
		
	}

	public Theme(String title, String lienDuSite, String lienDeResiliation, String description) {
		super();
		this.title = title;
		this.lienDuSite = lienDuSite;
		this.lienDeResiliation = lienDeResiliation;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLienDuSite() {
		return lienDuSite;
	}

	public void setLienDuSite(String lienDuSite) {
		this.lienDuSite = lienDuSite;
	}

	public String getLienDeResiliation() {
		return lienDeResiliation;
	}

	public void setLienDeResiliation(String lienDeResiliation) {
		this.lienDeResiliation = lienDeResiliation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Theme [id=" + id + ", title=" + title + ", lienDuSite=" + lienDuSite + ", lienDeResiliation="
				+ lienDeResiliation + ", description=" + description + "]";
	}
	
	
	
	
}
