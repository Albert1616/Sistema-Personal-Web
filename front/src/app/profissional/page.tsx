import Profissional from '@/components/profissional/profissional'
import React from 'react'

function page() {
  return (
    <div className='h-screen pt-7 px-5'>
        <Profissional src='/img/avatar-1.jpg' funcao='Personal' nome='Matheus' numAlunos={100}/>
    </div>
  )
}

export default page