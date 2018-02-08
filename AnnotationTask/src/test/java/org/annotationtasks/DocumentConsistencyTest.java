package org.annotationtasks;

import java.time.LocalDate;

import org.annotationtasks.models.Aadharcard;
import org.annotationtasks.models.IdentityProofDocuments;
import org.annotationtasks.models.PanCard;
import org.junit.Test;

import com.annotationtasks.documentservice.DocumentServiceFactory;
import com.annotationtasks.exceptions.IdentityDocumentConsistencyException;
import com.annotationtasks.validationframwork.DocumentValidatorFramework;

public class DocumentConsistencyTest {
	private DocumentServiceFactory documentServiceFactory = DocumentServiceFactory.getInstance();
	private DocumentValidatorFramework validationFramework = new DocumentValidatorFramework();
	
	@Test
	public void documentConsistencyTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		validationFramework.validateDocuments(identityDocuments);
	}
	
	@Test(expected=IdentityDocumentConsistencyException.class)
	public void firstNameNotMatchingTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		PanCard panCard = identityDocuments.getPanCard();
		panCard.setFirstname("changedFirstName");
		validationFramework.validateDocuments(identityDocuments);
	}
	
	@Test(expected=IdentityDocumentConsistencyException.class)
	public void lastNameNotMatchingTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		PanCard panCard = identityDocuments.getPanCard();
		panCard.setLastname("changedLastName");
		validationFramework.validateDocuments(identityDocuments);
	}
	
	@Test(expected=IdentityDocumentConsistencyException.class)
	public void dateOfBirthNotMatchingTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		PanCard panCard = identityDocuments.getPanCard();
		panCard.setDateOfBirth(LocalDate.of(2000, 2, 23));
		validationFramework.validateDocuments(identityDocuments);
	}
	
	@Test(expected=IdentityDocumentConsistencyException.class)
	public void firstNameLastNameNotMatchingTest() {
		IdentityProofDocuments identityDocuments = documentServiceFactory.getIdentityDocuments();
		PanCard panCard = identityDocuments.getPanCard();
		panCard.setLastname("changedLastName");
		panCard.setFirstname("changedFirstName");
		Aadharcard aadharCard = identityDocuments.getAadharCard();
	    aadharCard.setLastname("anotherLastname");
	    aadharCard.setFirstname("anotherChangedFirstname");
		validationFramework.validateDocuments(identityDocuments);
	}

}
