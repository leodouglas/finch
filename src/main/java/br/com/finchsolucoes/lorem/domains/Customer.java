package br.com.finchsolucoes.lorem.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

/**
 * Created by leodouglas on 23/12/15.
 */
@Document
public class Customer {

    @Id
    private String id;
    private String name;
    private String identityDocument;
    private String socialDocument;

    public Customer(String name, String identityDocument) {

        Assert.hasText(name, "Name must not be null or empty!");
        Assert.hasText(identityDocument, "Identity Document must not be null or empty!");

        this.name = name;
        this.identityDocument = identityDocument;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    public String getSocialDocument() {
        return socialDocument;
    }

    public void setSocialDocument(String socialDocument) {
        this.socialDocument = socialDocument;
    }
}
