import { DataTypes } from "sequelize";
import sequelize from "../db/connection.js";

const Cliente = sequelize.define("Cliente", {
    nome: { type: DataTypes.STRING, allowNull: false },
    cpf: { type: DataTypes.STRING, allowNull: false, unique: true },
    telefone: { type: DataTypes.STRING, allowNull: false },
    email: { type: DataTypes.STRING, allowNull: false, unique: true }
});

export default Cliente;