<html>
<head>
    <title>Digital Contract</title>
    <#include "style.css">
</head>
<style>
</style>
<body>
<h1>This is a test Contract</h1>
<div class="terms">Terms and Conditions:
    Read carefully!
</div>

<div class="signer-position">
    <div class="signer">
        <div>Signer 1: [text|req|signer1|Label|UniqueId|letters_only|name]</div>
        <div>Email: [text|noreq|signer1|Label|UniqueId|email_address|email]</div>
        <div class="sign">Sign: [sig|req|signer1]</div>
        <div>Signed On: [date|req|signer1]</div>
    </div>
    <div class="signer">
        <div>Signer 2: [text|req|signer2|Label|UniqueId|letters_only|name]</div>
        <div>Email: [text|noreq|signer2|Label|UniqueId|email_address|email]</div>
        <div class="sign">Sign: [sig|req|signer2]</div>
        <div>Signed On: [date|req|signer2]</div>
    </div>
</div>

<div>
    <table>
        <caption>
            MEDIA AUTHORIZATION FORM
        </caption>
        <thead>
        <tr>
            <th scope="col">Market</th>
            <th scope="col">Format</th>
            <th scope="col">Digital Or Static</th>
            <th scope="col">Qty</th>
            <th scope="col">Total Media</th>
        </tr>
        </thead>
        <tbody>
        <#list lineItems as lineItem>
            <tr>
                <th scope="row">${lineItem.getMarket()}</th>
                <td>${lineItem.getFormat()}</td>
                <td>${lineItem.getDigitalOrStatic()}</td>
                <td>${lineItem.getQty()}</td>
                <td>${lineItem.getPrice()}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>

</body>
</html>
