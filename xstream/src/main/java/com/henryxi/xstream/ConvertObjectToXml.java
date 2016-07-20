package com.henryxi.xstream;

import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.List;

public class ConvertObjectToXml {
    public static void main(String[] args) {
        User henry = initDate();
        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);
        String xml = xStream.toXML(henry);
        System.out.println(xml);
    }

    private static User initDate() {
        User henry = new User();
        henry.setName("henry");
        henry.setAge(27);
        Address home = new Address();
        home.setCountry("China");
        home.setCity("Hebei");
        Address company = new Address();
        company.setCountry("China");
        company.setCity("Beijing");
        List<Address> addressList = new ArrayList<>();
        addressList.add(home);
        addressList.add(company);
        henry.setAddresses(addressList);
        return henry;
    }
}
