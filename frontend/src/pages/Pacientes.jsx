import React, { useEffect, useState } from 'react'
import api from '../services/api'
import '../styles/wellbeing.css'

export default function Pacientes() {
  const [list, setList] = useState([])
  const [search, setSearch] = useState("")
  const [form, setForm] = useState({ nome:'', email:'', dataNascimento:'' })
  const [editId, setEditId] = useState(null)

  const load = async () => {
    const { data } = await api.get('/pacientes')
    setList(data)
  }

  useEffect(() => { load() }, [])

  const save = async (e) => {
    e.preventDefault()
    try {
      if(editId){
        await api.put(`/pacientes/${editId}`, form)
      } else {
        await api.post('/pacientes', form)
      }
      setForm({ nome:'', email:'', dataNascimento:'' })
      setEditId(null)
      load()
    } catch(err){
      alert('Erro: ' + (err?.response?.data?.message || 'Falha ao salvar'))
    }
  }

  const delItem = async (id) => {
    if(!confirm('Excluir paciente?')) return
    await api.delete(`/pacientes/${id}`)
    load()
  }

  const edit = (p) => {
    setEditId(p.id)
    setForm({ nome:p.nome, email:p.email, dataNascimento:p.dataNascimento })
  }

  const filtered = list.filter(p =>
    p.nome.toLowerCase().includes(search.toLowerCase())
  )

  return (
    <div className="page-container">
      <h2 className="page-title">Pacientes</h2>

      {/* Busca */}
      <div className="search-box">
        <input
          placeholder="Buscar por nome..."
          value={search}
          onChange={e => setSearch(e.target.value)}
        />
      </div>

      {/* Formulário */}
      <div className="form-card">
        <form onSubmit={save} className="form-grid">
          <input required placeholder="Nome"
            value={form.nome}
            onChange={e => setForm({...form, nome:e.target.value})}
          />
          <input required type="email" placeholder="Email"
            value={form.email}
            onChange={e => setForm({...form, email:e.target.value})}
          />
          <input required type="date"
            value={form.dataNascimento}
            onChange={e => setForm({...form, dataNascimento:e.target.value})}
          />

          <button className="btn-save">
            {editId ? 'Atualizar' : 'Cadastrar'}
          </button>
        </form>
      </div>

      {/* Tabela */}
      <table className="table">
        <thead>
          <tr><th>ID</th><th>Nome</th><th>Email</th><th>Nascimento</th><th>Ações</th></tr>
        </thead>
        <tbody>
          {filtered.map(p => (
            <tr key={p.id}>
              <td>{p.id}</td><td>{p.nome}</td><td>{p.email}</td><td>{p.dataNascimento}</td>
              <td>
                <button className="btn-action btn-edit" onClick={() => edit(p)}>Editar</button>
                <button className="btn-action btn-delete" onClick={() => delItem(p.id)}>Excluir</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}
