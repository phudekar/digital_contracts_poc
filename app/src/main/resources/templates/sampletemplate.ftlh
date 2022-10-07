<html>
<head>
    <title>Digital Contract</title>
    <#include "style.css">
</head>
<style>
</style>
<body>
<div class="content">
    <div class="header">
        <div class="logo">
            <img src="images/mcd.png" height="50px" width="75px"></img>
        </div>
        <div class="header-details">
            <div class="header-id">SomeId:
                <span style="font-weight: normal;">12345</span>
            </div>
            <div class="header-date">Date:
                <span style="font-weight: normal;">12/12/2022</span>
            </div>
        </div>
    </div>
    <div class="maf">
        <div class="maf-header">MEDIA AUTHORIZATION FORM</div>
        <table class="maf-table">
            <tr>
                <td class="maf-cell-header">Agency:</td>
                <td >SomeAgency</td>
                <td class="maf-cell-header">Advertiser:</td>
                <td >TEST</td>
                <td class=" maf-cell-header">Client Reference#:</td>
                <td >123</td>
            </tr>
            <tr>
                <td class="maf-cell-header">Agency Contact:</td>
                <td >Name and Email</td>
                <td class="maf-cell-header">Brand</td>
                <td >BrandName</td>
                <td class="maf-cell-header">Timing</td>
                <td >1/1/2022 12/1/2022</td>
            </tr>
            <tr>
                <td class="maf-cell-header">Contact</td>
                <td >SomeContact</td>
                <td ></td>
                <td ></td>
                <td ></td>
                <td ></td>
            </tr>
        </table>
        <div style="height: 30px"></div>
        <table class="maf-table">
            <thead>
            <tr>
                <th>Market</th>
                <th>Format</th>
                <th>Digital Or Static</th>
                <th>Qty</th>
                <th>Total Media</th>
            </tr>
            </thead>
            <#list lineItems as lineItem>
                <tr>
                    <td>${lineItem.getMarket()}</td>
                    <td>${lineItem.getFormat()}</td>
                    <td>${lineItem.getDigitalOrStatic()}</td>
                    <td>${lineItem.getQty()}</td>
                    <td>${lineItem.getPrice()}</td>
                </tr>
            </#list>
        </table>
    </div>
    <table class="signer-position">
        <tr class="signer">
            <td>
                <div>Signer 1: [text|req|signer1|Label|UniqueId|letters_only|name]</div>
                <div>Email: [text|noreq|signer1|Label|UniqueId|email_address|email]</div>
                <div class="sign">Sign: [sig|req|signer1]</div>
                <div>Signed On: [date|req|signer1]</div>
            </td>
            <td>
                <div>Signer 2: [text|req|signer2|Label|UniqueId|letters_only|name]</div>
                <div>Email: [text|noreq|signer2|Label|UniqueId|email_address|email]</div>
                <div class="sign">Sign: [sig|req|signer2]</div>
                <div>Signed On: [date|req|signer2]</div>
            </td>
        </tr>
    </table>
    <div class="terms">
        <h1> Terms and Conditions: Read carefully!</h1>
        <p>
            Apache License
            Version 2.0, January 2004
            http://www.apache.org/licenses/
        </p>
        <p>
            TERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION<br>
            <br>
            1. Definitions.<br>
            <br>
            "License" shall mean the terms and conditions for use, reproduction,<br>
            and distribution as defined by Sections 1 through 9 of this document.<br>
            <br>
            "Licensor" shall mean the copyright owner or entity authorized by<br>
            the copyright owner that is granting the License.<br>
            <br>
            "Legal Entity" shall mean the union of the acting entity and all<br>
            other entities that control, are controlled by, or are under common<br>
            control with that entity. For the purposes of this definition,<br>
            "control" means (i) the power, direct or indirect, to cause the<br>
            direction or management of such entity, whether by contract or<br>
            otherwise, or (ii) ownership of fifty percent (50%) or more of the<br>
            outstanding shares, or (iii) beneficial ownership of such entity.<br>
            <br>
            "You" (or "Your") shall mean an individual or Legal Entity<br>
            exercising permissions granted by this License.<br>
            <br>
            "Source" form shall mean the preferred form for making modifications,<br>
            including but not limited to software source code, documentation<br>
            source, and configuration files.<br>
            <br>
            "Object" form shall mean any form resulting from mechanical<br>
            transformation or translation of a Source form, including but<br>
            not limited to compiled object code, generated documentation,<br>
            and conversions to other media types.<br>
            <br>
            "Work" shall mean the work of authorship, whether in Source or<br>
            Object form, made available under the License, as indicated by a<br>
            copyright notice that is included in or attached to the work<br>
            (an example is provided in the Appendix below).<br>
            <br>
            "Derivative Works" shall mean any work, whether in Source or Object<br>
            form, that is based on (or derived from) the Work and for which the<br>
            editorial revisions, annotations, elaborations, or other modifications<br>
            represent, as a whole, an original work of authorship. For the purposes<br>
            of this License, Derivative Works shall not include works that remain<br>
            separable from, or merely link (or bind by name) to the interfaces of,<br>
            the Work and Derivative Works thereof.<br>
            <br>
            "Contribution" shall mean any work of authorship, including<br>
            the original version of the Work and any modifications or additions<br>
            to that Work or Derivative Works thereof, that is intentionally<br>
            submitted to Licensor for inclusion in the Work by the copyright owner<br>
            or by an individual or Legal Entity authorized to submit on behalf of<br>
            the copyright owner. For the purposes of this definition, "submitted"<br>
            means any form of electronic, verbal, or written communication sent<br>
            to the Licensor or its representatives, including but not limited to<br>
            communication on electronic mailing lists, source code control systems,<br>
            and issue tracking systems that are managed by, or on behalf of, the<br>
            Licensor for the purpose of discussing and improving the Work, but<br>
            excluding communication that is conspicuously marked or otherwise<br>
            designated in writing by the copyright owner as "Not a Contribution."<br>
            <br>
            "Contributor" shall mean Licensor and any individual or Legal Entity<br>
            on behalf of whom a Contribution has been received by Licensor and<br>
            subsequently incorporated within the Work.<br>
            <br>
            2. Grant of Copyright License. Subject to the terms and conditions of<br>
            this License, each Contributor hereby grants to You a perpetual,<br>
            worldwide, non-exclusive, no-charge, royalty-free, irrevocable<br>
            copyright license to reproduce, prepare Derivative Works of,<br>
            publicly display, publicly perform, sublicense, and distribute the<br>
            Work and such Derivative Works in Source or Object form.<br>
        </p>
    </div>
</div>
</body>
</html>
