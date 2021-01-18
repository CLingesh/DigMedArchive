package com.p_015.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class ListOfAilments {

	@Id
	@GeneratedValue
	private int ailmentId;

	@Size(min = 10, max = 100)
	private String ailmentReason;

	@NotNull
	@Size(min = 10, max = 50)
	private String ailmentName;

	@Size(min = 10, max = 50)
	@NotNull
	private String ailmentDescription;

	public int getAilmentId() {
		return ailmentId;
	}

	public void setAilmentId(int ailmentId) {
		this.ailmentId = ailmentId;
	}

	public String getAilmentName() {
		return ailmentName;
	}

	public void setAilmentName(String ailmentName) {
		this.ailmentName = ailmentName;
	}

	public String getDescription() {
		return ailmentDescription;
	}

	public void setDescription(String description) {
		this.ailmentDescription = description;
	}

	public String getAilmentReason() {
		return ailmentReason;
	}

	public void setAilmentReason(String ailmentReason) {
		this.ailmentReason = ailmentReason;
	}

	public ListOfAilments(int ailmentId, String ailmentReason, String ailmentName, String ailmentDescription) {
		super();
		this.ailmentId = ailmentId;
		this.ailmentReason = ailmentReason;
		this.ailmentName = ailmentName;
		this.ailmentDescription = ailmentDescription;
	}

	public ListOfAilments(@Size(min = 10, max = 110) String ailmentReason,
			@NotNull @Size(min = 10, max = 50) String ailmentName,
			@Size(min = 10, max = 50) @NotNull String ailmentDescription) {
		super();
		this.ailmentReason = ailmentReason;
		this.ailmentName = ailmentName;
		this.ailmentDescription = ailmentDescription;
	}

	public ListOfAilments() {
		super();
		// TODO Auto-generated constructor stub
	}

}
