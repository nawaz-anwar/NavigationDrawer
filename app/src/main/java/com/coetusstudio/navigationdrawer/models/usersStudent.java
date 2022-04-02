package com.coetusstudio.navigationdrawer.models;

public class usersStudent {

    String stName, stMail, stAddmissionNumber, stEnrollmentNumber, stBranch, stSemester, stPassword, stPicImage;

    public usersStudent() {
    }

    public usersStudent(String stName, String stMail, String stAddmissionNumber, String stEnrollmentNumber, String stBranch, String stSemester, String stPassword, String stPicImage) {
        this.stName = stName;
        this.stMail = stMail;
        this.stAddmissionNumber = stAddmissionNumber;
        this.stEnrollmentNumber = stEnrollmentNumber;
        this.stBranch = stBranch;
        this.stSemester = stSemester;
        this.stPassword = stPassword;
        this.stPicImage = stPicImage;
    }

    public usersStudent(String toString, String toString1, String toString2, String toString3) {
    }

    public usersStudent(String toString, String toString1, String toString2, String toString3, String toString4, String toString5, String toString6) {
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStMail() {
        return stMail;
    }

    public void setStMail(String stMail) {
        this.stMail = stMail;
    }

    public String getStAddmissionNumber() {
        return stAddmissionNumber;
    }

    public void setStAddmissionNumber(String stAddmissionNumber) {
        this.stAddmissionNumber = stAddmissionNumber;
    }

    public String getStEnrollmentNumber() {
        return stEnrollmentNumber;
    }

    public void setStEnrollmentNumber(String stEnrollmentNumber) {
        this.stEnrollmentNumber = stEnrollmentNumber;
    }

    public String getStBranch() {
        return stBranch;
    }

    public void setStBranch(String stBranch) {
        this.stBranch = stBranch;
    }

    public String getStSemester() {
        return stSemester;
    }

    public void setStSemester(String stSemester) {
        this.stSemester = stSemester;
    }

    public String getStPassword() {
        return stPassword;
    }

    public void setStPassword(String stPassword) {
        this.stPassword = stPassword;
    }
    public void setStPicImage(String stPicImage) {
        this.stPassword = stPicImage;
    }
    public void getStPicImage(String stPicImage) {
        this.stPassword = stPicImage;
    }
}
