package model;

public class Loan {
    private double principal;
    private double interest;
    private double period;
    private double payment;

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getPeriod() {
        return period;
    }

    public void setPeriod(double period) {
        this.period = period;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public void calculatePayment() {
        double a = (1 + (interest / 1200));
        payment = ((interest * principal) / 1200) / (1 - Math.pow(a, -period));
    }
}
