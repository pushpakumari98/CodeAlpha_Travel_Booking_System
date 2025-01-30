package com.System.Travel.Booking.System.Controller;

import com.System.Travel.Booking.System.Repository.FlightRepository;
import com.System.Travel.Booking.System.Service.FlightService;
import com.System.Travel.Booking.System.entity.Flight;
import com.System.Travel.Booking.System.model.AddFlight;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class FlightViewController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightRepository flightRepository;



    @GetMapping("flights")
    public String flightsView(HttpServletRequest req, Model m){   //for highlighting the currently selected button
        String requestURI=req.getRequestURI();
        m.addAttribute("mycurrentpage",requestURI);
        return "flights";
    }

    @GetMapping("/flightregister")
    public String bookRegister() {
        return "flightRegister";
    }




    @GetMapping("/availableflights")
    public ModelAndView getAllFlights() {
        List<Flight> list = flightService.getAllFlights();
        System.out.println("Flights fetched: " + list);
        return new ModelAndView("flightList", "flight", list);
    }
    @PostMapping("addflights")
    public String addFlight(@Valid @ModelAttribute AddFlight addFlight, Model model) {
        // For debugging, print the flight details to the console
        System.out.println(addFlight);

        // Save the addFlight to the database or perform other processing here

        // Optionally, add the saved flight to the model to display in the flight list

        model.addAttribute("flights", flightService.getAllFlights());

        // Redirect or return the view name
        return "redirect:/flights";
    }


    @RequestMapping("/editFlight/{id}")
    public String editFlight(@PathVariable("id") Long id, Model model) {
        Flight flight=flightService.getFlightById(id);
        model.addAttribute("flight",flight);
        return "flightEdit";

    }

    @RequestMapping("/deleteFlight/{id}")
    public String deleteFlight(@PathVariable("id") Long id) {
       flightService.deleteFlightById(id);
       return "redirect:/availableFlights";
    }
}
