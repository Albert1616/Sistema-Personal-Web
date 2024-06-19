/* eslint-disable react-hooks/rules-of-hooks */
'use client'

import React, { useState } from 'react'
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs"
import { Button } from '@/components/ui/button'
import Link from 'next/link'
import CardFicha from '@/components/fichaTreino/cardFicha'
import AvaliacaoFisica from '@/components/avaliacaoFisica/avaliacaoFisica'
import DetalhesAluno from '@/components/aluno/detalhesAluno'

const medidasFicticias = {
    peso: 75,
    altura: 180,
    peito: 95,
    bicepsDireito: 35,
    bicepsEsquerdo: 34,
    antebracoDireito: 28,
    antebracoEsquerdo: 27,
    cintura: 85,
    dorsal: 110,
    quadricepsDireito: 60,
    quadricepsEsquerdo: 59,
    panturrilhaDireito: 38,
    panturrilhaEsquerdo: 37,
};

function page() {
    const [isFicha, setIsFicha] = useState(true);
    const [isAvaliacao, setIsAvaliacao] = useState(true);

  return (
    <div className='h-[80vh] w-screen'>
 <Tabs defaultValue="ficha" className="w-full py-5 px-7">
        <TabsList className='text-white bg-tabsColor rounded-xl p-2'>
            <TabsTrigger value="ficha" className='bg-tabsColor rounded-xl'>Ficha de treino</TabsTrigger>
            <TabsTrigger value="avaliacao" className='bg-tabsColor rounded-xl'>Avaliação física</TabsTrigger>
            <TabsTrigger value="dados" className='bg-tabsColor rounded-xl'>Dados</TabsTrigger>
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
        <TabsContent value="avaliacao">
            {isAvaliacao?(
                <AvaliacaoFisica
                    {...medidasFicticias}
                />
            ):(
                <>
                    <h1>Nenhum treino cadastrado</h1>
                    <Button><Link href='/formTreino'>Adicionar treino</Link></Button>
                </>
            )}
            
        </TabsContent>
        <TabsContent value="dados">
            <DetalhesAluno nome='Matheus Albert da Silva Araujo' email='matheus@gmail.com' 
            dataNascimento='16/11/2002' professor='Albert'/>
        </TabsContent>
</Tabs>
    </div>
   

  )
}

export default page