package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Inpatient {

    private int id;
    private String status;
    private List<DoctorAppointment> appointment;

    public Inpatient() {
    }

    public Inpatient(int id, String status, List<DoctorAppointment> appointment) {
        this.id = id;
        this.status = status;
        this.appointment = appointment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DoctorAppointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<DoctorAppointment> appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "Inpatient{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", appointmentList=" + appointment +
                '}';
    }
}
