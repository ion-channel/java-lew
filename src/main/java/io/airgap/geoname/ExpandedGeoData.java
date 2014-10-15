package io.airgap.geoname;

import com.berico.clavin.gazetteer.CountryCode;
import com.berico.clavin.resolver.ResolvedLocation;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/*
(c) Copyright AirGap LLC - 2014

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/
public class ExpandedGeoData {
    int id;
    String name;
    String asciiName;
    List<String> alternateNames;
    double latitude;
    double longitude;
    String featureClass;
    String featureCode;
    CountryCode primaryCountryCode;
    List<CountryCode> alternateCountryCodes;
    String admin1Code;
    String admin2Code;
    String admin3Code;
    String admin4Code;
    long population;
    double elevation;
    int digitalElevationModel;
    TimeZone timezone;
    Date modificationDate;
    String primaryCountryName;

    String match;
    boolean fuzzy;
    double confidence;

    Links links;


    public class Links{
        String simple;

        public Links(String simple){
            this.simple = simple;
        }

        public String getSimple(){
            return this.simple;
        }
    }


    public ExpandedGeoData(int id, String name, String asciiName, List<String> alternateNames, double latitude, double longitude, String featureClass, String featureCode, CountryCode primaryCountryCode, List<CountryCode> alternateCountryCodes, String admin1Code, String admin2Code, String admin3Code, String admin4Code, int population, double elevation, int digitalElevationModel, TimeZone timezone, Date modificationDate, String primaryCountryName, String match, boolean fuzzy, double confidence, String simple) {
        this.id = id;
        this.name = name;
        this.asciiName = asciiName;
        this.alternateNames = alternateNames;
        this.latitude = latitude;
        this.longitude = longitude;
        this.featureClass = featureClass;
        this.featureCode = featureCode;
        this.primaryCountryCode = primaryCountryCode;
        this.alternateCountryCodes = alternateCountryCodes;
        this.admin1Code = admin1Code;
        this.admin2Code = admin2Code;
        this.admin3Code = admin3Code;
        this.admin4Code = admin4Code;
        this.population = population;
        this.elevation = elevation;
        this.digitalElevationModel = digitalElevationModel;
        this.timezone = timezone;
        this.modificationDate = modificationDate;
        this.primaryCountryName = primaryCountryName;
        this.match = match;
        this.fuzzy = fuzzy;
        this.confidence = confidence;
        this.links = new Links(simple);
    }

    public ExpandedGeoData(ResolvedLocation resolvedLocation, String simple){
        this.id = resolvedLocation.geoname.geonameID;
        this.name = resolvedLocation.geoname.name;
        this.asciiName = resolvedLocation.geoname.asciiName;
        this.alternateNames = resolvedLocation.geoname.alternateNames;
        this.latitude = resolvedLocation.geoname.latitude;
        this.longitude = resolvedLocation.geoname.longitude;
        this.featureClass = resolvedLocation.geoname.featureClass.description;
        this.featureCode = resolvedLocation.geoname.featureCode.description;
        this.primaryCountryCode = resolvedLocation.geoname.primaryCountryCode;
        this.alternateCountryCodes = resolvedLocation.geoname.alternateCountryCodes;
        this.admin1Code = resolvedLocation.geoname.admin1Code;
        this.admin2Code = resolvedLocation.geoname.admin2Code;
        this.admin3Code = resolvedLocation.geoname.admin3Code;
        this.admin4Code = resolvedLocation.geoname.admin4Code;
        this.population = resolvedLocation.geoname.population;
        this.elevation = resolvedLocation.geoname.elevation;
        this.digitalElevationModel = resolvedLocation.geoname.digitalElevationModel;
        this.timezone = resolvedLocation.geoname.timezone;
        this.modificationDate = resolvedLocation.geoname.modificationDate;
        this.primaryCountryName = resolvedLocation.geoname.getPrimaryCountryName();
        this.match = resolvedLocation.matchedName;
        this.fuzzy = resolvedLocation.fuzzy;
        this.confidence = resolvedLocation.confidence;
        this.links = new Links(simple);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAsciiName() {
        return asciiName;
    }

    public List<String> getAlternateNames() {
        return alternateNames;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getFeatureClass() {
        return featureClass;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public CountryCode getPrimaryCountryCode() {
        return primaryCountryCode;
    }

    public List<CountryCode> getAlternateCountryCodes() {
        return alternateCountryCodes;
    }

    public String getAdmin1Code() {
        return admin1Code;
    }

    public String getAdmin2Code() {
        return admin2Code;
    }

    public String getAdmin3Code() {
        return admin3Code;
    }

    public String getAdmin4Code() {
        return admin4Code;
    }

    public long getPopulation() {
        return population;
    }

    public double getElevation() {
        return elevation;
    }

    public int getDigitalElevationModel() {
        return digitalElevationModel;
    }

    public TimeZone getTimezone() {
        return timezone;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public String getPrimaryCountryName() {
        return primaryCountryName;
    }

    public String getMatch() {
        return match;
    }

    public boolean isFuzzy() {
        return fuzzy;
    }

    public double getConfidence() {
        return confidence;
    }

    public Links getLinks() {
        return links;
    }
}
