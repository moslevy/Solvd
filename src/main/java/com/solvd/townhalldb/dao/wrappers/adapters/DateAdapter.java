package com.solvd.townhalldb.dao.wrappers.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateAdapter extends XmlAdapter<String, Date> {

    @Override
    public Date unmarshal(String s) throws Exception {
        return (Date) new SimpleDateFormat("MM/dd/YYYY").parse(s);
    }

    @Override
    public String marshal(Date date) throws Exception {
        return new SimpleDateFormat("MM/dd/YYYY").format(date);
    }
}
