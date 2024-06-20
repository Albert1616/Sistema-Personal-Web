import React from 'react'
import Image from 'next/image'
import {AiOutlineSearch} from 'react-icons/ai'
import Link from 'next/link'

interface propsCard{
    gift:string,
    nome:string,
    musculo:string
}

function cardExercicio({gift, nome, musculo} : propsCard) {

    const route = `exercicios/detalhes?nome=${encodeURIComponent(nome)}&descricao=${encodeURIComponent(musculo)}&gift=${encodeURIComponent(gift)}`
  return (
    <div className='flex items-center justify-between bg-gray-300 rounded-xl p-5'>
        <div className='flex items-center gap-16'>
            <Image src={gift} alt='Execução do exercício' width={130} height={130}/>
            <div>
            <h1 className='text-2xl'>{nome}</h1>
            <h3 className='text-lg'>{musculo}</h3>
            </div>
        </div>
        <Link href={route}><AiOutlineSearch size={40}/></Link>
    </div>
  )
}

export default cardExercicio