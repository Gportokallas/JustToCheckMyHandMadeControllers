package com.example.demo.services;

import com.example.demo.mappers.TourMapper;
import com.example.demo.pojos.Tour;
import com.example.demo.pojos.TourResponse;
import com.example.demo.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourService {

    @Autowired
    private TourMapper mapper;

    @Autowired
    private TourRepository repository;

    public List<TourResponse> getAllTours() {
        Iterable<Tour> retrievedTours = repository.findAll();
        List<TourResponse> tours = new ArrayList<>();

        for (Tour tour : retrievedTours) {
            tours.add(mapper.mapTourResponseFromTour(tour));
        }

        return tours;
/*        retrievedTours.forEach((tour)-> {

        });*/
    }

    public List<TourResponse> getToursByPackageId(Long tourPackageId) {
        Iterable<Tour> retrievedTours = repository.findAll();
        List<TourResponse> tours = new ArrayList<>();
        for (Tour tour : retrievedTours) {
            if (tour.getTourPackage().getId() == tourPackageId) {
                tours.add(mapper.mapTourResponseFromTour(tour));
            }
        }
        return tours;
    }

    public List<TourResponse> getExpensiveTours() {
        Iterable<Tour> retrivedTours = repository.findAll();
        List<TourResponse> tours = new ArrayList<>();
        for (Tour tour : retrivedTours) {
            if (tour.getPrice() > 500) {
                tours.add(mapper.mapTourResponseFromTour(tour));
            }
        }
        return tours;
    }
}
