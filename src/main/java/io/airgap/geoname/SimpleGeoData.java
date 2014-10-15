package io.airgap.geoname;

import com.berico.clavin.resolver.ResolvedLocation;

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

public class SimpleGeoData {
    int id;
    String name;
    String country;
    String match;
    boolean fuzzy;
    double confidence;
    Links links;

    public class Links{
        String expand;

        public Links(String expand){
            this.expand = expand;
        }

        public String getExpand(){
            return this.expand;
        }
    }


    public SimpleGeoData(int id, String name, String country, String match, boolean fuzzy, double confidence, String expand) {
        this.confidence = confidence;
        this.id = id;
        this.name = name;
        this.country = country;
        this.match = match;
        this.fuzzy = fuzzy;
        this.links = new Links(expand);
    }

    public SimpleGeoData(ResolvedLocation resolvedLocation, String expand){
        this.id = resolvedLocation.geoname.geonameID;
        this.name = resolvedLocation.geoname.name;
        this.country = resolvedLocation.geoname.getPrimaryCountryName();
        this.match = resolvedLocation.matchedName;
        this.fuzzy = resolvedLocation.fuzzy;
        this.confidence = resolvedLocation.confidence;
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
