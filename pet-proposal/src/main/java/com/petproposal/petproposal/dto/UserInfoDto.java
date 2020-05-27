package com.petproposal.petproposal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.petproposal.petproposal.model.*;

import javax.validation.constraints.NotNull;

public class UserInfoDto implements AbstractDto{

    @NotNull(message = "Animal space needed must not be null.")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private SpaceNeeded userSpace;

    @NotNull(message = "Animal time needed must not be null.")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private TimeNeeded userTime;

    @NotNull(message = "Animal potential noise must not be null.")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private PotentialNoise bearableNoise;

    private Boolean alergicToHair;

    private Boolean alergicToFeather;

    @NotNull(message = "Animal money needed must not be null.")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private MoneyNeeded moneyForSpendingOnAnimal;

    private Boolean animalThatLikesPetting;

    @NotNull(message = "Animal absence from home must not be null.")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private AbsenceFromHome absentFromHome;

    private Boolean outdoorActivities;

    private Boolean teachingTricks;

    public UserInfoDto() {
    }

    public UserInfoDto(UserInfoDtoBuilder builder) {
        this.userSpace = builder.userSpace;
        this.userTime = builder.userTime;
        this.bearableNoise = builder.bearableNoise;
        this.alergicToHair = builder.alergicToHair;
        this.alergicToFeather = builder.alergicToFeather;
        this.moneyForSpendingOnAnimal = builder.moneyForSpendingOnAnimal;
        this.animalThatLikesPetting = builder.animalThatLikesPetting;
        this.absentFromHome = builder.absentFromHome;
        this.outdoorActivities = builder.outdoorActivities;
        this.teachingTricks = builder.teachingTricks;
    }

    public static UserInfoDtoBuilder builder() {
        return new UserInfoDtoBuilder();
    }

    public SpaceNeeded getUserSpace() {
        return userSpace;
    }

    public void setUserSpace(SpaceNeeded userSpace) {
        this.userSpace = userSpace;
    }

    public TimeNeeded getUserTime() {
        return userTime;
    }

    public void setUserTime(TimeNeeded userTime) {
        this.userTime = userTime;
    }

    public PotentialNoise getBearableNoise() {
        return bearableNoise;
    }

    public void setBearableNoise(PotentialNoise bearableNoise) {
        this.bearableNoise = bearableNoise;
    }

    public Boolean getAlergicToHair() {
        return alergicToHair;
    }

    public void setAlergicToHair(Boolean alergicToHair) {
        this.alergicToHair = alergicToHair;
    }

    public Boolean getAlergicToFeather() {
        return alergicToFeather;
    }

    public void setAlergicToFeather(Boolean alergicToFeather) {
        this.alergicToFeather = alergicToFeather;
    }

    public MoneyNeeded getMoneyForSpendingOnAnimal() {
        return moneyForSpendingOnAnimal;
    }

    public void setMoneyForSpendingOnAnimal(MoneyNeeded moneyForSpendingOnAnimal) {
        this.moneyForSpendingOnAnimal = moneyForSpendingOnAnimal;
    }

    public Boolean getAnimalThatLikesPetting() {
        return animalThatLikesPetting;
    }

    public void setAnimalThatLikesPetting(Boolean animalThatLikesPetting) {
        this.animalThatLikesPetting = animalThatLikesPetting;
    }

    public AbsenceFromHome getAbsentFromHome() {
        return absentFromHome;
    }

    public void setAbsentFromHome(AbsenceFromHome absentFromHome) {
        this.absentFromHome = absentFromHome;
    }

    public Boolean getOutdoorActivities() {
        return outdoorActivities;
    }

    public void setOutdoorActivities(Boolean outdoorActivities) {
        this.outdoorActivities = outdoorActivities;
    }

    public Boolean getTeachingTricks() {
        return teachingTricks;
    }

    public void setTeachingTricks(Boolean teachingTricks) {
        this.teachingTricks = teachingTricks;
    }

    public static class UserInfoDtoBuilder {
        private SpaceNeeded userSpace;
        private TimeNeeded userTime;
        private PotentialNoise bearableNoise;
        private Boolean alergicToHair;
        private Boolean alergicToFeather;
        private MoneyNeeded moneyForSpendingOnAnimal;
        private Boolean animalThatLikesPetting;
        private AbsenceFromHome absentFromHome;
        private Boolean outdoorActivities;
        private Boolean teachingTricks;

        public UserInfoDtoBuilder() {
        }

        public UserInfoDto build() {
            return new UserInfoDto(this);
        }

        public UserInfoDtoBuilder userSpace(SpaceNeeded userSpace) {
            this.userSpace = userSpace;
            return this;
        }

        public UserInfoDtoBuilder userTime(TimeNeeded userTime) {
            this.userTime = userTime;
            return this;
        }

        public UserInfoDtoBuilder bearableNoise(PotentialNoise bearableNoise) {
            this.bearableNoise = bearableNoise;
            return this;
        }

        public UserInfoDtoBuilder alergicToHair(Boolean alergicToHair) {
            this.alergicToHair = alergicToHair;
            return this;
        }

        public UserInfoDtoBuilder alergicToFeather(Boolean alergicToFeather) {
            this.alergicToFeather = alergicToFeather;
            return this;
        }

        public UserInfoDtoBuilder moneyForSpendingOnAnimal(MoneyNeeded moneyForSpendingOnAnimal) {
            this.moneyForSpendingOnAnimal = moneyForSpendingOnAnimal;
            return this;
        }

        public UserInfoDtoBuilder animalThatLikesPetting(Boolean animalThatLikesPetting) {
            this.animalThatLikesPetting = animalThatLikesPetting;
            return this;
        }

        public UserInfoDtoBuilder absentFromHome(AbsenceFromHome absentFromHome) {
            this.absentFromHome = absentFromHome;
            return this;
        }

        public UserInfoDtoBuilder outdoorActivities(Boolean outdoorActivities) {
            this.outdoorActivities = outdoorActivities;
            return this;
        }

        public UserInfoDtoBuilder teachingTricks(Boolean teachingTricks) {
            this.teachingTricks = teachingTricks;
            return this;
        }
    }
}
