package com.example.user.model;

import lombok.*;
import org.jfairy.producer.person.Address;
import org.jfairy.producer.person.Person;
import org.joda.time.DateTime;

/**
 * Created * Pandhuta Bangkit S 09/04/2020
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer studentId;
    private Address address;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Person.Sex sex;
    private String telephoneNumber;
    private DateTime dateOfBirth;
    private Integer age;
    private String companyEmail;
    private String nationalIdentityCardNumber;
    private String nationalIdentificationNumber;


    public Integer getStudentId() {
        return studentId;
    }


    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }


    public Address getAddress() {
        return address;
    }


    public void setAddress(Address address) {
        this.address = address;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getMiddleName() {
        return middleName;
    }


    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Person.Sex getSex() {
        return sex;
    }


    public void setSex(Person.Sex sex) {
        this.sex = sex;
    }


    public String getTelephoneNumber() {
        return telephoneNumber;
    }


    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }


    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }


    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public Integer getAge() {
        return age;
    }


    public void setAge(Integer age) {
        this.age = age;
    }


    public String getCompanyEmail() {
        return companyEmail;
    }


    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }


    public String getNationalIdentityCardNumber() {
        return nationalIdentityCardNumber;
    }


    public void setNationalIdentityCardNumber(String nationalIdentityCardNumber) {
        this.nationalIdentityCardNumber = nationalIdentityCardNumber;
    }


    public String getNationalIdentificationNumber() {
        return nationalIdentificationNumber;
    }


    public void setNationalIdentificationNumber(String nationalIdentificationNumber) {
        this.nationalIdentificationNumber = nationalIdentificationNumber;
    }


    public Student(int studentId, Person p) {
        this.studentId = studentId;
        this.nationalIdentityCardNumber = p.nationalIdentificationNumber();
        this.address = p.getAddress();
        this.firstName = p.firstName();
        this.middleName = p.middleName();
        this.lastName = p.lastName();
        this.email = p.email();
        this.sex = p.sex();
        this.telephoneNumber = p.telephoneNumber();
        this.dateOfBirth = p.dateOfBirth();
        this.age = p.age();
        this.nationalIdentificationNumber = p.nationalIdentificationNumber();
        this.companyEmail = p.companyEmail();
    }

}
