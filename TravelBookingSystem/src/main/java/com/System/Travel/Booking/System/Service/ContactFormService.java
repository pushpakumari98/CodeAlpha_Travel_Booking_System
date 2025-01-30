package com.System.Travel.Booking.System.Service;

import com.System.Travel.Booking.System.model.ContactForm;
import org.springframework.stereotype.Service;

@Service
public interface ContactFormService {
    public ContactForm saveContactFormService(ContactForm contactForm);
}
