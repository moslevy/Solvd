package com.solvd.townhalldb.domains;

import java.util.Date;

public class EmployeeDTO extends BaseDTO {
    private String first_name;
    private String last_name;
    private String ssn;
    private Date dob;
    private Date start_date;

    public EmployeeDTO(long id, String first_name, String last_name, String ssn, Date dob, Date start_date) {
        super(id);
        this.first_name = first_name;
        this.last_name = last_name;
        this.ssn = ssn;
        this.dob = dob;
        this.start_date = start_date;
    }

    public EmployeeDTO() {

    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }
}
