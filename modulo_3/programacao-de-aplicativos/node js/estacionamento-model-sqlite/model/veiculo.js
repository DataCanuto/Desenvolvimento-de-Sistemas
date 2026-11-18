import { DataTypes } from "sequelize";
import sequelize from "../db/connection.js";

const Veiculo = sequelize.define("Veiculo", {
    modelo: { type: DataTypes.STRING, allowNull: false },
    marca: { type: DataTypes.STRING, allowNull: false },
    placa: { type: DataTypes.STRING, allowNull: false, unique: true },
    ano: { type: DataTypes.STRING, allowNull: false },
    valorDiaria: { type: DataTypes.FLOAT, allowNull: false },
    disponivel: { type: DataTypes.BOOLEAN, allowNull: false, defaultValue: true }
});

export default Veiculo;