package com.bortnichenko.listOfRegions.telda.controller;

import com.bortnichenko.listOfRegions.telda.mapper.RegionMapper;
import com.bortnichenko.listOfRegions.telda.resource.RegionResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * Vyacheslav Alekseevich
 * 19/03/2020
 */

@RestController
@RequestMapping("/rest-api")
public class ApiController {

    private List<String> parametersToCheck = new LinkedList<>();

    private RegionMapper regionMapper;

    public ApiController(RegionMapper regionMapper) {
        this.regionMapper = regionMapper;
    }

    // get all
    @GetMapping("/all")
    public List<RegionResource> findAll() {
        return regionMapper.findAll();
    }

    // find by short name
    @GetMapping("/findByShortName")
    public List<RegionResource> getByShortName(@RequestParam String shortName) {
        return regionMapper.getByShortName(shortName);
    }

    @GetMapping("/insertValue")
    public String insert(@RequestParam String regionName, @RequestParam String regionShortName, @RequestParam String flag) {
        parametersToCheck.add(regionName);
        parametersToCheck.add(regionShortName);

        if (isEmpty(parametersToCheck) && !isLong(regionShortName)) {
            regionMapper.insert(new RegionResource(regionName, regionShortName, flag));
            return "the " + regionName + " was added";
        } else {
            return "all fields must be filled in";
        }
    }

    @GetMapping("/updateValue")
    public String update(@RequestParam String oShortName, @RequestParam String nName, @RequestParam String nShortName, @RequestParam String nFlag) {
        parametersToCheck.add(oShortName);
        parametersToCheck.add(nName);
        parametersToCheck.add(nShortName);

        if (isEmpty(parametersToCheck)) {
            regionMapper.update(oShortName, nName, nShortName, nFlag);
            return "the " + oShortName + " was updated";
        } else {
            return "all fields must be filled in";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String shortName) {
        parametersToCheck.add(shortName);
        if (isEmpty(parametersToCheck)) {
            regionMapper.delete(shortName);
            return "the " + shortName + " was deleted";
        } else {
            return "all fields must be filled in";
        }

    }

    private boolean isEmpty(List<String> list) {
        boolean isOK = false;
        for (String s : list) {
            if (!s.isEmpty()) {
                isOK = true;
            } else {
                isOK = false;
                parametersToCheck.clear();
                break;
            }
        }
        parametersToCheck.clear();
        return isOK;
    }

    private boolean isLong(String shortName) {
        return shortName.length() > 20;
    }

}
