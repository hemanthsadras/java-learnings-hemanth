package org.annotationtasks;

import org.annotationtasks.models.Aadharcard;
import org.annotationtasks.models.IdentityProofDocuments;
import org.junit.Test;

import com.annotationtasks.documentservice.DocumentServiceFactory;
import com.annotationtasks.exceptions.InvalidAadharCardDetailsException;
import com.annotationtasks.validationframwork.DocumentValidatorFramework;

public class AadharCardValidationTest  {
	
	private DocumentServiceFactory documentServiceFactory = DocumentServiceFactory.getInstance();
	private DocumentValidatorFramework validationFramework = new DocumentValidatorFramework();
	
	
	@Test
	public void aadharCardTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		validationFramework.validateDocuments(identityDocuments);
	}
	
	@Test(expected=InvalidAadharCardDetailsException.class)
	public void aadharCardFirstNameEmptyTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		Aadharcard aadharCard = identityDocuments.getAadharCard();
		aadharCard.setFirstname("");
		validationFramework.validateDocuments(identityDocuments);
	}
	
	@Test(expected=InvalidAadharCardDetailsException.class)
	public void aadharCardLastNameEmptyTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		Aadharcard aadharCard = identityDocuments.getAadharCard();
		aadharCard.setLastname("");
		validationFramework.validateDocuments(identityDocuments);
	}
	
	@Test(expected=InvalidAadharCardDetailsException.class)
	public void aadharCardFirstNameNullTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		Aadharcard aadharCard = identityDocuments.getAadharCard();
		aadharCard.setFirstname(null);
		validationFramework.validateDocuments(identityDocuments);
	}
	
	@Test(expected=InvalidAadharCardDetailsException.class)
	public void aadharCardLastNameNullTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		Aadharcard aadharCard = identityDocuments.getAadharCard();
		aadharCard.setLastname(null);
		validationFramework.validateDocuments(identityDocuments);
	}
	
	@Test(expected=InvalidAadharCardDetailsException.class)
	public void aadharCardAddressEmptyTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		Aadharcard aadharCard = identityDocuments.getAadharCard();
		aadharCard.setAddress("");
		validationFramework.validateDocuments(identityDocuments);
	}
	
	@Test(expected=InvalidAadharCardDetailsException.class)
	public void aadharCardAddressNullTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		Aadharcard aadharCard = identityDocuments.getAadharCard();
		aadharCard.setAddress(null);
		validationFramework.validateDocuments(identityDocuments);
	}
	
	

}
