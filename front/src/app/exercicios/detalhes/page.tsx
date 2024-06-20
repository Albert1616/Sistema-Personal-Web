/* eslint-disable react-hooks/rules-of-hooks */

'use client'

import DetalhesExercicio from '@/components/exercicio/detalhesExercicio'
import { useSearchParams } from 'next/navigation'
import React from 'react'

function page() {
  const params = useSearchParams();

  return (
    <div className='h-[80vh] w-screen flex flex-col'>
      <DetalhesExercicio nome={params.get('nome') as string} descricao={params.get('descricao') as string} 
      gift={params.get('gift') as string}/>
    </div>
  )
}

export default page