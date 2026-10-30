import { DataTypes } from "sequelize";
import sequelize from "../db/connection.js";

const Autor = sequelize.define("Autor",{
    nome:{type:DataTypes.STRING, allowNull: false}
});

export default Autor;