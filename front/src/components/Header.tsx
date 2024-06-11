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
    <div className='flex justify-between bg-primaryColor text-white  py-5 px-7'>
      <Link href='/'>
        <MdFitnessCenter size={50}/>
      </Link>
      <DropdownMenu>
  <DropdownMenuTrigger>
    <FaUserCircle size={50}/>
  </DropdownMenuTrigger>
  <DropdownMenuContent>
    <DropdownMenuLabel>Conta</DropdownMenuLabel>
    <DropdownMenuSeparator />
    <DropdownMenuItem className='cursor-pointer'>Detalhes
    </DropdownMenuItem>
    <DropdownMenuItem className='text-red-500 cursor-pointer'>Deletar</DropdownMenuItem>
    <DropdownMenuItem className='cursor-pointer'>Sair</DropdownMenuItem>
  </DropdownMenuContent>
</DropdownMenu>

    </div>
  )
}

export default Header