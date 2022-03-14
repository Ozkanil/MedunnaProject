package utilities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



    @JsonIgnoreProperties(ignoreUnknown = true)
    public class NewAppointment {

        private String username;
        private String password;
        private String firstname;
        private String lastname;
        private String ssn;
        private String email;
        private String phone;
        private String appointmentdatetime;

        public NewAppointment(){

        }

        public NewAppointment(String username, String password, String firstname, String lastname, String ssn, String email, String phone, String appointmentdatetime) {
            this.username = username;
            this.password = password;
            this.firstname = firstname;
            this.lastname = lastname;
            this.ssn = ssn;
            this.email = email;
            this.phone = phone;
            this.appointmentdatetime = appointmentdatetime;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getSsn() {
            return ssn;
        }

        public void setSsn(String ssn) {
            this.ssn = ssn;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAppointmentdatetime() {
            return appointmentdatetime;
        }

        public void setAppointmentdatetime(String appointmentdatetime) {
            this.appointmentdatetime = appointmentdatetime;
        }

        @Override
        public String toString() {
            return "NewAppointment{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", firstname='" + firstname + '\'' +
                    ", lastname='" + lastname + '\'' +
                    ", ssn='" + ssn + '\'' +
                    ", email='" + email + '\'' +
                    ", phone='" + phone + '\'' +
                    ", appointmentdatetime='" + appointmentdatetime + '\'' +
                    '}';
        }
    }


