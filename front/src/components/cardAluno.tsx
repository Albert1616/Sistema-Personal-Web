import React from 'react'
import Image from 'next/image'
import { FaUserCircle,FaSearch } from "react-icons/fa";
import { Button } from './ui/button';
import Link from 'next/link';


interface cardProps{
    icon?: string,
    nome: string,
    email: string,
    data: string
}

function cardAluno({icon, nome, email, data} : cardProps) {
  return (
    <div className='flex items-center justify-between bg-gray-300 rounded-md p-3'>
        <div className='flex gap-5'>
        {icon? (
            <Image src={icon!} alt='Foto do aluno' className='rounded-full ring-2 ring-white'/>
        ) : (
            <FaUserCircle size={90}/>
        )}
        <div className='flex flex-col gap-2'>
            <h1 className='text-3xl'>{nome}</h1>
            <h3>{email}</h3>
            <h3>{data}</h3>
        </div>
        </div>
        <Link href='/'>
            <FaSearch size={25}/>
        </Link>
    </div>
  )
}

export default cardAluno