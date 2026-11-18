import { Router } from "express";
import VeiculoController from "../controllers/veiculoController.js";

const router = Router();

router.get("/", VeiculoController.listar);
router.get("/:id", VeiculoController.buscarPorId);
router.post("/", VeiculoController.criar);
router.put("/:id", VeiculoController.atualizar);
router.delete("/:id", VeiculoController.deletar);

export default router;