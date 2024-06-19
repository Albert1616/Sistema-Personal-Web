import Link from 'next/link'
import React from 'react'
import {AiFillEye} from 'react-icons/ai'
import { SiReacthookform } from 'react-icons/si'

interface propsFicha{
    objetivo:string,
    data:string
}

function cardFicha({objetivo,data} : propsFicha) {
  return (
    <div className='flex items-center justify-between p-5 bg-gray-400 border rounded-xl'>
        <div className='flex gap-5 items-center'>
            <SiReacthookform size={60}/>
            <h1 className='text-md text-blue-700 flex flex-col'>Objetivo<span className='text-sm text-black'>{objetivo}</span></h1>
            <h1 className='text-md text-blue-700 flex flex-col'>Vencimento<span className='text-sm text-black'>{data}</span></h1>
        </div>
        <Link href='/'><AiFillEye size={30}/></Link>
    </div>
  )
}

export default cardFicha