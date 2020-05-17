package com.petproposal.petproposal.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Animal extends AbstractEntity {

    @NotNull(message = "Animal name must not be null.")
    @NotBlank(message = "Animal name must not be blank.")
    @Column(unique = true, nullable = false)
    private String name;

    @NotNull(message = "Animal space needed must not be null.")
    @Enumerated(EnumType.STRING)
    @Column(unique = false, nullable = false)
    private SpaceNeeded spaceNeeded;

    @NotNull(message = "Animal time needed must not be null.")
    @Enumerated(EnumType.STRING)
    @Column(unique = false, nullable = false)
    private TimeNeeded timeNeeded;

    @NotNull(message = "Animal potential noise must not be null.")
    @Enumerated(EnumType.STRING)
    @Column(unique = false, nullable = false)
    private PotentialNoise potentialNoise;

    @Column(unique = false, nullable = false)
    private Boolean hairAlergy;

    @Column(unique = false, nullable = false)
    private Boolean featherAlergy;

    @NotNull(message = "Animal money needed must not be null.")
    @Enumerated(EnumType.STRING)
    @Column(unique = false, nullable = false)
    private MoneyNeeded moneyNeeded;

    @Column(unique = false, nullable = false)
    private Boolean pettable;

    @NotNull(message = "Animal absence from home must not be null.")
    @Enumerated(EnumType.STRING)
    @Column(unique = false, nullable = false)
    private AbsenceFromHome absenceFromHome;

    @Column(unique = false, nullable = false)
    private Boolean activities;

    @Column(unique = false, nullable = false)
    private Boolean learningTricks;

    private Long result;

    public Animal() {
    }

    public Animal(AnimalBuilder builder) {
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

        this.result = 0L;
    }

    public static AnimalBuilder builder() {
        return new AnimalBuilder();
    }

    @Override
    public String toString() {
        return "Animal [name=" + name + ", spaceNeeded=" + spaceNeeded + ", timeNeeded=" + timeNeeded
                + ", potentialNoise=" + potentialNoise + ", hairAlergy=" + hairAlergy + ", featherAlergy="
                + featherAlergy + ", moneyNeeded=" + moneyNeeded + ", pettable=" + pettable + ", absenceFromHome="
                + absenceFromHome + ", activities=" + activities + ", learningTricks=" + learningTricks + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Animal otherAnimal = (Animal) obj;

        return this.name.equals(otherAnimal.getName());
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

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    public static class AnimalBuilder {
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

        public AnimalBuilder() {
        }

        public Animal build() {
            return new Animal(this);
        }

        public AnimalBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public AnimalBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AnimalBuilder spaceNeeded(SpaceNeeded spaceNeeded) {
            this.spaceNeeded = spaceNeeded;
            return this;
        }

        public AnimalBuilder timeNeeded(TimeNeeded timeNeeded) {
            this.timeNeeded = timeNeeded;
            return this;
        }

        public AnimalBuilder potentialNoise(PotentialNoise potentialNoise) {
            this.potentialNoise = potentialNoise;
            return this;
        }

        public AnimalBuilder hairAlergy(Boolean hairAlergy) {
            this.hairAlergy = hairAlergy;
            return this;
        }

        public AnimalBuilder featherAlergy(Boolean featherAlergy) {
            this.featherAlergy = featherAlergy;
            return this;
        }

        public AnimalBuilder moneyNeeded(MoneyNeeded moneyNeeded) {
            this.moneyNeeded = moneyNeeded;
            return this;
        }

        public AnimalBuilder pettable(Boolean pettable) {
            this.pettable = pettable;
            return this;
        }

        public AnimalBuilder absenceFromHome(AbsenceFromHome absenceFromHome) {
            this.absenceFromHome = absenceFromHome;
            return this;
        }

        public AnimalBuilder activities(Boolean activities) {
            this.activities = activities;
            return this;
        }

        public AnimalBuilder learningTricks(Boolean learningTricks) {
            this.learningTricks = learningTricks;
            return this;
        }

    }

}
