package io.ionchannel.geoname;

import com.bericotech.clavin.resolver.ResolvedLocation;

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

public class SimpleGeoData {
    int id;
    String name;
    String country;
    String match;
    boolean fuzzy;
    double confidence;
    Links links;

    int altitude;
    double latitude;
    double longitude;

    public class Links{
        String expand;

        public Links(String expand){
            this.expand = expand;
        }

        public String getExpand(){
            return this.expand;
        }
    }


    public SimpleGeoData(int id,
                         String name,
                         String country,
                         String match,
                         boolean fuzzy,
                         double confidence,
                         int altitude,
                         double latitude,
                         double longitude,
                         String expand) {
        this.confidence = confidence;
        this.id = id;
        this.name = name;
        this.country = country;
        this.altitude = altitude;
        this.latitude = latitude;
        this.longitude = longitude;
        this.match = match;
        this.fuzzy = fuzzy;
        this.links = new Links(expand);
    }

    public SimpleGeoData(ResolvedLocation resolvedLocation, String expand){
        this.id = resolvedLocation.getGeoname().getGeonameID();
        this.name = resolvedLocation.getGeoname().getName();
        this.country = resolvedLocation.getGeoname().getPrimaryCountryName();
        this.altitude = resolvedLocation.getGeoname().getElevation();
        this.latitude = resolvedLocation.getGeoname().getLatitude();
        this.longitude = resolvedLocation.getGeoname().getLongitude();
        this.match = resolvedLocation.getMatchedName();
        this.fuzzy = resolvedLocation.isFuzzy();
        this.confidence = resolvedLocation.getConfidence();
        this.links = new Links(expand);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getAltitude() { return altitude; }

    public double getLatitude() { return latitude; }

    public double getLongitude() { return longitude; }


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
