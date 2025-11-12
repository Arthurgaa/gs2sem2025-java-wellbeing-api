import React from 'react'
import { createRoot } from 'react-dom/client'
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'
import App from './App.jsx'
import Pacientes from './pages/Pacientes.jsx'
import Registros from './pages/Registros.jsx'

createRoot(document.getElementById('root')).render(
  <BrowserRouter>
    <Routes>
      <Route element={<App />}>
        <Route path="/" element={<Navigate to="/pacientes" />} />
        <Route path="/pacientes" element={<Pacientes />} />
        <Route path="/registros" element={<Registros />} />
      </Route>
    </Routes>
  </BrowserRouter>
)
