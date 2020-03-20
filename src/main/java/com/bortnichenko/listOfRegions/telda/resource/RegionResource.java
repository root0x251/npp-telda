package com.bortnichenko.listOfRegions.telda.resource;

/**
 * @author: vaceslavalekseevic
 * @date :   18/03/2020
 */


public class RegionResource {

    private Integer id;
    private String regionName;
    private String regionShortName;
    private String flag;

    public RegionResource(String regionName, String regionShortName, String flag) {
        this.regionName = regionName;
        this.regionShortName = regionShortName;
        this.flag = flag;
    }

    public RegionResource(Integer id, String regionName, String regionShortName, String flag) {
        this.id = id;
        this.regionName = regionName;
        this.regionShortName = regionShortName;
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionShortName() {
        return regionShortName;
    }

    public void setRegionShortName(String regionShortName) {
        this.regionShortName = regionShortName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "RegionResource{" +
                "id=" + id +
                ", regionName='" + regionName + '\'' +
                ", regionShortName='" + regionShortName + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }

}
