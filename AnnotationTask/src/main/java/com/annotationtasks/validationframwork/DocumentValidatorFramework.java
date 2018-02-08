package com.annotationtasks.validationframwork;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.annotationtasks.models.Aadharcard;
import org.annotationtasks.models.IdentityProofDocuments;
import org.annotationtasks.models.PanCard;

import com.annotationtasks.exceptions.IdentityDocumentConsistencyException;
import com.annotationtasks.exceptions.InvalidAadharCardDetailsException;
import com.annotationtasks.exceptions.InvalidPanCardDetailsException;

/**
 * This Represents DocumentValidatorFramework it validates aadhar card, pan
 * card, and also checks consistency between those objects
 * 
 * @author hemanth kumar
 *
 */
public class DocumentValidatorFramework {

	private Validator validator;

	public void validateDocuments(IdentityProofDocuments identityProofDocuments) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
		validateFieldsForAadhar(identityProofDocuments.getAadharCard());
		validateFieldsForPanCard(identityProofDocuments.getPanCard());
		validateDocumentConsistency(identityProofDocuments);
	}

	private void validateFieldsForAadhar(Aadharcard aadharcard) {
		Set<ConstraintViolation<Aadharcard>> aadharCardValidations = validator.validate(aadharcard);
		if (!aadharCardValidations.isEmpty()) {
			throw new InvalidAadharCardDetailsException(
					"Aadhar card Details are invalid, contains Null or Empty Values");
		}
	}

	private void validateFieldsForPanCard(PanCard panCard) {
		Set<ConstraintViolation<PanCard>> panCardViolations = validator.validate(panCard);
		if (!panCardViolations.isEmpty()) {
			throw new InvalidPanCardDetailsException("PAN card Details are invalid, contains Null or Empty Values");
		}
	}

	private void validateDocumentConsistency(IdentityProofDocuments identityProofDocuments) {
		Set<ConstraintViolation<IdentityProofDocuments>> documentConsistencyValidations = validator
				.validate(identityProofDocuments);
		if (!documentConsistencyValidations.isEmpty()) {
			throw new IdentityDocumentConsistencyException("Inconsistency in Id proof documents");
		}
	}

}
