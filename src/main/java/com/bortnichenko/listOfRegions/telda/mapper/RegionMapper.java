package com.bortnichenko.listOfRegions.telda.mapper;

import com.bortnichenko.listOfRegions.telda.resource.RegionResource;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: vaceslavalekseevic
 * @date :   18/03/2020
 */

@Mapper
public interface RegionMapper {
    String getAllValues = "select * from region_info order by " +
                            "region_name ASC";

    String findValueByShortName = "select * from region_info where region_info.region_short_name = #{shortName}";

    String insertInToTable = "INSERT INTO region_info (region_name,region_short_name,flag_url) " +
                            "values(#{regionName},#{regionShortName},#{flag}) " +
                            "ON CONFLICT (region_short_name) DO NOTHING";

    String updateValueByShortName = "update region_info set region_name = #{nName}, " +
                                    "region_short_name = #{nShortName},flag_url = #{nFlag} " +
                                    "where region_short_name = #{oShortName}";

    String deleteValueByShortName = "delete from region_info where region_short_name = #{shortName}";

    // get all
    @Select(getAllValues)
    List<RegionResource> findAll();

    // get by short name
    @Select(findValueByShortName)
    List<RegionResource> getByShortName(String shortName);

    // insert
    @Insert(insertInToTable)
    void insert(RegionResource resource);

    // update
    @Update(updateValueByShortName)
    void update(String oShortName, String nName, String nShortName, String nFlag);

    // delete
    @Delete(deleteValueByShortName)
    void delete(String shortName);

}
