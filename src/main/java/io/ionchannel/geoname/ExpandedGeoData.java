package io.ionchannel.geoname;

import com.bericotech.clavin.gazetteer.CountryCode;
import com.bericotech.clavin.resolver.ResolvedLocation;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/*
(c) Copyright Selection Pressure LLC - 2015

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
        this.id = resolvedLocation.getGeoname().getGeonameID();
        this.name = resolvedLocation.getGeoname().getName();
        this.asciiName = resolvedLocation.getGeoname().getAsciiName();
        this.alternateNames = resolvedLocation.getGeoname().getAlternateNames();
        this.latitude = resolvedLocation.getGeoname().getLatitude();
        this.longitude = resolvedLocation.getGeoname().getLongitude();
        this.featureClass = resolvedLocation.getGeoname().getFeatureClass().description;
        this.featureCode = resolvedLocation.getGeoname().getFeatureCode().getDescription();
        this.primaryCountryCode = resolvedLocation.getGeoname().getPrimaryCountryCode();
        this.alternateCountryCodes = resolvedLocation.getGeoname().getAlternateCountryCodes();
        this.admin1Code = resolvedLocation.getGeoname().getAdmin1Code();
        this.admin2Code = resolvedLocation.getGeoname().getAdmin2Code();
        this.admin3Code = resolvedLocation.getGeoname().getAdmin3Code();
        this.admin4Code = resolvedLocation.getGeoname().getAdmin4Code();
        this.population = resolvedLocation.getGeoname().getPopulation();
        this.elevation = resolvedLocation.getGeoname().getElevation();
        this.digitalElevationModel = resolvedLocation.getGeoname().getDigitalElevationModel();
        this.timezone = resolvedLocation.getGeoname().getTimezone();
        this.modificationDate = resolvedLocation.getGeoname().getModificationDate();
        this.primaryCountryName = resolvedLocation.getGeoname().getPrimaryCountryName();
        this.match = resolvedLocation.getMatchedName();
        this.fuzzy = resolvedLocation.isFuzzy();
        this.confidence = resolvedLocation.getConfidence();
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
