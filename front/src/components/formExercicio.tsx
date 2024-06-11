import React from 'react'
import { Label } from './ui/label'
import { Input } from './ui/input'
import { Button } from './ui/button'
import { Textarea } from './ui/textarea'

function formExercicio() {
  return (
    <form action="" className='w-[25%]'>
        <div className="flex flex-col justify-between gap-5">
          <div className="gap-1">
            <Label htmlFor="nome">Nome</Label>
            <Input type="text"/>
          </div>
          <div className="gap-1">
            <Label htmlFor="series">Séries</Label>
            <Input type="number"/>
          </div>
          <div className="gap-1">
            <Label htmlFor="rep">Repetições</Label>
            <Input type="number"/>
          </div>
          <div className="gap-1">
            <Label htmlFor="rep">Observações</Label>
            <Textarea />
          </div>
          <Button className="mt-4">Adicionar Exercício</Button>
        </div>
    </form>
  )
}

export default formExercicio