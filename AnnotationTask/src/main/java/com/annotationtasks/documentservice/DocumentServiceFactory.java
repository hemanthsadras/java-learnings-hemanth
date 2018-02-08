package com.annotationtasks.documentservice;

import java.time.LocalDate;

import org.annotationtasks.models.Aadharcard;
import org.annotationtasks.models.IdentityProofDocuments;
import org.annotationtasks.models.PanCard;

/**
 * DocumentServiceFactory is responsible for creating data
 * for the document validation framework to validate.
 * This is a dummy service for testing
 * @author hemanth kumar
 *
 */
public class DocumentServiceFactory {
	
	private static DocumentServiceFactory INSTANCE;
	
	private DocumentServiceFactory() {
		// singleton
	}
	
	public static DocumentServiceFactory getInstance() {
		if(INSTANCE == null) {
			return new DocumentServiceFactory();
		}
		else {
			return INSTANCE;
		}
	}
	
	
	
	public IdentityProofDocuments getIdentityDocuments() {
		
		IdentityProofDocuments documents = new IdentityProofDocuments();
        documents.setAadharCard(getAadharCard());
        documents.setPanCard(getPanCard());
        return documents;
	}

	private PanCard getPanCard() {
		 PanCard pancard = new PanCard();
	     pancard.setFirstname("hemanth");
	     pancard.setLastname("kumar");
	     pancard.setDateOfBirth(LocalDate.of(1991,10,20));
	     pancard.setPanNumber("abcd");
	     pancard.setFatherName("rajan");	     
	     return pancard;
	}

	private Aadharcard getAadharCard() {
		Aadharcard aadhar = new Aadharcard();
        aadhar.setAadharId("abcd");
        aadhar.setAddress("add");
        aadhar.setDateOfBirth(LocalDate.of(1991,10,20));
        aadhar.setFirstname("hemanth");
        aadhar.setLastname("kumar");   
        return aadhar;
	}

}
