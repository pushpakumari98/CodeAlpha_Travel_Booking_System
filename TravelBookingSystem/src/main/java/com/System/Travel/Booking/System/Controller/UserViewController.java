package com.System.Travel.Booking.System.Controller;


import com.System.Travel.Booking.System.Service.FlightService;
import com.System.Travel.Booking.System.model.AddFlight;
import com.System.Travel.Booking.System.model.ContactForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserViewController {

    @Autowired
    private FlightService flightService;

    @GetMapping(path={"/","home","welcome","index"})
    public String welcomeView(HttpServletRequest req, Model m){
        String requestURI=req.getRequestURI();
        m.addAttribute("mycurrentpage",requestURI);
        return "index";
    }

    @GetMapping("about")
    public String aboutView(HttpServletRequest req, Model m){
        String requestURI=req.getRequestURI();
        m.addAttribute("mycurrentpage",requestURI);
        return "about";
    }

    @GetMapping("flights")
    public String flightsView(HttpServletRequest req,Model m){
        String requestURI=req.getRequestURI();
        m.addAttribute("mycurrentpage",requestURI);
        return "flights";
    }

    @GetMapping("hotels")
    public String hotelsView(HttpServletRequest req,Model m){
        String requestURI=req.getRequestURI();
        m.addAttribute("mycurrentpage",requestURI);
        return "hotels";
    }
    @GetMapping("transports")
    public String transportsView(HttpServletRequest req,Model m){
        String requestURI=req.getRequestURI();
        m.addAttribute("mycurrentpage",requestURI);
        return "transports";
    }

    @GetMapping("services")
    public String serviceView(HttpServletRequest req,Model m){
        String requestURI=req.getRequestURI();
        m.addAttribute("mycurrentpage",requestURI);
        return "services";
    }

    @GetMapping("contacts")
    public String contactView(HttpServletRequest req,Model m){
        String requestURI=req.getRequestURI();          //RequestURI is used for highlighting  of any navbar
        m.addAttribute("mycurrentpage",requestURI);
        m.addAttribute("contactForm",new ContactForm());
        return "contacts";
    }

    @PostMapping("contactform")
    public String contactForm(@Valid @ModelAttribute ContactForm contactForm, BindingResult bindingResult, Model m){  //Binding result is used to find all the errors messages typed in  form
        if(bindingResult.hasErrors()){
            m.addAttribute("bindingResult");
            return "contacts";
        }
        System.out.println(contactForm);
        return "redirect:/contacts";
    }

    @PostMapping("addflights")
    public String addFlight(@Valid @ModelAttribute AddFlight addFlight, Model model) {
        // For debugging, print the flight details to the console
        System.out.println(addFlight);

        // Save the addFlight to the database or perform other processing here

        // Optionally, add the saved flight to the model to display in the flight list

        model.addAttribute("flights", flightService.getAllFlights());

        // Redirect or return the view name
        return "redirect:/flights";  // Ensure that "flights" is the correct Thymeleaf template for showing the flight list
    }




}

