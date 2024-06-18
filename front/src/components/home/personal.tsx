/* eslint-disable react-hooks/rules-of-hooks */
import React from 'react'
import { buttonVariants } from '../ui/button'
import Link from 'next/link'
import CardAluno from '../cardAluno'
import { useGenerationStore } from '@/lib/state/stateManagament'

function personal() {
  const {lst_aluno} = useGenerationStore();
  return (
    <main className="h-[80vh] w-full py-5 px-7 bg-background">
    <div>
      <section className="grid grid-cols-2 gap-5 mb-8">
        {lst_aluno.map((aluno) =>{
          return <CardAluno key={aluno.nome} nome={aluno.nome} 
          email={aluno.email} data={aluno.data_nascimento} icon='/img/avatar-1.jpg'/>
        })}
      </section>
      <div className="flex gap-4">
        <Link href='/formAluno' className={buttonVariants({variant:'default'})}>Adicionar aluno</Link>
        <Link href='/exercicios' className={buttonVariants({variant:'default'})}>Exercícios</Link>
      </div>
      
    </div>
  </main>
  )
}

export default personal;