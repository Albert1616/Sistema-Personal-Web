/* eslint-disable react-hooks/rules-of-hooks */
'use client'

import CardExercicio from '@/components/exercicio/cardExercicio';
import { Button } from '@/components/ui/button';
import Link from 'next/link';
import React, { useState } from 'react'
import { MdAssignmentAdd, MdHome } from "react-icons/md";


function page() {
const [exercicios, setExercicios] = useState([]);
  return (
    <div className='h-screen py-8 px-5'>
        <h1 className='text-3xl'>Exercícios</h1>
        {/* {exercicios.length > 0 ? (
            exercicios.map(exercicio => {
                return <p key={exercicio}>{exercicio}</p>
            })
        ) : (
            <p>Não Há exercícios cadastrados!</p>
        )} */}
        <div className='grid grid-cols-3 gap-8 mt-8'>
            <CardExercicio nome='Supino reto' musculo='peito' gift='https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgOjlvl2L7pFHcoTsObm2BdUsbDW-nll8QZ_Y9rzcpfVyiX-0xgN_OHYACirCN3MxVDEWRkDwFnIm2rWCPkE1IguCut012dLxq8_wPgPh-FY8rx7dVaQrd3FeCcrubxR2njnvYrbhEpbdb4/s1600/Barbell-Bench-press.gif'/>
            <CardExercicio nome='Supino reto' musculo='peito' gift='https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgOjlvl2L7pFHcoTsObm2BdUsbDW-nll8QZ_Y9rzcpfVyiX-0xgN_OHYACirCN3MxVDEWRkDwFnIm2rWCPkE1IguCut012dLxq8_wPgPh-FY8rx7dVaQrd3FeCcrubxR2njnvYrbhEpbdb4/s1600/Barbell-Bench-press.gif'/>
            <CardExercicio nome='Supino reto' musculo='peito' gift='https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgOjlvl2L7pFHcoTsObm2BdUsbDW-nll8QZ_Y9rzcpfVyiX-0xgN_OHYACirCN3MxVDEWRkDwFnIm2rWCPkE1IguCut012dLxq8_wPgPh-FY8rx7dVaQrd3FeCcrubxR2njnvYrbhEpbdb4/s1600/Barbell-Bench-press.gif'/>
        </div>
        <div className='flex gap-5 mt-8'>
            <Button>
                <Link href='/formExercicio' className='flex items-center justify-center gap-3'><MdAssignmentAdd size={20}/>Adicionar exericício</Link>
            </Button>
            <Button>
                <Link href='/' className='flex gap-3 items-center justify-center'><MdHome size={20}/>Home</Link>
            </Button>
        </div>
    </div>
  )
}

export default page