package com.petproposal.petproposal.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.petproposal.petproposal.model.AbsenceFromHome;
import com.petproposal.petproposal.model.MoneyNeeded;
import com.petproposal.petproposal.model.PotentialNoise;
import com.petproposal.petproposal.model.SpaceNeeded;
import com.petproposal.petproposal.model.TimeNeeded;

public class AnimalDto implements AbstractDto {

	private Long id;

	@NotNull(message = "Animal name must not be null.")
	@NotBlank(message = "Animal name must not be blank.")
	private String name;

	@NotNull(message = "Animal space needed must not be null.")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private SpaceNeeded spaceNeeded;

	@NotNull(message = "Animal time needed must not be null.")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private TimeNeeded timeNeeded;

	@NotNull(message = "Animal potential noise must not be null.")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private PotentialNoise potentialNoise;

	private Boolean hairAlergy;

	private Boolean featherAlergy;

	@NotNull(message = "Animal money needed must not be null.")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private MoneyNeeded moneyNeeded;

	private Boolean pettable;

	@NotNull(message = "Animal absence from home must not be null.")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private AbsenceFromHome absenceFromHome;

	private Boolean activities;

	private Boolean learningTricks;

	public AnimalDto() {
	}

	public AnimalDto(AnimalDtoBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.spaceNeeded = builder.spaceNeeded;
		this.timeNeeded = builder.timeNeeded;
		this.potentialNoise = builder.potentialNoise;
		this.hairAlergy = builder.hairAlergy;
		this.featherAlergy = builder.featherAlergy;
		this.moneyNeeded = builder.moneyNeeded;
		this.pettable = builder.pettable;
		this.absenceFromHome = builder.absenceFromHome;
		this.activities = builder.activities;
		this.learningTricks = builder.learningTricks;
	}

	public static AnimalDtoBuilder builder() {
		return new AnimalDtoBuilder();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SpaceNeeded getSpaceNeeded() {
		return spaceNeeded;
	}

	public void setSpaceNeeded(SpaceNeeded spaceNeeded) {
		this.spaceNeeded = spaceNeeded;
	}

	public TimeNeeded getTimeNeeded() {
		return timeNeeded;
	}

	public void setTimeNeeded(TimeNeeded timeNeeded) {
		this.timeNeeded = timeNeeded;
	}

	public PotentialNoise getPotentialNoise() {
		return potentialNoise;
	}

	public void setPotentialNoise(PotentialNoise potentialNoise) {
		this.potentialNoise = potentialNoise;
	}

	public Boolean getHairAlergy() {
		return hairAlergy;
	}

	public void setHairAlergy(Boolean hairAlergy) {
		this.hairAlergy = hairAlergy;
	}

	public Boolean getFeatherAlergy() {
		return featherAlergy;
	}

	public void setFeatherAlergy(Boolean featherAlergy) {
		this.featherAlergy = featherAlergy;
	}

	public MoneyNeeded getMoneyNeeded() {
		return moneyNeeded;
	}

	public void setMoneyNeeded(MoneyNeeded moneyNeeded) {
		this.moneyNeeded = moneyNeeded;
	}

	public Boolean getPettable() {
		return pettable;
	}

	public void setPettable(Boolean pettable) {
		this.pettable = pettable;
	}

	public AbsenceFromHome getAbsenceFromHome() {
		return absenceFromHome;
	}

	public void setAbsenceFromHome(AbsenceFromHome absenceFromHome) {
		this.absenceFromHome = absenceFromHome;
	}

	public Boolean getActivities() {
		return activities;
	}

	public void setActivities(Boolean activities) {
		this.activities = activities;
	}

	public Boolean getLearningTricks() {
		return learningTricks;
	}

	public void setLearningTricks(Boolean learningTricks) {
		this.learningTricks = learningTricks;
	}

	public static class AnimalDtoBuilder {
		private Long id;
		private String name;
		private SpaceNeeded spaceNeeded;
		private TimeNeeded timeNeeded;
		private PotentialNoise potentialNoise;
		private Boolean hairAlergy;
		private Boolean featherAlergy;
		private MoneyNeeded moneyNeeded;
		private Boolean pettable;
		private AbsenceFromHome absenceFromHome;
		private Boolean activities;
		private Boolean learningTricks;

		public AnimalDtoBuilder() {
		}

		public AnimalDto build() {
			return new AnimalDto(this);
		}

		public AnimalDtoBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public AnimalDtoBuilder name(String name) {
			this.name = name;
			return this;
		}

		public AnimalDtoBuilder spaceNeeded(SpaceNeeded spaceNeeded) {
			this.spaceNeeded = spaceNeeded;
			return this;
		}

		public AnimalDtoBuilder timeNeeded(TimeNeeded timeNeeded) {
			this.timeNeeded = timeNeeded;
			return this;
		}

		public AnimalDtoBuilder potentialNoise(PotentialNoise potentialNoise) {
			this.potentialNoise = potentialNoise;
			return this;
		}

		public AnimalDtoBuilder hairAlergy(Boolean hairAlergy) {
			this.hairAlergy = hairAlergy;
			return this;
		}

		public AnimalDtoBuilder featherAlergy(Boolean featherAlergy) {
			this.featherAlergy = featherAlergy;
			return this;
		}

		public AnimalDtoBuilder moneyNeeded(MoneyNeeded moneyNeeded) {
			this.moneyNeeded = moneyNeeded;
			return this;
		}

		public AnimalDtoBuilder pettable(Boolean pettable) {
			this.pettable = pettable;
			return this;
		}

		public AnimalDtoBuilder absenceFromHome(AbsenceFromHome absenceFromHome) {
			this.absenceFromHome = absenceFromHome;
			return this;
		}

		public AnimalDtoBuilder activities(Boolean activities) {
			this.activities = activities;
			return this;
		}

		public AnimalDtoBuilder learningTricks(Boolean learningTricks) {
			this.learningTricks = learningTricks;
			return this;
		}
	}

}
