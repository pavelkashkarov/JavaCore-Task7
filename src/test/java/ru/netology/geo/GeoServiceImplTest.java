package ru.netology.geo;

import org.junit.jupiter.api.Test;

import ru.netology.entity.Country;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    private final GeoService geoService = new GeoServiceImpl();

    @ParameterizedTest
    @CsvSource({GeoServiceImpl.LOCALHOST + ",", GeoServiceImpl.MOSCOW_IP + ",RUSSIA", GeoServiceImpl.NEW_YORK_IP + ",USA"})
    void byIp(String ip, Country country) {
        assertEquals(geoService.byIp(ip).getCountry(), country);
    }

    @Test
    void byIpInvalidData() {
        assertNull(geoService.byIp("invalidData"));
    }

    @Test
    void byCoordinates() {
        assertThrows(RuntimeException.class, () -> geoService.byCoordinates(1.0, 1.0));
    }
}