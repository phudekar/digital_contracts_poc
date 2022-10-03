# POC to geneate HelloSign Contract from Html

To test the ContractGenerator following example can be used.

> Replace `HELLOSIGN_API_KEY` with your api key and `TEST_HTML` with any html having elements with id `sign-1` and `sign-2`.

>You can also refer to test HTML example in `app/src/test/java/hello_sign_poc/HtmlGeneratorTest.java`


```java
        ContractGenerator contractGenerator = new ContractGenerator(HELLOSIGN_API_KEY);
        final PdfGenerator pdfGenerator = new PdfGenerator();

        final ContractData contractData = new ContractData("Test Contract",
                new Contact("Jon Doe", "jon.doe@test.ai"), new Contact("Jane Doe", "jane.doe@test.com"));
        final byte[] data = pdfGenerator.generatePDF(TEST_HTML, contractData.getContractName() + "_" + Instant.now().getEpochSecond());

        final SignatureRequest response = contractGenerator.sendNewSignatureRequest(contractData, data,
                pdfGenerator.getBoxForId("sign-1"), pdfGenerator.getBoxForId("sign-2"));
```