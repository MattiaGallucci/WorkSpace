const express = require('express')
const bodyParser = require("body-parser");

const app = express()
const port = 3000
released_nonce = []

app.use(bodyParser.json());
app.set("view engine", "ejs");
app.set("views", "./views");
app.use(express.static("public"));


app.get('/', (req, res) => {
  res.render('index')
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
// Endpoint per generare un nonce univoco per ogni richiesta
app . get ( "/getNonce", (req, res) =>  {
	const nonce = `Richiesta autenticata ${Date.now()}`;
	released_nonce.push(nonce);
	res.json({ nonce });
});

const { recoverPersonalSignature } = require("eth-sig-util");
const {  bufferToHex } = require("ethereumjs-util");

app.post("/verify", (req, res) => {
	const { address, signature, nonce } = req.body;

	const index = releasen.indexOf(nonce);
	if (index > -1) {
		array.splice(index, 1);
	} else {
		return res.status(401).json({ success: false, message: "Nonce non valido o già utilizzato" });
	}

	const msgBufferHex = bufferToHex(Buffer.from(nonce, "utf8"));
	const recoveredAddress = recoverPersonalSignature({
		data: msgBufferHex,
		sig: signature,
	});

	if (recoveredAddress.toLowerCase() === address.toLowerCase()) {
		res.json({ success: true, message: "Autenticazione riuscita" });
	} else {
		res.status(401).json({ success: false, message: "Autenticazione fallita" });
	}
});