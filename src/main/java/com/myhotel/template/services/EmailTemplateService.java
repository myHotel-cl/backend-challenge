package com.myhotel.template.services;

import com.myhotel.template.projections.EmailTemplateDataProjection;
import org.springframework.stereotype.Service;

@Service
public class EmailTemplateService {

    private final EmailSenderService emailSenderService;


    public EmailTemplateService(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    public EmailTemplateDataProjection getTemplateData(Long surveyResponseId) {
        return emailSenderService.getTemplateData(surveyResponseId);
    }

    public String getRecipe(Long surveyResponseId) {
        EmailTemplateDataProjection templateDataProjection =  this.getTemplateData(surveyResponseId);
        return templateDataProjection.getGuestEmail();
    }


    public String buildMailMessage(Long surveyResponseId) {
        EmailTemplateDataProjection templateDataProjection =  this.getTemplateData(surveyResponseId);
        return emailSenderService.buildMailMessage(templateDataProjection);
    }

    public String getSenderName(Long surveyResponseId) {
        EmailTemplateDataProjection templateData =  this.getTemplateData(surveyResponseId);
        return templateData.getHotelName();
    }
}
