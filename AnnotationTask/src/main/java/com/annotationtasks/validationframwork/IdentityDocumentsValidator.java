package com.annotationtasks.validationframwork;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.annotationtasks.models.Aadharcard;
import org.annotationtasks.models.IdentityProofDocuments;
import org.annotationtasks.models.PanCard;

/**
 * This is validator, which validates for consistency across
 * all documents
 * @author hemanth kumar
 *
 */
public class IdentityDocumentsValidator implements ConstraintValidator<IdentityDocumentsConsistency, IdentityProofDocuments>{

	@Override
	public boolean isValid(IdentityProofDocuments identityProofDocuments, ConstraintValidatorContext context) {
		Aadharcard aadharcard = identityProofDocuments.getAadharCard();
		PanCard panCard = identityProofDocuments.getPanCard();
		
		if(!aadharcard.getFirstname().equals(panCard.getFirstname())) {
			return false;
		}
		else if(!aadharcard.getLastname().equals(panCard.getLastname())) {
			return false;
		}
		else if(!aadharcard.getDateOfBirth().equals(panCard.getDateOfBirth())) {
			return false;
		}
		else {
			return true;
		}
	}

}
