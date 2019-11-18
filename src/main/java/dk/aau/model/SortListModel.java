package dk.aau.model;

import java.util.Date;

public class SortListModel {
    private boolean sortRecievedDate;
    private boolean sortReferralSentDate;
    private int cprNumber;
    private String status;
    private int referredTo;
    private String assigned;
    private Date fromDate;
    private Date toDate;
    private boolean referralProcessed;


    //Getter og Setter
    public boolean isSortRecievedDate() {
        return sortRecievedDate;
    }

    public void setSortRecievedDate(boolean sortRecievedDate) {
        this.sortRecievedDate = sortRecievedDate;
    }

    public boolean isSortReferralSentDate() {
        return sortReferralSentDate;
    }

    public void setSortReferralSentDate(boolean sortReferralSentDate) {
        this.sortReferralSentDate = sortReferralSentDate;
    }

    public int getCprNumber() {
        return cprNumber;
    }

    public void setCprNumber(int cprNumber) {
        this.cprNumber = cprNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getReferredTo() {
        return referredTo;
    }

    public void setReferredTo(int referredTo) {
        this.referredTo = referredTo;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public boolean isReferralProcessed() {
        return referralProcessed;
    }

    public void setReferralProcessed(boolean referralProcessed) {
        this.referralProcessed = referralProcessed;
    }
}