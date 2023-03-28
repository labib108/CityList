package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testDelet(){
        CityList cityList = new CityList();
        City city = new City("Bagerhat", "Khulna");
        City city1 = new City("mirpur", "Dhaka");
        City city2 = new City( "jessore", "khulna");
        cityList.add(city);
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city);

        assertTrue(!cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testDeletException(){
        CityList cityList = new CityList();
        City city = new City("Bagerhat", "Khulna");
        City city1 = new City("mirpur", "Dhaka");
        City city2 = new City( "jessore", "khulna");
        cityList.add(city);
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city);
        assertThrows(IllegalArgumentException.class, () ->{
            cityList.delete(city);
        });
    }
    @Test
    public void testCountException(){
        CityList cityList = new CityList();
        City city = new City("Bagerhat", "Khulna");
        City city1 = new City("mirpur", "Dhaka");
        City city2 = new City( "jessore", "khulna");
        cityList.add(city);
        cityList.add(city1);
        cityList.add(city2);

        assertEquals(3,cityList.count());
        cityList.delete(city);
        assertEquals(2,cityList.count());
        assertThrows(IllegalArgumentException.class, () ->{
            cityList.delete(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    @Test
    public void testGetProvienceCities() {
        CityList cityList = new CityList();
        City city1 = new City("Sathkhira", "Khulna");
        cityList.add(city1);
        assertEquals(0, city1.compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, city1.compareTo(cityList.getCities(1).get(1)));
    }
}
