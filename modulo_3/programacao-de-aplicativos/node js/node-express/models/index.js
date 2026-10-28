import sequelize from "../db/connection.js";
import Livro from "./livro.js";
import Autor from "./autor.js";

Autor.hasMany(Livro);
Livro.belongsTo(Autor);

export {sequelize, Livro, Autor};