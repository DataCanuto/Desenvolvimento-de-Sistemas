import sequelize from "../db/connection.js";
import Veiculo from "./veiculo.js";
import Cliente from "./cliente.js";

Cliente.hasMany(Veiculo, { foreignKey: "clienteId", as: "veiculos" });
Veiculo.belongsTo(Cliente, { foreignKey: "clienteId", as: "cliente" });

export { sequelize, Veiculo, Cliente };