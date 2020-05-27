import { Component, OnInit } from '@angular/core';
import { UserInfo } from '../model/user-info';
import { Animal } from '../model/animal';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Result } from '../model/result';

@Component({
  selector: 'app-propose-animal',
  templateUrl: './propose-animal.component.html',
  styleUrls: ['./propose-animal.component.css']
})
export class ProposeAnimalComponent implements OnInit {
  spaceValues: string[] = [];
  timeValues: string[] = [];
  noiseValues: string[] = [];
  moneyValues: string[] = [];
  absenceValues: string[] = [];

  chosenAnimal: Result;
  done: boolean;


  userInfoForm: FormGroup;

  constructor(private http: HttpClient, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.spaceValues.push('SMALL_APARTMENT');
    this.spaceValues.push('MEDIUM_APARTMENT');
    this.spaceValues.push('LARGE_APARTMENT');
    this.spaceValues.push('HOUSE');

    this.timeValues.push('HALF_HOUR');
    this.timeValues.push('ONE_HOUR');
    this.timeValues.push('TWO_HOURS');
    this.timeValues.push('THREE_HOURS');

    this.noiseValues.push('NO_NOISE');
    this.noiseValues.push('SOME_NOISE');
    this.noiseValues.push('A_LOT_OF_NOISE');

    this.moneyValues.push('NO_MONEY');
    this.moneyValues.push('A_LITTLE_BIT_OF_MONEY');
    this.moneyValues.push('A_BIT_MORE_MONEY');
    this.moneyValues.push('A_LOT_OF_MONEY');

    this.absenceValues.push('RARE');
    this.absenceValues.push('OCCASIONAL');
    this.absenceValues.push('FREQUENT');

    this.createUserInfoForm();
  }

  createUserInfoForm() {
    this.userInfoForm = this.formBuilder.group({
      userSpace: ['', [
        Validators.required
      ]],
      userTime: ['', [
        Validators.required
      ]],
      bearableNoise: ['', [
        Validators.required
      ]],
      alergicToHair: ['', [
        Validators.required
      ]],
      alergicToFeather: ['', [
        Validators.required
      ]],
      moneyForSpendingOnAnimal: ['', [
        Validators.required
      ]],
      animalThatLikesPetting: ['', [
        Validators.required
      ]],
      absentFromHome: ['', [
        Validators.required
      ]],
      outdoorActivities: ['', [
        Validators.required
      ]],
      teachingTricks: ['', [
        Validators.required
      ]],
    });
  }

  get userInfoData(): UserInfo {
    const userInfo = new UserInfo();
    userInfo.userSpace = this.userInfoForm.controls.userSpace.value;
    userInfo.userTime = this.userInfoForm.controls.userTime.value;
    userInfo.bearableNoise = this.userInfoForm.controls.bearableNoise.value;
    userInfo.alergicToHair = Boolean(this.userInfoForm.controls.alergicToHair.value);
    userInfo.alergicToFeather = Boolean(this.userInfoForm.controls.alergicToFeather.value);
    userInfo.moneyForSpendingOnAnimal = this.userInfoForm.controls.moneyForSpendingOnAnimal.value;
    userInfo.animalThatLikesPetting = Boolean(this.userInfoForm.controls.animalThatLikesPetting.value);
    userInfo.absentFromHome = this.userInfoForm.controls.absentFromHome.value;
    userInfo.outdoorActivities = Boolean(this.userInfoForm.controls.outdoorActivities.value);
    userInfo.teachingTricks = Boolean(this.userInfoForm.controls.teachingTricks.value);

    return userInfo;
  }

  onSendUserInfoSubmit() {
    const userInfo = this.userInfoData;
    this.chosenAnimal = new Result('none', 0);

    this.http.post<Result[]>('http://localhost:8080/api/animals/propose-animal', userInfo).subscribe(data => {
    console.log(data);

    data.forEach((d => {
      console.log(this.chosenAnimal);
      if (d.result > this.chosenAnimal.result) {
        this.chosenAnimal = d;
      }
    }));

    this.done = true;
    });
  }

}
