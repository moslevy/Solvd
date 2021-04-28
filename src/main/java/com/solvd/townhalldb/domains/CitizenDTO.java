package com.solvd.townhalldb.domains;

public class CitizenDTO extends BaseDTO{
    private String first_name;
    private String last_name;
    private String ssn;

    public CitizenDTO(long id, String name, String last_name, String ssn) {
        super(id);
        this.first_name = name;
        this.last_name = last_name;
        this.ssn = ssn;
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
}
