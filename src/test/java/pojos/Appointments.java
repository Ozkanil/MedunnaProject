package pojos;

import com.github.javafaker.DateAndTime;
public class Appointments {
    private String appoSpeciality;
    private String birthDate;
    private String email;
    private String firstName;
    private String gender;
    private String lastName;
    private String phone;
    private String snumber;
    private String ssn;
    private String startDate;
    private String from;
    private String to;
    //variables, constructors, getters and setters, toString
    public Appointments() {
    }
    public Appointments(String appoSpeciality, String birthDate, String email, String firstName, String gender, String lastName, String phone, String snumber, String ssn, String startDate, String from, String to) {
        this.appoSpeciality = appoSpeciality;
        this.birthDate = birthDate;
        this.email = email;
        this.firstName = firstName;
        this.gender = gender;
        this.lastName = lastName;
        this.phone = phone;
        this.snumber = snumber;
        this.ssn = ssn;
        this.startDate = startDate;
        this.from = from;
        this.to = to;
    }
    public String getAppoSpeciality() {
        return appoSpeciality;
    }
    public void setAppoSpeciality(String appoSpeciality) {
        this.appoSpeciality = appoSpeciality;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getSnumber() {
        return snumber;
    }
    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    @Override
    public String toString() {
        return "Appointment{" +
                "appoSpeciality='" + appoSpeciality + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", snumber='" + snumber + '\'' +
                ", ssn='" + ssn + '\'' +
                ", startDate='" + startDate + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
