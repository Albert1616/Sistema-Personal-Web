import React from 'react'
import {AiOutlineUser} from 'react-icons/ai'

import {
    Dialog,
    DialogContent,
    DialogDescription,
    DialogHeader,
    DialogTitle,
    DialogTrigger,
  } from "@/components/ui/dialog"
import { Input } from '../ui/input'
import { Label } from '../ui/label'
import { Button } from '../ui/button'
import Link from 'next/link'
  

function login() {
  return (
    <div className='bg-primaryColor'>
    <Dialog open defaultOpen>
  <DialogContent className='flex flex-col gap-4 px-10 py-7 rounded-md'>
    <DialogHeader>
      <DialogTitle className='flex flex-col items-center justify-center gap-1 mb-3 '><AiOutlineUser size={45}/>Login</DialogTitle>
      <DialogDescription>
        <div className='flex flex-col gap-8'>
            <Label htmlFor="username">Informe seu login</Label>
            <Input type='text'id='username' className='border-gray-400 rounded-sm'/>
            <Label htmlFor="password">Informe sua senha</Label>
            <Input type='text' id='password' className='border-gray-400 rounded-sm'/>  
        </div>
        <div className='flex flex-col gap-2 mt-6 '>
            <Button className='rounded-md'>Entrar</Button>
            <p>Ainda não tem uma conta? <Link href='/register' className='underline text-primary'>Faça seu cadastro!</Link></p>
        </div>
      </DialogDescription>
    </DialogHeader>
  </DialogContent>
</Dialog>

    </div>
      )
}

export default login