import * as admin from 'firebase-admin'
import express, {Request, Response} from 'express'
import cors from 'cors'

const app = express()

// Inicializando o firebase
var serviceAccount = require("./app-services-5b5c2-firebase-adminsdk-svdea-07ece87d91.json")

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount)
})

const db = admin.firestore()

app.use(express.json())
app.use(cors())


// Listar todos
app.get('/servicos', async(req: Request, res: Response) => {
    const servicosRef = db.collection('servicos')
    const servicosDoc = await servicosRef.get()
    const servicos: any[] = []
    servicosDoc.docs.forEach(doc=>servicos.push({id: doc.id, ...doc.data()}))
    return res.status(200).json(servicos)
})


// Listar um
app.get('/servicos/:id', async(req: Request, res: Response) => {
    const {id} = req.params
    const servicoDoc = await db.collection('servicos').doc(id).get()
    const comentarioDoc = await db.collection('comentarios').where('idServico', '==', id).get()
    const comentarios = comentarioDoc.docs.map(doc=>({mensagem: doc.data().mensagem}))
    const servico = {id: servicoDoc.id, ...servicoDoc.data(), comentarios: comentarios}
    return res.status(200).json(servico)
})


// Adicionar serviço
app.post('/servicos/criar', async(req: Request, res: Response) => {
    const {titulo, descricao, orcamento, dataCadastro, dataLimite, situacao} = req.body
    const servico = {titulo, descricao, orcamento: Number(orcamento), dataCadastro, dataLimite, situacao}
    const resultado = await db.collection('servicos').add(servico)
    return res.status(201).json({id: resultado.id, ...servico})
})


// Alterar dados gerais
app.put('/servicos/alterar/:id', async(req: Request, res: Response) => {
    const {id} = req.params
    const dados = req.body
    await db.collection('servicos').doc(id).update(dados)
    return res.status(200).json({msg: "Dados atualizados"})
})


// Marcar como Concluído/Cancelado
app.put('/servicos/marcar/:id', async(req: Request, res: Response) => {
    const {id} = req.params
    const situacao = req.body
    await db.collection('servicos').doc(id).update(situacao)
    return res.status(200).json({msg: "Marcado com sucesso"})
})


// Incluir comentários
app.post('/servicos/comentar/:id', async(req: Request, res: Response) => {
    const {id} = req.params
    const servico = await db.collection('servicos').doc(id).get()
    const servicoDados = servico.data()
    const situacaoServico = servicoDados.situacao

    if (situacaoServico != "aberto") {
        return res.json({msg: "Não é possível comentar um serviço não aberto"})
    }
    const idServico = id
    const mensagem = req.body.mensagem
    const comentario = {idServico, mensagem}
    await db.collection('comentarios').add(comentario)
    return res.json({msg: "Comentado com sucesso"})    
})


// Deletar serviço
app.delete("/servicos/deletar/:id", async(req: Request, res: Response) => {
    const {id} = req.params
    await db.collection('servicos').doc(id).delete();
    return res.status(204).send()
})


//Listar profissional
app.get('/profissionais', async(req: Request, res: Response) => {
    const profissionaisRef = db.collection('profissionais')
    const profissionaisDoc = await profissionaisRef.get()
    const profissionais: any[] = []
    profissionaisDoc.docs.forEach(doc=>profissionais.push({id: doc.id, ...doc.data()}))
    return res.status(200).json(profissionais)
})


app.listen(4000, () => {
    console.log("App running *4000...")
})
