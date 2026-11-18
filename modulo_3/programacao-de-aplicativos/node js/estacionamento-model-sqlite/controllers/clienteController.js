import { Cliente, Veiculo } from "../model/index.js";

class ClienteController {
    static async getAllClientes(req, res) {
        try {
            const clientes = await Cliente.findAll();
            res.status(200).json(clientes);
        } catch (error) {
            res.status(500).json({ error: "Erro ao listar clientes" });
        }
    }

    static async getClienteById(req, res) {
        const cliente = await Cliente.findByPk(req.params.id, {
            include: { model: Veiculo, as: "veiculos" }
        });
        if (!cliente) return res.status(404).json({ erro: "Cliente não encontrado" });
        res.status(200).json(cliente);
    }

    static async createCliente(req, res) {
        const cliente = await Cliente.create(req.body);
        res.status(201).json(cliente);
    }

    static async updateCliente(req, res) {
        const cliente = await Cliente.findByPk(req.params.id);
        if (!cliente) return res.status(404).json({ erro: "Cliente não encontrado" });
        await cliente.update(req.body);
        res.status(200).json(cliente);
    }

    static async deleteCliente(req, res) {
        const cliente = await Cliente.findByPk(req.params.id);
        if (!cliente) return res.status(404).json({ erro: "Cliente não encontrado" });
        await cliente.destroy();
        res.status(204).send();
    }
}

export default ClienteController;