/* eslint-disable react-hooks/rules-of-hooks */
import React, { useState } from 'react'

import { Avatar, AvatarFallback, AvatarImage } from '../ui/avatar'
import { Tabs, TabsContent, TabsList, TabsTrigger } from '../ui/tabs';
import CardFicha from '../fichaTreino/cardFicha';
import { Button } from '../ui/button';
import Link from 'next/link';
import AvaliacaoFisica from '../avaliacaoFisica/avaliacaoFisica';
import DetalhesAluno from '../aluno/detalhesAluno';
import Dieta from '../dieta/dieta';
import { FaExternalLinkAlt } from 'react-icons/fa';

function aluno() {

  const [isPersonal, setIsPersonal] = useState(true);
  const [isNutri, setIsNutri] = useState(true);
  const [isFicha, setIsFicha] = useState(true);
  const [isAvaliacao, setIsAvalicao] = useState(true);

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
  return (
    <div className='h-screen pt-5 px-7 grid grid-cols-3'>
      <div className='w-full flex flex-col gap-2'>
        <Avatar className='w-[15rem] h-[15rem]'>
          <AvatarImage src='/img/avatar-1.jpg' />
          <AvatarFallback>Aluno</AvatarFallback>
        </Avatar>
        <h1 className='text-2xl'>Matheus Albert da Silva Araújo</h1>
        <h1 className='text-xl'>Email: matheus@email.com</h1>
      <h3 className='text-xl flex items-center gap-2'>Professor:
        {isPersonal?(
          <Link href='/profissional' className='text-lg flex items-center gap-2'>Albert <FaExternalLinkAlt size={15}/></Link>
        ) :(
          <span className='text-lg'>você ainda não tem um personal!</span>
        )}
      </h3>
      <h3 className='text-xl flex items-center gap-2'>Nutricionista:
        {isNutri?(
          <Link href='/profissional' className='text-lg flex items-center gap-2'>Albert <FaExternalLinkAlt size={15}/></Link>
        ) :(
          <span className='text-lg'>você ainda não tem uma nutricionista!</span>
        )}
      </h3>
      </div>
      <div className='w-full col-span-2'>
      <Tabs defaultValue="ficha" className="w-full py-5 px-7">
        <TabsList className='text-white bg-tabsColor rounded-xl p-2'>
            <TabsTrigger value="ficha" className='bg-tabsColor rounded-xl'>Ficha de treino</TabsTrigger>
            <TabsTrigger value="avaliacao" className='bg-tabsColor rounded-xl'>Avaliação física</TabsTrigger>
            <TabsTrigger value="dieta" className='bg-tabsColor rounded-xl'>Dieta</TabsTrigger>
        </TabsList>

        <TabsContent value="ficha" className='grid grid-cols-2'>
            {isFicha? (
                <CardFicha objetivo='Hipertrofia' data='30/06/2024'/>
            ):(
                <>
                    <h1>Nenhum treino cadastrado</h1>
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
                </>
            )}
            
        </TabsContent>
        <TabsContent value="dieta">
            {isNutri?(
                <Dieta />
            ):(
                <>
                    <h1>Nenhuma dieta cadastrada</h1>
                </>
            )}
            
        </TabsContent>
</Tabs>
      </div>
    </div>
    
  )
}

export default aluno