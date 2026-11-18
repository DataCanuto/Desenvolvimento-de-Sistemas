import { Cliente, Veiculo } from "../model/index.js";

class VeiculoController {
    static async listar(req, res) {
        try {
            const veiculos = await Veiculo.findAll();
            res.status(200).json(veiculos);
        } catch (error) {
            res.status(500).json({ error: "Erro ao listar veiculos" });
        }
    }

    static async buscarPorId(req, res) {
        const veiculo = await Veiculo.findByPk(req.params.id, {
            include: { model: Veiculo, as: "veiculos" }
        });
        if (!veiculo) return res.status(404).json({ erro: "Veiculo não encontrado" });
        res.status(200).json(veiculo);
    }

    static async criar(req, res) {
        const veiculo = await Veiculo.create(req.body);
        res.status(201).json(veiculo);
    }

    static async atualizar(req, res) {
        const veiculo = await Veiculo.findByPk(req.params.id);
        if (!veiculo) return res.status(404).json({ erro: "Veiculo não encontrado" });
        await veiculo.update(req.body);
        res.status(200).json(veiculo);
    }

    static async deletar(req, res) {
        const veiculo = await Veiculo.findByPk(req.params.id);
        if (!veiculo) return res.status(404).json({ erro: "Veiculo não encontrado" });
        await veiculo.destroy();
        res.status(204).send();
    }
}

export default VeiculoController;