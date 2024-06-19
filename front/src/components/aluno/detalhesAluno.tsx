import React from 'react'

import {
  Accordion,
  AccordionContent,
  AccordionItem,
  AccordionTrigger,
} from "@/components/ui/accordion"

interface propsAluno{
  nome:string,
  email:string,
  dataNascimento:string,
  professor?:string,
  nutricionista?:string
}

function detalhesAluno({nome,email,dataNascimento,professor,nutricionista} : propsAluno) {
  return (
    <div className='flex gap-[30rem]'>
      <div className='flex flex-col gap-3'>
        <h1 className='text-2xl'>{nome}</h1>
        <h3 className='text-md'>Email: {email}</h3>
        <h3 className='text-md'>Data de nascimento: {dataNascimento}</h3>
      </div>
      <Accordion type="single" collapsible>
        <AccordionItem value="professor">
          <AccordionTrigger>Professor</AccordionTrigger>
        <AccordionContent>
        {professor? (
          <p>{professor}</p>
        ) : (
          <p>Esse aluno não tem professor cadastrado!</p>
        )}
        </AccordionContent>
        </AccordionItem>
        <AccordionItem value="nutri">
          <AccordionTrigger>Nutricionista</AccordionTrigger>
        <AccordionContent>
        {nutricionista? (
          <p>{nutricionista}</p>
        ) : (
          <p>Esse nutricionista não tem professor cadastrado!</p>
        )}
        </AccordionContent>
        </AccordionItem>
      </Accordion>
    </div>
  )
}

export default detalhesAluno