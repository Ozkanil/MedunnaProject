package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Invoice {

    private String billDate;
    private String billName;
    private String ssn;
    private String paymentMethod;
    private String totalCost;

    public Invoice() {
    }

    public Invoice(String billDate, String billName, String ssn, String paymentMethod, String totalCost) {
        this.billDate = billDate;
        this.billName = billName;
        this.ssn = ssn;
        this.paymentMethod = paymentMethod;
        this.totalCost = totalCost;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "billDate=" + billDate +
                ", billName=" + billName +
                ", ssn=" + ssn +
                ", paymentMethod=" + paymentMethod +
                ", totalCost=" + totalCost +
                '}';
    }
}
