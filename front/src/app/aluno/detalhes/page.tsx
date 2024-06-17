import React from 'react'
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs"
import { Button } from '@/components/ui/button'
import Link from 'next/link'


function page() {
  return (
    <div className='h-[80vh] w-screen'>
 <Tabs defaultValue="account" className="w-[400px]">
        <TabsList>
            <TabsTrigger value="ficha">Ficha de treino</TabsTrigger>
            <TabsTrigger value="avaliacao">Avaliação física</TabsTrigger>
            <TabsTrigger value="dados">Dados</TabsTrigger>
        </TabsList>

        <TabsContent value="ficha">
            <h1>Nenhum treino cadastrado</h1>
            <Button><Link href='/formTreino'>Adicionar treino</Link></Button>
        </TabsContent>
        <TabsContent value="avalicao">
            <h1>Nenhum treino cadastrado</h1>
            <Button><Link href='/formTreino'>Adicionar treino</Link></Button>
        </TabsContent>
        <TabsContent value="dados">
            <h1>Dados do aluno</h1>
        </TabsContent>
</Tabs>
    </div>
   

  )
}

export default page