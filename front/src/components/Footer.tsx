import React from 'react'
import { MdFitnessCenter,MdCopyright } from 'react-icons/md'

function Footer() {
  return (
    <div className='flex flex-col h-25  w-full'>
      <div className='w-full h-[90%] flex justify-between items-center bg-primaryColor px-5 py-7 text-white'>
        <MdFitnessCenter size={50}/>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.<br /> Ad voluptas magnam laborum beatae at nostrum<br /> cum quos,
        natus error ducimus harum saepe amet <br />voluptates omnis corrupti aliquid illum est eius!</p>
      </div>
      <div className='p-3 flex items-center justify-center text-white w-full h-[10%] bg-green-950'>
        <p className='flex items-center justify-center'><MdCopyright size={20}/> todos os direitos reservados</p>
      </div>
    </div>
  )
}

export default Footer