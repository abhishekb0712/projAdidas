package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pet {

	private String id;
	private Category category;
	private String name;
	private List<String> photoUrls = new ArrayList<String>();
	private List<Tag> tags = new ArrayList<Tag>();
	private Status status;

	public Pet(String id, Category category, String name, List<String> photoUrls, List<Tag> tags, Status status) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.photoUrls = photoUrls;
		this.tags = tags;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Pet pet = (Pet) o;
		return Objects.equals(this.id, pet.id) && Objects.equals(this.category, pet.category)
				&& Objects.equals(this.name, pet.name) && Objects.equals(this.photoUrls, pet.photoUrls)
				&& Objects.equals(this.tags, pet.tags) && Objects.equals(this.status, pet.status);
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", category=" + category + ", name=" + name + ", photoUrls=" + photoUrls + ", tags="
				+ tags + ", status=" + status + "]";
	}

}
