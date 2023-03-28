package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities() {
        List<City> cityList = cities;
        Collections.sort(cityList);

        return cityList;
    }

    /**
     * This function is for shorted city list according to province name
     * @param paramater
     * This function overloading the previous getCities function using this parameter
     * @return
     * Return a shorted list of cities according to province name
     *
     */
    public List<City> getCities(int paramater) {
        List<City> cityList = cities;
        Collections.sort(cityList);
        if(paramater == 1){
            Collections.sort(cityList);
        }
        else{
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city1, City city2) {
                    return city1.getProvinceName().compareTo(city2.getProvinceName());
                }
            });
        }

        return cityList;
    }

    /**
     * This function delet a city from city list.
     * @param city
     * Delet a city.
     */
    public void delete(City city){
        if(!cities.contains(city)){
            throw new IllegalArgumentException();
        }
        else {
            cities.remove(city);
        }
    }

    /**
     * This function count city
     * @return
     * return the size of city
     */
    public int count(){
        return cities.size();
    }
}
