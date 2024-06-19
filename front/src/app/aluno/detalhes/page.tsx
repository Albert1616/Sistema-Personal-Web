/* eslint-disable react-hooks/rules-of-hooks */
'use client'

import React, { useState } from 'react'
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs"
import { Button } from '@/components/ui/button'
import Link from 'next/link'
import CardFicha from '@/components/fichaTreino/cardFicha'


function page() {
    const [isFicha, setIsFicha] = useState(true);
  return (
    <div className='h-[80vh] w-screen'>
 <Tabs defaultValue="ficha" className="w-full py-5 px-7">
        <TabsList>
            <TabsTrigger value="ficha">Ficha de treino</TabsTrigger>
            <TabsTrigger value="avaliacao">Avaliação física</TabsTrigger>
            <TabsTrigger value="dados">Dados</TabsTrigger>
        </TabsList>

        <TabsContent value="ficha" className='grid grid-cols-3'>
            {isFicha? (
                <CardFicha objetivo='Hipertrofia' data='30/06/2024'/>
            ):(
                <>
                    <h1>Nenhum treino cadastrado</h1>
                    <Button><Link href='/formTreino'>Adicionar treino</Link></Button>
                </>
            )}
                
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