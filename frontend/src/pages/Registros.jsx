import React, { useEffect, useState } from 'react'
import api from '../services/api'
import '../styles/wellbeing.css'

export default function Registros(){
  const [list, setList] = useState([])
  const [pacientes, setPacientes] = useState([])
  const [search, setSearch] = useState("")
  const [form, setForm] = useState({
    dataRegistro:'', nivelHumor:3, nivelAnsiedade:5, horasSono:7, pacienteId:''
  })
  const [editId, setEditId] = useState(null)

  const load = async ()=>{
    const a = await api.get('registros-diarios'); setList(a.data)
    const b = await api.get('pacientes'); setPacientes(b.data)
  }

  useEffect(()=>{ load() },[])

  const save = async (e)=>{
    e.preventDefault()
    try{
      if(editId){
        await api.put(`registros-diarios/${editId}`, form)
      } else {
        await api.post('registros-diarios', form)
      }
      setForm({ dataRegistro:'', nivelHumor:3, nivelAnsiedade:5, horasSono:7, pacienteId:'' })
      setEditId(null)
      load()
    }catch(err){
      alert('Erro: ' + (err?.response?.data?.message || 'Falha ao salvar'))
    }
  }

  const delItem = async (id)=>{
    if(!confirm('Excluir registro?')) return
    await api.delete(`registros-diarios/${id}`)
    load()
  }

  const edit = (r)=>{
    setEditId(r.id)
    setForm({
      dataRegistro:r.dataRegistro,
      nivelHumor:r.nivelHumor,
      nivelAnsiedade:r.nivelAnsiedade,
      horasSono:r.horasSono,
      pacienteId:r.pacienteId
    })
  }

  const filtered = list.filter(r =>
      r.pacienteNome.toLowerCase().includes(search.toLowerCase())
  )

  return (
    <div className="page-container">
      <h2 className="page-title">Registros Diários</h2>

      {/* Busca */}
      <div className="search-box">
        <input
          placeholder="Buscar por paciente..."
          value={search}
          onChange={e => setSearch(e.target.value)}
        />
      </div>

      {/* Formulário */}
      <div className="form-card">
        <form onSubmit={save} className="form-grid">
          <input required type="date"
            value={form.dataRegistro}
            onChange={e=>setForm({...form, dataRegistro:e.target.value})}
          />
          <input required type="number" min="1" max="5"
            value={form.nivelHumor}
            onChange={e=>setForm({...form, nivelHumor:Number(e.target.value)})}
          />
          <input required type="number" min="0" max="10"
            value={form.nivelAnsiedade}
            onChange={e=>setForm({...form, nivelAnsiedade:Number(e.target.value)})}
          />
          <input required type="number" min="0" max="24"
            value={form.horasSono}
            onChange={e=>setForm({...form, horasSono:Number(e.target.value)})}
          />
          <select required value={form.pacienteId}
            onChange={e=>setForm({...form, pacienteId:Number(e.target.value)})}
          >
            <option value="" disabled>Paciente...</option>
            {pacientes.map(p=>(<option key={p.id} value={p.id}>{p.nome}</option>))}
          </select>

          <button className="btn-save">
            {editId ? 'Atualizar' : 'Cadastrar'}
          </button>
        </form>
      </div>

      {/* Tabela */}
      <table className="table">
        <thead>
          <tr><th>ID</th><th>Data</th><th>Humor</th><th>Ansiedade</th><th>Sono</th><th>Paciente</th><th>Ações</th></tr>
        </thead>
        <tbody>
          {filtered.map(r => (
            <tr key={r.id}>
              <td>{r.id}</td>
              <td>{r.dataRegistro}</td>
              <td>{r.nivelHumor}</td>
              <td>{r.nivelAnsiedade}</td>
              <td>{r.horasSono}</td>
              <td>{r.pacienteNome}</td>
              <td>
                <button className="btn-action btn-edit" onClick={() => edit(r)}>Editar</button>
                <button className="btn-action btn-delete" onClick={() => delItem(r.id)}>Excluir</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}
