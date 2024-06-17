import React from 'react'
import { Button } from '../ui/button'
import Link from 'next/link'
import CardAluno from '../cardAluno'

function personal() {
  return (
    <main className="h-[80vh] w-full py-5 px-7 bg-background">
    <div>
      <section className="grid grid-cols-2 gap-5 mb-8">
        <CardAluno nome="Matheus Albert" email="teste@gmail.com" data="10/11/2002"
        icon="/img/avatar-1.jpg"/>
        <CardAluno nome="Matheus Albert" email="teste@gmail.com" data="10/11/2002"
        icon="/img/avatar-2.jpg"/>
      </section>
      <div className="flex gap-4">
        <Button className="bg-ButtonColor p-4 text-white rounded-sm hover:bg-ButtonHoverColor">
          <Link href='/formAluno'>Adicionar aluno</Link>
        </Button>

        <Button className="bg-ButtonColor p-4 rounded-sm text-white hover:bg-ButtonHoverColor">
          <Link href='/exercicios'>Exercícios</Link>
        </Button>
      </div>
      
    </div>
  </main>
  )
}

export default personal;