package com.System.Travel.Booking.System.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransportationViewController {

    @GetMapping("transports")
    public String transportsView(HttpServletRequest req, Model m){
        String requestURI=req.getRequestURI();
        m.addAttribute("mycurrentpage",requestURI);
        return "transports";
    }

}
