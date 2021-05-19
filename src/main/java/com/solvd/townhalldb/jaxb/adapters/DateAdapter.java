package com.solvd.townhalldb.jaxb.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateAdapter extends XmlAdapter<String, Date> {

    @Override
    public Date unmarshal(String s) throws ParseException {
        return new SimpleDateFormat("MM/dd/YYYY").parse(s);
    }

    @Override
    public String marshal(Date date) {
        return new SimpleDateFormat("MM/dd/YYYY").format(date);
    }
}


