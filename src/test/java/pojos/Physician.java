package pojos;



/*

   private String appointments;
   private String birthDate;
   private String bloodGroup;
   private String examFee;
   private String firstName;
   private String id;
   private String lastName;
   private String phone;
   private String speciality;
   private String ssn;
   private String pattern;
   private String user;
 */

public class Physician {

    private String appointments;
    private String birthDate;
    private String bloodGroup;
    private String examFee;
    private String firstName;
    private String id;
    private String lastName;
    private String phone;
    private String speciality;
    private String ssn;
    private String pattern;
    private String user;
    private String email;

    public Physician() {
    }

    public Physician(String appointments, String birthDate, String bloodGroup, String examFee, String firstName, String id, String lastName, String phone, String speciality, String ssn, String pattern, String user, String email) {
        this.appointments = appointments;
        this.birthDate = birthDate;
        this.bloodGroup = bloodGroup;
        this.examFee = examFee;
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.phone = phone;
        this.speciality = speciality;
        this.ssn = ssn;
        this.pattern = pattern;
        this.user = user;
        this.email = email;
    }

    public String getAppointments() {
        return appointments;
    }

    public void setAppointments(String appointments) {
        this.appointments = appointments;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getExamFee() {
        return examFee;
    }

    public void setExamFee(String examFee) {
        this.examFee = examFee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Physician{" +
                "appointments='" + appointments + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", examFee='" + examFee + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", speciality='" + speciality + '\'' +
                ", ssn='" + ssn + '\'' +
                ", pattern='" + pattern + '\'' +
                ", user='" + user + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
