'use client'

import { Button } from '@/components/ui/button';
import Link from 'next/link';
import React, { useState } from 'react'
import { MdAssignmentAdd, MdHome } from "react-icons/md";


function page() {
const [exercicios, setExercicios] = useState([]);
  return (
    <div className='h-screen py-8 px-5'>
        <h1 className='text-3xl'>Exercícios</h1>
        {exercicios.length > 0 ? (
            exercicios.map(exercicio => {
                return <p key={exercicio}>{exercicio}</p>
            })
        ) : (
            <p>Não Há exercícios cadastrados!</p>
        )}
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