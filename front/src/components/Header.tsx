import React from 'react'
import { MdFitnessCenter } from "react-icons/md";
import { FaUserCircle } from "react-icons/fa";
import Link from 'next/link';

import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from "@/components/ui/dropdown-menu"


function Header() {
  return (
    <div className='flex justify-between sticky z-[100] inset-x-0 top-0 w-full h-25
     bg-primaryColor text-white  py-5 px-7 backdrop-blur-lg transition-all'>
      <Link href='/'>
        <MdFitnessCenter size={50}/>
      </Link>
      <DropdownMenu>
  <DropdownMenuTrigger>
    <FaUserCircle size={50}/>
  </DropdownMenuTrigger>
  <DropdownMenuContent className='mt-4 z-[100]'>
    <DropdownMenuLabel>Conta</DropdownMenuLabel>
    <DropdownMenuSeparator />
    <DropdownMenuItem className='cursor-pointer'>
      <Link href="conta/detalhes">Detalhes</Link>
    </DropdownMenuItem>
    <DropdownMenuItem className='text-red-500 cursor-pointer'>Deletar</DropdownMenuItem>
    <DropdownMenuItem className='cursor-pointer'>Sair</DropdownMenuItem>
  </DropdownMenuContent>
</DropdownMenu>

    </div>
  )
}

export default Header