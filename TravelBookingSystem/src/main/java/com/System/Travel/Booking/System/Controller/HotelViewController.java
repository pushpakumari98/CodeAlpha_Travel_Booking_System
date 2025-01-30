package com.System.Travel.Booking.System.Controller;

import com.System.Travel.Booking.System.Repository.HotelRepository;
import com.System.Travel.Booking.System.Service.HotelService;

import com.System.Travel.Booking.System.entity.Hotel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HotelViewController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("hotels")
    public String hotelsView(HttpServletRequest req, Model m){
        String requestURI=req.getRequestURI();
        m.addAttribute("mycurrentpage",requestURI);
        return "hotels";
    }

    @PostMapping("/addhotels")
    public String addHotel(@Valid @ModelAttribute("addHotels") Hotel hotel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // If validation errors occur, reload the page with existing hotels
            model.addAttribute("hotels", hotelService.getAllHotels());
            return "hotels";
        }

        // Save the hotel to the database
        hotelService.createHotel(hotel);

        // Redirect to the hotels page to refresh the list
        return "redirect:/hotels";
    }

    @GetMapping("/hotels/edit/{id}")
    public String editHotel(@PathVariable Long id, Model model) {
        // Retrieve the hotel by ID and add it to the model
        Hotel hotel = hotelService.getHotelById(id);
        if (hotel != null) {
            model.addAttribute("addHotels", hotel);
        }
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "hotels";
    }

    @GetMapping("/hotels/delete/{id}")
    public String deleteHotel(@PathVariable Long id) {
        // Delete the hotel by ID
        hotelService.deleteHotelById(id);
        return "redirect:/hotels"; // Redirect to the updated hotels page


    }
}
