package org.annotationtasks;

import org.annotationtasks.models.IdentityProofDocuments;
import org.annotationtasks.models.PanCard;
import org.junit.Test;

import com.annotationtasks.documentservice.DocumentServiceFactory;
import com.annotationtasks.exceptions.InvalidPanCardDetailsException;
import com.annotationtasks.validationframwork.DocumentValidatorFramework;

public class PanCardValidationTest {

	private DocumentServiceFactory documentServiceFactory = DocumentServiceFactory.getInstance();
	private DocumentValidatorFramework validationFramework = new DocumentValidatorFramework();
	
	@Test
	public void panCardTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		validationFramework.validateDocuments(identityDocuments);
	}
	
	@Test(expected=InvalidPanCardDetailsException.class)
	public void panCardCardFirstNameEmptyTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		PanCard panCard = identityDocuments.getPanCard();
		panCard.setFirstname("");
		validationFramework.validateDocuments(identityDocuments);
	}
	
	@Test(expected=InvalidPanCardDetailsException.class)
	public void panCardLastNameEmptyTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		PanCard panCard = identityDocuments.getPanCard();
		panCard.setLastname("");
		validationFramework.validateDocuments(identityDocuments);
	}
	
	@Test(expected=InvalidPanCardDetailsException.class)
	public void panCardFirstNameNullTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		PanCard panCard = identityDocuments.getPanCard();
		panCard.setFirstname(null);
		validationFramework.validateDocuments(identityDocuments);
	}
	
	@Test(expected=InvalidPanCardDetailsException.class)
	public void panCardLastNameNullTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		PanCard panCard = identityDocuments.getPanCard();
		panCard.setLastname(null);
		validationFramework.validateDocuments(identityDocuments);
	}
	
	@Test(expected=InvalidPanCardDetailsException.class)
	public void panCardFatherNameEmptyTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		PanCard panCard = identityDocuments.getPanCard();
		panCard.setFatherName("");
		validationFramework.validateDocuments(identityDocuments);
	}
	
	@Test(expected=InvalidPanCardDetailsException.class)
	public void panCardFatherNameNullTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		PanCard panCard = identityDocuments.getPanCard();
		panCard.setFatherName(null);
		validationFramework.validateDocuments(identityDocuments);
	}

}
