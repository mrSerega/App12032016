package com.example.serega.app12032016.people;

public class People
        implements Comparable<People>
{

    public People() {
        _name=new String("default");
        _surname = new String("default");
        _mark=new Integer(1);
    }

    public People( String surname ,String name,Integer mark){
        _name=name;
        _surname=surname;
        _mark=mark;
    }

    private String _name;
    private String _surname;
    private Integer _mark;

    public String getName(){return _name;}
    public String getSurname() {return _surname;}
    public Integer getMark(){return _mark;}

    public void setName(String name){_name=name;}
    public void setMark(Integer mark){_mark=mark;}
    public void setSurname(String surname){_surname=surname;}

    @Override
    public String toString() {
        String tmp=_surname+" "+_name+_mark.toString();
        return (tmp);
        //return "123";
    }

    @Override
    public int compareTo(People o) {
        int bool = _mark.compareTo(o._mark);
        String fullName=_surname+_name;
        String rhsFullName=o._surname+o._name;
        if(bool == 0) return _name.compareTo(o._name);
        else return bool;
    }
}
