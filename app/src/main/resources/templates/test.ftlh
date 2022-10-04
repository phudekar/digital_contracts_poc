<html>
<head>
    <title>Digital Contract</title>
</head>
<style>
    @page { size: letter landscape; margin: 1cm;}
    body { font-family: sans-serif; }
    .terms { height: 1000px; }
    .signer {
        margin-bottom: 40px;
    }
     .sign {
        height:40px;
        margin-top: 24px;
        margin-bottom: 12px;
        width: 400px;
        border-bottom: solid 1px black;
      }
</style>
<body>
<h1>This is a test Contract</h1>
<div class="terms">Terms and Conditions:
    Read carefully!
</div>

<p>
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
</p>

</body>
</html>