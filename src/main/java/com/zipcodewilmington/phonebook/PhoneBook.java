package com.zipcodewilmington.phonebook;

import java.util.*;
/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private String name;
    private String phoneNumber;
    private Map<String, List<String>> phoneBook;

    public PhoneBook(Map<String, List<String>> map) {
        phoneBook = new LinkedHashMap<>(map);
    }

    public PhoneBook() {
        this(new LinkedHashMap<String, List<String>>());
    }

    public void add(String name, String phoneNumber) {
        if(phoneBook.containsKey(name))
            phoneBook.get(name).add(phoneNumber);
        else {
            phoneBook.put(name, new ArrayList<String>());
            add(name, phoneNumber);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        this.name = name;
        phoneBook.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        phoneBook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phoneBook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phoneBook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (String name : phoneBook.keySet()){
            ArrayList<String> a = (ArrayList<String>)phoneBook.get(name);
            for (String each: a) {
                if (each.equals(phoneNumber))
                    System.out.println(name);
                    return name;
            }
        }
        return "-1";
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(phoneBook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return phoneBook;
    }
}
