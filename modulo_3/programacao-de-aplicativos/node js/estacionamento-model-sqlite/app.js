import express from "express";
import routes from "./routes/index.js";

const app = express();
app.use(express.json());

app.get("/", (req, res) => {
    res.status(200).send("Sistema Funcionando");
})
app.use(routes);

app.use((err, req, res, next) => {
    console.error(err);
    res.status(500).json({ erro: err.message });
});

export default app;