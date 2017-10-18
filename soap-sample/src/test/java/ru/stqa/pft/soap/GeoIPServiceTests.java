package ru.stqa.pft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;
import org.testng.Assert;
import org.testng.annotations.Test;



/**
 * Created by Антон on 19.10.2017.
 */
public class GeoIPServiceTests {


  @Test
  public void testMyIp(){

    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("178.129.52.219");
   Assert.assertEquals(geoIP.getCountryCode(),"RUS");
  }

  @Test
  public void testInvalidIp(){

    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("178.129.52.xxx");
    Assert.assertEquals(geoIP.getCountryCode(),"RUS");
  }
}
