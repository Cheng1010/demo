package com.example.demo;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tvseries")
public class TvSeriesController {

    @GetMapping
    public List<TvSeriesDto> getAll() {
        List<TvSeriesDto> list = new ArrayList<>();
        list.add(createPoi());
        list.add(createWestWorld());
        return list;
    }

    @GetMapping("/{id}")
    public TvSeriesDto getOne(@PathVariable int id) {
        if(id == 101) {
            return createWestWorld();
        } else if(id == 102) {
            return createPoi();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @PostMapping
    public TvSeriesDto insertOne(@RequestBody TvSeriesDto tvSeriesDto) {
        tvSeriesDto.setId(9999);
        return tvSeriesDto;
    }

    private TvSeriesDto createPoi() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2011,Calendar.OCTOBER,2,0,0);
        return new TvSeriesDto(102,"Person of Interest",1,calendar.getTime());
    }

    private TvSeriesDto createWestWorld() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016,Calendar.OCTOBER,2,0,0);
        return new TvSeriesDto(101,"WestWorld",1,calendar.getTime());
    }
}
