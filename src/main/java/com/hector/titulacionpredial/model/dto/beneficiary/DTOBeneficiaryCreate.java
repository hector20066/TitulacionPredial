package com.hector.titulacionpredial.model.dto.beneficiary;

import com.hector.titulacionpredial.model.dto.DTOBeneficiary;

/**
 *
 * @author hectoracevedo
 */
public class DTOBeneficiaryCreate extends DTOBeneficiary {

    private long id;
    private String fullName;
    private String expeditionLocation;
    private String cadastralReference;

    public DTOBeneficiaryCreate() {
        super();
    }

    public DTOBeneficiaryCreate(AbstractBuilder<?> builder) {
        super(builder);
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.expeditionLocation = builder.expeditionLocation;
        this.cadastralReference = builder.cadastralReference;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setExpeditionLocation(String expeditionLocation) {
        this.expeditionLocation = expeditionLocation;
    }

    public void setCadastralReference(String cadastralReference) {
        this.cadastralReference = cadastralReference;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getExpeditionLocation() {
        return expeditionLocation;
    }

    public String getCadastralReference() {
        return cadastralReference;
    }

    public abstract static class AbstractBuilder<T extends AbstractBuilder<T>> extends DTOBeneficiary.Builder<T> {

        private long id;
        private String fullName;
        private String expeditionLocation;
        private String cadastralReference;

        public T id(long id) {
            this.id = id;
            return self();
        }

        public T fullName(String fullName) {
            this.fullName = fullName;
            return self();
        }

        public T expeditionLocation(String expeditionLocation) {
            this.expeditionLocation = expeditionLocation;
            return self();
        }

        public T cadastralReference(String cadastralReference) {
            this.cadastralReference = cadastralReference;
            return self();
        }

    }

    public static class Builder extends AbstractBuilder<Builder> {

        @Override
        public DTOBeneficiaryCreate build() {
            return new DTOBeneficiaryCreate(this);
        }

    }

}
