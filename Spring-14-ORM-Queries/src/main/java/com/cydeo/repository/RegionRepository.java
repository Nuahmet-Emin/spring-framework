package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Queue;

public interface RegionRepository extends JpaRepository<Region,Long> {

// Requirement: Display all regions in Canada

    List<Region>  findByCountry(String country);

    //Display all regions in Canada, without duplicateds

    List<Region> findDistinctByCountry(String country);

    //Display all regions with country name includes 'United'
    List<Region> findByCountryContains(String country);

    //Display all regions with country name includes 'United' in order
    List<Region> findByCountryContainsOrderByCountry(String country);

    //Display top 2 regions in Canada
    List<Region> findTop2ByCountry(String country);


}
