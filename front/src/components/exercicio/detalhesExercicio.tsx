import React from 'react'
import Image from 'next/image'

interface propsExercicio{
    nome:string,
    gift:string,
    descricao:string
}

function detalhesExercicio({nome,gift,descricao} : propsExercicio) {
  return (
    <div className='flex gap-36 p-8'>
        <div className='flex flex-col gap-5'>
            <h1>{nome}</h1>
            <Image src={gift} alt='Execução do exercício' width={400} height={400}/>
        </div>
        <p>{descricao}</p>
    </div>
  )
}

export default detalhesExercicio