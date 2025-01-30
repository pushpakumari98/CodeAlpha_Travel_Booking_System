package com.System.Travel.Booking.System.Controller;


import com.System.Travel.Booking.System.Service.ContactFormService;
import com.System.Travel.Booking.System.ServiceImpl.ContactFormServiceImpl;

import com.System.Travel.Booking.System.model.BookingForm;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserViewController {
    @Autowired
    private ContactFormServiceImpl contactFormServiceImpl;

    @Autowired
    private ContactFormService contactFormService;


    @GetMapping(path={"/","home","welcome","index"})
    public String welcomeView(HttpServletRequest req, Model m){
        String requestURI=req.getRequestURI();
        m.addAttribute("mycurrentpage",requestURI);
        m.addAttribute("bookingForm",new BookingForm());
        return "index";
    }

    @GetMapping("about")
    public String aboutView(HttpServletRequest req, Model m){
        String requestURI=req.getRequestURI();
        m.addAttribute("mycurrentpage",requestURI);
        return "about";
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
    public String contactForm(@Valid @ModelAttribute ContactForm contactForm, BindingResult bindingResult, Model m,RedirectAttributes redirectAttributes){  //Binding result is used to find all the errors messages typed in  form

        if(bindingResult.hasErrors()){
            m.addAttribute("bindingResult");
            return "contacts";
        }
        System.out.println(contactForm);

        ContactForm saveContactFormService=contactFormService.saveContactFormService(contactForm);

        if(saveContactFormService!=null){
            redirectAttributes.addFlashAttribute("message","Message sent successfully");
        }
        else{
            redirectAttributes.addFlashAttribute("message","something went wrong");
        }
        return "redirect:/contacts";
    }

    @PostMapping("bookingform")
    public String bookingForm(@Valid @ModelAttribute BookingForm bookingForm, BindingResult bindingResult, Model m,RedirectAttributes redirectAttributes){  //Binding result is used to find all the errors messages typed in  form

        if(bindingResult.hasErrors()){
            m.addAttribute("bindingResult");
            return "index";
        }
        return "redirect:/index";
    }

}

