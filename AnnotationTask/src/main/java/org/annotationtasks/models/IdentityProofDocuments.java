package org.annotationtasks.models;

import com.annotationtasks.validationframwork.IdentityDocumentsConsistency;

/**
 * Wrapper class to hold documents for identity proof
 * 
 * @author hemanth kumar
 *
 */
@IdentityDocumentsConsistency
public class IdentityProofDocuments {

	private Aadharcard aadharCard;
	private PanCard panCard;

	public Aadharcard getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(Aadharcard aadharCard) {
		this.aadharCard = aadharCard;
	}

	public PanCard getPanCard() {
		return panCard;
	}

	public void setPanCard(PanCard panCard) {
		this.panCard = panCard;
	}

}
