package pojos;


    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class AppointmentOut {


        private AppointmentGet patient;
        private String startDate;
        private Integer id;
        private String firstName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public AppointmentOut() {
        }

        public AppointmentOut(String firstName) {
            this.firstName = firstName;
        }

        public AppointmentOut(AppointmentGet patient, String startDate, int id) {
            this.patient = patient;
            this.startDate = startDate;
            this.id = id;
        }

        public AppointmentGet getPatient() {
            return patient;
        }

        public void setPatient(AppointmentGet patient) {
            this.patient = patient;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "AppointmentOut{" +
                    "patient=" + patient +
                    ", startDate='" + startDate + '\'' +
                    ", id=" + id +
                    ", firstName='" + firstName + '\'' +
                    '}';
        }
    }
