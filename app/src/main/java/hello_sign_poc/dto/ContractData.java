package hello_sign_poc.dto;

public class ContractData {

    public String getContractName() {
        return contractName;
    }

    public Contact getFirstContact() {
        return firstContact;
    }

    public Contact getSecondContact() {
        return secondContact;
    }

    private final String contractName;
    private final Contact firstContact;
    private final Contact secondContact;

    public ContractData(final String contractName,
                        final Contact firstContact, final Contact secondContact) {

        this.contractName = contractName;
        this.firstContact = firstContact;
        this.secondContact = secondContact;
    }
}
