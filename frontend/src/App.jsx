import React from 'react'
import { Link, Outlet, useLocation } from 'react-router-dom'

export default function App(){
  const { pathname } = useLocation()
  return (
    <div style={{fontFamily:'Inter, system-ui', maxWidth: 980, margin: '0 auto', padding: 16}}>
      <h1>Wellbeing – Saúde Mental</h1>
      <nav style={{display:'flex', gap:12, marginBottom:16}}>
        <Link to="/pacientes" style={{fontWeight: pathname.startsWith('/pacientes')?'700':'400'}}>Pacientes</Link>
        <Link to="/registros" style={{fontWeight: pathname.startsWith('/registros')?'700':'400'}}>Registros Diários</Link>
      </nav>
      <Outlet />
    </div>
  )
}
