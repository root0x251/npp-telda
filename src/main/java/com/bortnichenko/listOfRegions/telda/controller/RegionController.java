package com.bortnichenko.listOfRegions.telda.controller;

import com.bortnichenko.listOfRegions.telda.mapper.RegionMapper;
import com.bortnichenko.listOfRegions.telda.resource.RegionResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: vaceslavalekseevic
 * @date :   18/03/2020
 */

@Controller
@RequestMapping("/")
public class RegionController {

    private RegionMapper regionMapper;

    public RegionController(RegionMapper regionMapper) {
        this.regionMapper = regionMapper;
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        Iterable<RegionResource> regionResources = regionMapper.findAll();
        model.addAttribute("regionResources", regionResources);
        return "index";
    }

}
