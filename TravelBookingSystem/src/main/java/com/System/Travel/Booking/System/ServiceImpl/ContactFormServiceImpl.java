package com.System.Travel.Booking.System.ServiceImpl;

import com.System.Travel.Booking.System.Repository.ContactFormCrud;
import com.System.Travel.Booking.System.Service.ContactFormService;
import com.System.Travel.Booking.System.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactFormServiceImpl implements ContactFormService {
    private ContactFormCrud contactFormCrud;

    @Autowired
    public ContactFormServiceImpl(ContactFormCrud contactFormCrud) {
        this.contactFormCrud = contactFormCrud;
    }

    @Override
    public ContactForm saveContactFormService(ContactForm contactForm) {
        return contactFormCrud.save(contactForm);

    }
}
