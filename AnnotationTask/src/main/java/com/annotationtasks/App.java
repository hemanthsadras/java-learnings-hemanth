package com.annotationtasks;

import org.annotationtasks.models.IdentityProofDocuments;

import com.annotationtasks.documentservice.DocumentServiceFactory;
import com.annotationtasks.validationframwork.DocumentValidatorFramework;

/**
 * Application to test the document validation functionality
 * @author hemanth kumar
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DocumentServiceFactory documentServiceFactory = DocumentServiceFactory.getInstance();
        IdentityProofDocuments idProofDocuments = documentServiceFactory.getIdentityDocuments();
        DocumentValidatorFramework documentValidatorFramework = new DocumentValidatorFramework();
        documentValidatorFramework.validateDocuments(idProofDocuments);
        System.out.println("Documents are validated Successfully");
        
        
    }
}
