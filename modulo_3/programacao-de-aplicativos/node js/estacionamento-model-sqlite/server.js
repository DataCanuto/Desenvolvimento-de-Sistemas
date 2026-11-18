import app from "./app.js";
import { sequelize } from "./model/index.js";

const PORT = 3000;

await sequelize.sync({ alter: true });
app.listen(PORT, () => {
    console.log(`Servidor rodando na porta ${PORT}`);
})