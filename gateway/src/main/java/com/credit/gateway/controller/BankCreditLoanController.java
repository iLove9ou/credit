package com.credit.gateway.controller;

import com.credit.gateway.annotation.Sign;
import com.credit.gateway.impl.ConsumerCreditBankLoanService;
import com.google.gson.Gson;
import common.credit.format.Document;
import common.credit.format.DocumentInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/old")
public class BankCreditLoanController {

    private final static Logger logger = LoggerFactory.getLogger(BankCreditLoanController.class);

    @Autowired
    private ConsumerCreditBankLoanService creditBankLoanService;


    @PostMapping(value = "/apply_notify", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public Document applyNotify(@RequestBody DocumentInput input) {

        logger.info("apply_notify " + " request: " + new Gson().toJson(input));
        Document document = creditBankLoanService.applyNotify(input);
        logger.info("apply_notify " + " response: " + new Gson().toJson(document));
        return document;
    }

    @PostMapping(value = "/approve_upload", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public Document approveUpload(@RequestBody DocumentInput input) {
        logger.info("approve_upload " + " request: " + new Gson().toJson(input));
        Document document = creditBankLoanService.approveUpload(input);
        logger.info("approve_upload " + "response: " + new Gson().toJson(document));
        return document;
    }

    @PostMapping(value = "/approveack_notify", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public Document approveackNotify(@RequestBody DocumentInput input) {
        logger.info("approveack_notify " + " request: " + new Gson().toJson(input));
        Document document = creditBankLoanService.finalNotify(input);
        logger.info("approveack_notify " + "response: " + new Gson().toJson(document));
        return document;
    }

    @PostMapping(value = "/approveack_confirm", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public Document approveackConfirm(@RequestBody DocumentInput input) {
        logger.info("approveack_confirm " + " request: " + new Gson().toJson(input));
        Document document = creditBankLoanService.finalConfirm(input);
        logger.info("approveack_confirm " + "response: " + new Gson().toJson(document));
        return document;
    }
}
