async function authenticateRequest() {
    try {
        const accounts = await ethereum.request({ method: 'eth_requestAccounts' });
        const account = accounts[0];

        const nonceResponse = await fetch("http://localhost:3000/getNonce");
        const { nonce } = await nonceResponse.json();


        const signature = await ethereum.request({
            //method: 'personal_sign',
            params: [nonce, account],
        });

        const responde = await fetch("http://localhost:3000/verify", {
            method: "POST",
            headers: {"Content-Type": "application/json",},
            body: JSON.stringify({ account, signature, nonce }),
        });

        const data = await responde.json();
        if (data.success) {
            document.getElementById("addressWallet").innerText = `Autenticazione riuscita per l'indirizzo: ${account}`;
        } else {
            document.getElementById("addressWallet").innerText = `Autenticazione fallita: ${data.message}`;
        }
    } catch (err) {
        console.error('Authentication request failed:', err);
        throw err;
    }
}