import { DataTypes } from "sequelize";
import sequelize from "../db/connection.js";

const Livro = sequelize.define("Livro",{
    isbn:{type:DataTypes.STRING, allowNull: false},
    titulo:{type:DataTypes.STRING, allowNull: false},
    autor:{type:DataTypes.STRING, allowNull: false} 
});

export default Livro;